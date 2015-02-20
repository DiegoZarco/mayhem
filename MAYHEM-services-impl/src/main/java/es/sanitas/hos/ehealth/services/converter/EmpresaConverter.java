package es.sanitas.hos.ehealth.services.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sanitas.hos.ehealth.services.api.vo.comunes.EmpresaVO;
import es.sanitas.hos.mayhem.persistence.entities.comunes.Centro;
import es.sanitas.hos.mayhem.persistence.entities.comunes.Empresa;
import es.sanitas.hos.mayhem.persistence.repositories.comunes.CentroRepository;

@Service("empresaConverter")
public class EmpresaConverter {
	
	@Autowired
	private CentroRepository centroRepository;

	public EmpresaVO entityToVo(final Empresa entity){
		EmpresaVO vo = null;
		if (entity!=null){
			vo = new EmpresaVO();
			vo.setId(entity.getId());
			vo.setNombre(entity.getNombre());
			if (entity.getCentros()!=null){
				List<Long> idCentros = new ArrayList<Long>();
				for (Centro centro : entity.getCentros()){
					idCentros.add(centro.getId());
				}
				vo.setIdCentrosAsociados(idCentros);
			}
		}
		return vo;
	}
	
	public Empresa voToEntity(final EmpresaVO vo){
		Empresa entity = null;
		if (vo!=null){
			entity = new Empresa();
			entity.setId(vo.getId());
			entity.setNombre(vo.getNombre());
			if (vo.getIdCentrosAsociados()!=null){
				List<Centro> centros = new ArrayList<Centro>();
				for (Long idCentro : vo.getIdCentrosAsociados()){
					centros.add(centroRepository.findOne(idCentro));
				}
				entity.setCentros(centros);
			}
		}
		return entity;
	}
}
