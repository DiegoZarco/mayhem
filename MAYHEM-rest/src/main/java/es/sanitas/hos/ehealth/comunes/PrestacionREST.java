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

import es.sanitas.hos.ehealth.services.api.PrestacionService;
import es.sanitas.hos.ehealth.services.api.vo.comunes.PrestacionVO;

@Controller
@RequestMapping("prestacion")
public class PrestacionREST {

	@Autowired
	private PrestacionService prestacionService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void guardarPrestacion(@RequestBody PrestacionVO vo) {
		prestacionService.save(vo);
	}

	@RequestMapping(value = "/{idPrestacion}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public PrestacionVO recuperarPrestacion(
			@PathVariable("idPrestacion") Long idPrestacion) {
		return prestacionService.findById(idPrestacion);
	}
}
