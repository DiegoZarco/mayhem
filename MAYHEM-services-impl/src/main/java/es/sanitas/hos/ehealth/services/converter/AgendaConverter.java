package es.sanitas.hos.ehealth.services.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sanitas.hos.ehealth.services.api.vo.agenda.AgendaVO;
import es.sanitas.hos.mayhem.persistence.entities.agenda.Agenda;

@Service("agendaConverter")
public class AgendaConverter {
	
	@Autowired
	private ProveedorConverter proveedorConverter;
	
	@Autowired
	private PrestacionConverter prestacionConverter;
	
	@Autowired
	private CitaConverter citaConverter;
	
	public AgendaVO entityToVo(final Agenda entity){
		AgendaVO vo = null;
		if (entity!=null){
			vo = new AgendaVO();
			vo.setFecha(entity.getFecha());
			vo.setId(entity.getId());
			vo.setLstCitas(citaConverter.lstEntitiesToLstVo(entity.getCitas()));
			vo.setProveedor(proveedorConverter.entityToVo(entity.getProveedor()));
			vo.setPrestacion(prestacionConverter.entityToVo(entity.getPrestacion()));
		}
		return vo;
	}
	
	public List<AgendaVO> lstEntitiesToLstVo(List<Agenda> lstEntities){
		List<AgendaVO> lstVo = new ArrayList<AgendaVO>();
		for (Agenda entity : lstEntities){
			lstVo.add(this.entityToVo(entity));
		}
		return lstVo;
	}

}
