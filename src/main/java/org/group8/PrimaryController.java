package org.group8;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import org.group8.bostonmetrosystem.BostonMetro;
import org.group8.bostonmetrosystem.Station;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class PrimaryController {

    public Button changeView;
    private Double zoomScaleX;

    private Double zoomScaleY;

    private final BostonMetro bm = new BostonMetro();
    @FXML
    private ImageView mapImage;
    @FXML
    private Slider zoomSlider;
    @FXML
    private TextArea textBox;
    @FXML
    private ComboBox<String> homeStation;
    @FXML
    private ComboBox<String> destinationStation;

    /**
     * Initialises the comboboxes by clearing them and then filling with the stations parsed in boston metro
     */
    @FXML
    public void initialize(){
        this.clearData();
        this.setData(bm.getStations());
        zoomScaleX = 1.00;
        zoomScaleY = 1.00;
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
     * Searches for a route between the two selected stations and displays it to the textarea
     */
    @FXML
    void getRoute() {
        ArrayList<Station> route = new ArrayList<>(bm.getRoute());
        StringBuilder sb = new StringBuilder();
        for (Station station : route) {
            sb.append(station.getName()).append("\n");
        }
        this.updateTextArea(sb.toString());
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
    @FXML
    private void changeZoom(ScrollEvent scrollEvent) {
        if (scrollEvent.getDeltaY() > 0) {
            if (zoomScaleX + 1 <= 5) {
                zoomScaleX += 1;
                zoomScaleY += 1;
                mapImage.setScaleX(zoomScaleX);
                mapImage.setScaleY(zoomScaleY);
            }
        } else {
            if (zoomScaleX - 1 >= 1) {
                zoomScaleX -= 1;
                zoomScaleY -= 1;
                mapImage.setScaleX(zoomScaleX);
                mapImage.setScaleY(zoomScaleY);
            }
        }
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
            System.out.println("Yep");
            //Previously selected station will be stored in the boston metro object
            homeStation.setValue(bm.getDestination().getName());
            //Update the new home station
            bm.setHomeStation(bm.lookupStation(homeStation.getValue()));
        }
        //Update the new destination station
        bm.setDestination(bm.lookupStation(destinationStation.getValue()));
    }

    /**
     * Changes to a more detailed view of the boston metro
     * Currently doessnt work (URL problems)
     * @param actionEvent
     */
    public void changeImage(ActionEvent actionEvent) {
        if(mapImage.getImage().getUrl().equals("bostonmetro.png")){
            mapImage.setImage(new Image("src/main/resources/org/group8/bostonmetro2.png"));
        }
        else{
            mapImage.setImage(new Image("src/main/resources/org/group8/bostonmetro.png"));
        }
    }
}

