module co.edu.uniquindio.observer {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.observer to javafx.fxml;
    opens co.edu.uniquindio.observer.viewcontroller to javafx.fxml;
    
    exports co.edu.uniquindio.observer;
    exports co.edu.uniquindio.observer.viewcontroller;
}
