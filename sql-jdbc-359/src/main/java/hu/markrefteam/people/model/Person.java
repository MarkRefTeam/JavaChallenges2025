package hu.markrefteam.people.model;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private Integer id;

    private String firstName;
    private String lastName;
    private String motherName;
    private String fatherName;

    private LocalDate birthDate;

    private Gender gender;
    private HighestEducation highestEducation;

    private int numberOfChildren;
}
