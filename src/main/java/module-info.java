module org.example.morsecodetree {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.morsecodetree to javafx.fxml;
    exports org.example.morsecodetree;
}