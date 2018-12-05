package dto;

import java.util.ArrayList;

public class SearchResult<T> {
    private int page;
    private ArrayList<T> resultSet;

    public SearchResult(int page, ArrayList<T> resultSet) {
        this.page = page;
        this.resultSet = resultSet;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<?> getResultSet() {
        return resultSet;
    }

    public void setResultSet(ArrayList<T> resultSet) {
        this.resultSet = resultSet;
    }
}
