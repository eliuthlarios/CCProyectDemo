module org.example.candycrushproyect {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.swing;
    requires javafx.media;

    opens org.example.candycrushproyect to javafx.fxml;
    exports org.example.candycrushproyect;
}