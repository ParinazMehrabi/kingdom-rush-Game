module org.example.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.media;

    opens view to javafx.fxml;
    exports view;
    exports view.fxmlController;
    opens view.fxmlController to javafx.fxml;
}