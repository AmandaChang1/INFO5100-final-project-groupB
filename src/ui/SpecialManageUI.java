package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;
import javax.swing.border.Border;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.table.*;

import dto.*;
import service.SpecialService;
import service.SpecialServiceImpl;
import ui.selfDefinedUI.MyButton;
import ui.selfDefinedUI.MyTextField;

public class SpecialManageUI extends JFrame implements SPEditEventListener  {

    private String dealerName;
    private JPanel topPanel, titlePanel, tablePanel, pagePanel;
    private JTable specialTable;
    private JScrollPane jScrollPane;
    private MyButton dealerNameBtn, addBtn, searchBtn, deleteBtn, editBtn;
    private MyButton toFirstPageBtn, prevPageBtn, nextPageBtn, toLastPageButton;
    private ImageIcon searchIcon, addIcon, deleteIcon, editIcon, toFirstIcon, prevIcon, nextIcon, toLastIcon;
    private Container container;
    private Font titleFont1, titleFont2, tableFont, headTableFont, popUpMenuFont;


    private JLabel pageNumLabel;

    private int currentPageSize;
    private int currentPage = 1;

    private PaginationDataProvider<Special> dataProvider;
    private SpecialsTableModel spTableModel;

    SpecialService specialService = new SpecialServiceImpl();

    SpecialManageUI() {
        //background = new JLabel(new ImageIcon(("resources/icons/background.jpeg")));
        dealerName = "gmps-tincher-london1";
        initData();
        initiateIcons();
        createComponents();
        addComponents();
        paginate();
        display();
    }


    SpecialManageUI(String dealerName) {
        //background = new JLabel(new ImageIcon(("resources/icons/background.jpeg")));
        this.dealerName = dealerName;
        initData();
        initiateIcons();
        createComponents();
        addComponents();
        paginate();
        display();
    }

    public static void main(String[] args) {
        SpecialManageUI specialManageUI = new SpecialManageUI("gmps-tincher-london1");
    }

    public void closeUpdateSpecial(Special sp, boolean isAddSpecial) {
        sp.setDealerName(dealerName);
        if (isAddSpecial)
            specialService.addSpecial(sp);
        else
            specialService.updateSpecial(sp);

//        paginate();
//        this.refreshPageUI();
//
//        specialTable.updateUI();
        dataProvider = new InMemoryPaginationDataProvider<Special>(specialService.getSpecialsByDealer(dealerName,0).getSpecials(), spTableModel);
        paginate();
        refreshPageUI();
        specialTable.updateUI();
    }

    private void deleteSpecial() {
        int index = specialTable.getSelectedRow();
        if(index == -1) {
            JOptionPane.showMessageDialog(null,"Please select a special!");
            return;
        }

        index = (currentPage - 1) * currentPageSize + index;
        specialService.deleteSpecial(specialService.getSpecialsByDealer(dealerName,0).getSpecials().get(index));


        dataProvider = new InMemoryPaginationDataProvider<Special>(specialService.getSpecialsByDealer(dealerName,0).getSpecials(), spTableModel);
        paginate();
        refreshPageUI();
        specialTable.updateUI();
    }

    private void editSpecial() {
        SpecialManageUI frame = this;
        int index = specialTable.getSelectedRow();
        if(index == -1) {
            JOptionPane.showMessageDialog(null,"Please select a special!");
            return;
        }

        index = (currentPage - 1) * currentPageSize + index;
        Special s = specialService.getSpecialsByDealer(dealerName,0).getSpecials().get(index);

        SpecialManagerEdit specialManagerEdit = new SpecialManagerEdit(s,false);
        specialManagerEdit.addListener(frame);
    }

    private void addSepcial() {
        SpecialManageUI frame = this;
        SpecialManagerEdit specialManagerEdit = new SpecialManagerEdit(dealerName, false);
        specialManagerEdit.addListener(frame);
    }

    private void copySpecial() {
        SpecialManageUI frame = this;
        int index = specialTable.getSelectedRow();
        if(index == -1) JOptionPane.showMessageDialog(null,"Please select a special!");

        index = (currentPage - 1) * currentPageSize + index;

//        Special s = specialManager.getSepcial(index);
        Special s = specialService.getSpecialsByDealer(dealerName,0).getSpecials().get(index);
        SpecialManagerEdit specialManagerEdit = new SpecialManagerEdit(s, true);
        specialManagerEdit.addListener(frame);
    }

    private void initData() {
        spTableModel = new SpecialsTableModel();
        dataProvider = new InMemoryPaginationDataProvider<Special>(specialService.getSpecialsByDealer(dealerName,0).getSpecials(), spTableModel);
    }

    private void initiateIcons(){
        searchIcon = new ImageIcon("src/resources/icons/search.png");
        addIcon = new ImageIcon("src/resources/icons/add.png");
        deleteIcon = new ImageIcon("src/resources/icons/delete.png");
        editIcon = new ImageIcon("src/resources/icons/edit.png");
        toFirstIcon = new ImageIcon("src/resources/icons/backward.png");
        prevIcon = new ImageIcon("src/resources/icons/back.png");
        nextIcon = new ImageIcon("src/resources/icons/next.png");
        toLastIcon = new ImageIcon("src/resources/icons/forward.png");
    }

    public void createComponents() {
        titleFont1 = new Font("Didot", Font.BOLD, 25);
        titleFont2 = new Font("Didot", Font.PLAIN, 18);
        popUpMenuFont = new Font("Baskerville", Font.PLAIN, 17);
        tableFont = new Font("Baskerville", Font.PLAIN,18);
        headTableFont = new Font("Baskerville", Font.PLAIN,19);

        JPanel dealerNamePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel dealerNameLabel = new JLabel(dealerName + "\t\t|");
        dealerNameLabel.setFont(titleFont2);
        dealerNameLabel.setForeground(Color.white);
        dealerNameBtn = new MyButton("Sign out");
        dealerNameBtn.setFont(titleFont2);
        dealerNameBtn.setForeground(Color.white);
        dealerNameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Select an Option...", JOptionPane.YES_NO_CANCEL_OPTION);
                if(result == 0) dispose();
            }
        });
        dealerNamePanel.add(dealerNameLabel);
        dealerNamePanel.add(dealerNameBtn);
        dealerNamePanel.setBackground(Color.black);
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(0,2));
        JLabel titleLabel = new JLabel("\tSpecial Managements");
        JPanel titleNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titleNamePanel.add(titleLabel);
        titleNamePanel.setBackground(Color.black);
        titleLabel.setFont(titleFont1);
        titleLabel.setForeground(Color.white);
        topPanel.add(titleNamePanel);
        topPanel.add(dealerNamePanel);
        topPanel.setBackground(Color.black);

        createTitlePanel();
        createTableComponents();
        createPagePanel();

    }

    private void createTitlePanel(){
        titlePanel = new JPanel();
        MyTextField searchTextField = new MyTextField();
        searchTextField.setBackground(getContentPane().getBackground());
        searchTextField.setPreferredSize(new Dimension(200, 25));

        titlePanel.add(searchTextField);
        searchBtn = new MyButton(searchIcon);
        titlePanel.add(searchBtn);

        searchBtn.addActionListener(ae->{
            System.out.println("Search..." + searchTextField.getText());

            if (searchTextField.getText().trim().length() > 0) {
                String[] words = searchTextField.getText().trim().split("\\s+");
                dataProvider.setFilter(Arrays.asList(words));
            } else {
                dataProvider.setFilter(null);
            }

            currentPage = 1;
            paginate();
            refreshPageUI();
        });

        addBtn = new MyButton(addIcon);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSepcial();
            }
        });
        titlePanel.add(addBtn);

        deleteBtn = new MyButton(deleteIcon);
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSpecial();
            }
        });
        titlePanel.add(deleteBtn);

        editBtn = new MyButton(editIcon);
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editSpecial();
            }
        });
        titlePanel.add(editBtn);
    }
    private void createPagePanel() {

        this.currentPageSize = 12 ;
        this.currentPage = 1;

        toFirstPageBtn = new MyButton(toFirstIcon);
        prevPageBtn = new MyButton(prevIcon);
        nextPageBtn = new MyButton(nextIcon);
        toLastPageButton = new MyButton(toLastIcon);
        pagePanel = new JPanel();
        pagePanel.add(toFirstPageBtn);
        pagePanel.add(prevPageBtn);
        JLabel pageLabel1 = new JLabel("Page: ");
        pageNumLabel = new JLabel("");
        pagePanel.add(pageLabel1);
        pagePanel.add(pageNumLabel);
        pagePanel.add(nextPageBtn);
        pagePanel.add(toLastPageButton);

        toFirstPageBtn.addActionListener(ae -> {
            this.currentPage = 1;
            paginate();
            refreshPageUI();
        });

        toLastPageButton.addActionListener(ae -> {
            this.currentPage = getTotalPage();
            paginate();
            refreshPageUI();
        });

        nextPageBtn.addActionListener(ae -> {
            if (currentPage < getTotalPage())
                currentPage += 1;
            paginate();
            refreshPageUI();
        });

        prevPageBtn.addActionListener(ae -> {
            if (currentPage > 0)
                currentPage -= 1;
            paginate();
            refreshPageUI();
        });

        this.refreshPageUI();
    }

    private int getTotalPage() {
        int totalPage = dataProvider.getTotalRowCount()/this.currentPageSize;
        totalPage += dataProvider.getTotalRowCount()%this.currentPageSize == 0 ? 0 : 1;
        return totalPage;
    }

    private void refreshPageUI() {
        pageNumLabel.setText(String.format("%d / %d", currentPage, getTotalPage()));
        specialTable.updateUI();
        setCellRenderer();
    }



    private void createTableComponents() {
        specialTable = new JTable(spTableModel);
        specialTable.setAutoCreateRowSorter(true);
        specialTable.getRowSorter().addRowSorterListener(
                new RowSorterListener() {
                    @Override
                    public void sorterChanged(RowSorterEvent e) {
                        if(e.getType()== RowSorterEvent.Type.SORT_ORDER_CHANGED) {
                            currentPage = 1;
                            paginate();
                            refreshPageUI();
                        }
                    }
                }
        );

        //Add Table Listener
        specialTable.addMouseListener(new MouseAdapter() {
            // Double click : edit
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    editSpecial();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int r = specialTable.rowAtPoint(e.getPoint());
                if (r >= 0 && r < specialTable.getRowCount()) {
                    specialTable.setRowSelectionInterval(r, r);
                } else {
                    specialTable.clearSelection();
                }

                int rowindex = specialTable.getSelectedRow();
                if (rowindex < 0) return;
                Special currentSpecial = specialService.getSpecialsByDealer(dealerName,0).getSpecials().get(rowindex);
                //悬浮显示内容
                //specialTable.setToolTipText(currentSpecial.getCriterionString());
                CriterionAndDescriptionUI criterionAndDescriptionUI = new CriterionAndDescriptionUI(currentSpecial.getCriterionString(), currentSpecial.getDescription());
                criterionAndDescriptionUI.setLocationRelativeTo(specialTable);
            }

        });

        JTableHeader head = this.specialTable.getTableHeader();
        head.setFont(headTableFont);
        specialTable.setShowGrid(false);
        specialTable.setShowHorizontalLines(false);
        specialTable.setFont(tableFont);
        specialTable.setRowHeight(33);

        setCellRenderer();

        final JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.setBorder(null);

        JMenuItem deleteItem = new JMenuItem("Delete");
        deleteItem.setFont(popUpMenuFont);
        deleteItem.setBackground(getContentPane().getBackground());
        deleteItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SpecialManageUI.this.deleteSpecial();
                SpecialManageUI.this.specialTable.updateUI();
            }
        });

        JMenuItem editItem = new JMenuItem("Edit");
        editItem.setFont(popUpMenuFont);
        editItem.setBackground(getContentPane().getBackground());
        editItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                editSpecial();
            }
        });

        JMenuItem copyItem = new JMenuItem("Copy");
        copyItem.setFont(popUpMenuFont);
        copyItem.setBackground(getContentPane().getBackground());
        copyItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                copySpecial();
            }
        });

        popupMenu.add(editItem);
        popupMenu.add(copyItem);
        popupMenu.add(deleteItem);
        popupMenu.setBackground(getContentPane().getBackground());

        specialTable.setComponentPopupMenu(popupMenu);
        specialTable.setBackground(getContentPane().getBackground());

        jScrollPane = new JScrollPane(this.specialTable);
        jScrollPane.setFont(tableFont);
        Border js = BorderFactory.createEmptyBorder();
        jScrollPane.setBorder(js);

        tablePanel = new JPanel();
        tablePanel.add(jScrollPane);
        tablePanel.setBackground(getContentPane().getBackground());
        jScrollPane.setPreferredSize(new Dimension(1000, 420));
        jScrollPane.setBackground(getContentPane().getBackground());
    }

    private void setCellRenderer(){
        DefaultTableCellRenderer ter = new DefaultTableCellRenderer()
        {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                setBackground(getContentPane().getBackground());
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        };
        ter.setHorizontalAlignment(JLabel.LEFT);
        int[] columnWidth = new int[]{10, 10, 70, 70, 180, 150};
        for(int i = 0; i < this.specialTable.getColumnCount(); i++) {
            TableColumn column = this.specialTable.getColumnModel().getColumn(i);
            column.setCellRenderer(ter);
            column.setPreferredWidth(columnWidth[i]);
            if(i == 0) {
                column.setCellRenderer(new TableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        ImageIcon validImageIcon = new ImageIcon("src/resources/icons/valid.png");
                        ImageIcon invalidImageIcon = new ImageIcon("src/resources/icons/invalid.png");
                        JLabel validLabel = new JLabel(validImageIcon);
                        JLabel invalidLabel = new JLabel(invalidImageIcon);
                        JLabel nullLabel = new JLabel();
                        nullLabel.setOpaque(true);
                        validLabel.setOpaque(true);
                        invalidLabel.setOpaque(true);
                        if(specialTable.getValueAt(row,0) == null) return nullLabel;
                        else if((boolean)specialTable.getValueAt(row,0))
                            return invalidLabel;
                        else return validLabel;
                    }
                });
            }
        }
    }

    private void addComponents() {
        container = getContentPane();
        container.add(topPanel);
        container.add(titlePanel);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(tablePanel);
        container.add(pagePanel);
    }

    private void display() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(1100, 800));
        setLocationRelativeTo(null);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        //setUndecorated(true);
    }

    private void paginate() {

        System.out.println("paginate....");
        int startIndex = (currentPage - 1) * currentPageSize;
        int endIndex = startIndex + currentPageSize;
        if (endIndex > dataProvider.getTotalRowCount()) {
            endIndex = dataProvider.getTotalRowCount();
        }

        int sortColumn = -1;
        boolean sortDescending = false;
        RowSorter<? extends TableModel> rowSorter = specialTable.getRowSorter();
        if (rowSorter != null) {
            for (RowSorter.SortKey sortKey : rowSorter.getSortKeys()) {
                if (sortKey.getSortOrder() != SortOrder.UNSORTED) {
                    sortColumn = sortKey.getColumn();
                    sortDescending = sortKey.getSortOrder() == SortOrder.DESCENDING;
                    break;

                }
            }
        }
        List<Special> rows = dataProvider.getRows(startIndex, endIndex, sortColumn, sortDescending);
        spTableModel.setRows(rows);
    }
}

