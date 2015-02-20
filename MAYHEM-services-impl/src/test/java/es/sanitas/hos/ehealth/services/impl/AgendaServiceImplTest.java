package es.sanitas.hos.ehealth.services.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import es.sanitas.hos.ehealth.services.api.vo.CrearAgendaVO;
import es.sanitas.hos.mayhem.persistence.entities.agenda.Agenda;
import es.sanitas.hos.mayhem.persistence.repositories.agenda.AgendaRepository;

/**
 * Clase para probar el servicio de agendas 
 * @author DIEGO
 *
 */
public class AgendaServiceImplTest {
	
	@Mock
    private AgendaRepository agendaRepository;
	
	@InjectMocks
	private AgendaServiceImpl agendaService;
	
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
	
//	@Test
//	public void generarAgendaParaUnDia() throws ParseException{
//		Mockito.when(agendaRepository.save(Mockito.any(Agenda.class))).thenReturn(new Agenda());		
//		CrearAgendaVO vo = new CrearAgendaVO();
//		vo.setFechaInicio(df.parse("01/01/2014"));
//		vo.setFechaFin(df.parse("01/01/2014"));
//		vo.setHoraFin("15:00");
//		vo.setHoraInicio("09:00");
//		vo.setMinutosHueco(10);
//		vo.setIdProveedor(1L);
//		vo.setIdServicio(1L);
//		agendaService.generarAgendas(vo);
//		Mockito.verify(agendaRepository, Mockito.times(1)).save(Mockito.any(Agenda.class));
//	}
	
	@Test
	public void generarAgendaPara5Dia() throws ParseException{
		Mockito.when(agendaRepository.save(Mockito.any(Agenda.class))).thenReturn(new Agenda());	
		CrearAgendaVO vo = new CrearAgendaVO();
		vo.setFechaInicio(df.parse("01/01/2014"));
		vo.setFechaFin(df.parse("05/01/2014"));
		vo.setHoraFin("15:00");
		vo.setHoraInicio("09:00");
		vo.setMinutosHueco(10);
		vo.setIdProveedor(1L);
		vo.setIdPrestacion(1L);
		agendaService.generarAgendas(vo);
		Mockito.verify(agendaRepository, Mockito.times(5)).save(Mockito.any(Agenda.class));
	}

}
