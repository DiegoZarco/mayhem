package es.sanitas.hos.ehealth.services.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sanitas.hos.ehealth.services.api.vo.comunes.CentroVO;
import es.sanitas.hos.mayhem.persistence.entities.comunes.Centro;
import es.sanitas.hos.mayhem.persistence.repositories.comunes.EmpresaRepository;

@Service("centroConverter")
public class CentroConverter {
	
	@Autowired
	private EmpresaRepository empresaRepository;

	public Centro voToEntity(final CentroVO vo){
		Centro entity = null;
		if (vo!=null){
			entity = new Centro();
			entity.setCodigo(vo.getCodigo());
			entity.setId(vo.getId());
			entity.setNombre(vo.getNombre());
			entity.setEmpresas(empresaRepository.findOne(vo.getIdEmpresa()));			
		}
		return entity;
	}
	
	public CentroVO entityToVo(final Centro entity){
		CentroVO vo = null;
		if (entity!=null){
			vo = new CentroVO();
			vo.setCodigo(entity.getCodigo());
			vo.setId(entity.getId());
			vo.setNombre(entity.getNombre());
			vo.setIdEmpresa(entity.getEmpresas().getId());
		}
		return vo;
	}
}
