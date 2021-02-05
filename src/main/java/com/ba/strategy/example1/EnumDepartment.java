package com.ba.strategy.example1;

public enum EnumDepartment {
    SOZEL("Sözel"),
    SAYISAL("Sayisal"),
    ESITAGIRLIK("Esit Agirlik");

    private String department;

    EnumDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return department;
    }
}
