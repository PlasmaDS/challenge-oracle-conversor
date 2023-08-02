package com.ar.conversor.model;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;

public class Input {

    public static String showInputDialog(JFrame frame, String message, String title, Icon icon) {
        JPanel myPanel = new JPanel();
        JTextField input = new JTextField(10); // Cambiar aquí el número de columnas
        myPanel.setLayout(new GridBagLayout()); // Cambiar el layout a GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.CENTER; // Centrar los elementos horizontalmente
        gbc.fill = GridBagConstraints.HORIZONTAL; // Rellenar horizontalmente

        // Espacio entre elementos
        gbc.insets = new Insets(0, 0, 3, 0);

        // Definimos la posición en X y en Y donde se va a agregar el mensaje
        gbc.gridx = 0;
        gbc.gridy = 0;
        myPanel.add(new JLabel(message), gbc);

        // Definimos la posición en Y donde se va a agregar el input
        gbc.gridy = 1;
        myPanel.add(input, gbc);

        int result = JOptionPane.showOptionDialog(frame, myPanel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        if (result == JOptionPane.OK_OPTION) {
            return input.getText();
        } else if (result == JOptionPane.CANCEL_OPTION) {
            return "-1"; // Si se presiona "Cancelar", retornamos "-1"
        }
        return null; // Si se presiona "Close", retornamos null
    }
}
