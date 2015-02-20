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

import es.sanitas.hos.ehealth.services.api.CentroService;
import es.sanitas.hos.ehealth.services.api.vo.comunes.CentroVO;

@Controller
@RequestMapping("centro")
public class CentroREST {

	@Autowired
	private CentroService centroService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void guardarEmpresa(@RequestBody CentroVO centro) {
		centroService.guardarCentro(centro);
	}

	@RequestMapping(value = "/{idCentro}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public CentroVO recuperarCentro(@PathVariable("idCentro") Long idCentro) {
		return centroService.findById(idCentro);
	}
}
