package Controller_UI;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;

import Controller.Server;
import Dto.CategoryDto;
import Dto.productDto;
import Model.Category;
import Model.Product;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;

public class controllerAdmin {
@FXML
private Label lableTime;
@FXML
private Label lableNotification;
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
private FlowPane flowPaneProduct;

@FXML
private Pane imageMenuProduct;

@FXML
private Pane paneNotification;

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
private Button btCancelNotification;

@FXML
private Button btOkNotification;

private byte[] imageBytes=null;

private Server server;

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
     
     //thêm pane cho flowpane
     loadProductToFlowPane();
     //thêm phân loại sản phẩm vào combobox menu
     loadComboboxCategory(cbbCategoryMenuProduct1);
     loadComboboxCategory(cbbCategoryMenuProduct);
    
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

}

