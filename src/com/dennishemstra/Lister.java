package com.dennishemstra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lister {

    ArrayList<String> carList = new ArrayList<>();
    ArrayList<String> addressBook = new ArrayList<>();
    ArrayList<String> journeyList = new ArrayList<>();
    File carsFile = new File("carlist.csv");
    File addressFile = new File("addressbook.csv");
    File journeyFile = new File("journeylist.csv");
    Scanner scanner;
    String lastJourney = getJourneyList().getLast();

    public ArrayList<String> getCarList() {
        try {
            scanner = new Scanner(carsFile);
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                carList.add(scanner.nextLine());
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Oops, something went wrong!");
        }
        return carList;
    }
    public String getCarStringFromList(String car) {
        return (car.split(";"))[0] + " " + (car.split(";"))[1] + " - " + (car.split(";"))[2];

    }
    public ArrayList<String> getAddressList() {
        try {
            scanner = new Scanner(addressFile);
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                addressBook.add(scanner.nextLine());
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Oops, something went wrong!");
        }
        return addressBook;
    }

    public ArrayList<String> getJourneyList() {
        try {
            scanner = new Scanner(journeyFile);
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                journeyList.add(scanner.nextLine());
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Oops, something went wrong!");
        }
        return journeyList;
    }

    public int getKmEnd() {

        String lastKm = (lastJourney.split(";"))[2];
        return Integer.parseInt(lastKm);
    }

    public String getLastLocation() {
        return (lastJourney.split(";"))[4];
    }
}
