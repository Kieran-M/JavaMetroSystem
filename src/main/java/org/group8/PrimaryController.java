package org.group8;

import java.io.*;
import java.util.*;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import org.group8.bostonmetrosystem.BostonMetro;
import org.group8.bostonmetrosystem.Station;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class PrimaryController {
    private final BostonMetro bm = new BostonMetro();

    HashMap<String, double[]> coordsMap;

    @FXML
    private GraphicsContext gc;
    @FXML
    private TextArea textBox;
    @FXML
    private ComboBox<String> homeStation;
    @FXML
    private ComboBox<String> destinationStation;
    @FXML
    private Button searchButton;
    @FXML
    private Canvas canvas;
    @FXML
    private ImageView mapImage;

    /**
     * Initialises the comboboxes by clearing them and then filling with the stations parsed in boston metro,
     * sets the canvas and gets each stations coordinates on the canvas for drawing on later
     */
    @FXML
    public void initialize(){
        this.clearData();
        this.setData(bm.getStations());
        this.gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLACK);
        parseCoords();
    }

    /**
     * Clears the items in the comboboxes
     */
    @FXML
    void clearData(){
        homeStation.getItems().clear();
        destinationStation.getItems().clear();
    }

    /**
     * Adds the list of stations to the comboboxes and sets metro values for home and destination stations
     * @param items A list of Station names
     */
    @FXML
    void setData(List<String> items){
        this.clearData();

        ObservableList<String> oList = FXCollections.observableArrayList(items);
        homeStation.setItems(oList);
        destinationStation.setItems(oList);

        homeStation.getSelectionModel().selectFirst();
        destinationStation.getSelectionModel().selectLast();

        //Set the stations in the model
        bm.setHomeStation(bm.lookupStation(homeStation.getValue()));
        bm.setDestination(bm.lookupStation(destinationStation.getValue()));
    }

    /**
     * Searches for a route between the two selected stations, displays it to the textarea and then shows the route on the map
     */
    @FXML
    void getRoute() {
        ArrayList<Station> route = new ArrayList<>(bm.getRoute());
        StringBuilder sb = new StringBuilder();
        for (Station station : route) {
            sb.append(station.getName()).append("\n");
        }
        this.updateTextArea(sb.toString());
        drawRoute(route);
    }

    /**
     * Updates the text area with the given text
     * @param txt Message to be displayed
     */
    @FXML
    private void updateTextArea(String txt){
        textBox.clear();
        textBox.setText(txt);
    }

    /**
     * Changes the current home station to the newly selected station
     * @param actionEvent onChange event
     */
    public void homeStationChange(ActionEvent actionEvent) {
        //If changing home station to the same station as destination then change the destination station to the previous home station
        if(homeStation.getValue().equals(destinationStation.getValue())){
            //Previously selected station will be stored in the boston metro object
            destinationStation.setValue(bm.getStation().getName());
            //Update the new destination station
            bm.setDestination(bm.lookupStation(destinationStation.getValue()));
        }
        //Update the new home station
        bm.setHomeStation(bm.lookupStation(homeStation.getValue()));
    }

    /**
     * Changes the current destination station to the newly selected station
     * @param actionEvent onChange event
     */
    public void destinationStationChanged(ActionEvent actionEvent) {
        //If changing destination station to the same station as home station then change the home station to the previous destination station
        if(destinationStation.getValue().equals(homeStation.getValue())){
            //Previously selected station will be stored in the boston metro object
            homeStation.setValue(bm.getDestination().getName());
            //Update the new home station
            bm.setHomeStation(bm.lookupStation(homeStation.getValue()));
        }
        //Update the new destination station
        bm.setDestination(bm.lookupStation(destinationStation.getValue()));
    }

    /**
     * Draws the route between current and destination station
     * @param route route of stations to be highlighted
     */
    @FXML
    public void drawRoute(List<Station> route){
        //CLear the canvas
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        //Draw oval representing the station on canvas
        for (Station station : route) {
            double[] coords = coordsMap.get(station.getName());
            gc.fillOval(coords[0],coords[1],13,13);
        }
    }

    /**
     * Parse each stations coordinates for drawing on canvas
     */
    public void parseCoords(){
        coordsMap = new HashMap<>();
        File file = new File("src/main/resources/org/group8/stationCoordinates.txt");

        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String stationName = sc.next();
                double[] coords = {sc.nextInt(), sc.nextInt()};
                coordsMap.put(stationName,coords);
            }
        }catch(IOException e){
            e.printStackTrace();
        }


    }
}

