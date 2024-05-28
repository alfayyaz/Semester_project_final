package com.example.demo9;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BasicPage {
    private Scene scene;
    private Stage basicPageStage = new Stage();

    public void showBasicPage(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        HBox header = new HBox();
        header.setStyle("-fx-background-color: #05b09c;");
        header.setPadding(new Insets(30, 40, 30, 40));
        header.setSpacing(10);
        header.setAlignment(Pos.BOTTOM_LEFT);
        Button logOutButton = new Button("Log out");
        logOutButton.setStyle("-fx-background-color: lightgrey; -fx-text-fill: black;");
        logOutButton.setOnAction(e -> {
            basicPageStage.close();
            primaryStage.show();
        });

        header.getChildren().add(logOutButton);

        VBox leftHalf = new VBox();
        leftHalf.setPadding(new Insets(30, 40, 30, 40));
        leftHalf.setStyle("-fx-background-color: #05b09c");
        leftHalf.setAlignment(Pos.CENTER);

        VBox rightHalf = new VBox();
        rightHalf.setPrefWidth(620);
        rightHalf.setStyle("-fx-background-color: white");
        rightHalf.setAlignment(Pos.CENTER);

        HBox pizzaBurgerBox = new HBox();
        pizzaBurgerBox.setSpacing(20);
        pizzaBurgerBox.setAlignment(Pos.CENTER);

        Button burgerButton = new Button();
        burgerButton.setPrefSize(120, 120);
        ImageView burgerImage = new ImageView(new Image("file:F:\\second semester\\Semester project\\target\\classes\\burger.png"));
        burgerImage.setFitWidth(120);
        burgerImage.setPreserveRatio(true);
        burgerButton.setGraphic(burgerImage);
        burgerButton.setOnAction(event -> {
            System.out.println("Burger button clicked!");
            FoodPage burgerPage = new Burger_Page();
            burgerPage.showFoodPage(basicPageStage);
            basicPageStage.close();
        });

        Button pizzaButton = new Button();
        pizzaButton.setPrefSize(120, 120);
        ImageView pizzaImage = new ImageView(new Image("file:F:\\second semester\\Semester project\\target\\classes\\pizza.png"));
        pizzaImage.setFitWidth(120);
        pizzaImage.setPreserveRatio(true);
        pizzaButton.setGraphic(pizzaImage);
        pizzaButton.setOnAction(event -> {
            System.out.println("Pizza button clicked!");
            FoodPage Pizza_Page = new Pizza_Page();
            Pizza_Page.showFoodPage(basicPageStage);
            basicPageStage.close();
        });

        Button sandwichButton = new Button();
        sandwichButton.setPrefSize(120, 120);
        ImageView sandwichImage = new ImageView(new Image("file:F:\\second semester\\Semester project\\target\\classes\\s.png"));
        sandwichImage.setFitWidth(120);
        sandwichImage.setPreserveRatio(true);
        sandwichButton.setGraphic(sandwichImage);
        sandwichButton.setOnAction(event -> {
            System.out.println("Sandwich button clicked!");
            FoodPage sandwich_Page = new sandwitch_Page();
            sandwich_Page.showFoodPage(basicPageStage);
            basicPageStage.close();
        });

        pizzaBurgerBox.getChildren().addAll(pizzaButton, burgerButton, sandwichButton);

        HBox dessertBox = new HBox();
        dessertBox.setSpacing(20);
        dessertBox.setAlignment(Pos.BOTTOM_CENTER);

        Button iceCreamButton = new Button();
        iceCreamButton.setPrefSize(120, 120);
        ImageView iceCreamImage = new ImageView(new Image("file:F:\\second semester\\Semester project\\target\\classes\\ice.png"));
        iceCreamImage.setFitWidth(120);
        iceCreamImage.setPreserveRatio(true);
        iceCreamButton.setGraphic(iceCreamImage);
        ice_cream iceCream = new ice_cream();
        iceCreamButton.setOnAction(event -> {

            iceCream.showFoodPage(basicPageStage);
            basicPageStage.close();
        });

        Button siderButton = new Button();
        siderButton.setPrefSize(120, 120);
        ImageView siderImage = new ImageView(new Image("file:F:\\second semester\\Semester project\\target\\classes\\d1.png"));
        siderImage.setFitWidth(120);
        siderImage.setPreserveRatio(true);
        siderButton.setGraphic(siderImage);
        siderButton.setOnAction(event -> {

            FoodPage drink = new drink();
            drink.showFoodPage(basicPageStage);
            basicPageStage.close();
        });

        dessertBox.getChildren().addAll(iceCreamButton, siderButton);

        rightHalf.getChildren().addAll(pizzaBurgerBox, dessertBox);

        borderPane.setLeft(leftHalf);
        borderPane.setCenter(rightHalf);
        borderPane.setTop(header);

        this.scene = new Scene(borderPane, 700, 500);
        basicPageStage.setScene(scene);
        basicPageStage.show();
    }
}
