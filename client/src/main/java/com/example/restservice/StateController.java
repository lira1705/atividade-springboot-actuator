package com.example.restservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

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

	@ApiOperation(value="Returns all states")
	@GetMapping("/states")
	public List<Object> goToStates(){
		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:8090/states", Object[].class);
		Object[] objects = responseEntity.getBody();
		return Arrays.asList(objects);
	}


	@ApiOperation(value="Returns information about a state")
	@GetMapping("/states/{abbreviation}")
	public ResponseEntity<Object> goToState(@PathVariable String abbreviation){
		Object s =  restTemplate.getForObject("http://localhost:8090/states/" + abbreviation.toUpperCase(), Object.class);
		if (s == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(s, HttpStatus.OK);
	}

	@ApiOperation(value="Saves a state")
	@PostMapping("/state")
	public String refreshState() {
		return "1";
	}

	@ApiOperation(value="Updates the information of a state")
	@PutMapping("/state")
	public String saveState() {
		return "1";
	}

	@ApiOperation(value="Delete a state")
	@DeleteMapping("/state")
	public String deleteState() {
		return "1";
	}

}