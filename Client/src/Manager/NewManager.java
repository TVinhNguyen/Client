package Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Model.New;

public class NewManager {
    private static NewManager instance;
    private List<New> newsList;

    private NewManager() {
        this.newsList = new ArrayList<>();
    }

    public static NewManager getInstance() {
        if (instance == null) {
            instance = new NewManager();
        }
        return instance;
    }

    public void addNew(New news) {
        newsList.add(news);
    }

    public boolean removeNew(int idNew) {
        return newsList.removeIf(news -> news.getIdNew() == idNew);
    }

    public boolean updateNew(New updatedNew) {
        for (int i = 0; i < newsList.size(); i++) {
            if (newsList.get(i).getIdNew() == updatedNew.getIdNew()) {
                newsList.set(i, updatedNew);
                return true;
            }
        }
        return false;
    }

    public Optional<New> getNewById(int idNew) {
        return newsList.stream()
                .filter(news -> news.getIdNew() == idNew)
                .findFirst();
    }

    public List<New> getAllNews() {
        return new ArrayList<>(newsList);
    }

    public List<New> searchNewsByTitle(String title) {
        List<New> result = new ArrayList<>();
        for (New news : newsList) {
            if (news.getTitleNew().toLowerCase().contains(title.toLowerCase())) {
                result.add(news);
            }
        }
        return result;
    }
}
