package com.ar.conversor.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Menu {
    
    public static void main(String[] args) {
        Object[] possibilities = {"Conversor de Monedas", "Conversor de Temperaturas"};
        JFrame frame = new JFrame();
        Icon icon = new ImageIcon("path_to_icon_file.png");
        String amount = "";
        int result = 0;
        boolean passMenu = false;	//pass para el volver al menu inicial o terminar el programa
        String conversion = "";
        
        do {
        	
        	// Ventana para seleccionar que se desea convertir
	        String conversor = (String) JOptionPane.showInputDialog(
	                frame,
	                "Seleccione una opción de conversión",
	                "Menu",
	                JOptionPane.PLAIN_MESSAGE,
	                icon,
	                possibilities,
	                null);
	        
	        // Finalizar el programa cuando se presiona el botón "Cancelar" o se cierra el cuadro de diálogo
            if (conversor == null) {
                passMenu = true;
            } else {
		        
		        // Ingresando al conversor de monedas
		        if ("Conversor de Monedas".equals(conversor)) {
		        	
		        	boolean pass = false;
		        	
		        	do {
			        	while (pass == false) {		// Ciclo para volver a pedir un valor a convertir si el anterior ingresado fuera no numérico
			        		
			        		// Ventana para ingresar la cantidad de dinero a convertir
			        		amount = Input.showInputDialog(frame, "Ingresa la cantidad de dinero que deseas convertir:", "Input", icon);
			                
			                // Try-Catch para atrapar el error si se ingresa un valor no numérico y lanzar mensaje de error
			            	try {
			            		Double.parseDouble(amount);
			            		pass = true;
			            		conversion = "";
			    			} catch (NumberFormatException e) {
			    				// Ventana con el mensaje de error
			    				JOptionPane.showMessageDialog(null, "Valor no válido", "Message", JOptionPane.INFORMATION_MESSAGE);
			    			} catch (NullPointerException e) {
							break;
			    			}
						}
			        	if (conversion == "-1") {
							pass = false;
						} else if (amount != null && amount != "-1") {
			        		conversion = CurrencyConverter.convert(frame, icon, amount);
			        	}
		        	} while (conversion == "-1");
		        	
		        // Ingresando al conversor de temperaturas
		        } else if ("Conversor de Temperaturas".equals(conversor)) {
		        	
		        	amount = Input.showInputDialog(frame, "Ingresa la temperatura que deseas convertir:", "Input", icon);
		            
		        } else {
		            throw new IllegalArgumentException("Unexpected value: " + conversor);
		        }
		        
		        if (amount != "-1" && amount != null) {
			        /* Ventana de dialogo para continuar usando el programa o finalizarlo
		        	 * Se omitio el boton "Cancel" solicitado por el cliente, ya que cumple exactamente la misma funcion que el boton "No"
		        	 * lo cual desmejora la experiencia de usuario. */
			        result = JOptionPane.showConfirmDialog(frame, "¿Desea continuar?", "Select an option", JOptionPane.YES_NO_OPTION);
			        if (result == JOptionPane.YES_OPTION) {
			        	passMenu = false;
			        	amount = "-1";
			        }
				}
		        
            }
            
        } while (passMenu != true && amount == "-1");
        
	        // Ventana con mensaje de finalización del programa
	        JOptionPane.showMessageDialog(null, "Programa terminado", "Message", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
}
