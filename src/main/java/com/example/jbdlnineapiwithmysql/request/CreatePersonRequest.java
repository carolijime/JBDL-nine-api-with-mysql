package com.example.jbdlnineapiwithmysql.request;

import com.example.jbdlnineapiwithmysql.model.Person;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreatePersonRequest {

    @NotBlank(message = "FirstName should not be empty")
    private String firstName; //should not be empty

    private String lastName; //can be empty

//    private int age; //could be calculated so no need to be in the request

    @NotBlank(message = "Date of birth should not be empty")
    private String dob;//mandatory

    public Person to(){
        return Person.builder()
                .firstName(firstName)
                .lastName(lastName)
                .dob(dob)
                .build();
    }

}
