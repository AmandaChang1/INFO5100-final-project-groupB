package ui.Calendar;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateChooser extends JPanel implements ActionListener,
        ChangeListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    int startYear = 1980;

    int lastYear = 2050;

    int width = 270;

    int height = 200;

    Color backGroundColor = Color.gray;


    Color palletTableColor = Color.white;

    Color todayBackColor = Color.orange;

    Color weekFontColor = Color.black;

    Color dateFontColor = Color.black;

    Color weekendFontColor = Color.red;


    Color controlLineColor = Color.decode("#F5DEB3");

    Color controlTextColor = Color.white;
    Color rbFontColor = Color.white;
    Color rbBorderColor = Color.red;
    Color rbButtonColor = Color.pink;
    Color rbBtFontColor = Color.red;
    JDialog dialog;

    JSpinner yearSpin;

    JSpinner monthSpin;

    JButton[][] daysButton = new JButton[6][7];

    JFormattedTextField jFormattedTextField;

    Calendar c = getCalendar();
    
    Calendar cal = Calendar.getInstance();  
    int currentDay=cal.get(Calendar.DAY_OF_MONTH);
    
    public DateChooser(JFormattedTextField jftf) {
        jFormattedTextField = jftf;

        setLayout(new BorderLayout());
        setBorder(new LineBorder(backGroundColor, 2));
        setBackground(backGroundColor);

        JPanel topYearAndMonth = createYearAndMonthPanal();
        add(topYearAndMonth, BorderLayout.NORTH);
        JPanel centerWeekAndDay = createWeekAndDayPanal();
        add(centerWeekAndDay, BorderLayout.CENTER);
    }


    private JPanel createYearAndMonthPanal() {
        int currentYear = c.get(Calendar.YEAR);
        int currentMonth = c.get(Calendar.MONTH) + 1;

        JPanel result = new JPanel();
        result.setLayout(new FlowLayout());
        result.setBackground(controlLineColor);

        yearSpin = new JSpinner(new SpinnerNumberModel(currentYear, startYear,
                lastYear, 1));
        yearSpin.setPreferredSize(new Dimension(60, 20));
        yearSpin.setName("Year");
        yearSpin.setEditor(new JSpinner.NumberEditor(yearSpin, "####"));
        ((JSpinner.DefaultEditor)yearSpin.getEditor()).getTextField().setEditable(false);
        yearSpin.addChangeListener(this);
        result.add(yearSpin);

        JLabel yearLabel = new JLabel("Year");
        yearLabel.setForeground(controlTextColor);
        result.add(yearLabel);

        monthSpin = new JSpinner(new SpinnerNumberModel(currentMonth, 1, 12, 1));
        monthSpin.setPreferredSize(new Dimension(40, 20));
        ((JSpinner.DefaultEditor)monthSpin.getEditor()).getTextField().setEditable(false);
        monthSpin.setName("Month");
        monthSpin.addChangeListener(this);
        result.add(monthSpin);

        JLabel monthLabel = new JLabel("Month");
        monthLabel.setForeground(controlTextColor);
        result.add(monthLabel);

        return result;
    }

    private JPanel createWeekAndDayPanal() {
        String colname[] = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
        JPanel result = new JPanel();
        result.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        result.setLayout(new GridLayout(7, 7));
        result.setBackground(Color.white);
        JLabel cell;

        for (int i = 0; i < 7; i++) {
            cell = new JLabel(colname[i]);
            cell.setHorizontalAlignment(JLabel.CENTER);
            if (i == 0 || i == 6)
                cell.setForeground(weekendFontColor);
            else
                cell.setForeground(weekFontColor);
            result.add(cell);
        }

        int actionCommandId = 0;
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 7; j++) {
                JButton numberButton = new JButton();
                numberButton.setBorder(null);
                numberButton.setHorizontalAlignment(SwingConstants.CENTER);
                numberButton.setActionCommand(String.valueOf(actionCommandId));
                numberButton.addActionListener(this);
                numberButton.setBackground(palletTableColor);
                numberButton.setForeground(dateFontColor);
                if (j == 0 || j == 6)
                    numberButton.setForeground(weekendFontColor);
                else
                    numberButton.setForeground(dateFontColor);
                daysButton[i][j] = numberButton;
                numberButton.addMouseListener(new MouseAdapter() {
                    public void mouseReleased(MouseEvent e) {
                        closeAndSetDate();
                    }
                });
                result.add(numberButton);
                actionCommandId++;
            }

        return result;
    }

    private JDialog createDialog(Frame owner) {
        JDialog result = new JDialog(owner, "CalendarChooser", true);
        result.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        result.getContentPane().add(this, BorderLayout.CENTER);
        result.pack();
        result.setSize(width, height);
        return result;
    }
    public void showDateChooser(Point position) {
        Object tmpobj=SwingUtilities.getWindowAncestor(jFormattedTextField);
        if(tmpobj.getClass().isInstance(new JDialog())||tmpobj.getClass().getSuperclass().isInstance(new JDialog()))
        {
            JDialog ownerdialog = (JDialog) SwingUtilities
            .getWindowAncestor(jFormattedTextField);
            Frame owner = (Frame) SwingUtilities.getWindowAncestor(ownerdialog);
            if (dialog == null || dialog.getOwner() != owner) {
                dialog = createDialog(owner);
            }
            dialog.setLocation(getAppropriateLocation(owner, position));
        }
        else if(tmpobj.getClass().isInstance(new JFrame())||tmpobj.getClass().getSuperclass().isInstance(new JFrame()))
        {            
            JFrame ownerFrame = (JFrame) SwingUtilities
            .getWindowAncestor(jFormattedTextField);
            if (dialog == null || dialog.getOwner() != ownerFrame) {
                dialog = createDialog(ownerFrame);
            }
            dialog.setLocation(getAppropriateLocation(ownerFrame, position));
        }
        
        flushWeekAndDay();
        dialog.setVisible(true);
    }

    Point getAppropriateLocation(Frame owner, Point position) {
        Point result = new Point(position);
        Point p = owner.getLocation();
        int offsetX = (position.x + width) - (p.x + owner.getWidth());
        int offsetY = (position.y + height) - (p.y + owner.getHeight());

        if (offsetX > 0) {
            result.x -= offsetX;
        }

        if (offsetY > 0) {
            result.y -= offsetY;
        }

        return result;

    }

    public void closeAndSetDate() {
        setDate(c.getTime());
        dialog.dispose();
    }

    private Calendar getCalendar() {
        Calendar result = Calendar.getInstance();
        result.setTime(getDate());
        return result;
    }

    private int getSelectedYear() {
        return ((Integer) yearSpin.getValue()).intValue();
    }

    private int getSelectedMonth() {
        return ((Integer) monthSpin.getValue()).intValue();
    }

    private void dayColorUpdate(boolean isOldDay) {
        int day = c.get(Calendar.DAY_OF_MONTH);

        c.set(Calendar.DAY_OF_MONTH, currentDay);

        int actionCommandId = day - 2 + c.get(Calendar.DAY_OF_WEEK);
        int i = actionCommandId / 7;
        int j = actionCommandId % 7;
        if (isOldDay)
            daysButton[i][j].setForeground(dateFontColor);
        else
            daysButton[i][j].setForeground(todayBackColor);
    }

    private void flushWeekAndDay() { 
        c.set(Calendar.DAY_OF_MONTH, currentDay);
        int maxDayNo = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dayNo = 2 - c.get(Calendar.DAY_OF_WEEK);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                String s = "";
                if (dayNo >= 1 && dayNo <= maxDayNo)
                    s = String.valueOf(dayNo);
                daysButton[i][j].setText(s);
                dayNo++;
            }
        }
        dayColorUpdate(false);
    }

    public void stateChanged(ChangeEvent e) {
        JSpinner source = (JSpinner) e.getSource();

        dayColorUpdate(true);
        if (source.getName().equals("Year")) {
            c.set(Calendar.YEAR, getSelectedYear());
        }
        if (source.getName().equals("Month")) {
            c.set(Calendar.MONTH, getSelectedMonth() - 1);
        }
        repaint();
        flushWeekAndDay();
    }

    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source.getText().length() == 0)
            return;
        dayColorUpdate(false);
        source.setForeground(todayBackColor);
        int newDay = Integer.parseInt(source.getText());
        c.set(Calendar.DAY_OF_MONTH, newDay);
        
    }

    public void setDate(Date date) {
        jFormattedTextField.setText(getDefaultDateFormat().format(date));
    }

    public Date getDate() {

        try {
            String dateString = jFormattedTextField.getText();
            System.out.println(dateString+"---------");
            return getDefaultDateFormat().parse(dateString);
        } catch (ParseException e) {
            return getNowDate();
        } catch (Exception ee) {
            return getNowDate();
        }
    }

    private static Date getNowDate() {
        return Calendar.getInstance().getTime();
    }

    private static SimpleDateFormat getDefaultDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }
}
