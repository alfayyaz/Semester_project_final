package com.example.demo9;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class sandwitch_Page extends FoodPage {

    @Override
    protected String getPageTitle() {
        return "sandwitchs";
    }

    @Override
    protected void onTotalButtonClicked() {
        System.out.println("Total button clicked on sandwitch Page, Total: $" + total);
    }

    protected HBox createItemBox() {
        HBox itemBox = new HBox();
        itemBox.setSpacing(20);
        itemBox.setAlignment(Pos.CENTER);


        itemBox.getChildren().addAll(
                createItem("file:F:\\second semester\\demo9\\src\\main\\java\\com\\example\\demo9\\s1.png", 600),
                createItem("file:F:\\second semester\\demo9\\src\\main\\java\\com\\example\\demo9\\s2.png", 450),
                createItem("file:F:\\second semester\\demo9\\src\\main\\java\\com\\example\\demo9\\s3.png", 700)
        );

        return itemBox;
    }


}
