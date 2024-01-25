package com.example.optimization2;

import com.example.optimization2.topBar.TopBar;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage){
        // Загрузка FXML
        //FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("app-View.fxml"));
        TopBar topBar = new TopBar();

        // Создание сцены с корневым контейнером
        Scene scene = new Scene(topBar);// Размеры вашего экрана
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setFullScreenExitHint("");
        stage.show();
    }
}

