package com.example.restservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
public class QuoteController {

	// private static final String template = "Hello, %s!";
	// private final AtomicLong counter = new AtomicLong();

  RestTemplate restTemplate;

	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@ApiOperation(value="Retorna uma lista de estados")
	@GetMapping("/states")
	public ArrayList<States> goToStates(){
		return getAllStates();
	}

	public ArrayList<States> getAllStates(){
        ArrayList<States> array = new ArrayList<>();
		array.add(new States("GO", "6.521", "92.9", "2.6", "Goiás"));
		return array;
    }

	@ApiOperation(value="Retorna informação de um estado")
	@GetMapping("/state")
	public ResponseEntity<States> goToState(@RequestParam(value = "abbreviation", defaultValue = "PE")  String abbreviation){
		for(States state : getAllStates()) { 
			if(state.getAbbreviation().equals(abbreviation)) { 
				return new ResponseEntity<States>(state, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
	
	public Quote run(RestTemplate restTemplate) {
    return restTemplate.getForObject(
        "https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    }
}