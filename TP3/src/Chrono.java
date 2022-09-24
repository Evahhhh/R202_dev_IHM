import javax.swing.*;
import java.awt.*;


public class Chrono extends JFrame{
    private int sec;
    private int min;
    private JLabel affChrono;
    private JButton start;
    private JButton stop;
    private JButton reset;

    public Chrono(){
        //Affichage
        this.affChrono =  new JLabel();
        this.sec = 0;
        this.min = 0;
        //chrono formaté 00:00
        this.affChrono.setText(String.format("%02d",this.min)+":"+String.format("%02d", this.sec));

        //boutons
        this.start = new JButton();
        this.stop = new JButton();
        this.reset = new JButton();
        this.start.setText("Start");
		this.stop.setText("Stop");
		this.reset.setText("Reset");

        //Barre latérale de navigation
        JPanel interactions = new JPanel();
        interactions.setLayout(new GridLayout(3,1));
		interactions.add(start);
		interactions.add(stop);
		interactions.add(reset);

        //layout final 
        setLayout(new BorderLayout());
        add(this.affChrono,BorderLayout.CENTER);
        add(interactions, BorderLayout.EAST);
        
        //listener
        ChronoListener listener = new ChronoListener(this);
        //bouton start
        start.addActionListener(listener);
        //bouton stop
		stop.addActionListener(listener);
        //bouton restart
		reset.addActionListener(listener);
        
        //fermer la fenetre et arrêter le programme quand on clique sur la croix
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //redimensionner la fenetre par rapport aux informations
        this.pack();
    }    

    public void addTemps(){
        //permet d'avoir des secondes qui ne dépassent pas 59s
		if(this.sec>60){
			this.sec=0;
			this.min+=1;
		}
        //si nous ne sommes pas à la fin de la minute, ajouter simplement 1 seconde
        else this.sec+=1;
        refresh();
	}

    public void refresh(){        
        //remettre à jour le chrono
        this.affChrono.setText(String.format("%02d",this.min)+":"+String.format("%02d",this.sec));
    }

    public void chronoReset(){
        //remettre le chrono à 0
        this.sec = 0;
        this.min = 0;
        refresh();
    }

    //lanceur
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //rendre visible la fenetre
                new Chrono().setVisible(true);
            }
        });
        }
}
