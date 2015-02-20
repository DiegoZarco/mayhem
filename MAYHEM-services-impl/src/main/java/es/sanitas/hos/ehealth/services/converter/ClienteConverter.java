package es.sanitas.hos.ehealth.services.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import es.sanitas.hos.ehealth.services.api.vo.comunes.ClienteVO;
import es.sanitas.hos.mayhem.persistence.entities.comunes.Cliente;

@Service("clienteConverter")
public class ClienteConverter {

	public ClienteVO entityToVo(final Cliente entity){
		ClienteVO vo = null;
		if (entity!=null){
			vo = new ClienteVO();
			vo.setApellido1(entity.getApellido1());
			vo.setApellido2(entity.getApellido2());
			vo.setDocumento(entity.getDocumento());
			vo.setId(entity.getId());
			vo.setNombre(entity.getNombre());
			vo.setDomicilio(entity.getDomicilio());
			vo.setTelefono1(entity.getTelefono1());
			vo.setTelefono2(entity.getTelefono2());
			vo.setFechaNac(entity.getFechaNacimiento());
		}
		return vo;
	}
	
	public Cliente voToEntity(final ClienteVO vo){
		Cliente entity = null;
		if (vo!=null){
			entity = new Cliente();
			entity.setApellido1(vo.getApellido1());
			entity.setApellido2(vo.getApellido2());
			entity.setDocumento(vo.getDocumento());
			entity.setId(vo.getId());
			entity.setNombre(vo.getNombre());
			entity.setDomicilio(vo.getDomicilio());
			entity.setTelefono1(vo.getTelefono1());
			entity.setTelefono2(vo.getTelefono2());
			entity.setFechaNacimiento(vo.getFechaNac());
		}
		return entity;
	}
	
	public List<Cliente> lstVoToLstEntities(final List<ClienteVO> lstVo){
		List<Cliente> lstEntities = new ArrayList<Cliente>();
		for (ClienteVO vo : lstVo){
			lstEntities.add(this.voToEntity(vo));
		}
		return lstEntities;
	}
	
	public List<ClienteVO> lstEntitiesToLstVo(final List<Cliente> lstEntities){
		List<ClienteVO> lstVo = new ArrayList<ClienteVO>();
		for (Cliente entity : lstEntities){
			lstVo.add(this.entityToVo(entity));
		}
		return lstVo;
	}
}
