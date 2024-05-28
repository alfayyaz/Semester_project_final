package com.example.demo9;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class drink extends FoodPage {

    @Override
    protected String getPageTitle() {
        return "drinks";
    }

    protected void onBackButtonClicked() {

        System.out.println("Back button clicked on drink Page");
    }

    @Override
    protected void onTotalButtonClicked() {

        System.out.println("Total button clicked on drink Page, Total: " + total);
    }

    @Override
    protected HBox createItemBox() {
        HBox itemBox = new HBox();
        itemBox.setSpacing(20);
        itemBox.setAlignment(Pos.CENTER);

        itemBox.getChildren().addAll(
                createItem("file:F:\\second semester\\demo9\\src\\main\\java\\com\\example\\demo9\\d1.png", 200),
                createItem("file:F:\\second semester\\demo9\\src\\main\\java\\com\\example\\demo9\\d2.png", 300),
                createItem("file:F:\\second semester\\demo9\\src\\main\\java\\com\\example\\demo9\\d1.png", 500)
        );

        return itemBox;
    }


}
