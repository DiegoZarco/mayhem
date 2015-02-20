package es.sanitas.hos.ehealth.comunes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.sanitas.hos.ehealth.services.api.ClienteService;
import es.sanitas.hos.ehealth.services.api.vo.comunes.ClienteVO;

@Controller
@RequestMapping("cliente")
public class ClienteREST {

	@Autowired 
	private ClienteService clienteService;
	
	@RequestMapping(method = RequestMethod.POST)	
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	@Secured({"ROLE_ADMIN"})
	public void guardarCliente(@RequestBody ClienteVO cliente) {
		clienteService.guardarCliente(cliente);
	}
	
	@RequestMapping(method = RequestMethod.PUT)	
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@Secured({"ROLE_ADMIN"})
	public void actualizarCliente(@RequestBody ClienteVO cliente) {
		clienteService.actualizarCliente(cliente);
	}
	
	@RequestMapping(value = "/{idCliente}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@Secured({"ROLE_ADMIN"})
	public ClienteVO recuperarCliente(@PathVariable("idCliente") Long idCliente) {
		return clienteService.findById(idCliente);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ClienteVO> recuperarClientes() {
		return clienteService.findAll();
	}
	
}
