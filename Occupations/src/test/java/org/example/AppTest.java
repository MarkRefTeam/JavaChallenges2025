package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AppTest {

    @ParameterizedTest
    @MethodSource("providePeople")
    void testIsPersonToWorkAvailable(Person person, boolean expected) {
        Assertions.assertEquals(expected, person.isOpenToWork());
    }

    private static Stream<Arguments> providePeople() {
        return Stream.of(
                Arguments.of(new Person(25, "Raul", Gender.MAN, true), true),
                Arguments.of(new Person(44, "Sofia", Gender.WOMAN, false), false),
                Arguments.of(new Person(18, "Veronica", Gender.WOMAN, false), false),
                Arguments.of(new Person(27, "Rio", Gender.MAN, true), true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideToStringTest")
    void testToString(Person person, String expected) {
        Assertions.assertEquals(expected, person.toString());
    }

    private static Stream<Arguments> provideToStringTest() {
        return Stream.of(
                Arguments.of(new Person(33, "Martin", Gender.MAN, false), "Martin (33, MAN)"),
                Arguments.of(new Person(41, "Nina", Gender.WOMAN, true), "Nina (41, WOMAN)")
        );
    }
}
