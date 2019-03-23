package Validator;

import Domain.Entity;

public interface Validator<T extends Entity> {

    void validate(T t);
}
