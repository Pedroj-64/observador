module co.edu.uniquindio.observer {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.observer to javafx.fxml;
    exports co.edu.uniquindio.observer;
}
