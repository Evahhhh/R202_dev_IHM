import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bouton extends JFrame{
    public static void main (String[]args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new bouton().setVisible(true);
            }
        });
    }

    private JButton b;
    private JButton c;


    public bouton(){
        this.b = new JButton();
        this.c = new JButton("HEY");

        setLayout(new FlowLayout());
        add(b);
        add(c);
    }
}
