import javax.swing.*;
import java.awt.FlowLayout;

/**
* Use Calendar.java to create the calendar view only
* 
*
* @author Eve-Anne Offredi
*/
public class CalendarView extends JFrame{

    private Calendar calendar;
    private JLabel dayName;
    private JLabel dayNumber;
    private JComboBox<String> monthName;
    private JLabel year;

    public CalendarView() {
        this.dayName = new JLabel();
        this.dayNumber = new JLabel();
        this.year = new JLabel();
        this.calendar = new Calendar();
        this.monthName = new JComboBox<String>(calendar.getMonthsNames());
        
        //Layout
        setLayout(new FlowLayout());

        add(this.dayName);
        add(this.dayNumber);
        add(this.monthName);
        add(this.year);

        //fermer la fenetre et arrêter le programme quand on clique sur la croix
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //refresh la date 
        refresh();

        CalendarListener listener = new CalendarListener(calendar, this);
        monthName.addKeyListener(listener);
        monthName.addItemListener(new CalendarListener(calendar,this));
    }
    
    public void refresh(){
        dayName.setText(calendar.getDayName());
        dayNumber.setText(String.valueOf(calendar.getDayNumber()));
        monthName.setSelectedItem(calendar.getMonthName());
        year.setText(String.valueOf(calendar.getYear()));
        //redimensionner la fenetre par rapport aux informations
        this.pack();
    }

    public String getMonth(){
        return monthName.getSelectedItem().toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalendarView().setVisible(true);
            }
        });
        }
}
