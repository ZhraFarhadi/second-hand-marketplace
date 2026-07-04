
package com.secondhand.frontend.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    public void initialize() {
        // اختیاری: تنظیم یا تغییر متن در هنگام اجرای برنامه
        welcomeText.setText("Hello");
    }
}

