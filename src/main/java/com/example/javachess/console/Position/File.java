package com.example.javachess.console.Position;

import lombok.Getter;

@Getter
public enum File {
    A("a", 1),
    B("b", 2),
    C("c", 3),
    D("d", 4),
    E("e", 5),
    F("f", 6),
    G("g", 7),
    H("h", 8)
    ;

    private final String fileName;
    private final int fileNumber;

    File(String fileName, int fileNumber) {
        this.fileName = fileName;
        this.fileNumber = fileNumber;
    }
}
