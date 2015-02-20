package es.sanitas.hos.ehealth.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sanitas.hos.ehealth.services.api.ProveedorService;
import es.sanitas.hos.ehealth.services.api.vo.comunes.ProveedorVO;
import es.sanitas.hos.ehealth.services.converter.ProveedorConverter;
import es.sanitas.hos.mayhem.persistence.repositories.comunes.ProveedorRepository;

@Service("proveedorService")
public class ProveedorServiceImpl implements ProveedorService{
	
	@Autowired
	private ProveedorRepository repository;
	
	@Autowired
	private ProveedorConverter converter;

	@Override
	public ProveedorVO findById(final Long id) {
		return converter.entityToVo(repository.findOne(id));
	}

	@Override
	public void save(final ProveedorVO proveedor) {
		repository.save(converter.voToEntity(proveedor));		
	}

}
