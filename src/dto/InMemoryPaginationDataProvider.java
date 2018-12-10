package dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InMemoryPaginationDataProvider<T> implements PaginationDataProvider<T> {
    private SortInfo currentSortInfo;
    private InMemoryComparator<T> comparator;
    private final List<T> rows;

    private List<T> filterRows;
    private List<String> filterWords;

    public InMemoryPaginationDataProvider(List<T> rows, SpecialsTableModel tableModel) {
        this.rows = rows;
        this.filterRows = new ArrayList<T>();
        this.filterWords = new ArrayList<>();
        currentSortInfo = new SortInfo();
        comparator = new InMemoryComparator(currentSortInfo, tableModel);
    }

    @Override
    public int getTotalRowCount() {
        return this.getCurrentRows().size();
    }

    @Override
    public List<T> getRows(int startIndex, int endIndex, int sortColumnIndex, boolean sortDescending) {
        setFilter(filterWords);
        sort(sortColumnIndex, sortDescending);
        return getCurrentRows().subList(startIndex, endIndex);
    }

    @Override
    public void setFilter(List<String> filterWords) {

        this.filterWords = filterWords;
        this.filterRows.clear();

        if (this.filterWords == null || this.filterWords.size() == 0)
            return;

        for (T sp: rows) {
            for (String searchStr:filterWords) {
                if (searchStr != null && searchStr.length() > 0) {
                    if (sp.toString().indexOf(searchStr) != -1) {
                        this.filterRows.add(sp);
                        break;
                    }
                }
            }
        }
    }

    private List<T> getCurrentRows() {
        if (filterWords == null || filterWords.size() == 0) {
            return rows;
        } else {
            return filterRows;
        }
    }

    private void sort(int sortColumnIndex, boolean sortDescending) {
        if (!currentSortInfo.equals(sortColumnIndex, sortDescending)) {
            currentSortInfo.sortIndex = sortColumnIndex;
            currentSortInfo.sortDescending = sortDescending;
            Collections.sort(getCurrentRows(), comparator);
        }
    }

    private static class SortInfo {
        private int sortIndex = -1;
        private boolean sortDescending;

        boolean equals(int sortIndex, boolean sortDescending) {
            return sortIndex == this.sortIndex &&
                    sortDescending == this.sortDescending;
        }
    }

    private static class InMemoryComparator<T> implements Comparator<T> {
        private final SortInfo sortInfo;
        private SpecialsTableModel objectTableModel;

        private InMemoryComparator(SortInfo sortInfo, SpecialsTableModel objectTableModel) {
            this.sortInfo = sortInfo;
            this.objectTableModel = objectTableModel;
        }

        @Override
        public int compare(T e1, T e2) {
            Object v1 = objectTableModel.getValueAt((Special)e1, sortInfo.sortIndex);
            Object v2 = objectTableModel.getValueAt((Special)e2, sortInfo.sortIndex);
            if (v1 instanceof Comparable && v2 instanceof Comparable) {
                return sortInfo.sortDescending ? ((Comparable) v2).compareTo(v1) :
                        ((Comparable) v1).compareTo(v2);
            }
            return 0;
        }
    }
};