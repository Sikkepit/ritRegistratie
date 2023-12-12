package com.dennishemstra;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Car {

    private String brand;
    private String model;
    private String licensePlate;

    public void addCar(String brand, String model, String licensePlate){
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
    }
    public String getCar() {
        return (this.brand + ";" + this.model + ";" + this.licensePlate);
    }

    public void saveCar() {
        try {
            FileWriter carList = new FileWriter("carlist.csv", true);
            BufferedWriter bw = new BufferedWriter(carList);
            bw.write(getCar());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Oops, something went wrong. Make sure the .csv file exists and isn't in use by another program.");
        }
    }
}
