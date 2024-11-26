package Controller_UI;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Interface.Hover;
import Manager.NewManager;
import Model.New;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class ControllerNews extends BaseController {

	    @FXML
	    private VBox newsContainer; // Khu vực chứa danh sách tin bên phải
	    @FXML
	    private Label titleCenter;  // Hiển thị tiêu đề tin ở giữa
	    @FXML
	    private Label contentCenter; // Hiển thị nội dung chi tiết ở giữa
	    @FXML
	    private ImageView imageCenter; // Hiển thị ảnh tin ở giữa
	    @FXML 
	    private Label dateInfo;

	    @FXML
	    public void initialize() {
	        loadNews(); 
	    }
	    
	    public void addNews(New news) {
	        HBox newsItem = new HBox();
	        newsItem.setAlignment(Pos.CENTER_LEFT);
	        newsItem.setPrefSize(360, 106);
	        
	        VBox.setMargin(newsItem, new Insets(10, 0, 10, 5));

	        // Tạo ImageView
	        ImageView imageView = new ImageView();
	        imageView.setFitHeight(102);
	        imageView.setFitWidth(144);
	        imageView.setPickOnBounds(true);
	        imageView.setPreserveRatio(true);
	        imageView.setImage(new Image(new ByteArrayInputStream(news.getImageNew()))); 
	        
	        VBox textContainer = new VBox();
	        textContainer.setAlignment(Pos.CENTER_LEFT);
	        textContainer.setPrefSize(202, 106);
	        textContainer.setSpacing(5); 
	        
	        // Tạo Label cho tiêu đề
	        Label titleLabel = new Label(news.getTitleNew());
	        titleLabel.setPrefSize(205, 66);
	        titleLabel.setTextFill(Color.WHITE); // Màu chữ trắng
	        titleLabel.setWrapText(true);
	        titleLabel.setFont(Font.font("System", FontWeight.BOLD, 14));
	        
	        // Tạo Label cho mô tả
	        Label descriptionLabel = new Label(news.getContentNew());
	        descriptionLabel.setPrefSize(205, 46);
	        descriptionLabel.setTextFill(Color.WHITE); // Màu chữ trắng
	        descriptionLabel.setWrapText(true);
	        
	        textContainer.getChildren().addAll(titleLabel, descriptionLabel);
	        
	        // Thêm ImageView và VBox vào HBox
	        newsItem.getChildren().addAll(imageView, textContainer);
	        
	        // Thêm margin vào textContainer (nếu cần)
	        HBox.setMargin(textContainer, new Insets(0, 0, 0, 5));
	        
	        // Thêm HBox vào newsContainer
	        newsContainer.getChildren().add(newsItem);

	        
	        // Tùy chọn: Thêm Separator nếu cần
	        Separator separator = new Separator();
	        separator.setPrefWidth(360);
	        newsItem.setOnMouseClicked(event -> showNewsInCenter(news));

	        newsContainer.getChildren().add(separator);
	    }
	    public void showNewsInCenter(New news) {
	        titleCenter.setText(news.getTitleNew());
	        contentCenter.setText(news.getContentNew());
	        dateInfo.setText(formatLocalDateTime(news.getDateNew()));
	        if (news.getImageNew() != null) {
	            Image image = new Image(new ByteArrayInputStream(news.getImageNew()));
	            imageCenter.setImage(image);
	        } else {
	            imageCenter.setImage(null);
	        }
	    }
	    public void loadNews() {
	        for (New news : NewManager.getInstance().getAllNews()) {
	            addNews(news);
	        }
	    }
	    public static String formatLocalDateTime(LocalDateTime dateTime) {
	        if (dateTime == null) {
	            return "";
	        }
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        return dateTime.format(formatter);
	    }

}
