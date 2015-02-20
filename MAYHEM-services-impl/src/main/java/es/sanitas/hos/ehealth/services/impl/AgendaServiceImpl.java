package es.sanitas.hos.ehealth.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Minutes;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sanitas.hos.ehealth.services.api.AgendaService;
import es.sanitas.hos.ehealth.services.api.vo.CrearAgendaVO;
import es.sanitas.hos.ehealth.services.api.vo.agenda.AgendaVO;
import es.sanitas.hos.ehealth.services.converter.AgendaConverter;
import es.sanitas.hos.mayhem.persistence.entities.agenda.Agenda;
import es.sanitas.hos.mayhem.persistence.entities.agenda.Cita;
import es.sanitas.hos.mayhem.persistence.entities.comunes.Prestacion;
import es.sanitas.hos.mayhem.persistence.entities.comunes.Proveedor;
import es.sanitas.hos.mayhem.persistence.repositories.agenda.AgendaRepository;

@Service("agendaService")
public class AgendaServiceImpl implements AgendaService {

	private static final Logger log = LoggerFactory
			.getLogger(AgendaServiceImpl.class);

	private AgendaRepository agendaRepository;
	
	private AgendaConverter agendaConverter;
	
	@Autowired
	public AgendaServiceImpl(AgendaRepository repository, AgendaConverter converter) {
		this.agendaRepository = repository;
		this.agendaConverter = converter;
	}

	@Override
	@Transactional
	public void generarAgendas(final CrearAgendaVO vo) {
		Calendar fechaAux = Calendar.getInstance();
		fechaAux.setTime(vo.getFechaInicio());
		int dias = this.diasEntreFechas(vo.getFechaInicio(), vo.getFechaFin());
		// Para todos los dias que haya entre la fechas
		for (int i = 0; i <= dias; i++) {
			try {
				// Creamos la agenda para el dia
				Agenda agenda = new Agenda();
				agenda.setFecha(fechaAux.getTime());
				agenda.setProveedor(new Proveedor(vo.getIdProveedor()));
				agenda.setPrestacion(new Prestacion(vo.getIdPrestacion()));
				agenda.setCitas(this.crearCitasVacias(vo, (fechaAux.getTime())));
				log.debug("Agenda creada {}", agenda.toString());
				agendaRepository.save(agenda);
			} catch (ParseException pe) {
				log.error("Ha ocurrido un error al parsear una fecha en la creacion de la agenda ", pe);
			}
			// Al final añadimos un dia mas
			fechaAux.add(Calendar.DAY_OF_YEAR, 1);
		}
	}
	
	@Transactional(readOnly=true)
	@Override
	public AgendaVO recuperarAgenda(final Long proveedor, final Date fecha) {
		return agendaConverter.entityToVo(agendaRepository.recuperarAgenda(proveedor, fecha));
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<AgendaVO> recuperarAgendasProveedor(Long proveedor) {
		return agendaConverter.lstEntitiesToLstVo(agendaRepository.recuperarAgendasProveedor(proveedor));
	}

	private List<Cita> crearCitasVacias(final CrearAgendaVO vo,
			final Date fechaCitas) throws ParseException {
		List<Cita> lst = new ArrayList<Cita>();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		// Horas auxiliares para la suma de los huecos
		DateTime horaIni = new DateTime(sdf.parse(vo.getHoraInicio()));
		DateTime horaFin = new DateTime(sdf.parse(vo.getHoraFin()));
		DateTimeFormatter dtf = DateTimeFormat.forPattern("HH:mm");		
		int minutosEntreHoras = minutosEntreHoras(horaIni, horaFin)
				/ vo.getMinutosHueco(); // nos daria las veces que
		// tenemos que ejecutar el bucle
		// y el numero de citas que
		// vamos a dar
		DateTime horaFinalCita = horaIni.plusMinutes(vo.getMinutosHueco());
		for (int j = 0; j < minutosEntreHoras; j++) {
			Cita cita = new Cita();
			//cita.setClientes(null);
			cita.setFecha(fechaCitas);
			cita.setHoraInicio(horaIni.toString(dtf));
			cita.setHoraFin(horaFinalCita.toString(dtf));
			lst.add(cita);
			// Sumamos el tiempo del hueco a la hora inicio y a la hora fin
			horaIni = horaFinalCita;
			horaFinalCita = horaIni.plusMinutes(vo.getMinutosHueco());
		}
		return lst;
	}

	private int minutosEntreHoras(final DateTime horaInicio,
			final DateTime horaFinal) {
		// Horas de JodaTime para calcular los minutos entre ellos
		Minutes m = Minutes.minutesBetween(horaInicio, horaFinal);
		return m.getMinutes();
	}

	private int diasEntreFechas(final Date fechaInicio, final Date fechaFinal) {
		LocalDate fechaIni = new LocalDate(fechaInicio);
		LocalDate fechaFin = new LocalDate(fechaFinal);
		Days dias = Days.daysBetween(fechaIni, fechaFin);
		return dias.getDays();
	}
}
