package es.sanitas.hos.ehealth.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sanitas.hos.ehealth.services.api.ClienteService;
import es.sanitas.hos.ehealth.services.api.vo.comunes.ClienteVO;
import es.sanitas.hos.ehealth.services.converter.ClienteConverter;
import es.sanitas.hos.mayhem.persistence.entities.comunes.Cliente;
import es.sanitas.hos.mayhem.persistence.repositories.comunes.ClienteRepository;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteConverter clienteConverter;

	@Override
	public void guardarCliente(final ClienteVO cliente) {
		clienteRepository.save(clienteConverter.voToEntity(cliente));
	}

	@Override
	public ClienteVO findById(final Long idCliente) {
		return clienteConverter.entityToVo(clienteRepository.findOne(idCliente));
	}

	@Override
	public List<ClienteVO> findAll() {		
		return clienteConverter.lstEntitiesToLstVo(clienteRepository.findAll());
	}

	@Transactional
	@Override
	public void actualizarCliente(ClienteVO vo) {
		Cliente entity = clienteRepository.findOne(vo.getId());
		if (entity!=null){
			entity.setApellido1(vo.getApellido1());
			entity.setApellido2(vo.getApellido2());
			entity.setDocumento(vo.getDocumento());
			entity.setNombre(vo.getNombre());
			entity.setDomicilio(vo.getDomicilio());
			entity.setTelefono1(vo.getTelefono1());
			entity.setTelefono2(vo.getTelefono2());
			entity.setFechaNacimiento(vo.getFechaNac());
		}
	}
}
