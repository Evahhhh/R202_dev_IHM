import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CelsiusConverterGUI extends JFrame {

    private JLabel celsiusLabel;
    private JButton convertButtonCelsius;
    private JButton convertButtonFarhenheit;
    private JLabel fahrenheitLabel;
    private JTextField tempTextField1;
    private JTextField tempTextField2;

    /**
     * Program entry point
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CelsiusConverterGUI frame = new CelsiusConverterGUI();
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    /** Initialize the CelsiusConverterGUI frame components. */
    public CelsiusConverterGUI() {

        setTitle("Celsius Converter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        tempTextField1 = new JTextField();
        tempTextField2 = new JTextField();
        celsiusLabel = new JLabel();
        convertButtonCelsius = new JButton();
        convertButtonFarhenheit = new JButton();
        fahrenheitLabel = new JLabel();
        celsiusLabel.setText("Celsius");
        convertButtonCelsius.setText("Convert Farhenheit");
        convertButtonFarhenheit.setText("Convert Celsius");
        convertButtonCelsius.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt1) {
                convertButtonActionPerformedToFarhenheit(evt1);
            }
        });
        convertButtonFarhenheit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt2) {
                convertButtonActionPerformedToCelsius(evt2);
            }
        });
        celsiusLabel.setText("Celsius");
        fahrenheitLabel.setText("Farhenheit");

        getContentPane().setLayout(new GridLayout(3,2));
        add(tempTextField1);
        add(celsiusLabel);
        add(tempTextField2);
        add(fahrenheitLabel);
        add(convertButtonCelsius);
        add(convertButtonFarhenheit);
    }

    /** Parse degrees Celsius as a double and convert to Fahrenheit */
    private void convertButtonActionPerformedToFarhenheit(ActionEvent evt) {
        int tempFahr = (int)((Double.parseDouble(tempTextField1.getText())) * 1.8 + 32);
        tempTextField2.setText(String.valueOf(tempFahr));
    }

    /** Parse degrees Farhenheit as a double and convert to Celsius */
    private void convertButtonActionPerformedToCelsius(ActionEvent evt) {
        int tempCels = (int)(((Double.parseDouble(tempTextField2.getText())) -32) / 1.8);
        tempTextField1.setText(String.valueOf(tempCels));
    }
}
