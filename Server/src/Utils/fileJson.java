package Utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Dto.productDto;
import Model.Order;
import Model.Product;

public  class fileJson {
	public static String userName;
	public static int idComputer;
	public static boolean isPaid ;
	public static LocalDateTime timePay;
	public static Order order;

	public static void jsonconvertOrder(String jsonString)
	{
        userName = jsonString.split("\"userName\":\"")[1].split("\"")[0];

        idComputer = Integer.parseInt(jsonString.split("\"idComputer\":")[1].split(",")[0]);

        isPaid = Boolean.parseBoolean(jsonString.split("\"isPaid\":")[1].split(",")[0]);

        String productsString = jsonString.split("\"products\":\\[")[1].split("]")[0];
        String[] productEntries = productsString.split("\\},\\{");

        order = new Order();
        for (String productEntry : productEntries) {
            productEntry = productEntry.replace("{", "").replace("}", "");

            String[] productParts = productEntry.split(",");
            int idProduct = Integer.parseInt(productParts[0].split(":")[1]);
            int quantityProduct = Integer.parseInt(productParts[1].split(":")[1]);
            Product pr = productDto.getProductById(idProduct);
            order.addItem(pr, quantityProduct);

        }
        timePay = LocalDateTime.now();
        

    }

  
}
