package org.group8.GUI;

import org.group8.bostonmetrosystem.BostonMetro;
import org.group8.bostonmetrosystem.Station;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class GUI {
    public static void guiComponents(Container pane) {
        pane.setLayout(null);

        //Images
        ImageIcon image =  new ImageIcon("map.jpg");

        //Labels
        JLabel originStation = new JLabel("Origin Station");
        JLabel destinationStation = new JLabel("Destination Station");
        JLabel imgLabel =  new JLabel();
        imgLabel.setIcon(image);

        //Dropdowns
        BostonMetro bm = new BostonMetro();
        //ArrayList<Station> array = newClassObj.getStationArray();
        JComboBox stationList = new JComboBox(bm.getStations().toArray());
        JComboBox stationList2 = new JComboBox(bm.getStations().toArray());
        stationList.setSelectedItem(0);
        stationList2.setSelectedItem(1);

        //Combobox ActionListeners
        stationList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                bm.setStation((Station)stationList.getSelectedItem());
            }
        });

        //Textbox
        JTextArea textBox = new JTextArea();
        textBox.setEditable(false);

        //Buttons
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList <Station> route = new ArrayList<>(bm.getRoute());
                for (Station s : route) {
                    textBox.append(s.getName() + "\n");
                }
            }
        });



        //Adding components to panel.
        pane.add(originStation);
        pane.add(destinationStation);
        pane.add(stationList);
        pane.add(stationList2);
        pane.add(searchButton);
        pane.add(textBox);
        pane.add(imgLabel);

        //Absolute positioning for components
        Insets insets = pane.getInsets();
        Dimension size = originStation.getPreferredSize();
        originStation.setBounds(25 + insets.left, 400 + insets.top, size.width, size.height);
        size = destinationStation.getPreferredSize();
        destinationStation.setBounds(150 + insets.left, 400 + insets.top, size.width, size.height);
        size = stationList.getPreferredSize();
        stationList.setBounds(25 + insets.left, 425 + insets.top, 80, size.height);
        size = stationList2.getPreferredSize();
        stationList2.setBounds(150 + insets.left, 425 + insets.top, 80, size.height);
        size = searchButton.getPreferredSize();
        searchButton.setBounds(275 + insets.left, 425 + insets.top, 80, size.height);
        textBox.setBounds(375 + insets.left, 425 + insets.top, 300, 225);
        imgLabel.setBounds(170 + insets.left, 20 + insets.top, 350, 350);
    }



    public static void showGUI() {
        JFrame frame = new JFrame("Boston Metro System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        guiComponents(frame.getContentPane());

        Insets insets = frame.getInsets();

        frame.setMinimumSize(new Dimension(700, 700));
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main (String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                showGUI();
            }
        });
    }
}