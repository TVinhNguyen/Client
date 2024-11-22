package Manager;

import java.util.Base64;
import java.util.List;

import Model.New;
import Model.Product;

public class NewsManager {
	
	    public String convertNewsToString(List<New> News) {
		    StringBuilder jsonBuilder = new StringBuilder();
		    jsonBuilder.append("["); // Mở danh sách JSON

		    for (int i = 0; i < News.size(); i++) {
		        New neww = News.get(i);
		        String encodedImage = neww.getImageNew() != null 
		            ? Base64.getEncoder().encodeToString(neww.getImageNew())
		            : null;

		        jsonBuilder.append("{")
		            .append("\"idNew\":").append(neww.getIdNew()).append(",")
		            .append("\"titleNew\":\"").append(neww.getTitleNew()).append("\",")
		            .append("\"contentNew\":").append(neww.getContentNew()).append(",")
		            .append("\"dateNew\":").append(neww.getDateNew()).append(",")
		            .append("\"imageNew\":\"").append(encodedImage).append("\",")
		            .append("}");

		        if (i < News.size() - 1) {
		            jsonBuilder.append(",");
		        }
		    }

		    jsonBuilder.append("]"); 
		    return jsonBuilder.toString();
		}
}
