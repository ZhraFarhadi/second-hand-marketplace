
module com.secondhand.frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;

    opens com.secondhand.frontend to javafx.fxml;
    opens com.secondhand.frontend.controller.auth to javafx.fxml;
    exports com.secondhand.frontend;
    exports com.secondhand.frontend.controller;
    opens com.secondhand.frontend.controller to javafx.fxml;
}