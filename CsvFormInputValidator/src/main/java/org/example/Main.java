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

        String path = "C:\\work\\CleanedRepo\\CsvFormInputValidator\\src\\main\\resources";
        List<UserComment> comments = CsvParser.parse(path);
        System.out.println("All valid comment number: " + comments.size());
    }
}
