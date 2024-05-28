package com.example.demo9;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class ice_cream extends FoodPage {

    @Override
    protected String getPageTitle() {
        return "ice_creams";
    }


    protected void onBackButtonClicked() {

        System.out.println("Back button clicked on ice_cream Page");
    }

    @Override
    protected void onTotalButtonClicked() {

        System.out.println("Total button clicked on ice_cream Page, Total: $" + total);
    }

    @Override
    protected HBox createItemBox() {
        HBox itemBox = new HBox();
        itemBox.setSpacing(20);
        itemBox.setAlignment(Pos.CENTER);

        itemBox.getChildren().addAll(
                createItem("file:F:\\second semester\\demo9\\src\\main\\java\\com\\example\\demo9\\i1.png", 300),
                createItem("file:F:\\second semester\\demo9\\src\\main\\java\\com\\example\\demo9\\i2.png", 450),
                createItem("file:F:\\second semester\\demo9\\src\\main\\java\\com\\example\\demo9\\i3.png", 500)
        );

        return itemBox;
    }


}
