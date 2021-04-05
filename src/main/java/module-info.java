module groupid {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.group8.bostongui to javafx.fxml;
    exports org.group8.bostongui;
    exports org.group8.bostonmetrosystem;
    exports org.group8.directedgraph;
}