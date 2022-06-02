package org.exapmple;

public class CatNotFoundException extends RuntimeException {
    public CatNotFoundException(Long id) {

        super("Нет такого кота: " + id);

    }
}
