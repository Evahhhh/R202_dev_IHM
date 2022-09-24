import java.awt.event.*;
import javax.swing.*;

public class ChronoListener implements ActionListener{
    Chrono view;
    Timer chrono;

    public ChronoListener(Chrono view){
        //obligation d'avoir un view
        if(view == null) System.out.println("Error ChronoListener : constructor : view null");
        else {
            //initialisations, timer avec un delai de 1000ms soit 1s
            this.chrono = new Timer(1000,this);
            this.view = view;   

            //le chrono se répètera
            this.chrono.setRepeats(true);
            //lancer le chrono
            this.chrono.start();
        }
    }

    public void actionPerformed(ActionEvent e){
        Object o = e.getSource();

        //si l'action vient d'un JButton
		if(o instanceof JButton){
            //trouver de quel bouton il s'agit
			JButton b = (JButton) e.getSource();
            String t = b.getText();

            //si son texte correspond au Start = si c'est le bouton Start, on lance le chrono
            if(t.equals("Start")) chrono.start();
            //si son texte correspond au Stop = si c'est le bouton Stop, on arrete le chrono
            if(t.equals("Stop")) chrono.stop();
            //si son texte correspond au Reset = si c'est le bouton Reset, on relance le chrono grace a la methode dans view
            if(t.equals("Reset")) view.chronoReset();

            //si nous n'avons appuye sur aucun bouton, on ajoute du temps soit 1seconde
		}else view.addTemps();
    }
}
