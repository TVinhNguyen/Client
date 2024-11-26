package Manager;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Model.Product;

public class ProductManager {
    private static ProductManager instance;
    private List<Product> products;

    private ProductManager() {
        this.products = new ArrayList<>();
    }

    public static ProductManager getInstance() {
        if (instance == null) {
            instance = new ProductManager();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(int idProduct) {
        return products.removeIf(product -> product.getIdProduct() == idProduct);
    }

    public boolean updateProduct(Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getIdProduct() == updatedProduct.getIdProduct()) {
                products.set(i, updatedProduct);
                return true;
            }
        }
        return false;
    }

    public Optional<Product> getProductById(int idProduct) {
        return products.stream()
                .filter(product -> product.getIdProduct() == idProduct)
                .findFirst();
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public List<Product> searchProductByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getNameProduct().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }
    public List<Product> searchByCategory(int idCategory) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getIdCategory()==idCategory){
                result.add(product);
            }
        }
        return result;
    }
    
}
