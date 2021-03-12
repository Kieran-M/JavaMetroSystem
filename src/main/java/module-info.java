module groupid {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.group8 to javafx.fxml;
    exports org.group8;
}