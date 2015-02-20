package es.sanitas.hos.ehealth.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sanitas.hos.ehealth.services.api.CitaService;
import es.sanitas.hos.ehealth.services.api.vo.agenda.CitaVO;
import es.sanitas.hos.ehealth.services.converter.CitaConverter;
import es.sanitas.hos.mayhem.persistence.repositories.agenda.CitaRepository;

@Service("citaService")
public class CitaServiceImpl implements CitaService{
	
	@Autowired
	private CitaRepository repository;
	
	@Autowired
	private CitaConverter converter;

	@Override
	public void guardarCita(final CitaVO cita) {
		repository.save(converter.voToEntity(cita));
	}

	@Override
	public List<CitaVO> recuperarCitasPorCliente(final Long idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
