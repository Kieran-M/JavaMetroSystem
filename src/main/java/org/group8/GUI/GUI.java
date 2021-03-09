package org.group8.GUI;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private static JFrame frame;


    public static void main(String[] args){
        frame();
    }

    public static void frame(){
        frame = new JFrame("Boston Metro System"); //Creates the window for the GUI
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Container for the frame
        Container content = frame.getContentPane();

        JLabel originStation = new JLabel("Origin Station");
        JLabel finalStation = new JLabel("Final Station");

        JButton temp1 = new JButton("DropDown Box");
        JButton temp2 = new JButton("DropDown Box");
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
        panel1.add(temp1);
        panel1.add(temp2);
        panel1.add(search);
        panel1.add(textBox);

        content.add(panel, BorderLayout.NORTH);
        content.add(panel1, BorderLayout.SOUTH);

        frame.pack();
        frame.setSize(500, 100);
        frame.setVisible(true);
    }

}
