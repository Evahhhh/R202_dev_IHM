import java.awt.event.*;
import javax.swing.*;

public class Listener implements ActionListener{
    MonEcouteur ec;

    public Listener(MonEcouteur ec){
        this.ec = ec;
    }

    public void actionPerformed(ActionEvent e){
        JButton b = (JButton) e.getSource();
        String l = b.getText();

        if(l.equals("Cliquez ici !")){
            ec.message("Bravo, vous avez gagné !!!");
        }
        if(l.equals("Non, plutôt ici !")){
            ec.message("Perdu boloss ");
        }
    }
}
