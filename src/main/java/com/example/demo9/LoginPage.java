package com.example.demo9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginPage{

    public void showLoginPage(Stage primaryStage) {
        Stage loginPageStage = new Stage();
        loginPageStage.setTitle("Login Page");

        BorderPane borderPane = new BorderPane();

        VBox leftBlank = new VBox();
        leftBlank.setPrefWidth(350);
        leftBlank.setStyle("-fx-background-color: #05b09c");
        leftBlank.setAlignment(Pos.CENTER);
        ImageView imageView = new ImageView();
        Image image = new Image("file:F:\\second semester\\Semester project\\target\\classes\\icon.png");
        imageView.setImage(image);
        imageView.setFitWidth(250);
        imageView.setPreserveRatio(true);
        Label leftBlankLabel = new Label("Welcome Back!");
        leftBlankLabel.setStyle("-fx-font-family: Calibri; -fx-font-size: 20px;");

        leftBlank.getChildren().addAll(leftBlankLabel, imageView);
        borderPane.setLeft(leftBlank);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label welcomeLabel = new Label("Enter Your Information");
        welcomeLabel.setStyle("-fx-font-family:Calibri; -fx-font-size: 20px;");
        grid.add(welcomeLabel, 0, 0, 2, 1);

        Label userNameLabel = new Label("Username:");
        userNameLabel.setStyle("-fx-font-family: Calibri; -fx-font-size: 15px;");
        grid.add(userNameLabel, 0, 1);

        TextField userNameField = new TextField();
        userNameField.setPromptText("Enter your username");
        grid.add(userNameField, 1, 1);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-font-family: Calibri; -fx-font-size: 15px;");
        grid.add(passwordLabel, 0, 2);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        grid.add(passwordField, 1, 2);

        Button loginButton = new Button("Login");
        HBox hbLoginButton = new HBox(10);
        hbLoginButton.setAlignment(Pos.BOTTOM_RIGHT);
        loginButton.setStyle("-fx-background-color: #007bff; -fx-text-fill: white;");
        hbLoginButton.getChildren().add(loginButton);
        grid.add(hbLoginButton, 1, 4);

        final Label loginStatusLabel = new Label();
        grid.add(loginStatusLabel, 1, 8);

        loginButton.setOnAction(e -> {
            String username = userNameField.getText();
            String password = passwordField.getText();

            if (validateLogin(username, password)) {
                loginStatusLabel.setText("Login successful!");
                BasicPage basicPage = new BasicPage();
                basicPage.showBasicPage(primaryStage);
                loginPageStage.close();
                System.out.println("Login Successful");
            } else {
                loginStatusLabel.setText("Invalid username or password");
                System.out.println("Login Failed");
            }
        });

        Label message = new Label("Don't have an account? Register here!");
        grid.add(message, 1, 6);
        Button registerButton = new Button("Click");
        HBox hbRegisterButton = new HBox(10);
        hbRegisterButton.setAlignment(Pos.BOTTOM_RIGHT);
        registerButton.setStyle("-fx-background-color: #007bff; -fx-text-fill: white;");
        registerButton.setPrefWidth(50);

        hbRegisterButton.getChildren().add(registerButton);
        grid.add(hbRegisterButton, 1, 7);
     registerButton.setOnAction(e ->{
         SignUp signUp = new SignUp();
         signUp.showSignUpPage(primaryStage);
         loginPageStage.close();

     });

        borderPane.setRight(grid);

        Scene scene = new Scene(borderPane, 700, 500);
       loginPageStage.setScene(scene);
        loginPageStage.show();
    }

    private boolean validateLogin(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                   return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
