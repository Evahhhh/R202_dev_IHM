import javax.swing.*;
import java.awt.GridLayout;

public class CharacterSheetStats extends JPanel {

    // On a besoin de ce blankLabel pour "passer" des cellules du GridLayout
    private JLabel blankLabel;

    // Les labels
    // TODO
    private JLabel nom;
    private JLabel race;
    private JLabel classe;

    // Les champs de texte
    // TODO
    private JTextField nomEdit;    

    // Les boutons radios
    // TODO
    private JRadioButton homme;
    private JRadioButton femme;
    private ButtonGroup sexe;
    


    // Les combobox
    // TODO
    private JComboBox<Races> raceBox;
    private JComboBox<Classes> classeBox;
    // Model
    private CharacterSheetModel characterSheetModel;

    public CharacterSheetStats(CharacterSheetListener characterSheetListener) {
        // TODO
        initComponents();
    }

    private void initComponents() {
        this.blankLabel = new JLabel("");

        // Ici on ajoute le nom du personnage
        // TIPS : JLabel - JTextField
        // TODO
        this.nom = new JLabel();
        this.nom.setText("Nom");
        this.nomEdit = new JTextField();

        
        
        // Ici on ajoute la sélection de race, on souhaite utilisé l'énumeration Races
        // TIPS : Enum.values() permet de récupérer les valeurs
        // TODO
        this.race = new JLabel();
        this.race.setText("Race");
        this.classe = new JLabel();
        this.classe.setText("Classe");
        this.raceBox = new JComboBox<Races>(Races.values());
        this.classeBox = new JComboBox<Classes>(Classes.values());

        
        // Ici on ajoute les boutons radio H/F (attention, on ne veux pas qu'ils fassent toute la largeur)
        // TIPS : faire un JPanel qui regroupe les deux boutons, ne pas oublier ButtonGroup
        // TODO
        this.homme = new JRadioButton();
        this.homme.setText("H");
        this.femme = new JRadioButton();
        this.femme.setText("F");

        this.sexe = new ButtonGroup();
        this.sexe.add(homme);
        this.sexe.add(femme);
        
        //Layout
        setLayout(new GridLayout(4,2));
        //ajouter les elements
        add(nom);
        add(nomEdit);
        add(race);
        add(raceBox);
        add(classe);
        add(classeBox);
        add(homme);
        add(femme);
    }
}
