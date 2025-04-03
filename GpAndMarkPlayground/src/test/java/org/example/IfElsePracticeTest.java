package org.example;

import org.junit.jupiter.api.Test;

import static org.example.IfElsePractice.evaluateGrade;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IfElsePracticeTest {

    @Test
    public void testCategorizeAge() {
        assertEquals("Invalid Age", IfElsePractice.categorizeAge(-1));
        assertEquals("Child" , IfElsePractice.categorizeAge(10));
        assertEquals("Teenager" , IfElsePractice.categorizeAge(17)); //In Usa
        assertEquals("Adult" , IfElsePractice.categorizeAge(24));
        assertEquals("Pensioner" , IfElsePractice.categorizeAge(64));
        assertEquals("Connor Macleod" , IfElsePractice.categorizeAge(356));
        assertEquals("God or AI" , IfElsePractice.categorizeAge(7645));
    }

    @Test
    public void testGetDayName() {
        assertEquals("Monday" , IfElsePractice.getDayName(0));
        assertEquals("Tuesday" , IfElsePractice.getDayName(1));
        assertEquals("Wednesday" , IfElsePractice.getDayName(2));
        assertEquals("Thursday" , IfElsePractice.getDayName(3));
        assertEquals("Friday" , IfElsePractice.getDayName(4));
        assertEquals("Saturday" , IfElsePractice.getDayName(5));
        assertEquals("Sunday" , IfElsePractice.getDayName(6));
        assertEquals("Invalid Day" , IfElsePractice.getDayName(7));
    }

    @Test
    public void testTemperature() {
        assertEquals("Freezing" ,IfElsePractice.classifyTemperature(-1));
        assertEquals("Cold" ,IfElsePractice.classifyTemperature(10));
        assertEquals("Cool" ,IfElsePractice.classifyTemperature(19));
        assertEquals("Warm" ,IfElsePractice.classifyTemperature(29));
        assertEquals("Hot" ,IfElsePractice.classifyTemperature(39));
        assertEquals("Extremely hot" ,IfElsePractice.classifyTemperature(60));
        assertEquals("Welcome in the Jupiter",IfElsePractice.classifyTemperature(600));
        assertEquals("Armageddon" ,IfElsePractice.classifyTemperature(10_000));
    }

    @Test
    public void testGrade() {

        assertEquals("Excellent" ,IfElsePractice.evaluateGrade(90));
        assertEquals("Very Good" ,IfElsePractice.evaluateGrade(89));
        assertEquals("Good" ,IfElsePractice.evaluateGrade(71));
        assertEquals("Pass" ,IfElsePractice.evaluateGrade(63));
        assertEquals("Fail" ,IfElsePractice.evaluateGrade(33));
        assertEquals("Invalid Score" ,IfElsePractice.evaluateGrade(133));
    }
}
