package org.example.validator;

public interface Validator<T> {
    boolean validate(T input);
}
