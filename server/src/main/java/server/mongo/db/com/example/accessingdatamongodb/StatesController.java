package com.example.accessingdatamongodb;

// import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class StatesController {

  @Autowired
  private StatesRepository repository;

	// private static final String template = "Hello, %s!";
	// private final AtomicLong counter = new AtomicLong();

	@GetMapping("/states")
	public ArrayList<States> states() {
		return getAllStates();
	}

  public ArrayList<States> getAllStates() {
    ArrayList<States> states = new ArrayList<>();
    for (States state : repository.findAll()) {
      states.add(state);
    }
    System.out.println(states); 
    return states;
  }
}
