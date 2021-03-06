package es.sanitas.hos.ehealth.comunes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.sanitas.hos.ehealth.services.api.ProveedorService;
import es.sanitas.hos.ehealth.services.api.vo.comunes.ProveedorVO;

@Controller
@RequestMapping("proveedor")
public class ProveedorREST {
	
	@Autowired
	private ProveedorService proveedorService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void guardarProveedor(@RequestBody ProveedorVO proveedor) {
		proveedorService.save(proveedor);
	}
	
	@RequestMapping(value = "/{idProveedor}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ProveedorVO recuperarCentro(@PathVariable("idProveedor") Long idProveedor) {
		return proveedorService.findById(idProveedor);
	}

}
