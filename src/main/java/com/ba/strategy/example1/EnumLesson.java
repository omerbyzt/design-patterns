package com.ba.strategy.example1;

public enum EnumLesson {
    TURKCE("Türkçe"),
    MATH("Matematik"),
    FEN("Fen Bilgisi"),
    SOSYAL("Sosyal");

    private String lesson;

    EnumLesson(String lesson) {
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return lesson;
    }
}
