package com.example.restservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.swagger.annotations.ApiOperation;
@RestController
public class StateController {

	// private static final String template = "Hello, %s!";
	// private final AtomicLong counter = new AtomicLong();

  RestTemplate restTemplate = new RestTemplate();

	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@ApiOperation(value="Retorna uma lista de estados")
	@GetMapping("/states")
	public List<Object> goToStates(){
		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:8090/states", Object[].class);
		Object[] objects = responseEntity.getBody();
		return Arrays.asList(objects);
	}


	@ApiOperation(value="Retorna informação de um estado")
	@GetMapping("/states/{abbreviation}")
	public Object goToState(@PathVariable String abbreviation){
		Object s =  restTemplate.getForObject("http://localhost:8090/states/" + abbreviation, Object.class);
		return s;
	}

	@ApiOperation(value="Atualiza informação de um estado")
	@PostMapping("/state")
	public String refreshState() {
		return "1";
	}

	@ApiOperation(value="Salva informação de um estado")
	@PutMapping("/state")
	public String saveState() {
		return "1";
	}

	@ApiOperation(value="Remove informação de um estado")
	@DeleteMapping("/state")
	public String deleteState() {
		return "1";
	}

}