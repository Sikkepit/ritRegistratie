package com.dennishemstra;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;

public class Panel extends JPanel {


    Lister lister;
    public Panel() {

        lister = new Lister();

        //construct components and give default values
        JTextField dateField = new JTextField(5);
        dateField.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        JTextField kmStartField = new JTextField(5);
        kmStartField.setText(String.valueOf(lister.getKmEnd()));

        JTextField kmEndField = new JTextField(5);

        JTextField locationStartField = new JTextField(5);
        locationStartField.setText(lister.getLastLocation());

        JTextField locationDestinationField = new JTextField(5);
        JTextField journeyDescField = new JTextField(5);

        JComboBox<String> journeyVehicleDropDown = new JComboBox<>();
        journeyVehicleDropDown.setFocusable(false);
        ArrayList <String> cars = lister.getCarList();
        for (String car : cars) {
//            int index = cars.indexOf(car) + 1;
            journeyVehicleDropDown.addItem(lister.getCarStringFromList(car));
        }

        JButton submitButton = new JButton("Opslaan");
        JButton cancelButton = new JButton("Annuleren");


        JLabel dateLabel = new JLabel("Datum");
        JLabel kmStartLabel = new JLabel("Beginstand (km)");
        JLabel kmEndLabel = new JLabel("Eindstand (km)");
        JLabel locationStartLabel = new JLabel("Vertreklocatie");
        JLabel locationDestinationLabel = new JLabel("Bestemming");
        JLabel journeyDescLabel = new JLabel("Beschrijving");
        JLabel privateCheckLabel = new JLabel("Is de rit prive?");
        JLabel journeyVehicleLabel = new JLabel("Voertuig");
        JCheckBox privateCheckField = new JCheckBox("");

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
