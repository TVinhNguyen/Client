package Manager;

import java.util.List;

import Model.Category;

public class CategoryManager {
	  public static  String convertCategoryToString(List<Category> categories) {
	        StringBuilder jsonBuilder = new StringBuilder();
	        jsonBuilder.append("["); // Mở danh sách JSON

	        for (int i = 0; i < categories.size(); i++) {
	            Category category = categories.get(i);

	            jsonBuilder.append("{")
	                .append("\"idCategory\":").append(category.getIdCategory()).append(",")
	                .append("\"nameCategory\":\"").append(category.getNameCategory()).append("\"")
	                .append("}");

	            if (i < categories.size() - 1) {
	                jsonBuilder.append(","); // Thêm dấu phẩy nếu không phải phần tử cuối
	            }
	        }

	        jsonBuilder.append("]"); 
	        return jsonBuilder.toString();
	    }
}
