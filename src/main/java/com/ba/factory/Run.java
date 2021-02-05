package com.ba.factory;

public class Run {
    public static void main(String[] args) {
        String file = FileExporterFactory.getInstance(FileExporterFactory.FileType.EXCEL)
                .export("Test EXCEL file content");
        System.out.println(file);
    }
}
