package com.example.optimization2;

import com.example.optimization2.dragAndDrop.CellWithDocument;
import com.example.optimization2.topBar.TopBar;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage){

        BorderPane borderPane = MainPage();
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setFullScreenExitHint("");
        stage.show();
    }

    private BorderPane MainPage() {
        BorderPane root = new BorderPane();
        TopBar topBar = new TopBar();

        CellWithDocument dragTarget1 = new CellWithDocument();

        // Создаем VBox для второго dragTarget
        VBox vboxForDragTarget2 = new VBox(10);
        CellWithDocument dragTarget2 = new CellWithDocument();
        vboxForDragTarget2.getChildren().add(dragTarget2); // Добавляем dragTarget2 в VBox

        // Создаем HBox для кнопок, чтобы они были в ряд
        HBox buttonsContainer = new HBox(10); // 10 пикселей промежуток между кнопками
        Button button1 = new Button("Заполнить");
        Button button2 = new Button("Сохранить");
        Button button3 = new Button("Изменить");
        buttonsContainer.getChildren().addAll(button1, button2, button3); // Добавляем кнопки в HBox

        // Добавляем HBox с кнопками в VBox под dragTarget2
        vboxForDragTarget2.getChildren().add(buttonsContainer);

        // Создаем главный HBox для размещения dragTarget1 и VBox с dragTarget2 и кнопками
        HBox dragTargetsContainer = new HBox(10, dragTarget1, vboxForDragTarget2);
        dragTargetsContainer.setPadding(new Insets(20));
        HBox.setHgrow(dragTarget1, Priority.ALWAYS); // Позволяем dragTarget1 расти
        HBox.setHgrow(vboxForDragTarget2, Priority.ALWAYS); // Позволяем VBox расти, содержащему dragTarget2 и кнопки

        root.setTop(topBar);
        root.setCenter(dragTargetsContainer);
        root.setStyle("-fx-background-color: lightgray;");

        return root;
    }
}

