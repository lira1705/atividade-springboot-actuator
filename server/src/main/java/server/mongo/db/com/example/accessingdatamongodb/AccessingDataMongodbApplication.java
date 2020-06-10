package server.mongo.db.com.example.accessingdatamongodb;

import java.io.FileNotFoundException;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.*;

import java.io.IOException;
import java.util.*;


@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

  @Autowired
  private StatesRepository repository;

  public static void main(String[] args) {
      SpringApplication.run(AccessingDataMongodbApplication.class, args);
  }

  public static void addState(JSONObject s, List<State> stateList) {
        String abb = (String) s.get("abbreviation");
        String cases = (String) s.get("cases");
        String incidence = (String) s.get("incidence");
        String mortality = (String) s.get("mortality");
        String name = (String) s.get("name");
        stateList.add(new State(abb, cases, incidence, mortality, name));
  }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        JSONParser jsonParser = new JSONParser();
        try (FileReader file = new FileReader("states.json")) {
            Object obj = jsonParser.parse(file);
            JSONArray stateList = (JSONArray) obj;
            List<State> states = new ArrayList<State>();
            stateList.forEach(st -> addState((JSONObject) st, states));
//            for (State state : states) {
//                System.out.println(state);
//            }
            for (State state : states) {
                repository.save(state);
            }
            for (State state : repository.findAll()) {
                System.out.println(state);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    // @Override
  // public void run(String... args) throws Exception {

  //   repository.deleteAll();

  //   // save a couple of customers
  //   repository.save(new Customer("Alice", "Smith"));
  //   repository.save(new Customer("Bob", "Smith"));

  //   // fetch all customers
  //   System.out.println("Customers found with findAll():");
  //   System.out.println("-------------------------------");
  //   for (Customer customer : repository.findAll()) {
  //     System.out.println(customer);
  //   }
  //   System.out.println();

  //   // fetch an individual customer
  //   System.out.println("Customer found with findByFirstName('Alice'):");
  //   System.out.println("--------------------------------");
  //   System.out.println(repository.findByFirstName("Alice"));

  //   System.out.println("Customers found with findByLastName('Smith'):");
  //   System.out.println("--------------------------------");
  //   for (Customer customer : repository.findByLastName("Smith")) {
  //     System.out.println(customer);
  //   }

  // }

}