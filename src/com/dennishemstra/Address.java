package com.dennishemstra;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Address {
    private String addressLabel;
    private String addressStreet;
    private int addressHouseNumber;
    private String addressPostalCode;
    private String addressCity;

    public void addAddress(String addressLabel, String addressStreet, int addressHouseNumber, String addressPostalCode, String addressCity) {
        this.addressLabel = addressLabel;
        this.addressStreet = addressStreet;
        this.addressHouseNumber = addressHouseNumber;
        this.addressPostalCode = addressPostalCode;
        this.addressCity = addressCity;
    }

    public String getAddress(){
        return(this.addressLabel+";"+this.addressStreet+";"+this.addressHouseNumber+";"+
                this.addressPostalCode+";"+this.addressCity);
    }

    public void saveAddress() {
        try {
            FileWriter addressBook = new FileWriter("addressbook.csv", true);
            BufferedWriter bw = new BufferedWriter(addressBook);
            bw.write(getAddress());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Oops, something went wrong. Make sure the .csv file exists and isn't in use by another program.");
        }
    }
}
