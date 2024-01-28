package com.example.optimization2.topBar;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Screen;

public class TopBar extends HBox {

    public TopBar() {
        double screenHeight = Screen.getPrimary().getBounds().getHeight();
        double topBarHeight = screenHeight * 0.2;

        this.setAlignment(Pos.TOP_LEFT);
        this.setSpacing(20);
        this.setStyle("-fx-background-color: black;");
        this.setPrefHeight(topBarHeight);

        Button button1 = createStyledButton("БиОТ");
        Button button2 = createStyledButton("ПТМ");
        Button button3 = createStyledButton("ПБ");
        Button button4 = createStyledButton("ЭБ");
        Button button5 = createStyledButton("ИТР");

        applyMarginFirst(button1);
        applyMargin(button2, button3, button4, button5);

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
        button.setStyle(
                "-fx-background-color: #087C84; " +
                "-fx-font-size: 20px; " +
                "-fx-font-family: 'Poppins'; " +
                "-fx-font-weight: 700; " +
                "-fx-word-wrap: break-word;" +
                "-fx-padding: 15px;" +
                "-fx-background-radius: 10px;" +
                "-fx-text-fill: white;" +
                        //размеры кнопок (поиграйся)
                "-fx-max-height: 100px;" +
                "-fx-min-height: 50px;" +
                "-fx-min-width: 100px;" +
                "-fx-max-width: 150px;"
        );
        return button;
    }

    private void applyMarginFirst(Button... buttons) {
        for (Button button : buttons) {
            HBox.setMargin(button, new Insets(15, 0, 0, 15));
        }
    }
    private void applyMargin(Button... buttons) {
        for (Button button : buttons) {
            HBox.setMargin(button, new Insets(15, 0, 0, 0));
        }
    }
}
