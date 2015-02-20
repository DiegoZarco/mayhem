package es.sanitas.hos.ehealth;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import es.sanitas.hos.ehealth.services.api.vo.comunes.PrestacionVO;

public class PrestacionRESTTest {

	//Estos test son de integracion solo funcionaran si esta desplegado el artefacto
		@Test
		public void generarPrestacionRestTest() throws ParseException{
			SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
			RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
			List<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
			list.add(new MappingJackson2HttpMessageConverter());
			restTemplate.setMessageConverters(list);
			
			PrestacionVO vo = new PrestacionVO();
			vo.setDescripcion("Prestacion de primera instancia");
			vo.setPrecio(new BigDecimal(5.35));
			vo.setIdServicio(1L);
			restTemplate.postForObject("http://localhost:8080/hce/rest/prestacion/", vo, PrestacionVO.class);
		}
}
