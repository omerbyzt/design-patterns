package com.ba.strategy.example1;

public class SayisalStrategy implements ExamStrategy{
    @Override
    public EnumLesson getFirst() {
        return EnumLesson.MATH;
    }

    @Override
    public EnumLesson getSecond() {
        return EnumLesson.TURKCE;
    }

    @Override
    public EnumLesson getThird() {
        return EnumLesson.FEN;
    }

    @Override
    public EnumLesson getFourth() {
        return EnumLesson.SOSYAL;
    }
}
