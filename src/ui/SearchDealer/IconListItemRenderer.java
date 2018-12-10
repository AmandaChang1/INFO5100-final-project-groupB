package ui.SearchDealer;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class IconListItemRenderer extends JLabel implements ListCellRenderer {
    private Border border;
    private Border selectedBorder = BorderFactory.createLineBorder(Color.blue, 1);
    private Border emptyBorder = BorderFactory.createEmptyBorder(1, 1, 1, 1);

    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        IconListItem item = (IconListItem) value;
        this.setIcon(item.getIcon());
        this.setText(item.getText());

        if (isSelected) setBorder(selectedBorder);
        else setBorder(emptyBorder);
        return this;

    }
}

