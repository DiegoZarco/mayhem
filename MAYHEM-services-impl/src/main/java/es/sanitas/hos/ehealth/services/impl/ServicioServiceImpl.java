package es.sanitas.hos.ehealth.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sanitas.hos.ehealth.services.api.ServicioService;
import es.sanitas.hos.ehealth.services.api.vo.comunes.ServicioVO;
import es.sanitas.hos.ehealth.services.converter.ServicioConverter;
import es.sanitas.hos.mayhem.persistence.repositories.comunes.ServicioRepository;

@Service("servicioService")
public class ServicioServiceImpl implements ServicioService {
	
	@Autowired
	private ServicioRepository repository;
	
	@Autowired
	private ServicioConverter converter;

	@Override
	public ServicioVO findById(final Long id) {
		return converter.entityToVo(repository.findOne(id));
	}

	@Override
	public List<ServicioVO> findAll() {
		return converter.lstEntityToLstVo(repository.findAll());
	}

}
