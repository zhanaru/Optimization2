package com.example.optimization2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Загрузка фотографии
        Image backgroundImage = new Image("C:\\Users\\Администратор\\Desktop\\Optimization2\\src\\main\\java\\pictures\\background.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);

        // Загрузка FXML
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        // Создание корневого контейнера с фотографией в качестве заднего фона
        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundImageView, fxmlLoader.load());

        // Создание сцены с корневым контейнером
        Scene scene = new Scene(root, 1920, 1080); // Размеры вашего экрана

        stage.setScene(scene);
        stage.setFullScreen(true); // Установка полноэкранного режима
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
