import javax.swing.*;
import java.awt.BorderLayout;

public class CharacterSheetStateBar extends JPanel{

    // Les deux labels de notre barre d'état
    // le label de message et le label de version
    // TODO
    private JLabel statut;
    private JLabel version;

    public CharacterSheetStateBar(String version){
        // TODO
        this.initComponents(version);
    }

    private void initComponents(String version) {
        // TODO
        this.statut = new JLabel();
        this.statut.setText("<statut>");
        this.version = new JLabel();
        this.version.setText(version);

        this.setLayout(new BorderLayout());
        this.add(this.statut,BorderLayout.WEST);
        this.add(this.version,BorderLayout.EAST);
    }

}
