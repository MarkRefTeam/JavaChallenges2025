package hu.markrefteam.crud.ui;

public class EnumPicker {

    public static <T extends Enum<T>> T pick(Class<T> enumType, int choice) {
        T[] values = enumType.getEnumConstants();
        if (choice < 1 || choice > values.length) return null;
        return values[choice - 1];
    }

    public static <T extends Enum<T>> void printOptions(Class<T> enumType) {
        T[] values = enumType.getEnumConstants();
        for (int i = 0; i < values.length; i++) {
            System.out.printf("%d) %s%n", i + 1, values[i].name());
        }
    }
}