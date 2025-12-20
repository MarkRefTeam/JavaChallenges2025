package model;

public class Card {

    private final Colour colour;
    private final Value value;

    public Colour getColour() {
        return colour;
    }

    public Value getValue() {
        return value;
    }

    //Extra String:
    public Card(String raw) {
        this.colour = parseColour(raw.charAt(0));
        this.value = parseValue(raw.charAt(1));
    }

    //Parse Methods:
    private static Colour parseColour(char c) {
        return switch (c) {
            case 'M' -> Colour.MAKK;
            case 'Z' -> Colour.ZOLD;
            case 'P' -> Colour.PIROS;
            case 'T' -> Colour.TOK;
            default -> throw new IllegalArgumentException("Invalid colour: " + c);
        };
    }

    private static Value parseValue(char c) {
        return switch (c) {
            case '7' -> Value.HET;
            case '8' -> Value.NYOLC;
            case '9' -> Value.KILENC;
            case 'T' -> Value.TIZ;
            case 'A' -> Value.ALSO;
            case 'F' -> Value.FELSO;
            case 'K' -> Value.KIRALY;
            case 'Z' -> Value.ASZ;
            default -> throw new IllegalArgumentException("Invalid value: " + c);
        };
    }
}
