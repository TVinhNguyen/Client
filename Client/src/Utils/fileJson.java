package Utils;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Manager.CategoryManager;
import Manager.NewManager;
import Manager.ProductManager;
import Model.Category;
import Model.New;
import Model.Order;
import Model.OrderItem;
import Model.Product;

public class fileJson {
	  public static void  parseJsonToProducts(String json) {
	      

	        json = json.trim();
	        if (json.startsWith("[") && json.endsWith("]")) {
	            json = json.substring(1, json.length() - 1); // Loại bỏ dấu [ ]
	            String[] productJsons = json.split("\\},\\{");

	            for (String productJson : productJsons) {
	                productJson = productJson.replaceAll("^\\{", "").replaceAll("\\}$", ""); // Loại bỏ dấu { }
	                String[] fields = productJson.split(",");

	                int idProduct = 0;
	                String nameProduct = "";
	                double priceProduct = 0.0;
	                byte[] imageProduct = null;
	                int quantityProduct = 0;
	                boolean statusProduct = false;
	                int idCategory = 0;

	                for (String field : fields) {
	                    String[] keyValue = field.split(":", 2);
	                    if (keyValue.length != 2) continue;

	                    String key = keyValue[0].trim().replaceAll("\"", "");
	                    String value = keyValue[1].trim();

	                    switch (key) {
	                        case "idProduct":
	                            idProduct = Integer.parseInt(value);
	                            break;
	                        case "nameProduct":
	                            nameProduct = value.replaceAll("^\"|\"$", "").replace("\\\"", "\"");
	                            break;
	                        case "priceProduct":
	                            priceProduct = Double.parseDouble(value);
	                            break;
	                        case "imageProduct":
	                            if (!value.equals("null")) {
	                                value = value.replaceAll("^\"|\"$", ""); // Loại bỏ dấu "
	                                imageProduct = Base64.getDecoder().decode(value);
	                            }
	                            break;
	                        case "quantityProduct":
	                            quantityProduct = Integer.parseInt(value);
	                            break;
	                        case "statusProduct":
	                            statusProduct = Boolean.parseBoolean(value);
	                            break;
	                        case "idCategory":
	                            idCategory = Integer.parseInt(value);
	                            break;
	                    }
	                }

	                Product product = new Product(idProduct, nameProduct, priceProduct, imageProduct, quantityProduct, statusProduct, idCategory);
	                ProductManager.getInstance().addProduct(product);
	            }
	        }
	    }    
	   
	 public static void parseJsonToNews(String json) {
	    	System.out.println(json);
	        json = json.trim();
	        if (json.startsWith("[") && json.endsWith("]")) {
	            json = json.substring(1, json.length() - 1); // Loại bỏ dấu [ ]
	            String[] newsJsonArray = json.split("(?<=\\}),\\s*(?=\\{)");

	            for (String newsJson : newsJsonArray) {
	                newsJson = newsJson.replaceAll("^\\{", "").replaceAll("\\}$", ""); // Loại bỏ dấu { }
	                String[] fields = newsJson.split(",(?=\\\".*\\\":)");

	                int idNew = 0;
	                String title = "";
	                String content = "";
	                LocalDateTime date = null;
	                byte[] imageNew = null;

	                for (String field : fields) {
	                    String[] keyValue = field.split(":", 2);
	                    if (keyValue.length != 2) continue;

	                    String key = keyValue[0].trim().replaceAll("\"", "");
	                    String value = keyValue[1].trim().replaceAll("^\"|\"$", ""); // Loại bỏ dấu "

	                    switch (key) {
	                        case "idNew":
	                            idNew = Integer.parseInt(value);
	                            break;
	                        case "titleNew":
	                            title = value.replace("\\\"", "\"");
	                            break;
	                        case "contentNew":
	                            content = value.replace("\\\"", "\"");
	                            break;
	                        case "dateNew":
	                            if (!value.equals("null")) {
	                                date = LocalDateTime.parse(value);
	                            }
	                            break;
	                        case "imageNew":
	                            if (!value.equals("null")) {
	                                imageNew = Base64.getDecoder().decode(value);
	                            }
	                            break;
	                    }
	                }

	                New news = new New(idNew, title, content, date, imageNew);
	                NewManager.getInstance().addNew(news);
	            }
	        }
	    }
	 public static void  parseJsonToCategory(String json) {
	      

	        json = json.trim();
	        if (json.startsWith("[") && json.endsWith("]")) {
	            json = json.substring(1, json.length() - 1); // Loại bỏ dấu [ ]
	            String[] categoryJsons = json.split("\\},\\{");

	            for (String categoryJson : categoryJsons) {
	            	categoryJson = categoryJson.replaceAll("^\\{", "").replaceAll("\\}$", ""); // Loại bỏ dấu { }
	                String[] fields = categoryJson.split(",");

	                int idCategory = 0;
	                String nameCategory = "";
	               

	                for (String field : fields) {
	                    String[] keyValue = field.split(":", 2);
	                    if (keyValue.length != 2) continue;

	                    String key = keyValue[0].trim().replaceAll("\"", "");
	                    String value = keyValue[1].trim();

	                    switch (key) {
	                        case "idCategory":
	                        	idCategory = Integer.parseInt(value);
	                            break;
	                        case "nameCategory":
	                        	nameCategory = value.replaceAll("^\"|\"$", "").replace("\\\"", "\"");
	                            break;
	                    
	                    }
	                }

	                Category category = new Category(idCategory,nameCategory);
	                CategoryManager.getInstance().addCategory(category);
	            }
	        }

	    }
	 public static String convertOrderToString(String userName, int idComputer, boolean isPaid, Order order) {
	        StringBuilder jsonBuilder = new StringBuilder();
	        jsonBuilder.append("{"); 

	        jsonBuilder.append("\"userName\":\"").append(userName).append("\",")
	                   .append("\"idComputer\":").append(idComputer).append(",")
	                   .append("\"isPaid\":").append(isPaid).append(",");

	        jsonBuilder.append("\"products\":["); 
	        
	        Set<Map.Entry<Product, OrderItem>> entries = order.items().entrySet();
	        int i = 0;
	        for (Map.Entry<Product, OrderItem> entry : entries) {
	        	Product product = entry.getKey();
	            OrderItem orderItem = entry.getValue();

	            jsonBuilder.append("{")
	                       .append("\"idProduct\":").append(product.getIdProduct()).append(",")
	                       .append("\"quantityProduct\":").append(orderItem.getQuantity())
	                       .append("}");

	            if (++i < entries.size()) {
	                jsonBuilder.append(",");
	            }
	           
	        }

	        jsonBuilder.append("]"); 
	        jsonBuilder.append("}"); 

	        return jsonBuilder.toString();
	    }
	 public static String convertDepositToString(String username,int idComputer,double balance)
	 {
		  StringBuilder jsonBuilder = new StringBuilder();
	        jsonBuilder.append("{"); 

	        jsonBuilder.append("\"userName\":\"").append(username).append("\",")
	                   .append("\"idComputer\":").append(idComputer).append(",")
	                   .append("\"balance\":").append(balance).append("}");
	       return jsonBuilder.toString();
	 }
}
