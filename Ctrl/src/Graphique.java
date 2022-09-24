import java.awt.*;
import javax.swing.*;
public class Graphique extends JFrame{
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                Graphique g = new Graphique();
                g.pack();
                g.setVisible(true);
            }
        });
    }
    
    private JComboBox<Color> nom;
    private JPanel cPanel;

    public Graphique(){
        nom = new JComboBox<Color>(new Color[]{
            Color.BLACK,Color.BLUE,Color.CYAN,Color.DARK_GRAY,Color.GRAY,Color.LIGHT_GRAY,
            Color.GREEN,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED,Color.WHITE,Color.YELLOW
        });
        this.cPanel = new JPanel();
        cPanel.setPreferredSize(new Dimension(300,300));
        

        setLayout( new GridLayout(2,1));
        add(nom);
        add(cPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nom.addActionListener(new Ecouteur(this));

    }

    public void change(){
        cPanel.setBackground((Color)nom.getSelectedItem());
    }
}