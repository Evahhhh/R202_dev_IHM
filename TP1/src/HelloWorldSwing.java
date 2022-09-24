import javax.swing.*;

public class HelloWorldSwing extends JFrame {

    /**
     * Program entry point
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloWorldSwing frame = new HelloWorldSwing(args);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    /** Initialize the HelloWorldSwing frame components. */
    public HelloWorldSwing(String[] args) {

        setTitle("HelloWorldSwing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(String s : args){
            getContentPane().setLayout(new java.awt.FlowLayout());
            //Add the ubiquitous "Hello World" label.
            JLabel label = new JLabel(s);
            add(label);
        }
    }
}
