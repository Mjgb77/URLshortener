package com.company;

import java.util.Arrays;
import java.util.Optional;

public enum Operation {
    FINISH("finish"),
    SHORTEN("shorten"),
    EXPAND("expand");

    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    static Optional<Operation> getOperation(String value) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.operation.equals(value))
                .findFirst();
    }
}
