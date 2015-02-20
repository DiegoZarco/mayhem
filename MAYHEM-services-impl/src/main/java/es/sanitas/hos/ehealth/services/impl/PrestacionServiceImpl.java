package es.sanitas.hos.ehealth.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sanitas.hos.ehealth.services.api.PrestacionService;
import es.sanitas.hos.ehealth.services.api.vo.comunes.PrestacionVO;
import es.sanitas.hos.ehealth.services.converter.PrestacionConverter;
import es.sanitas.hos.mayhem.persistence.repositories.comunes.PrestacionRepository;

@Service("prestacionService")
public class PrestacionServiceImpl implements PrestacionService{

	@Autowired
	private PrestacionRepository repository;
	
	@Autowired
	private PrestacionConverter converter;
	
	@Override
	public PrestacionVO findById(Long id) {
		return converter.entityToVo(repository.findOne(id));
	}

	@Transactional
	@Override
	public void save(PrestacionVO vo) {
		repository.save(converter.voToEntity(vo));
	}

}
