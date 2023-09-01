package codificada;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfazCodificada extends JFrame implements ActionListener {

    JLabel l1;
    JLabel perrosp;
    JLabel perrosg;
    JLabel perrosm;
    JLabel horas1;
    JLabel icon;
    JTextField perrog;
    JTextField perrom;
    JTextField perrop;
    JTextField horas;
    JButton b1;
    JPanel panel;
    JPanel texto;
    JPanel datos;
    Color fondo;
    Color fondoText;
    Color dog;
    Font fontTitle;

    public static void main(String[] args) {
        // TODO code application logic here
        InterfazCodificada gato = new InterfazCodificada();

    }

    public InterfazCodificada() {

        setBounds(100, 100, 615, 430);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        fondo = new Color(255, 204, 255);
        fondoText = new Color(204, 255, 255);
        dog = new Color(255, 175, 138);
        fontTitle = new Font("Calibri", Font.PLAIN, 14); // Ejemplo de fuente

        getContentPane().setBackground(fondo);
        String texto1 = "<html><b><i>Servicio de paseo de perros, se le cobrara:<br>"
                + " $10.000 por perro grande.<br>"
                + "$5.000 por perro mediano.<br>"
                + "$3.000 por perro pequeño.<br>"
                + "Adicional a eso, si se pasea mas de un perro, se le hara un descuento del 10% al costo total.</i></b> </html>";

        l1 = new JLabel(texto1);

        icon = new JLabel();
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/codificada/Dog1.jpg")));

        perrosg = new JLabel("Digite la cantidad de perros grandes: ");
        perrosm = new JLabel("Digite la cantidad de perros medianos: ");
        perrosp = new JLabel("Digite la cantidad de perros pequeños:");
        horas1 = new JLabel("Digite la cantidad de horas que desea pasear los perros:");

        l1.setOpaque(true);
        l1.setBackground(fondoText);
        l1.setBorder(BorderFactory.createLineBorder(dog, 2));

        new JTextField(10);
        perrog = new JTextField(1);
        perrog.setBorder(BorderFactory.createLineBorder(dog, 2));
        perrom = new JTextField(5);
        perrom.setBorder(BorderFactory.createLineBorder(dog, 2));
        perrop = new JTextField(5);
        perrop.setBorder(BorderFactory.createLineBorder(dog, 2));
        horas = new JTextField(5);
        horas.setBorder(BorderFactory.createLineBorder(dog, 2));
        b1 = new JButton("Calcular costos");
        b1.addActionListener(this);
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.WHITE);

        panel = new JPanel();
        panel.add(icon);
        panel.setBorder(BorderFactory.createLineBorder(dog, 5));

        texto = new JPanel();
        texto.setLayout(new GridLayout(1, 1));
        texto.add(l1);
        l1.setFont(fontTitle);
        /*texto.add(l2);*/

        datos = new JPanel();
        datos.setLayout(new GridLayout(0, 1, 10, 5));
        datos.setBackground(fondo);
        datos.add(perrosg, new Dimension(5, 5));
        datos.add(perrog);
        datos.add(perrosm);
        datos.add(perrom);
        datos.add(perrosp);
        datos.add(perrop);
        datos.add(horas1);
        datos.add(horas);
        datos.add(b1);

        add(texto);
        add(datos, BorderLayout.EAST);
        add(panel, BorderLayout.WEST);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        int costoP = Integer.parseInt(perrog.getText()) * 10000
                + Integer.parseInt(perrop.getText()) * 3000
                + Integer.parseInt(perrom.getText()) * 5000;

        int total = costoP * Integer.parseInt(horas.getText());
        int descuento = total - (total / 10);

        if (accion.equals("Calcular costos")) {
            JOptionPane.showMessageDialog(this, "Usted ha digitado que va a pasear :\n"
                    + Integer.parseInt(perrog.getText()) + " perros grandes.\n"
                    + Integer.parseInt(perrom.getText()) + " perros medianos y \n"
                    + Integer.parseInt(perrop.getText()) + " Perros pequeños.\n"
                    + "la suma de los perros digitados es: " + costoP + "$");

            if (Integer.parseInt(perrog.getText()) + Integer.parseInt(perrom.getText())
                    + Integer.parseInt(perrop.getText()) == 1) {
                JOptionPane.showMessageDialog(this, "Solo ha paseado un perro, no se le hara descuento.\n"
                        + "El costo del paseo del perro es de: " + total + "$");
                perrog.setText("");
                perrom.setText("");
                perrop.setText("");
                horas.setText("");
            }
            if (Integer.parseInt(perrog.getText()) + Integer.parseInt(perrom.getText())
                    + Integer.parseInt(perrop.getText()) > 1) {
                JOptionPane.showMessageDialog(this, "Usted ha paseado mas de un perro, se le hara el descuento del 10%:\n"
                        + "El costo del paseo de los perros es de: " + descuento + "$");

                perrog.setText("");
                perrom.setText("");
                perrop.setText("");
                horas.setText("");
            }
        }
    }

}
