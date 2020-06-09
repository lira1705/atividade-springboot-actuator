package com.example.restservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

@RestController
public class QuoteController {

	// private static final String template = "Hello, %s!";
	// private final AtomicLong counter = new AtomicLong();

  RestTemplate restTemplate;

	@GetMapping("/quote")
	public Quote quote() {
		return run(restTemplate());
	}

	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public Quote run(RestTemplate restTemplate) {
    return restTemplate.getForObject(
        "https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    }
}