package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AppTest {

    @ParameterizedTest
    @MethodSource("providePeople")
    void testIsPersonRendtable(Person person, boolean expected) {
        Assertions.assertEquals(expected, person.isRentable());
    }

    private static Stream<Arguments> providePeople() {
        return Stream.of(
                Arguments.of(new Person(25, "Raul", Gender.Man, true), true),
                Arguments.of(new Person(44, "Sofia", Gender.Woman, false), false),
                Arguments.of(new Person(18, "Veronica", Gender.Woman, false), false),
                Arguments.of(new Person(27, "Rio", Gender.Man, true), true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideToStringTest")
    void testToString(Person person, String expected) {
        Assertions.assertEquals(expected, person.toString());
    }

    private static Stream<Arguments> provideToStringTest() {
        return Stream.of(
                Arguments.of(new Person(33, "Martin", Gender.Man, false), "Martin (33, Man)"),
                Arguments.of(new Person(41, "Nina", Gender.Woman, true), "Nina (41, Woman)")
        );
    }
}
