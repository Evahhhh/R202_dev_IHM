import java.awt.event.*;

public class CalendarListener implements ItemListener, KeyListener{
    private CalendarView view;
    private Calendar cal;

    public CalendarListener(Calendar cal, CalendarView view){
        this.cal = cal;
        this.view = view;
    }

    public void keyPressed(KeyEvent e){
        //Recuperer dans k la touche pressee
        int k = e.getKeyCode();
        //touche gauche : reculer calendrier
        if(k==KeyEvent.VK_LEFT){
            cal.previousDay();
        }
        //touche droite : avancer calendrier
        else if(k==KeyEvent.VK_RIGHT){
            cal.nextDay();
        }
        //refresh
        view.refresh();
        
    }

    public void itemStateChanged(ItemEvent event) {
        if(view.getMonth() != cal.getMonthName()) {
            String[] months = cal.getMonthsNames();
            int i = 0;
            int f = -1;
            for(String month : months){
                if(month == view.getMonth()) f = i;
                i++;
            }
            cal.setMonth(f);
            view.refresh();
        }
    }


    public void keyReleased(KeyEvent e){}

    public void keyTyped(KeyEvent e) {}
}
