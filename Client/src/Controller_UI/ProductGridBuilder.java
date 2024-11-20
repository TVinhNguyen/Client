package Controller_UI;

import java.io.ByteArrayInputStream;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import Model.Product;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ProductGridBuilder {

	public static void populateProductGrid(GridPane productGridPane, List<Product> products) {
	    int columns = 5; 
	    int col = 0;
	    int row = 0;

	    productGridPane.getChildren().clear(); 
	    productGridPane.getRowConstraints().clear();
	    productGridPane.setVgap(20); 
	    productGridPane.setHgap(20); 
	  
	    for (Product product : products) {
	        VBox productBox = createProductBox(product);

	        productBox.setUserData(product.getIdProduct());
	        productGridPane.add(productBox, col, row);

	        col++;
	        if (col >= columns) {
	            col = 0;
	            row++;

	            RowConstraints rowConstraints = new RowConstraints();
	            rowConstraints.setMinHeight(30); 
	            rowConstraints.setPrefHeight(260); 
	            rowConstraints.setVgrow(Priority.ALWAYS); 
	            productGridPane.getRowConstraints().add(rowConstraints);
	        }
	    }

//	    if (!products.isEmpty() && productGridPane.getRowConstraints().isEmpty()) {
//	        RowConstraints rowConstraints = new RowConstraints();
//	        rowConstraints.setMinHeight(30);
//	        rowConstraints.setPrefHeight(200);
//	        rowConstraints.setVgrow(Priority.NEVER);
//	        productGridPane.getRowConstraints().add(rowConstraints);
//	    }
	  
	}



    private static VBox createProductBox(Product product) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

        VBox productBox = new VBox(10);
        productBox.setAlignment(Pos.TOP_CENTER);
        productBox.setPrefWidth(100);
        productBox.setPrefHeight(200);
        productBox.setStyle("-fx-background-color: #333; -fx-background-radius: 10;");

        ImageView imageView = new ImageView();
        imageView.setFitWidth(157);
        imageView.setFitHeight(175);
        imageView.setPickOnBounds(true);

        if (product.getImageProduct() != null) {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(product.getImageProduct());
            Image image = new Image(inputStream);
            imageView.setImage(image);
        }

        Label nameLabel = new Label(product.getNameProduct());
        nameLabel.setFont(new Font(18));
        nameLabel.setStyle("-fx-text-fill: white;");
        
        String price = currencyFormat.format(product.getPriceProduct()).replaceAll("[^0-9,.]", "").trim() + "đ"; 
        Label priceLabel = new Label(price);
        priceLabel.setFont(Font.font("System",FontWeight.BOLD, 22));
        priceLabel.setStyle("-fx-text-fill: #fc1919;");

        productBox.getChildren().addAll(imageView, nameLabel, priceLabel);
        VBox.setMargin(nameLabel, new Insets(10, 0, 0, 0));
        VBox.setMargin(priceLabel, new Insets(5, 0, 0, 0));

        return productBox;
    }
}
