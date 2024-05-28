package com.example.demo9;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class FoodPage {

    protected static double total = 0;
    protected Button totalButton;

    public void showFoodPage(Stage basicPageStage) {
        Stage foodPageStage = new Stage();

        BorderPane borderPane = new BorderPane();
        HBox header = new HBox();
        header.setStyle("-fx-background-color: #05b09c;");
        header.setPadding(new Insets(30, 40, 30, 40));
        header.setSpacing(10);
        header.setAlignment(Pos.BOTTOM_LEFT);
        Button backButton = new Button("<-");
        backButton.setPrefWidth(50);
        backButton.setStyle("-fx-background-color: lightgrey; -fx-text-fill: black;");
        backButton.setOnAction(event -> {
            foodPageStage.close();
            basicPageStage.show();
        });

        Label titleLabel = new Label(getPageTitle());
        titleLabel.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 20px; -fx-text-fill: white;");
        titleLabel.setAlignment(Pos.CENTER);

        header.getChildren().addAll(backButton, titleLabel);

        VBox leftHalf = new VBox();
        leftHalf.setPadding(new Insets(30, 40, 30, 40));
        leftHalf.setStyle("-fx-background-color: #05b09c;");
        leftHalf.setAlignment(Pos.CENTER);

        VBox rightHalf = new VBox();
        rightHalf.setPrefWidth(620);
        rightHalf.setStyle("-fx-background-color: white;");
        rightHalf.setAlignment(Pos.CENTER);

        HBox itemBox = createItemBox();
        rightHalf.getChildren().add(itemBox);

        totalButton = new Button("Total: " + total);
        totalButton.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        totalButton.setPrefWidth(150);
        totalButton.setOnAction(e -> onTotalButtonClicked());

        VBox bottomBox = new VBox();
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setPadding(new Insets(20));
        bottomBox.setStyle("-fx-background-color: #05b09c;");
        bottomBox.getChildren().add(totalButton);

        borderPane.setLeft(leftHalf);
        borderPane.setRight(rightHalf);
        borderPane.setTop(header);
        borderPane.setBottom(bottomBox);

        Scene scene = new Scene(borderPane, 700, 500);
        foodPageStage.setScene(scene);
        foodPageStage.setTitle("Order Page");
        foodPageStage.show();
    }

    protected abstract String getPageTitle();

  protected abstract void onTotalButtonClicked();

    protected abstract HBox createItemBox();

    protected HBox createItem(String imagePath, double price) {
        VBox itemBox = new VBox();
        itemBox.setAlignment(Pos.CENTER);

        Button itemButton = new Button();
        itemButton.setPrefSize(120, 130);
        ImageView itemImage = new ImageView(new Image(imagePath));
        itemImage.setFitWidth(120);
        itemImage.setPreserveRatio(true);
        itemButton.setGraphic(itemImage);

        Label priceLabel = new Label( ""+ price);
        priceLabel.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 15px; -fx-text-fill: black;");

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(5);

        Button plusButton = new Button("+");
        Button minusButton = new Button("-");
        Label quantityLabel = new Label("0");
        int[] quantity = {0};

        plusButton.setOnAction(e -> {
            quantity[0]++;
            quantityLabel.setText(String.valueOf(quantity[0]));
            updateTotalAndButton(price * quantity[0] - price * (quantity[0] - 1));
        });

        minusButton.setOnAction(e -> {
            if (quantity[0] > 0) {
                quantity[0]--;
                quantityLabel.setText(String.valueOf(quantity[0]));
                updateTotalAndButton(price * quantity[0] - price * (quantity[0] + 1));
            }
        });

        buttonBox.getChildren().addAll(plusButton, quantityLabel, minusButton);

        VBox.setMargin(buttonBox, new Insets(10, 0, 0, 0));
        itemBox.getChildren().addAll(itemButton, priceLabel, buttonBox);

        HBox itemContainer = new HBox(itemBox);
        itemContainer.setSpacing(10);
        itemContainer.setAlignment(Pos.CENTER);

        return itemContainer;
    }

    private void updateTotalAndButton(double amount) {
        total += amount;
        totalButton.setText("Total: " + total);
        totalButton.setOnAction(event -> {
            Stage totalStage = new Stage();
            VBox totalBox = new VBox();
            totalBox.setAlignment(Pos.CENTER);
            totalBox.setPadding(new Insets(20));
            totalBox.setStyle("-fx-background-color: #ffffff;");

            Label totalLabel = new Label("Total Bill: " + total);
            totalLabel.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 20px; -fx-text-fill: black;");

            totalBox.getChildren().add(totalLabel);
            File file=new File("order_detail");


            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWriter=new FileWriter(file);
                fileWriter.write("Total Bill: " + total);
                fileWriter.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Scene totalScene = new Scene(totalBox, 300, 200);
            totalStage.setScene(totalScene);
            totalStage.setTitle("Total Bill");
            totalStage.show();
        });
    }

}