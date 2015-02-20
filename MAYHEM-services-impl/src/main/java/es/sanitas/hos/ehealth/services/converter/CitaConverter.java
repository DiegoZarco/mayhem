package es.sanitas.hos.ehealth.services.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sanitas.hos.ehealth.services.api.vo.agenda.CitaVO;
import es.sanitas.hos.mayhem.persistence.entities.agenda.Cita;

@Service("citaConverter")
public class CitaConverter {
	
	@Autowired
	private ClienteConverter clienteConverter;

	public CitaVO entityToVo(final Cita entity){
		CitaVO vo = null;
		if (entity!=null){
			vo = new CitaVO();
			vo.setClientes(clienteConverter.lstEntitiesToLstVo(entity.getClientes()));
			vo.setFecha(entity.getFecha());
			vo.setHoraFin(entity.getHoraFin());
			vo.setHoraInicio(entity.getHoraInicio());
			vo.setId(entity.getId());
			
		}
		return vo;
	}
	
	public Cita voToEntity(final CitaVO vo){
		Cita entity = null;
		if (vo!=null){
			entity = new Cita();
			entity.setFecha(vo.getFecha());
			entity.setHoraFin(vo.getHoraFin());
			entity.setHoraInicio(vo.getHoraInicio());
			entity.setId(vo.getId());
		}
		return entity;
	}
	
	public List<Cita> lstVoToLstEntity(final List<CitaVO> lstVo){
		List<Cita> lstEntities = new ArrayList<Cita>();
		for (CitaVO vo : lstVo){
			lstEntities.add(this.voToEntity(vo));
		}
		return lstEntities;
	}
	
	public List<CitaVO> lstEntitiesToLstVo(final List<Cita> lstEntities){
		List<CitaVO> lstVo = new ArrayList<CitaVO>();
		for (Cita entity : lstEntities){
			lstVo.add(this.entityToVo(entity));
		}
		return lstVo;
	}
}
