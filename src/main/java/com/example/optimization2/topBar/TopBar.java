package com.example.optimization2.topBar;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class TopBar extends HBox {

    public TopBar() {
        //this.setStyle("-fx-background-color: #087C84; -fx-padding: 6px 34px 7px 34px; -fx-opacity: 0.85; -fx-background-radius: 32px; -fx-overflow: hidden; -fx-alignment: center; -fx-display: inline-flex;");
        this.setAlignment(Pos.TOP_LEFT);
        this.setSpacing(20);

        Button button1 = createStyledButton("БиОТ");
        Button button2 = createStyledButton("ПТМ");
        Button button3 = createStyledButton("ПБ");
        Button button4 = createStyledButton("ЭБ");
        Button button5 = createStyledButton("ИТР");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        this.getChildren().addAll(
                button1,
                button2,
                button3,
                button4,
                button5,
                spacer
        );
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-color: #087C84; -fx-font-size: 15px; -fx-font-family: 'Poppins'; -fx-font-weight: 700; -fx-word-wrap: break-word;");
        return button;
    }
}
