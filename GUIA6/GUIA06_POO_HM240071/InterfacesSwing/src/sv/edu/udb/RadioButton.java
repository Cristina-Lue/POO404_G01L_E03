package sv.edu.udb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButton extends JFrame{
    private JLabel lblTitulo;
    private JRadioButton rbtOpcion1;
    private JRadioButton rbtOpcion2;
    private JRadioButton rbtOpcion3;
    private JPanel pnlImg;
    private JLabel lblImg;

    public RadioButton(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlImg);
        this.setMinimumSize(new Dimension(400,400));
        this.setLocationRelativeTo(getParent());
    }

    public RadioButton() {
        rbtOpcion1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("sv/edu/udb/img/img2.png")));
            }
        });
        rbtOpcion2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("src/sv/edu/udb/img/img1.png")));
            }
        });
        rbtOpcion3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sv/edu/udb/img/img3.png")));
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new RadioButton("Seleccione una imagen");
        frame.setVisible(true);
    }


}
