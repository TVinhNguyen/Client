package Controller_UI;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;

import Controller.Server;
import Dto.CategoryDto;
import Dto.ComputerDto;
import Dto.CustomerDto;
import Dto.PromotionDto;
import Dto.RoleDto;
import Dto.StaffDto;
import Dto.productDto;
import Model.Category;
import Model.Computer;
import Model.Customer;
import Model.CustomerTableRow;
import Model.Product;
import Model.Promotion;
import Model.PromotionTableRow;
import Model.Staff;
import Model.StaffTableRow;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;

public class controllerAdmin {
@FXML
private Label lableTime;
@FXML
private Label lableNotification;
@FXML
private Label lableNotificationStaff;
@FXML
private Label lableNotificationPromotion;
@FXML
private Label lableNotificationCustomer;
@FXML
private FontAwesomeIcon close;
@FXML
private FontAwesomeIcon minus;
@FXML
private FontAwesomeIcon menu;
@FXML
private FontAwesomeIcon computer;
@FXML
private FontAwesomeIcon history;
@FXML
private FontAwesomeIcon client;
@FXML
private FontAwesomeIcon staff;
@FXML
private FontAwesomeIcon sale;
@FXML
private FontAwesomeIcon revenue;
@FXML
private FontAwesomeIcon bell;
@FXML
private FontAwesomeIcon setting;
@FXML 
private Separator h1;
@FXML 
private Separator h2;
@FXML 
private Separator h3;
@FXML 
private Separator h4;
@FXML 
private Separator h5;
@FXML
private Separator h6;
@FXML 
private Separator h7;

@FXML
private AnchorPane formClient;

@FXML
private AnchorPane formComputer;

@FXML
private AnchorPane formHistory;

@FXML
private AnchorPane formMenu;

@FXML
private AnchorPane formRevenue;

@FXML
private AnchorPane formSale;

@FXML
private AnchorPane formStaff;

@FXML
private AnchorPane chartComputer;

@FXML
private AnchorPane chartGenus;

@FXML
private AnchorPane chartGuest;

@FXML
private AnchorPane chartRevenue;

@FXML
private AnchorPane payment;

@FXML
private ComboBox<String> comboboxSelectChart;

@FXML
private ComboBox<String> comboboxComputerMonth;

@FXML
private ComboBox<String> comboboxGuestMonth;

@FXML
private ComboBox<String> comboboxComputerYear;

@FXML
private ComboBox<String> comboboxGuestYear;

@FXML
private ComboBox<String> comboboxSelectGenus;

@FXML
private ComboBox<String> comboboxSelectRevenue;

@FXML
private ComboBox<String> cbbCategoryMenuProduct;

@FXML
private ComboBox<String> cbbCategoryMenuProduct1;

@FXML
private ComboBox<String> cbbnameRole;

@FXML
private ComboBox<String> cbbStatusPromotion;

@FXML
private ComboBox<String> cbbSelectPromotion;

@FXML
private ComboBox<String> cbbSelectCustomer;

@FXML
private FlowPane flowPaneProduct;

@FXML
private FlowPane flowPaneComputer;

@FXML
private Pane imageMenuProduct;

@FXML
private Pane paneNotification;

@FXML
private Pane paneNotificationStaff;

@FXML
private Pane paneAddEndUpdatePromotion;

@FXML
private Pane paneNotificationPromotion;

@FXML
private Pane paneAddEndUpdateCustomer;

@FXML
private Pane paneNotificationCustomer;

@FXML
private TextField idMenuProduct;

@FXML
private TextField priceMenuProduct;

@FXML
private TextField nameMenuProduct;

@FXML
private TextField quantityMenuProduct;

@FXML
private TextField searchMenuProduct;

@FXML 
private TextField tfIdComputer;

@FXML
private TextField tfNameComputer;

@FXML
private TextField searchComputer;

@FXML
private TextField tfidStaff;

@FXML
private TextField tfnameStaff;

@FXML
private TextField tfphoneStaff;

@FXML
private TextField tfaddressStaff;

@FXML
private TextField tfaccountStaff;

@FXML
private TextField tfpasswordStaff;

@FXML
private TextField tfdayWork;

@FXML 
private TextField searchStaff;

@FXML
private TextField tfIdPromotion;

@FXML
private TextField tfNamePromotion;

@FXML 
private TextField tfApplicablePromotion;

@FXML
private TextField tfNodePromotion;

@FXML 
private TextField searchPromotion;

@FXML
private TextField searchCustomer;

@FXML
private TextField tfIdCustomer;

@FXML
private TextField tfNameCustomer;

@FXML
private TextField tfPhoneCustomer;

@FXML 
private TextField tfPointCustomer;

@FXML
private TextField tfNameAccount;

@FXML
private TextField tfPasswordAccount;

@FXML
private TextField tfHourRemainTime;

@FXML
private TextField tfMinuteRemainTime;
@FXML
private TextField tfSecondRemainTime;

@FXML
private Button btCancelNotification;

@FXML
private Button btOkNotification;

@FXML
private Button btCancelNotificationStaff;

@FXML
private Button btOkNotificationStaff;

@FXML
private Button btExitPromotion;

@FXML
private Button btOkPromotion;

@FXML
private Button btCancelNotificationPromotion;

@FXML
private Button btOkNotificationPromotion;

@FXML
private Button btCancelNotificationCustomer;

@FXML
private Button btOkNotificationCustomer;

@FXML
private Button btExitCustomer;

@FXML
private Button btOkCustomer;

@FXML
private Button addCustomer;

@FXML
private RadioButton rbOn;

@FXML
private RadioButton rbOff;

@FXML
private RadioButton rbMaintenance;

@FXML
private TableColumn<StaffTableRow, String> nameRole;

@FXML
private TableColumn<StaffTableRow, String> nameStaff;

@FXML
private TableColumn<StaffTableRow, String> phoneStaff;

@FXML
private TableColumn<StaffTableRow, Integer> dayWork;

@FXML
private TableColumn<StaffTableRow, Button> show;

@FXML
private TableColumn<PromotionTableRow,Integer> idPromotion;

@FXML
private TableColumn<PromotionTableRow, String> namePromotion;

@FXML
private TableColumn<PromotionTableRow, String> applicableLevel;

@FXML
private TableColumn<PromotionTableRow, Date> startDate;

@FXML
private TableColumn<PromotionTableRow, Date> endDate;

@FXML
private TableColumn<PromotionTableRow, String> statusPromotion;

@FXML
private TableColumn<PromotionTableRow, Button> showPromotion;

@FXML
private TableColumn<CustomerTableRow,Integer> idCustomer;

@FXML
private TableColumn<CustomerTableRow,String> nameCustomer;

@FXML
private TableColumn<CustomerTableRow, String> phoneCustomer;

@FXML
private TableColumn<CustomerTableRow, String> nameAccount;

@FXML
private TableColumn<CustomerTableRow, String> passwordAccount;

@FXML
private TableColumn<CustomerTableRow, Integer> pointAccount;

@FXML
private TableColumn<CustomerTableRow, Time> remainTime;

@FXML
private TableColumn<CustomerTableRow, Button> showCustomer;

@FXML
private TableView<StaffTableRow> tableViewStaff;

@FXML
private TableView<PromotionTableRow> tableViewPromotion;

@FXML
private TableView<CustomerTableRow> tableViewCustomer;

@FXML
private DatePicker dptimeStartWork;

@FXML
private DatePicker dpStartDate;

@FXML 
private DatePicker dpEndDate;

private byte[] imageBytes=null;

private Server server;

ObservableList<StaffTableRow> staffList=FXCollections.observableArrayList();

ObservableList<PromotionTableRow> promotionList=FXCollections.observableArrayList();

ObservableList<CustomerTableRow> customerList=FXCollections.observableArrayList();

public controllerAdmin() {
	this.server = new Server(this);
	new Thread(server).start();
}


@FXML
public void initialize()
{
	 updateTime();
	 setHoverEffect(close);//chức năng đóng cửa sổ
     setHoverEffect(minus);//chức năng thu nhỏ cửa sổ
     setHoverMenu(bell);
     setHoverMenu(setting);
     
     FontAwesomeIcon[] listMenu= {menu,computer,history,client,sale,staff,revenue};
	 Separator[] listRow= {h1,h2,h3,h4,h5,h6,h7};
	 AnchorPane[] listAnchorPane= {formMenu,formComputer,formHistory,formClient,formSale,formStaff,formRevenue};
	 
	 Map<FontAwesomeIcon, Separator> list1=new HashMap<FontAwesomeIcon, Separator>();
	 list1.put(menu, h1);
     list1.put(computer, h2);
     list1.put(history, h3);
     list1.put(client, h4);
     list1.put(sale, h5);
     list1.put(staff, h6);
     list1.put(revenue, h7);
     Map<Separator, AnchorPane> list2=new HashMap<Separator, AnchorPane>();
     list2.put(h1, formMenu);
     list2.put(h2, formComputer);
     list2.put(h3, formHistory);
     list2.put(h4, formClient);
     list2.put(h5, formSale);
     list2.put(h6, formStaff);
     list2.put(h7,formRevenue);
     
     listMenu[0].setFill(Color.web("#c4c8cf"));
     listRow[0].setVisible(true);
     listAnchorPane[0].setVisible(true);
     
     for(int i=1;i<listAnchorPane.length;i++)
     {
    	 listAnchorPane[i].setVisible(false);
     }
     
     for (int i=1;i<listRow.length;i++) { 
         listRow[i].setVisible(false);
     }
     for ( Map.Entry<FontAwesomeIcon, Separator> icon : list1.entrySet()) {
    	 setClickMenu(icon.getKey(),icon.getValue(),listMenu,listRow,list2);
         setHoverMenu(icon.getKey());   
     }
     comboboxChart(comboboxSelectChart,comboboxComputerMonth,comboboxComputerYear,
    		       comboboxGuestMonth,comboboxGuestYear,comboboxSelectGenus,
    		       comboboxSelectRevenue);
     //sự kiện combobox hiện màn hình thống kê
     AnchorPane[] listChart= {chartRevenue,chartGuest,chartGenus,chartComputer,payment};
     listChart[0].setVisible(true);
     comboboxSelectChart.setOnAction(event -> {
    		for(AnchorPane x: listChart)
    		{
    			x.setVisible(false);
    		}
    		String value=comboboxSelectChart.getValue();
    		try {
    			int i=comboboxSelectChart.getItems().indexOf(value);
    			listChart[i].setVisible(true);
    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    		}	
     });
     
     //thêm pane cho flowpane của menu
     loadProductToFlowPane();
     //thêm phân loại sản phẩm vào combobox menu
     loadComboboxCategory(cbbCategoryMenuProduct1);
     loadComboboxCategory(cbbCategoryMenuProduct);
     //thêm pane cho flowpane của computer
     loadComputerAndLable();
     //load bảng nhân viên
     loadTableStaff();
     //load bảng khuyến mãi
     loadTablePromotion();
     //load bảng khách hàng
     loadTableCustomer();
    
}
private void comboboxChart(ComboBox<String> comboboxSelectChart,ComboBox<String> comboboxComputerMonth,
		                   ComboBox<String> comboboxComputerYear,ComboBox<String> comboboxGuestMonth,
		                   ComboBox<String> comboboxGuestYear,ComboBox<String> comboboxSelectGenus,
		                   ComboBox<String> comboboxSelectRevenue)
{
    
	 //Thêm các tùy chọn danh sách thống kê 
        ObservableList<String> chartTypes = FXCollections.observableArrayList(
            "Thống kê thu", "Thông số khách", "Thống kê chi", "Tỉ lệ chọn máy"
        );
        comboboxSelectChart.setItems(chartTypes);
        comboboxSelectChart.setValue("Thống kê thu");
        
        //Thêm tùy chọn danh sách các tháng và năm cho combobox
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        ObservableList<String> months = FXCollections.observableArrayList();
        ObservableList<String> Years = FXCollections.observableArrayList();
        for(int year=2020;year<=currentYear;year++)
        {
        	Years.add("Năm "+year);
        }
        for (int x = 1; x <= 12; x++) {
            months.add("Tháng " + x);
        }
        comboboxComputerMonth.setItems(months);
        comboboxComputerMonth.setValue("Tháng " + currentMonth );
        comboboxGuestMonth.setItems(months);
        comboboxGuestMonth.setValue("Tháng " + currentMonth);
        comboboxComputerYear.setItems(Years);
        comboboxComputerYear.setValue("Năm " + currentYear);
        comboboxGuestYear.setItems(Years);
        comboboxGuestYear.setValue("Năm " + currentYear);
        
        //Thêm tùy chọn ngày, tháng, năm vào combobox
        ObservableList<String> x = FXCollections.observableArrayList(
                "Ngày", "Tháng", "Năm"
            );
        comboboxSelectRevenue.setItems(x);
        comboboxSelectGenus.setItems(x);
}

//cập nhật thời gian
private void updateTime()
{
	Timeline timeline=new Timeline(
		new KeyFrame(Duration.seconds(1),event -> {
			lableTime.setText(java.time.LocalDateTime.now().format(
			java.time.format.DateTimeFormatter.ofPattern("HH:mm  dd-MM-yy")	
			));
		})	
	);
	timeline.setCycleCount(Timeline.INDEFINITE);
	timeline.play(); 
  }
//đóng cửa sổ 
@FXML
private void handleClose(MouseEvent event) {
	 Stage stage = (Stage) close.getScene().getWindow(); 
     stage.close();  
}
//thu nhỏ cửa sổ
@FXML
private void handleMinus(MouseEvent event) {
    Stage stage = (Stage) minus.getScene().getWindow();
    stage.setIconified(true); 
}
//sự kiện khi di chuột tới
private void setHoverEffect(FontAwesomeIcon icon) {
	icon.setOnMouseEntered(event -> {
    	icon.setFill(Color.WHITE);  
    });
    icon.setOnMouseExited(event -> {
    	icon.setFill(Color.WHITE);
    });
}
//sự kiện khi di chuột tới 
private void setHoverMenu(FontAwesomeIcon icon)
{
	icon.setOnMouseEntered(event -> {
    	icon.setScaleX(1.5);                
        icon.setScaleY(1.5);
    });
    icon.setOnMouseExited(event -> {
    	icon.setScaleX(1);                
        icon.setScaleY(1);
    });
}
//sự kiện khi click chuột 
private void setClickMenu(FontAwesomeIcon icon,Separator separator, FontAwesomeIcon[] lisMenu,Separator[] listRow,Map<Separator, AnchorPane> list2) {
    icon.setOnMouseClicked(event -> {
    	for (FontAwesomeIcon x : lisMenu) {
    		if(x==icon)
    		{
    		    x.setFill(Color.RED); 
    		}
    		else
    		{
    	         x.setFill(Color.WHITE);
    		}
   
        }
    	for (Separator x : listRow) {
    		if(x==separator)
    		{
    			  x.setVisible(true);
    		}
    		else
    		{
    			  x.setVisible(false);
    		}
          
        }
    	for(Map.Entry<Separator, AnchorPane> x: list2.entrySet())
    	{
    		if(x.getKey()==separator)
    		{
    			x.getValue().setVisible(true);
    		}
    		else
    		{
    			x.getValue().setVisible(false);
    		}
    	}
        
    });
}

@FXML
private void showForm(MouseEvent event)
{
	 AnchorPane[] listChart= {chartRevenue,chartGuest,chartGenus,chartComputer};
	 for(AnchorPane chart:listChart)
	 {
		 chart.setVisible(false);
	 }
	 payment.setVisible(true);
}

//----------------------------------MeNu---------------------------


//load giao diện sản phẩm
private void loadProductToFlowPane()
{
	flowPaneProduct.getChildren().clear();
	try {
		List<Product> products=Dto.productDto.getAllProducts();
		for(var product:products)
		{
			if(product.isStatusProduct())
			createImage(product.getNameProduct(), product.getImageProduct(),flowPaneProduct,product.getIdProduct());
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//tạo ra giao diện chức sản phẩm 
private void createImage(String nameProduct, byte[] imageProduct,FlowPane flowPane , int idProduct)
{
	
	try {
		 Image image = new Image(new ByteArrayInputStream(imageProduct));
	     ImageView imageView = new ImageView(image);
	     imageView.setFitWidth(202);
	     imageView.setFitHeight(118);
	     
	     Label label=new Label(nameProduct);
	     label.setStyle(
	    		 "-fx-font-family: 'Arial'; " +
	             "-fx-font-size: 14px; " +
	             "-fx-text-fill: white; " +
	             "-fx-alignment: center;");
	     label.setPrefWidth(190);  
	     label.setPrefHeight(25);
	     label.setAlignment(Pos.CENTER);
	     
	     Pane productPane=new Pane();
	     productPane.setStyle(
	    	"-fx-border-color: black;" + 
            "-fx-border-width: 1px;");
	     productPane.setPrefHeight(200);
	     productPane.setPrefWidth(245);
	     
	     imageView.setLayoutX(23);
	     imageView.setLayoutY(25);
	     label.setLayoutX(28);
	     label.setLayoutY(161);
	     
	     productPane.getChildren().addAll(imageView,label);
	     //sự kiện khi click vào pane
	     productPane.setOnMouseClicked(event ->{
	    	List<Product> products;
			try {
				products = Dto.productDto.getAllProducts();
				for(var product:products)
		 		{
		 			if(product.getIdProduct()==idProduct && product.isStatusProduct())
		 			{
		 				idMenuProduct.setText(product.getIdProduct()+"");
		 				nameMenuProduct.setText(product.getNameProduct());
		 				priceMenuProduct.setText(product.getPriceProduct()+" VND");
		 				quantityMenuProduct.setText(product.getQuantityProduct()+"");
		 				cbbCategoryMenuProduct.setValue(CategoryDto.getNameCategoryProduct(product.getIdCategory()));
		 			    loadImage(product.getImageProduct());
		 				break;
		 			}
		 		}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	     });
	     flowPane.getChildren().add(productPane);
	} catch (Exception e) {
		e.printStackTrace();
	}  
}


//Thêm hình ảnh khi click vào pane
private void loadImage(byte[] image)
{
	    imageBytes=image;
	    Image image1=new Image(new ByteArrayInputStream(image));
	    ImageView imageMenu = new ImageView(image1);
	    imageMenu.setFitWidth(284);
	    imageMenu.setFitHeight(150);
	    imageMenu.setLayoutX(76);
	    imageMenu.setLayoutY(12);
	    imageMenuProduct.getChildren().add(imageMenu);
}
//tạo combobox phân loại sản phẩm 
private void loadComboboxCategory(ComboBox<String> x)
{
	try {
		if(x == cbbCategoryMenuProduct1)
		{
			cbbCategoryMenuProduct1.getItems().add("All");
			if (!cbbCategoryMenuProduct1.getItems().isEmpty()) {
                cbbCategoryMenuProduct1.setValue(cbbCategoryMenuProduct1.getItems().get(0));
            }
		}
		List<Category> categorys=CategoryDto.getALLCategorys();
		for(var name:categorys)
		{
			x.getItems().add(name.getNameCategory());
		} 
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//tạo sự kiện tìm kiếm menu
@FXML
private void searchMenu(KeyEvent event) {
	try {
       
        List<Product> products = productDto.getAllProducts();
        String searchText = searchMenuProduct.getText().toLowerCase();
        flowPaneProduct.getChildren().clear();
        for (Product product : products) {
            if (product.getNameProduct().toLowerCase().contains(searchText) && product.isStatusProduct()) {
                createImage(product.getNameProduct(), product.getImageProduct(), flowPaneProduct, product.getIdProduct()); 
            }else
            if(searchText=="" && product.isStatusProduct())
            {
            	 createImage(product.getNameProduct(), product.getImageProduct(), flowPaneProduct, product.getIdProduct());
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); 
    }
}
//sự kiện chọn combobox menu 
@FXML
private void cbbSearchMenu(ActionEvent event) {
try {
	List<Product> products=productDto.getAllProducts();
	String nameCombobox=cbbCategoryMenuProduct1.getSelectionModel().getSelectedItem();
	int idCategory=CategoryDto.getIdCategoryProduct(nameCombobox);
	flowPaneProduct.getChildren().clear();
	for(Product product:products)
	{
		if(product.getIdCategory()== idCategory && product.isStatusProduct())
		{
			createImage(product.getNameProduct(), product.getImageProduct(), flowPaneProduct, product.getIdProduct());
		}
		else if(nameCombobox=="All" && product.isStatusProduct())
		{
			createImage(product.getNameProduct(), product.getImageProduct(), flowPaneProduct, product.getIdProduct());
		}
	}
} catch (Exception e) {
	e.printStackTrace();
}
}
//Thêm hình ảnh từ máy tính lên 
@FXML
private void addImageMenu(MouseEvent event) {
 JFileChooser filechooser=new JFileChooser();
 filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
 
 int result=filechooser.showOpenDialog(null);
 if(result==JFileChooser.APPROVE_OPTION)
 {
	 File imageFile=filechooser.getSelectedFile();
	 try(FileInputStream fileInputStream=new FileInputStream(imageFile)) {
		imageBytes =new byte[(int) imageFile.length()];
		fileInputStream.read(imageBytes);
		loadImage(imageBytes);
	} catch (Exception e) {
		e.printStackTrace();
	}
 }
}
//xóa sản phẩm 
@FXML
private void deleteMenuProduct(MouseEvent event) {
   try {
	   if(idMenuProduct.getText()=="")
	    {
	    	paneNotification.setVisible(true);
	    	lableNotification.setText("Bạn chưa chọn sản phẩm");
	    	btCancelNotification.setOnMouseClicked(even ->{
	    		paneNotification.setVisible(false);
	    	});
	    	btOkNotification.setVisible(false);
	    }
	    else
	    {
	    	paneNotification.setVisible(true);
	    	lableNotification.setText("Ban Có muốn xóa sản phẩm : "+nameMenuProduct.getText()+" ?");
	    	try {
	    		btOkNotification.setOnMouseClicked(even ->{
	    			String notification=productDto.setStatusProduct(Integer.parseInt(idMenuProduct.getText()),false);
	    			if(notification=="Thành công loại bỏ sản phẩm !!!")
	    			{
	    				lableNotification.setStyle(
	    						"-fx-border-color: green; " +
	    				        "-fx-text-fill: green; "
	    						);
	    			}
	    			else if(notification=="Loại bỏ không thành công !!!")
	    			{
	    				lableNotification.setStyle(
	    						"-fx-border-color: red; "+
	    				         "-fx-text-fill: red; "
	    						);
	    			}
		    		lableNotification.setText(notification);
		    		btOkNotification.setOnMouseClicked(even1 ->{
		        		paneNotification.setVisible(false);
		        		loadProductToFlowPane();
		        		loadAfterDelete();
		        	    lableNotification.setStyle(
	    						"-fx-border-color: black; " +
	    				        "-fx-text-fill: white; "
	    						);
		        	});
		    		btCancelNotification.setVisible(false);
		    	});
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	btCancelNotification.setVisible(true);
	    	btCancelNotification.setOnMouseClicked(even -> {
	    		paneNotification.setVisible(false);
	    	});
	    }
  } catch (Exception e) {
	e.printStackTrace();
  }	
}
//load sản phẩm sau khi xóa
private void loadAfterDelete()
{
	imageMenuProduct.getChildren().clear();
	imageBytes=null;
	idMenuProduct.setText("");
	nameMenuProduct.setText("");
	priceMenuProduct.setText("");
	quantityMenuProduct.setText("");
	cbbCategoryMenuProduct.getItems().get(0);
}
//thêm sản phẩm 
@FXML
private void addMenuProduct(MouseEvent event) {
    try {
        paneNotification.setVisible(true);
        lableNotification.setText("Bạn muốn thêm sản phẩm: " + nameMenuProduct.getText() + " ?");

        btOkNotification.setOnMouseClicked(even -> {
            try {
                int idProduct = -1;
                if (!idMenuProduct.getText().isEmpty()) {
                    idProduct = Integer.parseInt(idMenuProduct.getText());
                }
                String nameProduct = nameMenuProduct.getText();
                boolean isProductExist = false;

                for (var product : productDto.getAllProducts()) {
                    if (idProduct == product.getIdProduct()) {
                        lableNotification.setText("Bạn muốn cập nhật thông tin");
                        btCancelNotification.setVisible(true);
                        btCancelNotification.setOnMouseClicked(even1 -> {
                            paneNotification.setVisible(false);  
                        });

                        btOkNotification.setVisible(true);
                        btOkNotification.setOnMouseClicked(even1 -> {
                            updateProductDetails(product);
                        });
                        isProductExist = true;
                        break;
                    } else if (nameProduct.equalsIgnoreCase(product.getNameProduct())) {
                        lableNotification.setText("Tên sản phẩm đã trùng. Bạn có muốn tiếp tục?");
                        btOkNotification.setVisible(true);
                        btOkNotification.setOnMouseClicked(even1 -> {
                            addNewProduct(nameProduct);
                        });

                        btCancelNotification.setVisible(true);
                        btCancelNotification.setOnMouseClicked(even1 -> {
                            paneNotification.setVisible(false);  
                        });
                        isProductExist = true;
                        break;
                    }
                }
                if (!isProductExist) {
                    addNewProduct(nameProduct);
                }
            } catch (NumberFormatException e) {
                lableNotification.setText("Nhập sai dữ liệu! Vui lòng kiểm tra lại các trường số.");
               
            } catch (Exception e) {
                lableNotification.setText("Có lỗi xảy ra khi thêm sản phẩm.");
                e.printStackTrace();
            }  
        });

        btCancelNotification.setVisible(true);
        btCancelNotification.setOnMouseClicked(even -> {
            paneNotification.setVisible(false);
        });
    } catch (Exception e) {
        e.printStackTrace();
    }
    loadProductToFlowPane();
    btOkNotification.setVisible(true);
}

// thêm product
private void addNewProduct(String nameProduct) {
    try {
    	btOkNotification.setVisible(false);
        if (nameProduct == null || nameProduct.trim().isEmpty()) {
            lableNotification.setText("Tên sản phẩm không được để trống.");
            return;
        }
        Double priceProduct;
        try {
            priceProduct = Double.parseDouble(priceMenuProduct.getText().trim());
            if (priceProduct <= 0) {
                lableNotification.setText("Giá sản phẩm phải lớn hơn 0.");
                return;
            }
        } catch (NumberFormatException e) {
            lableNotification.setText("Giá sản phẩm không hợp lệ! Vui lòng nhập số.");
            return;
        }
        byte[] imageProduct = imageBytes;
        if (imageProduct == null) {
            lableNotification.setText("Bạn chưa chọn hình ảnh!");
            return;
        }
        int quantityProduct;
        try {
            quantityProduct = Integer.parseInt(quantityMenuProduct.getText().trim());
            if (quantityProduct <= 0) {
                lableNotification.setText("Số lượng sản phẩm phải lớn hơn 0.");
                return;
            }
        } catch (NumberFormatException e) {
            lableNotification.setText("Số lượng sản phẩm không hợp lệ! Vui lòng nhập số.");
            return;
        }
        String selectedCategory = cbbCategoryMenuProduct.getSelectionModel().getSelectedItem();
        if (selectedCategory == null) {
            lableNotification.setText("Bạn chưa chọn danh mục sản phẩm!");
            return;
        }
        int idCategory = CategoryDto.getIdCategoryProduct(selectedCategory);
        if (idCategory == -1) {
            lableNotification.setText("Danh mục sản phẩm không hợp lệ.");
            return;
        }
        String result = productDto.addProduct(nameProduct, priceProduct, imageProduct, quantityProduct, true, idCategory);
        lableNotification.setText(result);
        loadProductToFlowPane();
        loadAfterDelete();
        btOkNotification.setVisible(true);
        btOkNotification.setOnMouseClicked(even1 -> paneNotification.setVisible(false));
        btCancelNotification.setVisible(false);

    } catch (Exception e) {
        lableNotification.setText("Có lỗi xảy ra khi thêm sản phẩm.");
        e.printStackTrace();
    }
}

// cập nhật lại product
private void updateProductDetails(Product product) {
    try {
    	btOkNotification.setVisible(false);
    	String nameProduct=nameMenuProduct.getText();
    	if (nameProduct == null || nameProduct.trim().isEmpty()) {
            lableNotification.setText("Tên sản phẩm không được để trống.");
            return;
        }
        Double priceProduct;
        try {
            priceProduct = Double.parseDouble(priceMenuProduct.getText().trim());
            if (priceProduct <= 0) {
                lableNotification.setText("Giá sản phẩm phải lớn hơn 0.");
                return;
            }
        } catch (NumberFormatException e) {
            lableNotification.setText("Giá sản phẩm không hợp lệ! Vui lòng nhập số.");
            return;
        }
        byte[] imageProduct = imageBytes;
        if (imageProduct == null) {
            lableNotification.setText("Bạn chưa chọn hình ảnh!");
            return;
        }
        int quantityProduct;
        try {
            quantityProduct = Integer.parseInt(quantityMenuProduct.getText().trim());
            if (quantityProduct <= 0) {
                lableNotification.setText("Số lượng sản phẩm phải lớn hơn 0.");
                return;
            }
        } catch (NumberFormatException e) {
            lableNotification.setText("Số lượng sản phẩm không hợp lệ! Vui lòng nhập số.");
            return;
        }
        String selectedCategory = cbbCategoryMenuProduct.getSelectionModel().getSelectedItem();
        if (selectedCategory == null) {
            lableNotification.setText("Bạn chưa chọn danh mục sản phẩm!");
            return;
        }
        int idCategory = CategoryDto.getIdCategoryProduct(selectedCategory);
        if (idCategory == -1) {
            lableNotification.setText("Danh mục sản phẩm không hợp lệ.");
            return;
        }
        String result = productDto.updateProduct(product.getIdProduct(), nameProduct, priceProduct, imageProduct, quantityProduct, true, idCategory);
        lableNotification.setText(result);
        loadProductToFlowPane();
        loadAfterDelete();
        btOkNotification.setVisible(true);
        btOkNotification.setOnMouseClicked(even1 -> paneNotification.setVisible(false));
        btCancelNotification.setVisible(false);

    } catch (Exception e) {
        lableNotification.setText("Có lỗi xảy ra khi cập nhật sản phẩm.");
        e.printStackTrace();
    }
}

// reset lại form điền thông tin 
@FXML
private void resetForm(MouseEvent event) {
      loadAfterDelete();
}

//---------------------------------------MeNu----------------------------


//-------------------------------------Computer---------------------------

//tạo giao diện computer
private void createComputerAndLabel(int idComputer,String nameComputer,int statusComputer,FlowPane flowPane)
{
	try {
		FontAwesomeIcon icon =new FontAwesomeIcon();
		icon.setSize("70px");
		icon.setGlyphName("DESKTOP");
		icon.setLayoutX(29);
		icon.setLayoutY(74);
		
		Label label=new Label();
		label.setStyle("-fx-font-family:\"Arial\"; "+
		               "-fx-font-size:14px; "+
				       "-fx-text-fill:white; ");
		label.setText(nameComputer);
		label.setLayoutX(30);
		label.setLayoutY(92);
		
		Pane pane=new Pane();
		pane.setPrefWidth(138);
		pane.setPrefHeight(117);
		if(statusComputer==0)
		{
			pane.setStyle("-fx-border-color: red; "+" -fx-border-width: 1px; ");
		}
		else
		if(statusComputer==1)
		{
			pane.setStyle("-fx-border-color: green; "+" -fx-border-width: 1px; ");
		}
		else
		if(statusComputer==2)
		{
				pane.setStyle("-fx-border-color: black; "+" -fx-border-width: 1px; ");
		}
		pane.getChildren().addAll(icon,label);
		pane.setOnMouseClicked(even->{
			tfIdComputer.setText(idComputer+"");
			tfNameComputer.setText(nameComputer);
			rbOff.setSelected(false);
			rbOn.setSelected(false);
			rbMaintenance.setSelected(false);
			if (statusComputer == 0) {
			    rbOff.setSelected(true);
			} else if (statusComputer == 1) {
			    rbOn.setSelected(true);
			} else if (statusComputer == 2) {
			    rbMaintenance.setSelected(true);
			}
		});
		flowPane.getChildren().add(pane);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//load máy tính
private void loadComputerAndLable()
{
	flowPaneComputer.getChildren().clear();
	try {
		List<Computer> computers=ComputerDto.getAllComputers();
		for(var computer:computers)
		{
			createComputerAndLabel(computer.getIdComputer(), computer.getNameComputer(),computer.getStatusComputer() ,flowPaneComputer);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//tìm kiếm máy tính 
@FXML
private void searchComputer(KeyEvent event) {
    try {
    	String text= searchComputer.getText().toLowerCase();
    	flowPaneComputer.getChildren().clear();
		for(var computer:ComputerDto.getAllComputers())
		{
			if(computer.getNameComputer().toLowerCase().contains(text.toLowerCase()))
			{
				createComputerAndLabel(computer.getIdComputer(), computer.getNameComputer(), computer.getStatusComputer(), flowPaneComputer);
			}
			else if(text=="")
			{
				createComputerAndLabel(computer.getIdComputer(), computer.getNameComputer(), computer.getStatusComputer(), flowPaneComputer);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	} 
}

//-------------------------------------Computer---------------------------

//-------------------------------------Staff-------------------------------
//load danh sách sinh viên
private void loadTableStaff()
{
	try {
		ObservableList<String> listRole = FXCollections.observableArrayList();
		cbbnameRole.getItems().clear();
		tableViewStaff.getItems().clear();
		staffList.clear();
		for(var staff:StaffDto.getAllStaffs())
		{
			createTableStaff(staff);
		}
		//thêm vào combox chức năng 
	   for(var role: RoleDto.getAllRoles())
		{
				listRole.add(RoleDto.checkID(role.getIdRole()));
		}
		cbbnameRole.setItems(listRole);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//thêm nhân viên vào hàng
private void createTableStaff(Staff staff)
{
	String role = RoleDto.checkID(staff.getIdRole());
	Button showButton = new Button("Xem");
	showButton.setPrefWidth(88.79998779296875);
	showButton.setMinWidth(50); 
	showButton.setMaxWidth(88.79998779296875);
	showButton.setOnAction(event -> {
	        	tfidStaff.setText(staff.getIdStaff()+"");
	        	tfnameStaff.setText(staff.getName());
	        	tfphoneStaff.setText(staff.getPhone());
	        	tfaddressStaff.setText(staff.getAddressStaff());
	        	tfaccountStaff.setText(staff.getNameAccount());
	        	tfpasswordStaff.setText(staff.getPasswordAccount());
	        	cbbnameRole.getSelectionModel().select(RoleDto.checkID(staff.getIdRole()));
	        	dptimeStartWork.setValue(staff.getTimeStartWork().toLocalDate());
	        	tfdayWork.setText(staff.getDayWork()+"");
	 });
	  StaffTableRow rowData = new StaffTableRow(
	            staff.getName(),
	            staff.getPhone(),
	            staff.getDayWork(),
	            role,
	            showButton
	  );
		    staffList.add(rowData);
		    nameStaff.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
		    phoneStaff.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhone()));
		    dayWork.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getDayWork()).asObject());	   
		    nameRole.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRole()));
		    show.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getShowButton()));
		    tableViewStaff.setItems(staffList);
		
}
//xóa thông tin nhân viên hiện trên màn hình 
@FXML
private void resetStaff(MouseEvent even)
{
	tfidStaff.setText("");
	tfnameStaff.setText("");
	tfphoneStaff.setText("");
	tfaddressStaff.setText("");
	tfaccountStaff.setText("");
	tfpasswordStaff.setText("");
	cbbnameRole.getSelectionModel().clearSelection();
	dptimeStartWork.setValue(null);
	tfdayWork.setText("");
}
//tìm kiếm nhân viên
@FXML
private void searchStaff(KeyEvent event)
{
	try {
		String text=searchStaff.getText();
		tableViewStaff.getItems().clear();
		staffList.clear();
		for(var staff:StaffDto.getAllStaffs())
		{
			if (staff.getName().toLowerCase().contains(text.toLowerCase())
) {
			    createTableStaff(staff);
			} else if (text.isEmpty()) {
			    createTableStaff(staff);
			}

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
 
//thêm và cập nhật nhân viên
@FXML
private void addEndUpdateStaff(MouseEvent event) {
    try {
        paneNotificationStaff.setVisible(true);
        boolean check = true;

        // Kiểm tra các điều kiện
        if (tfnameStaff.getText().isEmpty()) {
            lableNotificationStaff.setText("Tên nhân viên không được để trống !!!");
            check = false;
        } else if (cbbnameRole.getValue() == null || cbbnameRole.getValue().trim().isEmpty()) {
            lableNotificationStaff.setText("Chức vụ không được để trống !!!");
            check = false;
        } else if (tfdayWork.getText().isEmpty() || !tfdayWork.getText().matches("\\d+")) {
            lableNotificationStaff.setText("Số ngày làm việc phải là số và không được để trống !!!");
            check = false;
        } else if (tfphoneStaff.getText().isEmpty() || !tfphoneStaff.getText().matches("\\d{10,11}")) {
            lableNotificationStaff.setText("Số điện thoại phải có 10-11 chữ số !!!");
            check = false;
        } else if (tfaddressStaff.getText().isEmpty()) {
            lableNotificationStaff.setText("Địa chỉ không được để trống !!!");
            check = false;
        } else if (dptimeStartWork.getValue() == null) {
            lableNotificationStaff.setText("Ngày bắt đầu làm việc không được để trống !!!");
            check = false;
        } else if (tfaccountStaff.getText().isEmpty()) {
            lableNotificationStaff.setText("Tên tài khoản không được để trống !!!");
            check = false;
        } else if (tfpasswordStaff.getText().isEmpty()) {
            lableNotificationStaff.setText("Mật khẩu không được để trống !!!");
            check = false;
        }
        if (!check) {
            btOkNotificationStaff.setVisible(false);
            btCancelNotificationStaff.setOnMouseClicked(event1 -> paneNotificationStaff.setVisible(false));
            return;
        }
        int dayWork=0;
        if(!tfdayWork.getText().isEmpty())
        {
        	 String dayWorkStr = tfdayWork.getText();
             dayWork = Integer.parseInt(dayWorkStr);
             if(dayWork<0)
             {
            	 lableNotificationStaff.setText("Ngày nhập nhỏ hơn 0 !!!");
            	 check=false;
             }
        }
        if (!check) {
            btOkNotificationStaff.setVisible(false);
            btCancelNotificationStaff.setOnMouseClicked(event1 -> paneNotificationStaff.setVisible(false));
            return;
        }
        String selectedRole = cbbnameRole.getValue().trim();
        int idRole = RoleDto.checkNameRole(selectedRole);
        String idStaffStr = tfidStaff.getText();
        if (idStaffStr.isEmpty()) {
            idStaffStr="0";
        }
        int idStaff = Integer.parseInt(idStaffStr);
        String nameStaff = tfnameStaff.getText();
        String phoneStaff = tfphoneStaff.getText();
        String nameAccount = tfaccountStaff.getText();
        String passwordAccount = tfpasswordStaff.getText();
        String addressStaff = tfaddressStaff.getText();
        LocalDate localDate = dptimeStartWork.getValue();
        Date timeStartWork = java.sql.Date.valueOf(localDate);
        boolean isStaffExist = false;
        for (var staff : StaffDto.getAllStaffs()) {
            if (staff.getIdStaff() == idStaff) {
                isStaffExist = true;
                break;
            }
        }
        if (isStaffExist) {
            lableNotificationStaff.setText("Bạn có muốn cập nhật thông tin nhân viên không ?");
            setupAddEndUpdateStaff(idStaff, nameStaff, phoneStaff, nameAccount, passwordAccount, addressStaff, timeStartWork, dayWork, idRole, "cập nhật");
        } else {
            lableNotificationStaff.setText("Bạn có muốn thêm thông tin nhân viên không ?");
            setupAddEndUpdateStaff(idStaff, nameStaff, phoneStaff, nameAccount, passwordAccount, addressStaff, timeStartWork, dayWork, idRole, "thêm");
        }
      
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//hiển thị thông báo thêm và cập nhật nhân viên 
private void setupAddEndUpdateStaff(int idStaff, String nameStaff, String phoneStaff, String nameAccount,
                                      String passwordAccount, String addressStaff, Date timeStartWork,
                                      int dayWork, int idRole, String action) {
    btCancelNotificationStaff.setVisible(true);
    btCancelNotificationStaff.setOnMouseClicked(event -> paneNotificationStaff.setVisible(false));
    btOkNotificationStaff.setVisible(true);
    btOkNotificationStaff.setOnMouseClicked(event -> {
        lableNotificationStaff.setText(StaffDto.addEndUpdateStaff(idStaff, nameStaff, phoneStaff, nameAccount,
                                                                  passwordAccount, addressStaff, timeStartWork, dayWork, idRole));
        btOkNotificationStaff.setVisible(false);
        btCancelNotificationStaff.setVisible(true);
        btCancelNotificationStaff.setOnMouseClicked(event2 -> {
            paneNotificationStaff.setVisible(false);
            loadTableStaff();
            resetStaff(event2);
        });
    });
}
//-------------------------------------Staff-------------------------------
//-------------------------------------Sale--------------------------------
//load thông tin bảng khuyến mãi 
private void loadTablePromotion()
{
	try {
		ObservableList<String> listStatusPromotion=FXCollections.observableArrayList();
		ObservableList<String> listSelectPromtion=FXCollections.observableArrayList();
		cbbStatusPromotion.getItems().clear();
		tableViewPromotion.getItems().clear();
		cbbSelectPromotion.getItems().clear();
		for(var promotion:PromotionDto.getAllPromotions())
		{
			createTablePromotion(promotion);
		}
		listSelectPromtion.addAll("Mã khuyến mãi","Tên khuyến mãi","Mức áp dụng","Trạng thái");
		listStatusPromotion.addAll("Còn hạn","Hết hạn");
		cbbStatusPromotion.setItems(listStatusPromotion);
		cbbSelectPromotion.setItems(listSelectPromtion);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
//thêm khuyến mãi vào bảng
private void createTablePromotion(Promotion promotion)
{
	Button button=new Button("Xem");
	button.setPrefWidth(84.8);
	button.setMinWidth(50); 
	button.setMaxWidth(84.8);
	String status="";
    if(promotion.isStatusPromotion())
    {
    	status="Còn hạn";
    }
    else
    {
    	status="Hết hạn";
    }
    button.setOnMouseClicked(event->{
    	resetPromotion();
    	paneAddEndUpdatePromotion.setVisible(true);
    	tfIdPromotion.setText(promotion.getIdPromotion()+"");
    	tfNamePromotion.setText(promotion.getNamePromotion());
    	tfApplicablePromotion.setText(promotion.getApplicableLevel()+"%");
    	if(promotion.isStatusPromotion())
    	{
    		cbbStatusPromotion.getSelectionModel().select(0);
    	}else
    	{
    		cbbStatusPromotion.getSelectionModel().select(1);
    	}
    	dpStartDate.setValue(promotion.getStartDate().toLocalDate());
    	dpEndDate.setValue(promotion.getEndDate().toLocalDate());
    	tfNodePromotion.setText(promotion.getNodePromotion());
    	btExitPromotion.setVisible(true);
    	btExitPromotion.setOnMouseClicked(event1->{
    		paneAddEndUpdatePromotion.setVisible(false);
    	});
    	btOkPromotion.setVisible(true);
    	btOkPromotion.setOnMouseClicked(event1->{
    		addEndUpdatePromotion(event1);
    	});
    });
    String applicable=promotion.getApplicableLevel()+"%";
	PromotionTableRow rowData=new PromotionTableRow(
			promotion.getIdPromotion(),
			promotion.getNamePromotion(),
			applicable,
			promotion.getStartDate(),
			promotion.getEndDate(),
			status,
			button
	);
	promotionList.add(rowData);
	idPromotion.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdPromotion()).asObject());
	namePromotion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNamePromotion()));
	applicableLevel.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApplicableLevel()));
	startDate.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getStartDate()));
	endDate.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEndDate()));
	statusPromotion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatusPromotion()));
	showPromotion.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getShowPromotion()));
	tableViewPromotion.setItems(promotionList);
}
//tìm kiếm khuyến mãi 
@FXML
private void searchPromotion(KeyEvent event) {
    try {
        tableViewPromotion.getItems().clear();
        String text = searchPromotion.getText().toLowerCase();
        int selectedIndex = cbbSelectPromotion.getSelectionModel().getSelectedIndex();
        for (var promotion : PromotionDto.getAllPromotions()) {
            boolean match = false;
            if (selectedIndex == 0) {
                match = text.isEmpty() || (promotion.getIdPromotion() + "").toLowerCase().contains(text);
            } else if (selectedIndex == 1) {
                match = text.isEmpty() || promotion.getNamePromotion().toLowerCase().contains(text);
            } else if (selectedIndex == 2) {
                match = text.isEmpty() || (promotion.getApplicableLevel() + "").toLowerCase().contains(text);
            } else if (selectedIndex == 3) {
                if (text.isEmpty() || ("Còn hạn").toLowerCase().contains(text)) {
                    match = promotion.isStatusPromotion();
                } else if (("Hết hạn").toLowerCase().contains(text)) {
                    match = !promotion.isStatusPromotion();
                }
            }
            if (match) {
                createTablePromotion(promotion);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//click nút add trong promotion
@FXML
private void addPromotion(MouseEvent event) {
	resetPromotion();
	paneAddEndUpdatePromotion.setVisible(true);
	btExitPromotion.setVisible(true);;
	btExitPromotion.setOnMouseClicked(event1->{
		paneAddEndUpdatePromotion.setVisible(false);
	});
	btOkPromotion.setVisible(true);
}
//thêm và cập nhật khuyến mãi 
@FXML
private void addEndUpdatePromotion(MouseEvent event) {
	paneAddEndUpdatePromotion.setVisible(false);
	try {
		boolean check=true;
		if(tfNamePromotion.getText().isEmpty())
		{
			lableNotificationPromotion.setText("Tên khuyến mãi chưa nhập !!!");
			check=false;
		}
		else if(tfApplicablePromotion.getText().isEmpty() || !tfApplicablePromotion.getText().matches("\\d+"))
		{
			lableNotificationPromotion.setText("Mức áp dụng chưa nhập và phải là số !!!");
			check=false;
		}
		else if(cbbStatusPromotion.getValue()==null)
		{
			lableNotificationPromotion.setText("Trạng thái sử dụng chưa chọn !!!");
			check=false;
		}
		else if(dpStartDate.getValue()==null)
		{
			lableNotificationPromotion.setText("Ngày bắt đầu chưa chọn !!!");
			check=false;
		}
		else if(dpEndDate.getValue()==null)
		{
			lableNotificationPromotion.setText("Ngày kết thúc chưa chọn !!!");
			check=false;
		}
		else if(tfNodePromotion.getText()=="")
		{
			lableNotificationPromotion.setText("Ghi chú không được để trống !!!");
			check=false;
		}
		if(!check)
		{
			paneNotificationPromotion.setVisible(true);
			btCancelNotificationPromotion.setVisible(true);
			btCancelNotificationPromotion.setOnMouseClicked(event1->{
				paneNotificationPromotion.setVisible(false);
				paneAddEndUpdatePromotion.setVisible(true);
			});
			btOkNotificationPromotion.setVisible(false);
			return;
		}
		int idPromotion = 0;
        if (!tfIdPromotion.getText().isEmpty()) {
            idPromotion = Integer.parseInt(tfIdPromotion.getText());
        }
		String namePromotion=tfNamePromotion.getText();
		int applicableLevel = 0;
		if (!tfApplicablePromotion.getText().isEmpty() && tfApplicablePromotion.getText().matches("\\d+")) {
		    applicableLevel = Integer.parseInt(tfApplicablePromotion.getText());
		}
		boolean statusPromotion = cbbStatusPromotion.getSelectionModel().getSelectedIndex() == 0;
		LocalDate localDateStart=dpStartDate.getValue();
		Date startDate=java.sql.Date.valueOf(localDateStart);
		LocalDate localDateEnd=dpEndDate.getValue();
		Date endDate=java.sql.Date.valueOf(localDateEnd);
		boolean checkid=false;
		for(var promotion:PromotionDto.getAllPromotions())
		{
			if(promotion.getIdPromotion()==idPromotion)
			{
				checkid=true;
				break;
			}
		}
		String nodePromotion=tfNodePromotion.getText();
		lableNotificationCustomer.setText(
                checkid ? "Bạn muốn cập nhật thông tin khuyến mãi ?" : "Bạn muốn thêm thông tin khuyến mãi ?"
        );
		setupAddEndUpdatePromotion(idPromotion, namePromotion, applicableLevel, startDate, endDate, statusPromotion, nodePromotion);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//hiển thị thông báo thêm và cập nhật thành công
private void setupAddEndUpdatePromotion(int idPromotion, String namePromotion, int applicableLevel,Date startDate,Date endDate,Boolean statusPromotion,String nodePromotion)
{
  paneNotificationPromotion.setVisible(true);
  btCancelNotificationPromotion.setVisible(true);
  btCancelNotificationPromotion.setOnMouseClicked(event->{
	  paneNotificationPromotion.setVisible(false);
  });
  btOkNotificationPromotion.setVisible(true);
  btOkNotificationPromotion.setOnMouseClicked(event->{
	  lableNotificationPromotion.setText(PromotionDto.addEndUpdatePromotion(idPromotion, namePromotion, applicableLevel, startDate, endDate, statusPromotion, nodePromotion));
	  btCancelNotificationPromotion.setVisible(true);
	  btCancelNotificationPromotion.setOnMouseClicked(event1->{
		  paneNotificationPromotion.setVisible(false);
		  loadTablePromotion();
		  resetPromotion();
		  paneAddEndUpdatePromotion.setVisible(true);
	  });
	  btOkNotificationPromotion.setVisible(false);
  });
}
//xóa toàn bộ thông tin trong bảng paneAddEndUpdateCustomer
private void resetPromotion()
{
	tfIdPromotion.setText("");
	tfNamePromotion.setText("");
	tfApplicablePromotion.setText("");
	cbbStatusPromotion.getSelectionModel().clearSelection();
	dpEndDate.setValue(null);
	dpStartDate.setValue(null);
	tfNodePromotion.setText("");
}
//-------------------------------------Sale------------------------------------
//-------------------------------------customer--------------------------------
//load thông tin khách hàng lên table
private void loadTableCustomer()
{
	try {
		ObservableList<String> listSelectCustomer=FXCollections.observableArrayList();
		tableViewCustomer.getItems().clear();
		cbbSelectCustomer.getItems().clear();
		for(var customer: CustomerDto.getAllCustomers())
		{
			createTableCustomer(customer);
		}
		listSelectCustomer.addAll("Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Tên tài khoản", "Mật khẩu","Điểm");
		cbbSelectCustomer.setItems(listSelectCustomer);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//thêm khách hàng vào bảng table
private void createTableCustomer(Customer customer)
{
	Button button =new Button("Xem");
	button.setPrefWidth(86.4);
	button.setMinWidth(50); 
	button.setMaxWidth(86.4);
	button.setOnMouseClicked(event->{
		resetCustomer();
		tfIdCustomer.setText(customer.getIdCustomer()+"");
	    tfNameCustomer.setText(customer.getName());
	    tfPhoneCustomer.setText(customer.getPhone());
	    tfPointCustomer.setText(customer.getPointAccount()+"");
	    tfNameAccount.setText(customer.getNameAccount());
	    tfPasswordAccount.setText(customer.getPasswordAccount());
	    tfHourRemainTime.setText(customer.getRemainTime().getHours()+"");
	    tfSecondRemainTime.setText(customer.getRemainTime().getSeconds()+"");
	    tfMinuteRemainTime.setText(customer.getRemainTime().getMinutes()+"");
		paneAddEndUpdateCustomer.setVisible(true);
		btExitCustomer.setVisible(true);
		btExitCustomer.setOnMouseClicked(event1->{
			paneAddEndUpdateCustomer.setVisible(false);
		});
		btOkCustomer.setVisible(true);
		btOkCustomer.setOnMouseClicked(event1->{
			addEndUpdateCustomer(event1);
			});
	});
	CustomerTableRow rowData=new CustomerTableRow(
		customer.getIdCustomer(),
		customer.getName(),
		customer.getPhone(),
		customer.getNameAccount(),
		customer.getPasswordAccount(),
		customer.getPointAccount(),
		customer.getRemainTime(),
		button
	);
	customerList.add(rowData);
	idCustomer.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getIdCustomer()).asObject());
	nameCustomer.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNameCustomer()));
	phoneCustomer.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhoneCustomer()));
	nameAccount.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNameAccount()));
	passwordAccount.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPasswordAccount()));
	pointAccount.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPointAccount()).asObject());
	remainTime.setCellValueFactory(cellData -> new SimpleObjectProperty<Time>(cellData.getValue().getRemainTime()));
	showCustomer.setCellValueFactory(cellData -> new SimpleObjectProperty<Button>(cellData.getValue().getShowCustomer()));
	tableViewCustomer.setItems(customerList);
}
//tìm kiếm khách hàng
@FXML
private void searchCustomer(KeyEvent event)
{
	try {
		tableViewCustomer.getItems().clear();
		String text=searchCustomer.getText().toLowerCase();
		int selectIndex=cbbSelectCustomer.getSelectionModel().getSelectedIndex();
	
		for(var customer: CustomerDto.getAllCustomers())
		{
			boolean check=false;
			if(selectIndex==0)
			{
				check=text.isEmpty() || (customer.getIdCustomer()+"").toLowerCase().contains(text);
			}
			else if(selectIndex==1)
			{
			     check=text.isEmpty() || customer.getName().toLowerCase().contains(text);
			}
			else if( selectIndex==2)
			{
				check=text.isEmpty() || customer.getPhone().toLowerCase().contains(text);
			}
			else if( selectIndex==3)
			{
				check=text.isEmpty() || customer.getNameAccount().toLowerCase().contains(text);
			}
			else if(selectIndex ==4)
			{
				check=text.isEmpty() || customer.getPasswordAccount().toLowerCase().contains(text);
			}
			else if(selectIndex==5)
			{
				check=text.isEmpty() || (customer.getPointAccount()+"").toLowerCase().contains(text);
			}
		    if(check)
		    {
		    	createTableCustomer(customer);
		    }
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

//thêm và cập nhật khách hàng
@FXML
private void addEndUpdateCustomer(MouseEvent event) {
    paneAddEndUpdateCustomer.setVisible(false);
    try {
        boolean check = true;
        if (tfNameCustomer.getText().isEmpty()) {
            lableNotificationCustomer.setText("Tên khách hàng chưa nhập !!!");
            check = false;
        }
        else if (tfPhoneCustomer.getText().isEmpty() || !tfPhoneCustomer.getText().matches("\\d{10,11}")) {
            lableNotificationCustomer.setText("Số điện thoại phải có 10-11 chữ số !!!");
            check = false;
        }
        else if (tfPointCustomer.getText().isEmpty() || !tfPointCustomer.getText().matches("\\d+")) {
            lableNotificationCustomer.setText("Số điểm chưa nhập và phải là số !!!");
            check = false;
        }
        else if (tfNameAccount.getText().isEmpty()) {
            lableNotificationCustomer.setText("Tên tài khoản không được để trống !!!");
            check = false;
        }
        else if (tfPasswordAccount.getText().isEmpty()) {
            lableNotificationCustomer.setText("Mật khẩu không được để trống !!!");
            check = false;
        }
        if (!check) {
            displayNotification();
            return;
        }
        int idCustomer = 0;
        if (!tfIdCustomer.getText().isEmpty()) {
            idCustomer = Integer.parseInt(tfIdCustomer.getText());
        }
        String nameCustomer = tfNameCustomer.getText();
        int pointCustomer = Integer.parseInt(tfPointCustomer.getText());
        if (pointCustomer < 0) {
            lableNotificationCustomer.setText("Điểm không được nhỏ hơn 0 !!!");
            displayNotification();
            return;
        }
        String phoneCustomer = tfPhoneCustomer.getText();
        String nameAccount = tfNameAccount.getText();
        String passwordAccount = tfPasswordAccount.getText();
        int hourRemainTime = parseTime(tfHourRemainTime.getText(), "Giờ");
        int minuteRemainTime = parseTime(tfMinuteRemainTime.getText(), "Phút", 0, 59);
        int secondRemainTime = parseTime(tfSecondRemainTime.getText(), "Giây", 0, 59);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hourRemainTime);
        calendar.set(Calendar.MINUTE, minuteRemainTime);
        calendar.set(Calendar.SECOND, secondRemainTime);
        Time time = new Time(calendar.getTimeInMillis());

        boolean checkId = false;
        for(var customer: CustomerDto.getAllCustomers())
        {
        	if(customer.getIdCustomer()==idCustomer)
        	{
        		checkId=true;
        		break;
        	}
        }
        lableNotificationCustomer.setText(
                checkId ? "Bạn muốn cập nhật thông tin khách hàng ?" : "Bạn muốn thêm thông tin khách hàng ?"
        );

        setupAddEndUpdateCustomer(idCustomer, nameCustomer, phoneCustomer, nameAccount, passwordAccount, pointCustomer, time);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void displayNotification() {
    paneNotificationCustomer.setVisible(true);
    btCancelNotificationCustomer.setVisible(true);
    btCancelNotificationCustomer.setOnMouseClicked(event -> {
        paneNotificationCustomer.setVisible(false);
        paneAddEndUpdateCustomer.setVisible(true);
    });
    btOkNotificationCustomer.setVisible(false);
}
//kiểm tra thời gian có hợp lệ không
private int parseTime(String input, String fieldName) {
    return parseTime(input, fieldName, 0, Integer.MAX_VALUE);
}
//kiểm tra thời gian có hợp lệ không
private int parseTime(String input, String fieldName, int min, int max) {
    if (!input.isEmpty() && input.matches("\\d+")) {
        int value = Integer.parseInt(input);
        if (value < min || value > max) {
            lableNotificationCustomer.setText(fieldName + " không hợp lệ !!!");
            displayNotification();
            return 0;
        }
        return value;
    }
    return 0;
}
//hiển thị thông báo cập nhật và thêm thành công
private void setupAddEndUpdateCustomer(int idCustomer, String nameCustomer, String phoneCustomer, String nameAccount, String passwordAccount, int pointAccount, Time remainTime)
{
	paneNotificationCustomer.setVisible(true);
	btCancelNotificationCustomer.setVisible(true);
	btCancelNotificationCustomer.setOnMouseClicked(event->{
		paneNotificationCustomer.setVisible(false);
		paneAddEndUpdateCustomer.setVisible(true);
	});
	btOkNotificationCustomer.setVisible(true);
	btOkNotificationCustomer.setOnMouseClicked(event->{
		lableNotificationCustomer.setText(CustomerDto.addEndUpdateCustomer(idCustomer, nameCustomer, phoneCustomer, nameAccount, passwordAccount, pointAccount, remainTime));
		btOkNotificationCustomer.setVisible(false);
		btCancelNotificationCustomer.setVisible(true);
		btCancelNotificationCustomer.setOnMouseClicked(event1->{
			paneNotificationCustomer.setVisible(false);
			loadTableCustomer();
			resetCustomer();
			paneAddEndUpdateCustomer.setVisible(true);
		});
	});
}
//click nút add trong customer
@FXML
private void addCustomer(MouseEvent event)
{
	resetCustomer();
	paneAddEndUpdateCustomer.setVisible(true);
	btExitCustomer.setVisible(true);
	btExitCustomer.setOnMouseClicked(event1->{
		paneAddEndUpdateCustomer.setVisible(false);
	});
	btOkCustomer.setVisible(true);
}
//xóa toàn bộ thông tin của paneAddEndUpdateCustomer
private void resetCustomer()
{
	tfIdCustomer.setText("");
	tfNameCustomer.setText("");
	tfPhoneCustomer.setText("");
	tfNameAccount.setText("");
	tfPasswordAccount.setText("");
	tfPointCustomer.setText("");
	tfMinuteRemainTime.setText("");
	tfSecondRemainTime.setText("");
	tfHourRemainTime.setText("");
}

//-------------------------------------customer--------------------------------
//-------------------------------------customer--------------------------------
}

