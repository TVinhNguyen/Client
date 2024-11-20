package Controller_UI;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import Interface.Hover;
import Interface.HoverImp;
import Manager.ProductManager;
import Model.Order;
import Model.Product;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;

public class ControllerShop extends BaseController implements Hover{
	private ProductManager productManager= ProductManager.getInstance();
	private Order currentOrder = new Order(); // Assuming you create the order as items are added

	@FXML
	private Button buttonPay;
	@FXML
	private GridPane productGridPane;
	@FXML
	private Label total;
	@FXML
	private VBox orderVBox;
	private Map<Product, HBox> productMap = new HashMap<>();
	private Map<Product, Spinner<Integer>> spinnerMap = new HashMap<>();
	@FXML
	public void initialize() {
	    ProductGridBuilder.populateProductGrid(productGridPane, productManager.getAllProducts());
	    for (Node node : productGridPane.getChildren()) {
	        if (node instanceof VBox) {
	            node.setOnMouseClicked(event -> {
	                VBox vbox = (VBox) node;
	                int idProduct = (int) vbox.getUserData(); 
//	                Label nameLabel = (Label) vbox.getChildren().get(1);
//	                Label priceLabel = (Label) vbox.getChildren().get(2);
//	                
//	                String name = nameLabel.getText();
//	                int price = Integer.parseInt(priceLabel.getText().replace("đ", "").replace(".", "").trim());
//	                System.out.println(idProduct);	
	                Product selectedProduct = productManager.getProductById(idProduct).orElseThrow(() -> new RuntimeException("Product not found"));

	                addProductToOrder(selectedProduct);
	            });
	        }
	    }
	}
	private void updateTotalPrice() {
	    double totalPrice = currentOrder.getTotalCost();
	    total.setText(String.format("%,.0fđ", totalPrice)); // Cập nhật giá trị vào Label
	}

	@FXML
	public void clickPay(ActionEvent e) {
		
	}
	private void addProductToOrder(Product product) {
	    if (productMap.containsKey(product)) {
	        Spinner<Integer> existingSpinner = spinnerMap.get(product);
	        existingSpinner.getValueFactory().setValue(existingSpinner.getValue() + 1);

	        currentOrder.addItem(product, 1); 
	        return; 
	    }
	    HBox orderItem = new HBox();
	    orderItem.setAlignment(Pos.CENTER_LEFT);
	    orderItem.setSpacing(10);
	    orderItem.getStyleClass().add("fx-set-border-hbox"); // Match the CSS style

	    VBox leftVBox = new VBox();
	    leftVBox.setPrefWidth(255);
	    leftVBox.setSpacing(10);

	    Label nameLabel = new Label(product.getNameProduct());
	    nameLabel.setPrefWidth(190);
	    nameLabel.setTextFill(Color.WHITE);
	    nameLabel.setFont(new Font(18));
	    Spinner<Integer> quantitySpinner = new Spinner<>(1, product.getQuantityProduct(), 1); 
	    quantitySpinner.setPrefWidth(132);
	    quantitySpinner.setPrefHeight(31.0);
	    quantitySpinner.setEditable(true); 
	    TextFormatter<Integer> textFormatter = new TextFormatter<>(
	        new IntegerStringConverter(),
	        1, 
	        change -> {
	            String newText = change.getControlNewText(); 
	            if (newText.isEmpty()) {
	                return change;
	            }
	            if (newText.matches("\\d*")) { 
	                try {
	                    int newValue = Integer.parseInt(newText);
	                    if (newValue >= 1 && newValue <= product.getQuantityProduct()) {
	                        return change; 
	                    }
	                } catch (NumberFormatException e) {
	                   
	                }
	            }
	            return null; 
	        }
	    );

	    quantitySpinner.getEditor().setTextFormatter(textFormatter);

	    quantitySpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
	        if (newValue == null) {
	            quantitySpinner.getValueFactory().setValue(1);
	            int currentQuantity = currentOrder.getQuantity(product); 
	            currentOrder.addItem(product, 1 - currentQuantity); 
	            updateTotalPrice();
	            return;
	        }
	        if (oldValue == null) oldValue = 0; 

	        int delta = newValue - oldValue;
	        currentOrder.addItem(product, delta);
	        updateTotalPrice();
	    });



	    leftVBox.getChildren().addAll(nameLabel, quantitySpinner);
	    HBox.setMargin(leftVBox, new Insets(0, 0, 5, 10));

	    VBox rightVBox = new VBox();
	    rightVBox.setPrefWidth(261);
	    rightVBox.setAlignment(Pos.TOP_RIGHT);
	    rightVBox.setSpacing(10);

	    FontAwesomeIcon deleteIcon = new FontAwesomeIcon();
	    deleteIcon.setIcon(FontAwesomeIcons.TRASH);
	    deleteIcon.setOnMouseClicked(event -> {
	    	 currentOrder.removeItem(product); 
	         orderVBox.getChildren().remove(orderItem); 
	         productMap.remove(product); 
	         spinnerMap.remove(product); 
	         updateTotalPrice(); 

	    });
	    deleteIcon.getStyleClass().add("delete-icon");
	    deleteIcon.setSize("20.0"); 


	    Label priceLabel = new Label(String.format("%,.0fđ", product.getPriceProduct()));
	    priceLabel.setPrefWidth(177);
	    priceLabel.setTextFill(Color.WHITE);
	    priceLabel.setFont(Font.font("System", FontWeight.BOLD, 22));
	    priceLabel.setAlignment(Pos.CENTER_RIGHT);
	    
	    rightVBox.getChildren().addAll(deleteIcon, priceLabel);
	    HBox.setMargin(rightVBox, new Insets(10, 20, 0, 0));

	    orderItem.getChildren().addAll(leftVBox, rightVBox);
	    productMap.put(product, orderItem);
	    spinnerMap.put(product, quantitySpinner);
	    VBox.setMargin(orderItem, new Insets(5, 0, 0, 0));
	    orderVBox.getChildren().add(orderItem);
	    currentOrder.addItem(product, 1);
	    updateTotalPrice(); 


	}



	@Override
	public void hoverHbox(MouseEvent e) {
		 	HBox hbox = (HBox) e.getSource(); 
		    Button button = (Button) hbox.lookup("#" + hbox.getId() + "button"); 
		    FontAwesomeIcon icon = (FontAwesomeIcon) hbox.lookup("#" + hbox.getId() + "arrowIcon"); 
		    createColorTransition(button, icon, Color.RED);		
	}

	@Override
	public void exitedHBox(MouseEvent e) {
		 HBox hbox = (HBox) e.getSource(); 
		    Button button = (Button) hbox.lookup("#" + hbox.getId() + "button"); 
		    FontAwesomeIcon icon = (FontAwesomeIcon) hbox.lookup("#" + hbox.getId() + "arrowIcon"); 
		    createColorTransition(button, icon, Color.WHITE);
		
	}

	@Override
	public void createColorTransition(Button button, FontAwesomeIcon icon, Color targetColor) {
		 Timeline timeline = new Timeline();

		    int frames = 10; 
		    for (int i = 0; i <= frames; i++) {
		        final double fraction = i / (double) frames; 
		        KeyFrame keyFrame = new KeyFrame(Duration.seconds(i * 0.05), event -> {
		       
		            Color currentTextColor = (Color) button.getTextFill();
		            Color newTextColor = interpolateColor(currentTextColor, targetColor, fraction);
		            button.setTextFill(newTextColor);

		            Color currentIconColor = (Color) icon.getFill();
		            Color newIconColor = interpolateColor(currentIconColor, targetColor, fraction);
		            icon.setFill(newIconColor);
		        });
		        timeline.getKeyFrames().add(keyFrame);
		    }
		    timeline.play();		
	}

	@Override
	public Color interpolateColor(Color startColor, Color endColor, double fraction) {
		 double red = startColor.getRed() + (endColor.getRed() - startColor.getRed()) * fraction;
		    double green = startColor.getGreen() + (endColor.getGreen() - startColor.getGreen()) * fraction;
		    double blue = startColor.getBlue() + (endColor.getBlue() - startColor.getBlue()) * fraction;
		    return Color.color(red, green, blue);
	}

}
