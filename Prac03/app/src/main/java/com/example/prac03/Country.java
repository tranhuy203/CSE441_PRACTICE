package com.example.prac03;

public class Country {
    private String name;
    private long population;
    private String details;
    private int flagResource;
    private double area;  // Thêm diện tích
    private double density;  // Thêm mật độ dân số
    private double worldShare;  // Thêm tỷ lệ thế giới

    public Country(String name, long population, String details, int flagResource, double area, double density, double worldShare) {
        this.name = name;
        this.population = population;
        this.details = details;
        this.flagResource = flagResource;
        this.area = area;
        this.density = density;
        this.worldShare = worldShare;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getFlagResource() {
        return flagResource;
    }

    public void setFlagResource(int flagResource) {
        this.flagResource = flagResource;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getWorldShare() {
        return worldShare;
    }

    public void setWorldShare(double worldShare) {
        this.worldShare = worldShare;
    }
}
