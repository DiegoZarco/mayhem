package es.sanitas.hos.ehealth.agenda;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.sanitas.hos.ehealth.services.api.AgendaService;
import es.sanitas.hos.ehealth.services.api.vo.CrearAgendaVO;
import es.sanitas.hos.ehealth.services.api.vo.agenda.AgendaVO;

@Controller
@RequestMapping("agenda")
public class AgendaREST {

	@Autowired
	private AgendaService agendaService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void generarAgenda(@RequestBody CrearAgendaVO vo) {
		agendaService.generarAgendas(vo);
	}

	@RequestMapping(value = "/{proveedor}/{fecha}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public AgendaVO recuperarAgenda(
			@PathVariable("proveedor") Long proveedor,
			@PathVariable("fecha") Date fecha) {
		return agendaService.recuperarAgenda(proveedor, fecha);
	}
	
	@RequestMapping(value = "/{proveedor}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<AgendaVO> recuperarAgendasProveedor(
			@PathVariable("proveedor") Long proveedor) {
		return agendaService.recuperarAgendasProveedor(proveedor);
	}

	@RequestMapping(value = "/saluda", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String hello() {
		return "hello";
	}
}
