package es.sanitas.hos.ehealth;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import es.sanitas.hos.ehealth.services.api.vo.CrearAgendaVO;
import es.sanitas.hos.ehealth.services.api.vo.agenda.AgendaVO;
import es.sanitas.hos.ehealth.services.api.vo.agenda.CitaVO;


public class AgendaRESTTest {
	
	//Estos test son de integracion solo funcionaran si esta desplegado el artefacto
	@Test
	public void generarAgendasRestTest() throws ParseException{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		List<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
		list.add(new MappingJackson2HttpMessageConverter());
		restTemplate.setMessageConverters(list);
		
		CrearAgendaVO vo = new CrearAgendaVO();
		vo.setFechaInicio(df.parse("01/01/2014"));
		vo.setFechaFin(df.parse("02/01/2014"));
		vo.setHoraFin("15:00");
		vo.setHoraInicio("09:00");
		vo.setMinutosHueco(10);
		vo.setIdProveedor(1L);
		vo.setIdPrestacion(1L);
		restTemplate.postForObject("http://localhost:8080/hce/rest/agenda/", vo, CrearAgendaVO.class);
	}
	
	
	@Test
	public void recuperarAgendasProveedor(){
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		List<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
		list.add(new MappingJackson2HttpMessageConverter());
		restTemplate.setMessageConverters(list);
		AgendaVO[] agenda = restTemplate.getForObject("http://localhost:8080/hce/rest/agenda/1", AgendaVO[].class);
		for (AgendaVO a : agenda){
			System.out.println("Fecha: " + a.getFecha());
			System.out.println("Proveedor: " + a.getProveedor().getNombre());
			System.out.println("Servicio: " + a.getPrestacion().getDescripcion());
			for (CitaVO cita : a.getLstCitas()){
				System.out.println(cita.getHoraInicio() + " " + cita.getHoraFin());
			}
		}
	}
}
