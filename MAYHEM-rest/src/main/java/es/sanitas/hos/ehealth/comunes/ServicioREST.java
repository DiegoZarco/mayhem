package es.sanitas.hos.ehealth.comunes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.sanitas.hos.ehealth.services.api.ServicioService;
import es.sanitas.hos.ehealth.services.api.vo.comunes.ServicioVO;

@Controller
@RequestMapping("servicio")
public class ServicioREST {
	
	@Autowired
	private ServicioService servicioService;

	@RequestMapping(value = "/{idServicio}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ServicioVO recuperarServicio(
			@PathVariable("idServicio") Long idServicio) {
		return servicioService.findById(idServicio);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ServicioVO> recuperarTodosServicio() {
		return servicioService.findAll();
	}
}
