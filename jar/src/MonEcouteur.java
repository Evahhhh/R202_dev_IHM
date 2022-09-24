import javax.swing.*;
import java.awt.*;

public class MonEcouteur extends JFrame{
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                MonEcouteur g = new MonEcouteur();
                g.setVisible(true);
                g.pack();
            }
        });
    }

    private JButton b1;
    private JButton b2;
    private JLabel label;
    private ButtonGroup group;

    public MonEcouteur(){
        b1 = new JButton();
        b2 = new JButton();
        label = new JLabel();
        group = new ButtonGroup();
        group.add(b1);
        group.add(b2);
        b1.setText("Cliquez ici !");
        b2.setText("Non, plutôt ici !");
        label.setText("Ici s'affichent les messages");

        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(label);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1.addActionListener(new Listener(this));
        b2.addActionListener(new Listener(this));
    }

    public void message(String m){
        label.setText(m);
    }
}
