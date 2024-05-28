package com.example.demo9;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class Burger_Page extends FoodPage {

    @Override
    public String getPageTitle() {
        return "Burgers";
    }


    protected void onBackButtonClicked() {

        System.out.println("Back button clicked on Burger Page");
    }

    @Override
    protected void onTotalButtonClicked() {

        System.out.println("Total button clicked on Burger Page, Total: " + total);
    }

    @Override
    protected HBox createItemBox() {
        HBox itemBox = new HBox();
        itemBox.setSpacing(20);
        itemBox.setAlignment(Pos.CENTER);


        itemBox.getChildren().addAll(
                createItem("file:F:\\second semester\\Semester project\\target\\classes\\c.png", 550),
                createItem("file:F:\\second semester\\Semester project\\target\\classes\\chee.png", 400),
                createItem("file:F:\\second semester\\Semester project\\target\\classes\\beef.png", 800)
        );

        return itemBox;
    }


}
