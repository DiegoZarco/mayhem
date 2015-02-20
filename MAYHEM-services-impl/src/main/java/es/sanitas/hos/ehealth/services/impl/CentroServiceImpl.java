package es.sanitas.hos.ehealth.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sanitas.hos.ehealth.services.api.CentroService;
import es.sanitas.hos.ehealth.services.api.vo.comunes.CentroVO;
import es.sanitas.hos.ehealth.services.converter.CentroConverter;
import es.sanitas.hos.mayhem.persistence.repositories.comunes.CentroRepository;

@Service("centroService")
public class CentroServiceImpl implements CentroService{

	@Autowired
	private CentroRepository centroRepository;
	
	@Autowired
	private CentroConverter centroConverter;
	
	@Transactional
	@Override
	public void guardarCentro(CentroVO centro) {
		centroRepository.save(centroConverter.voToEntity(centro));
	}

	@Override
	public CentroVO findById(Long idCentro) {
		return centroConverter.entityToVo(centroRepository.findOne(idCentro));
	}

}
