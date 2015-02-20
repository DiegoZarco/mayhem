package es.sanitas.hos.ehealth.services.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sanitas.hos.ehealth.services.api.vo.comunes.PrestacionVO;
import es.sanitas.hos.mayhem.persistence.entities.comunes.Prestacion;
import es.sanitas.hos.mayhem.persistence.repositories.comunes.ServicioRepository;

@Service("prestacionConverter")
public class PrestacionConverter {
	
	@Autowired
	private ServicioRepository servicioRepository;

	public PrestacionVO entityToVo(final Prestacion entity){
		PrestacionVO vo = null;
		if (entity!=null){
			vo = new PrestacionVO();
			vo.setDescripcion(entity.getDescripcion());
			vo.setId(entity.getId());
			vo.setPrecio(entity.getPrecio());
			vo.setDescServicio(entity.getServicio().getDescripcion());
			vo.setIdServicio(entity.getServicio().getId());
		}
		return vo;
	}
	
	public Prestacion voToEntity(final PrestacionVO vo){
		Prestacion entity = null;
		if (vo!=null){
			entity = new Prestacion();
			entity.setDescripcion(vo.getDescripcion());
			entity.setId(vo.getId());
			entity.setPrecio(vo.getPrecio());
			entity.setServicio(servicioRepository.findOne(vo.getIdServicio()));
		}
		return entity;
	}
}
