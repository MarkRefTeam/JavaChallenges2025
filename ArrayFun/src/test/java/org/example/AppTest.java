package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    //OneDimensional Test Phase :

    @ParameterizedTest
    @MethodSource("provideGetEvenAverageData")
    public void testGetEvenAverage(int[] input, double expected) {
        assertEquals(expected, OneDimensionalApp.getEvenAverage(input));
    }

    static Stream<Arguments> provideGetEvenAverageData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 3.0),
                Arguments.of(new int[]{2, 4, 6}, 4.0),
                Arguments.of(new int[]{1, 3, 5}, 0.0),
                Arguments.of(new int[]{}, 0.0),
                Arguments.of(new int[]{8, 10}, 9.0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideEvenOddTestData")
    public void testOneDimensional(int[] input, int[] expected) {
        assertArrayEquals(expected, OneDimensionalApp.evenTakeOddSkip(input));
    }

    static Stream<Arguments> provideEvenOddTestData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 9, 25}),
                Arguments.of(new int[]{2, 4, 6}, new int[]{}),
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{1, 3, 5}, new int[]{1, 9, 25}),
                Arguments.of(new int[]{7, 8, 9}, new int[]{49, 81})
        );
    }

    @ParameterizedTest
    @MethodSource("provideStartsWithATestData")
    public void testCountStartWithA(String[] input, int expected) {
        assertEquals(expected, OneDimensionalApp.countStartWithA(input));
    }

    static Stream<Arguments> provideStartsWithATestData() {
        return Stream.of(
                Arguments.of(new String[]{"apple", "banana", "avocado"}, 2),
                Arguments.of(new String[]{"Banana", "Pear", "Kiwi"}, 0),
                Arguments.of(new String[]{"Aardvark", "Ant", "ape", "Bear"}, 3),
                Arguments.of(new String[]{}, 0),
                Arguments.of(new String[]{"aardvark", "Ape", "A", "apple"}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("provideConcatLongStringsData")
    public void testConcatLongStrings(String[] input, String expected) {
        assertEquals(expected, OneDimensionalApp.concatLongStrings(input));
    }

    static Stream<Arguments> provideConcatLongStringsData() {
        return Stream.of(
                Arguments.of(new String[]{"dog", "banana", "cat", "apple"}, "dogbananacatapple"),
                Arguments.of(new String[]{"one", "two", "three"}, ""),
                Arguments.of(new String[]{"hi", "no", "yes"}, ""),
                Arguments.of(new String[]{"house", "car", "bicycle",}, ""),
                Arguments.of(new String[]{}, "")
        );
    }

    @ParameterizedTest
    @MethodSource("provideHasConsecutiveDuplicates")
    public void testHasConsecutiveDuplicates(int[] input, boolean expected) {
        assertEquals(expected, OneDimensionalApp.hasConsecutiveDuplicates(input));
    }

    static Stream<Arguments> provideHasConsecutiveDuplicates() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2}, true),
                Arguments.of(new int[]{3, 4, 5}, false)
        );
    }

    //Two Dimensional Test Phase:

    @ParameterizedTest
    @MethodSource("provideCountVowels2D")
    public void testCountVowels2D(String[][] words, int expected) {
        assertEquals(expected, TwoDimensionalApp.countVowels2D(words));
    }

    static Stream<Arguments> provideCountVowels2D() {
        return Stream.of(
                Arguments.of(new String[][]{{"apple", "banana"}, {"orange", "grape"}}, 10),
                Arguments.of(new String[][]{{"brr", "xyz"}}, 0),
                Arguments.of(new String[][]{{"AI", "UI", "aeiou"}}, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("provideSumOfLongestStrings")
    public void testSumOfLongestStrings(String[][] words, int expected) {
        assertEquals(expected, TwoDimensionalApp.sumOfLongestStrings(words));
    }

    static Stream<Arguments> provideSumOfLongestStrings() {
        return Stream.of(
                Arguments.of(new String[][]{{"apple", "banana", "cat"}}, 6),
                Arguments.of(new String[][]{{"dog", "orange"}}, 6),
                Arguments.of(new String[][]{{"a"}}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideFlattenToUpper")
    public void testFlattenToUpper(String[][] words, String[] expected) {
        assertArrayEquals(expected, TwoDimensionalApp.flattenToUpper(words));
    }

    static Stream<Arguments> provideFlattenToUpper() {
        return Stream.of(
                Arguments.of(new String[][]{{"robot"}}, new String[]{"ROBOT"}),
                Arguments.of(new String[][]{{"a", "", " b "}}, new String[]{"A", "", " B "}),
                Arguments.of(new String[][]{{"hello", "world"}}, new String[]{"HELLO", "WORLD"})
        );
    }

    @ParameterizedTest
    @MethodSource("provideContainsDigit2D")
    public void testContainsDigit2D(String[][] words, boolean[][] expected) {
        assertArrayEquals(expected, TwoDimensionalApp.containsDigit2D(words));
    }

    static Stream<Arguments> provideContainsDigit2D() {
        return Stream.of(
                Arguments.of(
                        new String[][]{{"abc123", "xyz"}, {"42", "hello5"}},
                        new boolean[][]{{true, false}, {true, true}}),
                Arguments.of(
                        new String[][]{{"test"}, {"nodigit"}, {"one1"}},
                        new boolean[][]{{false}, {false}, {true}}),
                Arguments.of(
                        new String[][]{{"0"}, {"1a", "b2"}, {"c"}},
                        new boolean[][]{{true}, {true, true}, {false}}),
                Arguments.of(
                        new String[][]{{"", " "}, {"123", "!"}},
                        new boolean[][]{{false, false}, {true, false}}),
                Arguments.of(
                        new String[][]{{"9"}, {"eight"}, {"seven7"}},
                        new boolean[][]{{true}, {false}, {true}})
        );
    }

    @ParameterizedTest
    @MethodSource("provideAverageChartersPerString")
    public void testAverageChartersPerString(String[][] words, double expected) {
        assertEquals(expected, TwoDimensionalApp.averageChartersPerString(words), 0.001);
    }

    static Stream<Arguments> provideAverageChartersPerString() {
        return Stream.of(
                Arguments.of(new String[][]{{"a", "bb"}, {"ccc"}}, 2.0),
                Arguments.of(new String[][]{{"hello"}, {"world"}}, 5.0),
                Arguments.of(new String[][]{{"a", "b", "c"}}, 1.0),
                Arguments.of(new String[][]{{"abc"}, {"", "de"}}, 1.666),
                Arguments.of(new String[][]{{"x"}}, 1.0)

        );
    }


    //Three Dimensional Test Phase :

    @ParameterizedTest
    @MethodSource("providethePalindromTask")
    public void testThePalindromicTask(String[][][] words, int expected) {
        assertEquals(expected, ThreeDimensionalApp.thePalindromicTask(words));
    }

    static Stream<Arguments> providethePalindromTask() {
        return Stream.of(
                Arguments.of(
                        new String[][][]{
                                {{"madam", "racecar"}},
                                {{"level"}},
                                {{"world", "noon"}}}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsInSub")
    public void testCountStringsInSubSubarrays(String[][][] words, int[] expected) {
        assertArrayEquals(expected, ThreeDimensionalApp.countStringsInSubSubarrays(words));
    }

    static Stream<Arguments> provideStringsInSub() {
        return Stream.of(
                Arguments.of(
                        new String[][][]{{{"a", "b"}, {"c"}}, {{"d", "e", "f"}}}, new int[]{2, 1, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("provideConcatenationWithString")
    public void testConcatenationWithString(String[][][] words, String expected) {
        assertEquals(expected, ThreeDimensionalApp.concatenationWithString(words));
    }

    static Stream<Arguments> provideConcatenationWithString() {
        return Stream.of(
                Arguments.of(new String[][][]{{{"hi", "a"}, {"ok"}}, {{"b", "yes"}, {"go"}}}, "hiokyesgo")
        );

    }

    @ParameterizedTest
    @MethodSource("provideGetLongestWordLength")
    public void testGetLongestWordLength(String[][][] words, int expected) {
        assertEquals(expected, ThreeDimensionalApp.getLongestWordLength(words));
    }

    static Stream<Arguments> provideGetLongestWordLength() {
        return Stream.of(
                Arguments.of(new String[][][]{{{"banana"}}, {{}}}, 6),
                Arguments.of(new String[][][]{}, 0),
                Arguments.of(new String[][][]{{{"abcd", "1234"}, {"xyzw"}}, {{"four"}}}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("provideWordsForEndsWithSTest")
    void testAllSubarraysContainWordEndingWithS(String[][][] words, boolean expected) {
        assertEquals(expected, ThreeDimensionalApp.allSubarraysContainWordEndingWithS(words));
    }

    private static Stream<Arguments> provideWordsForEndsWithSTest() {
        return Stream.of(

                Arguments.of(new String[][][]{{{"apples", "banana"}, {"dogs"}}, {{"cats", "milk"}}}, true),
                Arguments.of(new String[][][]{{{"apple", "banana"}, {"dog"}}, {{"cat", "milk"}}}, false),
                Arguments.of(new String[][][]{{{"s"}}}, true),
                Arguments.of(new String[][][]{{{}}}, false),
                Arguments.of(new String[][][]{{{"books", "note"}, {"pens"}}, {{"shoes", "cap"}, {"dress"}}}, true)
        );
    }

    //Four Dimensional Test Phase:

    @ParameterizedTest
    @MethodSource("provideLowerCaseWords")
    public void testCountLowerCaseWords(String[][][][] words, int expected) {
        assertEquals(expected, FourDimensionalApp.countLowerCaseWords(words));
    }

    static Stream<Arguments> provideLowerCaseWords() {
        return Stream.of(
                Arguments.of(new String[][][][]{
                        {{{"hello"}, {"world"}}}
                }, 2),
                Arguments.of(new String[][][][]{
                        {{{"Hello"}, {"world"}}}
                }, 1),
                Arguments.of(new String[][][][]{
                        {{{"HELLO"}, {"WORLD"}}}
                }, 0),
                Arguments.of(new String[][][][]{
                        {{{"abc", "Def"}}, {{"ghi"}}, {{"jKL"}}}
                }, 2),
                Arguments.of(new String[][][][]{}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideReverseAllStrings")
    public void testReverseAllStrings(String[][][][] words, String expected) {
        assertEquals(expected, FourDimensionalApp.reverseAllStrings(words));
    }

    static Stream<Arguments> provideReverseAllStrings() {
        return Stream.of(
                Arguments.of((Object) new String[][][][]{
                        {
                                {
                                        {"dog", "cat"},
                                        {"fish", "bird"}
                                },
                                {
                                        {"cow", "bat"},
                                        {"ant", "pig"}
                                }
                        }
                })
        );
    }

    @ParameterizedTest
    @MethodSource("provideAverageStringLength")
    public void testAverageStringLength(String[][][][] words, int expected) {
        assertEquals(expected, FourDimensionalApp.averageStringLength(words));
    }

    static Stream<Arguments> provideAverageStringLength() {
        return Stream.of(
                Arguments.of((Object) new String[][][][]{
                        {
                                {
                                        {"dog", "cat"},
                                        {"fish", "bird"}
                                },
                                {
                                        {"cow", "bat"},
                                        {"ant", "pig"}
                                }
                        }
                }, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideFindVowelRichWords")
    public void testFindVowelRichWords(String[][][][] words, List<String> expected) {
        assertEquals(expected, FourDimensionalApp.findVowelRichWords(words));
    }

    static Stream<Arguments> provideFindVowelRichWords() {
        return Stream.of(
                Arguments.of(
                        new String[][][][]{
                                {
                                        {
                                                {"banana", "sky"},
                                                {"audio", "zip"}
                                        },
                                        {
                                                {"orange", "fly"},
                                                {"cup", "hello"}
                                        }
                                }
                        },
                        List.of("banana", "audio", "orange")
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideFindShortestWord")
    public void testFindShortestWord(String[][][][] words, String expected) {
        assertEquals(expected, FourDimensionalApp.findShortestWord(words));
    }

    static Stream<Arguments> provideFindShortestWord() {
        return Stream.of(
                Arguments.of(
                        new String[][][][]{
                                {
                                        {
                                                {"banana", "sky"},
                                                {"audio", "zip"}
                                        },
                                        {
                                                {"orange", "fly"},
                                                {"cup", "hello"}
                                        }
                                }
                        },
                        "sky"
                )
        );
    }

    //Five Dimensional Test Phase:

    @ParameterizedTest
    @MethodSource("provideCountFilteredWords")
    public void testCountFilteredWords(String[][][][][] words,int expected) {
        assertEquals(expected,FiveDimensionalApp.countFilteredWords(words));
    }

    static Stream<Arguments> provideCountFilteredWords() {
        return Stream.of(Arguments.of(
                        new String[][][][][]{
                                {
                                        {
                                                {
                                                        { "cat", "dog" },
                                                        { "sky", "fly" }
                                                },
                                                {
                                                        { "tree", "rose" },
                                                        { "sun", "moon" }
                                                }
                                        }
                                }
                        },
                        6)
        );
    }

    @ParameterizedTest
    @MethodSource("provideReplaceStringsWithLengths")
    public void testReplaceStringsWithLengths(String[][][][][] words, int[][][][][] expected) {
        assertArrayEquals(expected, FiveDimensionalApp.replaceStringsWithLengths(words));
    }

    static Stream<Arguments> provideReplaceStringsWithLengths() {
        return Stream.of(
                Arguments.of(
                        new String[][][][][]{
                                {
                                        {
                                                {
                                                        { "hi", "there" },
                                                        { "OTP", "rocks" }
                                                }
                                        }
                                }
                        },
                        new int[][][][][]{
                                {
                                        {
                                                {
                                                        { 2, 5 },
                                                        { 3, 5 }
                                                }
                                        }
                                }
                        }
                ),
                Arguments.of(
                        new String[][][][][]{
                                {
                                        {
                                                {
                                                        { "a", "bc" }
                                                }
                                        },
                                        {
                                                {
                                                        { "def" }
                                                }
                                        }
                                }
                        },
                        new int[][][][][]{
                                {
                                        {
                                                {
                                                        { 1, 2 }
                                                }
                                        },
                                        {
                                                {
                                                        { 3 }
                                                }
                                        }
                                }
                        }
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideSameStartEndLengthData")
    public void testCountSameStartEndLength(String[][][][][] words, int expected) {
        assertEquals(expected, FiveDimensionalApp.countSameStartEndLength(words));
    }

    static Stream<Arguments> provideSameStartEndLengthData() {
        return Stream.of(
                Arguments.of(
                        new String[][][][][] {
                                {
                                        {
                                                {
                                                        { "apple", "arena" },
                                                        { "bob", "test" }
                                                }
                                        }
                                }
                        },
                        12
                ),
                Arguments.of(
                        new String[][][][][] {
                                {
                                        {
                                                {
                                                        { "wow", "echo", "eye" }
                                                }
                                        }
                                }
                        },
                        6
                ),
                Arguments.of(
                        new String[][][][][] {
                                {
                                        {
                                                {
                                                        { "apple", "banana" }
                                                }
                                        }
                                }
                        },
                        0
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideConcatenatedWords")
    public void testConcatenateAllWords(String[][][][][] words, String expected) {
        assertEquals(expected, FiveDimensionalApp.concatenateAllWords(words));
    }

    static Stream<Arguments> provideConcatenatedWords() {
        return Stream.of(
                Arguments.of(
                        new String[][][][][] {
                                {
                                        {
                                                {
                                                        { "hello", "world" },
                                                        { "foo", "bar" }
                                                }
                                        }
                                }
                        },
                        "helloworldfoobar"
                ),
                Arguments.of(
                        new String[][][][][] {
                                {
                                        {
                                                {
                                                        { "a", "b" },
                                                        { "c" }
                                                }
                                        }
                                }
                        },
                        "abc"
                ),
                Arguments.of(
                        new String[][][][][] {
                                {
                                        {
                                                {
                                                        {}
                                                }
                                        }
                                }
                        },
                        ""
                )
        );
    }





}

