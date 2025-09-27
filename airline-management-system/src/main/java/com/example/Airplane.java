package com.example;

public class Airplane {
    private String id;
    private String company;

    public Airplane(String id, String company) {
        this.id = id;
        this.company = company;
    }
    public String getId() {
        return id;
    }
    public String getCompany() {
        return company;
    }
}
