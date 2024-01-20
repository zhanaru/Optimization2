package com.example.optimization2.topBar;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.control.Button;

import java.awt.*;

public class TopBar extends HBox {

    public TopBar(){
        this.setStyle("-fx-background-color: #111111");
        this.getMaxWidth();
        this.setHeight(0.5);
        this.setAlignment(Pos.BASELINE_LEFT);

        Button button1 = new Button("Кнопка");
        Button button2 = new Button("Кнопка");
        Button button3 = new Button("Кнопка");
        Button button4 = new Button("Кнопка");
        Button button5 = new Button("Кнопка");
        Button button6 = new Button("Кнопка");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        this.getChildren().addAll(
                button1,
                button2,
                button3,
                button4,
                button5,
                button6);
    }
}
