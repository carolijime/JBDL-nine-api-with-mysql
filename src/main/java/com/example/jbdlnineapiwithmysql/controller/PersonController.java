package com.example.jbdlnineapiwithmysql.controller;

import com.example.jbdlnineapiwithmysql.model.Person;
import com.example.jbdlnineapiwithmysql.request.CreatePersonRequest;
import com.example.jbdlnineapiwithmysql.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {

    //need to autowired, if not, need to create object of personservice everytime
    @Autowired
    PersonService personService;

    private static Logger logger = LoggerFactory.getLogger(PersonController.class);

    @PostMapping("/person")
    public void createPerson(@Valid @RequestBody CreatePersonRequest createPersonRequest){

        //Validations and Exception handling we have outsourced
        //Invoking service class's function
        personService.createPerson(createPersonRequest);
    }

    @GetMapping("/person")
    public Person getPersonById(@RequestParam("id") int id){
        return personService.getPerson(id);
    }

    @GetMapping("/person/all")
    public List<Person> getPeople(){
        return personService.getPeople();
    }

    @DeleteMapping("/person/{id}")
    public Person deletePerson(@PathVariable("id") int pId) throws Exception {
        return personService.deletePerson(pId);
    }

    //Below API that throws error message if error occurs (ex. missing fields)
//    @PostMapping("/person")
//    public ResponseEntity createPerson(@RequestBody @Valid CreatePersonRequest personRequest){
//
//        //Logging the request
//        logger.info("person - {}", personRequest);
//
//        //Applying "manual" validations --> do not do validations this way
////        if(personRequest.getFirstName() == null || personRequest.getFirstName().isEmpty()){
////            logger.info("Person's first name is empty");
////            return;
////        }
////
////        if(personRequest.getDob() == null || personRequest.getDob().isEmpty()){
////            logger.info("Person's dob is empty");
////            return;
////        }
//
//        //Below example for throwing IndexOutOfBoundsException exception
//        Integer a = new Random().nextInt() % 2;
//        if(a == 0){
//            logger.info("Random no % 2 is 0 ");
//            throw new IndexOutOfBoundsException();
//        }
//
//        //Logic for saving the request in DB
//        logger.info("Going to save the request in DB");
//
//        MultiValueMap<String, String> headers = new HttpHeaders();
//        headers.add("sample_response_header", "Person type object");
//
//        //returning with header
//        return new ResponseEntity(new Person(), headers, HttpStatus.CREATED);
//        //simple return with just person + http status
////        return new ResponseEntity<>(new Person(), HttpStatus.CREATED);
//
//    }



    //using person class will expose all attributes of person --> no good
//    @PostMapping("/person")
//    public void createPerson(@RequestBody Person person){
//
//    }



// Code below is how to "normally" create a person
//    public static void main(String[] args) {
//        Person p = new Person();
//        p.setAge(10);
//        p.setFirstName("ABC");
//        p.setLastName("XYZ");
//        p.setId(1);
//
//        //Below builder replaces the person creation above
//        Person person = Person.builder()
//                .age(10)
//                .firstName("ABC")
//                .lastName("XYZ")
//                .id(1)
//                .build();
//
//        //above another "way" to create person using a function to do some logic and build the person
//        Person.PersonBuilder personBuilder = Person.builder();
//        personBuilder.firstName("ABC").lastName("XYZ");
//        Person person2 = setFn(personBuilder);
//
//        //just calculating age and adding it to person
//        int personAge= calculateAge();
//        person2.setAge(personAge);
//
//    }
//
//    public static Person setFn(Person.PersonBuilder personBuilder){
//        //logic to calculate age
//        int age = 10;
//        return personBuilder.age(age).build();
//    }
//
//    // Return the age of a person
//    public static int calculateAge(){
//        return 10;
//    }

}
