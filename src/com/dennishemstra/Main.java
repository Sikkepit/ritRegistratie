package com.dennishemstra;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {

        JFrame frame = new JFrame ("Kilometerregistratie App");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Panel());
        frame.pack();
        frame.setVisible (true);
    }
}