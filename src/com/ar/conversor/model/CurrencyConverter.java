package com.ar.conversor.model;

import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;
import java.text.DecimalFormat;

public class CurrencyConverter {

    public static String convert(JFrame frame, Icon icon, String amount) {

        // Creacion del objeto que contiene las tipos de cambio disponibles para seleccionar
        Object[] options = {"De Peso a Dolar", "De Peso a Euro", "De Peso a Libras", "De Peso a Yen", "De Peso a Won Coreano", "Dolar a pesos", "Euro a pesos", "Libras a pesos", "Yen a pesos", "Won Coreano a pesos"};

        JComboBox<Object> comboBox = new JComboBox<>(options);

        // Crear un panel para albergar el mensaje y el cuadro de selección
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 3, 0);

        // Agregar el mensaje
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel messageLabel = new JLabel("Elije la moneda a la que deseas convertir tu dinero");
        panel.add(messageLabel, gbc);

        // Obtener el tamaño preferido del mensaje
        Dimension messageSize = messageLabel.getPreferredSize();

        // Agregar el cuadro de selección
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        comboBox.setPreferredSize(new Dimension(messageSize.width, comboBox.getPreferredSize().height));
        panel.add(comboBox, gbc);

        // Mostrar el cuadro de diálogo personalizado
        int result = JOptionPane.showConfirmDialog(frame, panel, "Monedas", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, icon);

        if (result == JOptionPane.CANCEL_OPTION) {
        	return "-1";
        }
        // Proceso de conversión si se selecciona "OK"
        if (result == JOptionPane.OK_OPTION) {
            int selectedOption = comboBox.getSelectedIndex();
            if (selectedOption >= 0 && selectedOption < options.length) {
                String currency = "Pesos";
                double exchangedCurrency = Double.parseDouble(amount);

                switch (selectedOption) {
                    case 0: {
                        currency = "Dolares";
                        exchangedCurrency = exchangedCurrency / 276.21;
                        break;
                    }
                    case 1: {
                        currency = "Euros";
                        exchangedCurrency = exchangedCurrency / 303.45;
                        break;
                    }
                    case 2: {
                        currency = "Libras";
                        exchangedCurrency = exchangedCurrency / 352.74;
                        break;
                    }
                    case 3: {
                        currency = "Yen";
                        exchangedCurrency = exchangedCurrency / 1.94;
                        break;
                    }
                    case 4: {
                        currency = "Won Coreano";
                        exchangedCurrency = exchangedCurrency / 0.21;
                        break;
                    }
                    case 5: {
                    	// Lógica para la conversión de Dolar a Peso
                        exchangedCurrency = exchangedCurrency / 0.0036;
                        break;
                    }
                    case 6: {
                    	// Lógica para la conversión de Euro a Peso
                        exchangedCurrency = exchangedCurrency / 0.0033;
                        break;
                    }
                    case 7: {
                        // Lógica para la conversión de Libras a Peso
                        exchangedCurrency = exchangedCurrency / 0.52;
                        break;
                    }
                    case 8: {
                        // Lógica para la conversión de Yen a Peso
                        exchangedCurrency = exchangedCurrency / 1.94;
                        break;
                    }
                    case 9: {
                        // Lógica para la conversión de Won Coreano a Peso
                        exchangedCurrency = exchangedCurrency / 4.70;
                        break;
                    }
                }
                
                // Formateamos el resultado para que muestre solo dos decimales
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                String formattedCurrency = decimalFormat.format(exchangedCurrency);

                // Mostrar el resultado
                JOptionPane.showMessageDialog(null, "Tienes " + "$" + formattedCurrency + " " + currency, "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        }
		return amount;
    }
}

