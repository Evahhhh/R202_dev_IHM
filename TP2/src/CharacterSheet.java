import javax.swing.*;
import java.awt.BorderLayout;

public class CharacterSheet extends JFrame {

    private JPanel panel;

    private CharacterSheetStats characterSheetStats;
    private CharacterSheetToolBar characterSheetToolBar;
    private CharacterSheetStateBar characterSheetStateBar;

    private CharacterSheetListener characterSheetListener;

    public CharacterSheet() {
        this.initComponents();
    }

    private void initComponents() {
        // TODO
        this.characterSheetListener = new CharacterSheetListener(this);
        this.panel = new JPanel();
        this.panel = (JPanel)this.getContentPane();
        this.panel.setLayout(new BorderLayout());
        this.characterSheetStats = new CharacterSheetStats(this.characterSheetListener);
        this.characterSheetToolBar = new CharacterSheetToolBar(this.characterSheetListener);
        this.characterSheetStateBar = new CharacterSheetStateBar("0.0.1");

        //mettre en ordre chaque partie 
        this.panel.add(this.characterSheetStateBar,BorderLayout.SOUTH);
        this.panel.add(this.characterSheetStats,BorderLayout.CENTER);
        this.panel.add(this.characterSheetToolBar,BorderLayout.WEST);

        this.pack();
    }

    public CharacterSheetStats getCharacterSheetStats(){
        return this.characterSheetStats;
    }

    public CharacterSheetToolBar getCharacterSheetToolBar(){
        return this.characterSheetToolBar;
    }

    public CharacterSheetStateBar getCharacterSheetStateBar(){
        return this.characterSheetStateBar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CharacterSheet().setVisible(true);
            }
        });
        }

}
