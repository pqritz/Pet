module com.example.pet {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.pet to javafx.fxml;
    exports com.example.pet;
}