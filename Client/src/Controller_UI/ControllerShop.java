package Controller_UI;

import java.awt.event.ActionEvent;

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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.util.Duration;

public class ControllerShop extends BaseController implements Hover{
	private ProductManager productManager= ProductManager.getInstance();
	private Order currentOrder = new Order(); // Assuming you create the order as items are added

	@FXML
	private Button buttonPay;
	@FXML
	private GridPane productGridPane;

	@FXML
	private VBox orderVBox;
	@FXML
	public void initialize() {

	    for (Node node : productGridPane.getChildren()) {
	        if (node instanceof VBox) {
	            node.setOnMouseClicked(event -> {
	                VBox vbox = (VBox) node;
	                int idProduct = (int) vbox.getUserData(); 
	                Label nameLabel = (Label) vbox.getChildren().get(1);
	                Label priceLabel = (Label) vbox.getChildren().get(2);
	                
	                String name = nameLabel.getText();
	                int price = Integer.parseInt(priceLabel.getText().replace("đ", "").replace(",", "").trim());
	                Product selectedProduct = productManager.getProductById(idProduct).orElseThrow(() -> new RuntimeException("Product not found"));

	                addProductToOrder(selectedProduct);
	            });
	        }
	    }
	}
	@FXML
	public void clickPay(ActionEvent e) {
		
	}
	private void addProductToOrder(Product product) {
	    HBox orderItem = new HBox();
	    orderItem.setAlignment(Pos.CENTER_LEFT);
	    orderItem.setSpacing(10);

	    Label nameLabel = new Label(product.getNameProduct());
	    nameLabel.setPrefWidth(150);
	    nameLabel.setTextFill(Color.WHITE);
	    
	    Spinner<Integer> quantitySpinner = new Spinner<>(1, 10, 1);
	    quantitySpinner.setPrefWidth(60);
	    
	    quantitySpinner.valueProperty().addListener((obs, oldValue, newValue) -> {
	        int delta = newValue - oldValue;
	        currentOrder.addItem(product, delta); 
	    });
	    
	    Label priceLabel = new Label(String.format("%,dđ", product.getPriceProduct()));
	    priceLabel.setPrefWidth(100);
	    priceLabel.setTextFill(Color.WHITE);
	    
	    FontAwesomeIcon deleteIcon = new FontAwesomeIcon();
	    deleteIcon.setIcon(FontAwesomeIcons.TRASH);
	    deleteIcon.setFill(Color.RED);
	    deleteIcon.setOnMouseClicked(event -> {
	        currentOrder.removeItem(product);
	        orderVBox.getChildren().remove(orderItem);
	    });

	    orderItem.getChildren().addAll(nameLabel, quantitySpinner, priceLabel, deleteIcon);
	    orderVBox.getChildren().add(orderItem);
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
