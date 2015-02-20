package es.sanitas.hos.ehealth.services.converter;

import org.springframework.stereotype.Service;

import es.sanitas.hos.ehealth.services.api.vo.comunes.ProveedorVO;
import es.sanitas.hos.mayhem.persistence.entities.comunes.Proveedor;

@Service("proveedorConverter")
public class ProveedorConverter {

	public ProveedorVO entityToVo(Proveedor entity){
		ProveedorVO vo = null;
		if (entity!=null){
			vo = new ProveedorVO();
			vo.setApellido1(entity.getApellido1());
			vo.setApellido2(entity.getApellido2());
			vo.setId(entity.getId());
			vo.setNombre(entity.getNombre());
		}
		return vo;
	}
	
	public Proveedor voToEntity(ProveedorVO vo){
		Proveedor entity = null;
		if (vo!=null){
			entity = new Proveedor();
			entity.setApellido1(vo.getApellido1());
			entity.setApellido2(vo.getApellido2());
			entity.setId(vo.getId());
			entity.setNombre(vo.getNombre());
		}
		return entity;
	}
}
