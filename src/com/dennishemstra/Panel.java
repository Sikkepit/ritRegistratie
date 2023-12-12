package com.dennishemstra;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;

public class Panel extends JPanel{


    Lister lister;
    public Panel() {

        lister = new Lister();

        //construct labels
        JLabel dateLabel = new JLabel("Datum");
        JLabel kmStartLabel = new JLabel("Beginstand (km)");
        JLabel kmEndLabel = new JLabel("Eindstand (km)");
        JLabel locationStartLabel = new JLabel("Vertreklocatie");
        JLabel locationDestinationLabel = new JLabel("Bestemming");
        JLabel journeyDescLabel = new JLabel("Beschrijving");
        JLabel privateCheckLabel = new JLabel("Is de rit prive?");
        JLabel journeyVehicleLabel = new JLabel("Voertuig");

        //construct components
        JTextField dateField = new JTextField(5);
        JTextField kmStartField = new JTextField(5);
        JTextField kmEndField = new JTextField(5);
        JTextField locationStartField = new JTextField(5);
        JTextField locationDestinationField = new JTextField(5);
        JTextField journeyDescField = new JTextField(5);
        JCheckBox privateCheckField = new JCheckBox("");
        JComboBox<String> journeyVehicleDropDown = new JComboBox<>();
        JButton submitButton = new JButton("Opslaan");
        JButton cancelButton = new JButton("Afsluiten");

        //set initial values for dateField, kmStart and locationStart
        dateField.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        try {
            kmStartField.setText(String.valueOf(lister.getKmEnd()));
        } catch (Exception ignored) {}

        try {
            locationStartField.setText(lister.getLastLocation());
        } catch (Exception ignored) {}

        // setup cars dropdown
        journeyVehicleDropDown.setFocusable(false);
        ArrayList <String> cars = lister.getCarList();
        for (String car : cars) {
            journeyVehicleDropDown.addItem(lister.getCarStringFromList(car));
        }

        // setup exit-button
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // setup submit-button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String journeyVehicle = String.valueOf(journeyVehicleDropDown.getSelectedItem());
                    if (!kmStartField.getText().isEmpty() && !kmEndField.getText().isEmpty() &&
                        Integer.parseInt(kmStartField.getText()) < Integer.parseInt(kmEndField.getText())) {


                        String carToBeSavedBrand = journeyVehicle.split(" ")[0];
                        String carToBeSavedModel = journeyVehicle.split(" ")[1];
                        String carToBeSavedLicensePlate = journeyVehicle.split("- ")[1];
                        Car newCar = new Car();
                        newCar.addCar(carToBeSavedBrand, carToBeSavedModel, carToBeSavedLicensePlate);
                        Journey newJourney = new Journey();
                        newJourney.addJourney(
                                dateField.getText(),
                                Integer.parseInt(kmStartField.getText()),
                                Integer.parseInt(kmEndField.getText()),
                                locationStartField.getText(),
                                locationDestinationField.getText(),
                                privateCheckField.isSelected(),
                                journeyDescField.getText(),
                                newCar);
                        newJourney.saveJourney();
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Rit opgeslagen");

                        kmStartField.setText(kmEndField.getText());
                        kmEndField.setText("");
                        locationStartField.setText(locationDestinationField.getText());
                        locationDestinationField.setText("");
                        privateCheckField.setSelected(false);
                        journeyDescField.setText("");
                    }
                    else {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                                "De opgegeven kilometerstanden zijn onjuist of onvolledig.",
                                "Foutmelding", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                            "Oeps! Er ging iets fout. Controleer of je het formulier juist hebt ingevuld.",
                            "Foutmelding", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        //adjust size and set layout
        setPreferredSize (new Dimension (450, 427));
        setLayout (null);

        //add components
        add (dateField);
        add (kmStartField);
        add (kmEndField);
        add (locationStartField);
        add (locationDestinationField);
        add (journeyDescField);
        add (journeyVehicleDropDown);
        add (dateLabel);
        add (kmStartLabel);
        add (kmEndLabel);
        add (locationStartLabel);
        add (locationDestinationLabel);
        add (journeyDescLabel);
        add (privateCheckLabel);
        add (journeyVehicleLabel);
        add (privateCheckField);
        add (submitButton);
        add (cancelButton);

        //set component bounds
        dateField.setBounds (160, 40, 245, 25);
        kmStartField.setBounds (160, 75, 245, 25);
        kmEndField.setBounds (160, 110, 245, 25);
        locationStartField.setBounds (160, 145, 245, 25);
        locationDestinationField.setBounds (160, 180, 245, 25);
        journeyDescField.setBounds (160, 215, 245, 25);
        privateCheckField.setBounds (158, 250, 100, 25);
        journeyVehicleDropDown.setBounds (160, 285, 245, 25);

        submitButton.setBounds (110, 365, 100, 25);
        cancelButton.setBounds (230, 365, 100, 25);

        dateLabel.setBounds (40, 40, 100, 25);
        kmStartLabel.setBounds (40, 75, 100, 25);
        kmEndLabel.setBounds (40, 110, 100, 25);
        locationStartLabel.setBounds (40, 145, 100, 25);
        locationDestinationLabel.setBounds (40, 180, 100, 25);
        journeyDescLabel.setBounds (40, 215, 100, 25);
        privateCheckLabel.setBounds (40, 250, 100, 25);
        journeyVehicleLabel.setBounds (40, 285, 100, 25);

    }

}
