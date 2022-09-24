import java.awt.event.*;
import java.awt.*;

public class Ecouteur implements ActionListener{
    Graphique g;
    public Ecouteur(Graphique g){
        this.g = g;
    }

    public void actionPerformed(ActionEvent event) {
        g.change();
    }
}
