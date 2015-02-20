package es.sanitas.hos.ehealth.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.sanitas.hos.ehealth.services.api.EmpresaService;
import es.sanitas.hos.ehealth.services.api.vo.comunes.EmpresaVO;
import es.sanitas.hos.ehealth.services.converter.EmpresaConverter;
import es.sanitas.hos.mayhem.persistence.repositories.comunes.EmpresaRepository;

@Service("empresaService")
public class EmpresaServiceImpl implements EmpresaService{
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaConverter empresaConverter;

	@Override
	public void guardarEmpresa(EmpresaVO empresa) {
		empresaRepository.save(empresaConverter.voToEntity(empresa));
	}

	@Override
	public EmpresaVO findById(Long idEmpresa) {
		return empresaConverter.entityToVo(empresaRepository.findOne(idEmpresa));
	}

}
