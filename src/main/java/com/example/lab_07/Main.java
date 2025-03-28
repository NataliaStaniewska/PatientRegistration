package com.example.lab_07;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Ładowanie pliku FXML
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Window.fxml"));
        // Tworzenie nowej sceny
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        // Ustawienie sceny w głównym oknie aplikacji
        stage.setScene(scene);
        // Wyświetlenie okna
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}