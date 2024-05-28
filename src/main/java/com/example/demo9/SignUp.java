package com.example.demo9;

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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class SignUp {
    public void showSignUpPage(Stage primaryStage) {
        Stage SignPageStage = new Stage();
        SignPageStage.setTitle("Login Page");



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

        Label leftBlankLabel = new Label("Welcome to Cheezious Online!");
        leftBlankLabel.setStyle("-fx-font-family: Calibri; -fx-font-size: 20px;");
        leftBlank.getChildren().add(leftBlankLabel);
        leftBlank.getChildren().add(imageView);

        borderPane.setLeft(leftBlank);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Add controls to the GridPane
        Label welcomeLabel = new Label("Create a New Account");
        welcomeLabel.setStyle("-fx-font-family: Calibri; -fx-font-size: 20px;");
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

        Label confirmPasswordLabel = new Label("Confirm Password:");
        confirmPasswordLabel.setStyle("-fx-font-family: Calibri; -fx-font-size: 15px;");
        grid.add(confirmPasswordLabel, 0, 3);

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm your password");
        grid.add(confirmPasswordField, 1, 3);

        Button signupButton = new Button("Sign Up");
        HBox hbSignupButton = new HBox(10);
        hbSignupButton.setAlignment(Pos.BOTTOM_RIGHT);
        hbSignupButton.getChildren().add(signupButton);
        grid.add(hbSignupButton, 1, 5);

        final Label signupStatusLabel = new Label();
        grid.add(signupStatusLabel, 1, 6);








        signupButton.setOnAction(e -> {
            String username = userNameField.getText();
            String password = passwordField.getText();
            String confirmPassword = confirmPasswordField.getText();

            if (!password.equals(confirmPassword)) {
                signupStatusLabel.setText("Passwords do not match!");
            } else {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
                    writer.write(username + ":" + password);
                    writer.newLine();
                    signupStatusLabel.setText("Sign up successful!");
                } catch (IOException ioException) {
                    signupStatusLabel.setText("Error saving user information.");
                    ioException.printStackTrace();
                }
                signupStatusLabel.setText("Sign up successful!");
                SignPageStage.close();
                LoginPage loginPage = new LoginPage();
                loginPage.showLoginPage(primaryStage);

            }
        });

        borderPane.setRight(grid);

         Scene scene = new Scene(borderPane, 700, 500);
        SignPageStage.setScene(scene);
        SignPageStage.show();

    }
}