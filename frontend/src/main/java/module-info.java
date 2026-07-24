
module com.secondhand.frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires java.desktop;
    requires com.google.gson;

    opens com.secondhand.frontend to javafx.fxml;
    opens com.secondhand.frontend.controller.auth to javafx.fxml;
    opens com.secondhand.frontend.controller.home to javafx.fxml;
    opens com.secondhand.frontend.controller.advertisement to javafx.fxml;
    opens com.secondhand.frontend.controller.components to javafx.fxml;
    opens com.secondhand.frontend.controller.advertisement.components to javafx.fxml;
    opens com.secondhand.frontend.dto.auth.request to com.google.gson;
    opens com.secondhand.frontend.dto.auth.response to com.google.gson;
    opens com.secondhand.frontend.controller.conversation to javafx.fxml;
    opens com.secondhand.frontend.controller.profile to javafx.fxml;
    opens com.secondhand.frontend.dto.province.response to com.google.gson;
    opens com.secondhand.frontend.dto.advertisement.request to com.google.gson;
    opens com.secondhand.frontend.dto.profile.response to com.google.gson;
    opens com.secondhand.frontend.model to com.google.gson;
    opens com.secondhand.frontend.controller.favorite to javafx.fxml;
    opens com.secondhand.frontend.dto.conversation.response to com.google.gson;
    opens com.secondhand.frontend.controller.admin to javafx.fxml;
    opens com.secondhand.frontend.controller to javafx.fxml;
    opens com.secondhand.frontend.dto.admin.request to com.google.gson;
    opens com.secondhand.frontend.dto.admin.response to javafx.base, com.google.gson;
    exports com.secondhand.frontend.controller.profile;





    opens com.secondhand.frontend.dto.common to com.google.gson;

    opens com.secondhand.frontend.dto.city.response to com.google.gson;

    opens com.secondhand.frontend.dto.category.response to com.google.gson;

    opens com.secondhand.frontend.dto.advertisement.response to com.google.gson;


    exports com.secondhand.frontend;
    exports com.secondhand.frontend.controller;

}