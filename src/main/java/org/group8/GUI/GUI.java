package org.group8.GUI;

import org.group8.bostonmetrosystem.BostonMetro;
import org.group8.bostonmetrosystem.MetroMapParser;
import org.group8.bostonmetrosystem.Station;
import org.group8.bostonmetrosystem.Track;
import org.group8.directedgraph.DirectedGraph;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUI {
    private static JFrame frame;


    public static void main(String[] args){
        frame();
    }

    public static void frame(){
        BostonMetro bostonMetro = new BostonMetro();
        frame = new JFrame("Boston Metro System"); //Creates the window for the GUI
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Container for the frame
        Container content = frame.getContentPane();

        JLabel originStation = new JLabel("Origin Station");
        JLabel finalStation = new JLabel("Final Station");

        JComboBox stationList = new JComboBox(bostonMetro.getStations().toArray());
        JComboBox stationList2 = new JComboBox(bostonMetro.getStations().toArray());
        JButton search = new JButton("Search");

        //Text area to show the route
        JTextArea textBox = new JTextArea("Test");
        textBox.setEditable(false);

        //Add the text labels to the panel
        JPanel panel = new JPanel(new GridLayout(0,4));
        panel.add(originStation);
        panel.add(finalStation);

        //Add the dropdown lists, buttons and text area to the panel
        JPanel panel1 = new JPanel(new GridLayout(0,4));
        panel1.add(stationList);
        panel1.add(stationList2);
        panel1.add(search);
        panel1.add(textBox);

        content.add(panel, BorderLayout.NORTH);
        content.add(panel1, BorderLayout.SOUTH);

        frame.pack();
        frame.setSize(500, 100);
        frame.setVisible(true);

       // stationList.add()
    }
}
