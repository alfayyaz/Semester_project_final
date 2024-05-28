package com.example.demo9;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class Pizza_Page extends FoodPage {

    @Override
    protected String getPageTitle() {
        return "Pizzas";
    }


    protected void onBackButtonClicked() {

        System.out.println("Back button clicked on Pizza Page");
    }

    @Override
    protected void onTotalButtonClicked() {

        System.out.println("Total button clicked on Pizza Page, Total: " + total);
    }

    @Override
    protected HBox createItemBox() {
        HBox itemBox = new HBox();
        itemBox.setSpacing(20);
        itemBox.setAlignment(Pos.CENTER);

        itemBox.getChildren().addAll(
                createItem("file:F:\\second semester\\demo9\\src\\main\\java\\com\\example\\demo9\\p1.png", 1600),
                createItem("file:F:\\second semester\\demo9\\src\\main\\java\\com\\example\\demo9\\p2.png", 1450),
                createItem("file:F:\\second semester\\demo9\\src\\main\\java\\com\\example\\demo9\\p3.png", 1700)
        );

        return itemBox;
    }


}
