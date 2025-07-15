package org.example;

import org.example.model.UserComment;
import org.example.parser.CsvParser;

import java.util.List;

public class Main {
    public static void main( String[] args ) {

        //Lombok test message:
        UserComment uc = new UserComment();
        uc.setUsername("Test");
        System.out.println(uc.getUsername());

        List<UserComment> comments = CsvParser.parse("username.email.comment.csv");
        System.out.println("All valid comment number: " + comments.size());
    }
}
