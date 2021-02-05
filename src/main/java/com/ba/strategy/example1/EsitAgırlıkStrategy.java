package com.ba.strategy.example1;

public class EsitAgırlıkStrategy implements  ExamStrategy{
    @Override
    public EnumLesson getFirst() {
        return EnumLesson.TURKCE;
    }

    @Override
    public EnumLesson getSecond() {
        return EnumLesson.MATH;
    }

    @Override
    public EnumLesson getThird() {
        return EnumLesson.SOSYAL;
    }

    @Override
    public EnumLesson getFourth() {
        return EnumLesson.FEN;
    }
}
