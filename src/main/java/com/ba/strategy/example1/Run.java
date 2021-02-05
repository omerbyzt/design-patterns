package com.ba.strategy.example1;

public class Run {
    public static void main(String[] args) {
        System.out.println("----------Sayisal------------");
        writePriority(EnumDepartment.SAYISAL);

        System.out.println("----------Sozel------------");
        writePriority(EnumDepartment.SOZEL);

        System.out.println("----------EsitAgirlik------------");
        writePriority(EnumDepartment.ESITAGIRLIK);
    }

    private static void writePriority(EnumDepartment department) {
        Student student = new Student(department);
        System.out.println(student.priority());
    }
}
