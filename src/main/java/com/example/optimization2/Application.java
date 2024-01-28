package com.example.optimization2;

import com.example.optimization2.dragAndDrop.CellWithDocument;
import com.example.optimization2.topBar.TopBar;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage){

        BorderPane borderPane = createYourCustomPage();
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setFullScreenExitHint("");
        stage.show();
    }

    private BorderPane createYourCustomPage() {
        BorderPane root = new BorderPane();
        TopBar topBar = new TopBar();
        CellWithDocument dragTarget1 = new CellWithDocument();
        CellWithDocument dragTarget2 = new CellWithDocument();

        HBox dragTargetsContainer = new HBox(10, dragTarget1, dragTarget2);

        root.setTop(topBar);
        root.setCenter(dragTargetsContainer);

        return root;
    }
}

