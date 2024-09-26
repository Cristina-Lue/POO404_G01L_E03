import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JFrame {

    public Main(){
        JLabel lblholga = new JLabel("hola");
        add(lblholga);
        this.setSize(200,200);
        this.setTitle("JFrame");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}