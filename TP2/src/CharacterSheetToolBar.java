import javax.swing.*;
import java.awt.GridLayout;

public class CharacterSheetToolBar extends JToolBar{

    // Les boutons que l'on veut utiliser :
    // nouveau, charger, enregistrer, enregistrer sous
    // TODO
    private JButton nouveau;
    private JButton charger;
    private JButton enregistrer;
    private JButton enregistrerSous;

    public CharacterSheetToolBar(CharacterSheetListener characterSheetListener){
        // TODO
        initComponents();
    }
    
    private void initComponents() {
        // TODO
        this.nouveau = new JButton();
        this.charger = new JButton();
        this.enregistrer = new JButton();
        this.enregistrerSous = new JButton();
        
        this. nouveau.setText("Nouveau");
        this.charger.setText("Charger");
        this.enregistrer.setText("Enregistrer");
        this. enregistrerSous.setText("Enregistrer sous...");
        
        this.setLayout(new GridLayout(4,1));
        this.add(this.nouveau);
        this.add(this.charger);
        this.add(this.enregistrer);
        this.add(this.enregistrerSous);
    }
}
