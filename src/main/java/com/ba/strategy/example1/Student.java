package com.ba.strategy.example1;

public class Student {

    private EnumDepartment department;
    private ExamStrategy examStrategy;

    public Student(EnumDepartment department) {
        this.department = department;

        if(department == null){
            throw new NullPointerException("Department cannot be empty...!");
        }

        switch (department){
            case SOZEL:
                examStrategy = new SozelStrategy();
                break;
            case ESITAGIRLIK:
                examStrategy = new EsitAgırlıkStrategy();
                break;
            case SAYISAL:
                examStrategy = new SayisalStrategy();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public String priority(){
        System.out.println(department + " Strategy : ");

        String ranking = "First " + examStrategy.getFirst() + "\n" +
                "Second " + examStrategy.getSecond() + "\n" +
                "Third " + examStrategy.getThird() + "\n" +
                "Last " + examStrategy.getFourth() + "\n";

        return ranking;
    }

}
