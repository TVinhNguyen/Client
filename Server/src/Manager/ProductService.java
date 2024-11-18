package Manager;

import java.util.List;

import Model.Product;

public class ProductService {
	 public String convertProductsToString(List<Product> productss) {
	        StringBuilder jsonBuilder = new StringBuilder();
	        jsonBuilder.append("["); // Mở danh sách JSON

	        for (int i = 0; i < productss.size(); i++) {
	            Product product = productss.get(i);
	            jsonBuilder.append("{")
	                .append("\"idProduct\":").append(product.getIdProduct()).append(",")
	                .append("\"nameProduct\":\"").append(product.getNameProduct()).append("\",")
	                .append("\"priceProduct\":").append(product.getPriceProduct()).append(",")
	                .append("\"quantityProduct\":").append(product.getQuantityProduct()).append(",")
	                .append("\"statusProduct\":").append(product.isStatusProduct()).append(",")
	                .append("\"idCategory\":").append(product.getIdCategory())
	                .append("}");

	            // Thêm dấu phẩy nếu không phải là phần tử cuối
	            if (i < productss.size() - 1) {
	                jsonBuilder.append(",");
	            }
	        }

	        jsonBuilder.append("]"); // Đóng danh sách JSON
	        return jsonBuilder.toString();
	    }

	
}
