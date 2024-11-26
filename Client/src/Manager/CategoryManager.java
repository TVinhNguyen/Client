package Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Model.Category;

public class CategoryManager {

	    private static CategoryManager instance;
	    private List<Category> newsList;

	    private CategoryManager() {
	        this.newsList = new ArrayList<>();
	    }

	    public static CategoryManager getInstance() {
	        if (instance == null) {
	            instance = new CategoryManager();
	        }
	        return instance;
	    }

	    public void addCategory(Category category) {
	        newsList.add(category);
	    }

	    public boolean removeCategory(int idCategory) {
	        return newsList.removeIf(categorys -> categorys.getIdCategory() == idCategory);
	    }

	    public boolean updateCategory(Category updatedNew) {
	        for (int i = 0; i < newsList.size(); i++) {
	            if (newsList.get(i).getIdCategory() == updatedNew.getIdCategory()) {
	                newsList.set(i, updatedNew);
	                return true;
	            }
	        }
	        return false;
	    }

	    public Optional<Category> getIdCategory(int idCategory) {
	        return newsList.stream()
	                .filter(news -> news.getIdCategory() == idCategory)
	                .findFirst();
	    }

	    public List<Category> getAllCategory() {
	        return new ArrayList<>(newsList);
	    }

	    public List<Category> searchByName(String nameCategory) {
	        List<Category> result = new ArrayList<>();
	        for (Category categorys : newsList) {
	            if (categorys.getNameCategory().toLowerCase().contains(nameCategory.toLowerCase())) {
	                result.add(categorys);
	            }
	        }
	        return result;
	    }
	

}
