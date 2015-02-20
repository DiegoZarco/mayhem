package es.sanitas.hos.ehealth.services.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sanitas.hos.ehealth.services.api.vo.comunes.PrestacionVO;
import es.sanitas.hos.ehealth.services.api.vo.comunes.ServicioVO;
import es.sanitas.hos.mayhem.persistence.entities.comunes.Prestacion;
import es.sanitas.hos.mayhem.persistence.entities.comunes.Servicio;

@Service("servicioConverter")
public class ServicioConverter {
	
	@Autowired
	private PrestacionConverter prestacionConverter;
	
	public ServicioVO entityToVo(final Servicio entity){
		ServicioVO vo = null;
		if (entity!=null){
			vo = new ServicioVO();
			vo.setDescripcion(entity.getDescripcion());
			vo.setId(entity.getId());
			if (entity.getPrestaciones()!=null){
				List<PrestacionVO> lstPrestacionVO = new ArrayList<PrestacionVO>();
				for (Prestacion prestacion : entity.getPrestaciones()){
					lstPrestacionVO.add(prestacionConverter.entityToVo(prestacion));
				}
				vo.setPrestaciones(lstPrestacionVO);
			}
		}
		return vo;
	}
	
	public Servicio voToEntity(final ServicioVO vo){
		Servicio entity = null;
		if (vo != null){
			entity = new Servicio();
			entity.setDescripcion(vo.getDescripcion());
			entity.setId(vo.getId());
			if (vo.getPrestaciones()!=null){
				List<Prestacion> lstPrestacion = new ArrayList<Prestacion>();
				for (PrestacionVO prestacionVO : vo.getPrestaciones()){
					lstPrestacion.add(prestacionConverter.voToEntity(prestacionVO));
				}
				entity.setPrestaciones(lstPrestacion);
			}
		}
		return entity;
	}
	
	public List<ServicioVO> lstEntityToLstVo(final List<Servicio> lstEntities){
		List<ServicioVO> lstVo = new ArrayList<ServicioVO>();
		for (Servicio entity : lstEntities){
			lstVo.add(this.entityToVo(entity));
		}
		return lstVo;
	}

}
