package com.dennishemstra;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Journey {

    private String journeyDate;
    private int kmStart;
    private int kmEnd;
    private String startAddress;
    private String destinationAddress;
    private  boolean privateJourney;
    private String journeyDescription;
    private Car journeyVehicle;


    public void addJourney(String journeyDate, int kmStart, int kmEnd, String startAddress, String destinationAddress, boolean privateJourney, String journeyDescription, Car journeyVehicle) {
        this.journeyDate = journeyDate;
        this.kmStart = kmStart;
        this.kmEnd = kmEnd;
        this.startAddress = startAddress;
        this.destinationAddress = destinationAddress;
        this.privateJourney = privateJourney;
        this.journeyDescription = journeyDescription;
        this.journeyVehicle = journeyVehicle;
    }
    public String getJourney() {
        String car = this.journeyVehicle.getCar();
        return(this.journeyDate+";"+this.kmStart+";"+this.kmEnd+";"+this.startAddress+";"+
                this.destinationAddress+";"+this.privateJourney+";"+this.journeyDescription+";" +car);
    }
    public void saveJourney() {
        try {
            FileWriter journeyList = new FileWriter("journeylist.csv", true);
            BufferedWriter bw = new BufferedWriter(journeyList);
            String car = this.journeyVehicle.getCar();
            bw.write(this.getJourney());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Oops, something went wrong. Make sure the .csv file exists and isn't in use by another program.");
        }
    }



}
