/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exameen2;

/**
 *
 * @author andre
 */
import javax.swing.JOptionPane;

public class exameen2 {

    public static void main(String[] args) {

        
        JOptionPane.showMessageDialog(null, "Bienvenido al hotel");
        
        // aqui hice el inicio para elegir la opcion 
        Hotel hotel = new Hotel();
        String opciones = "1. Mostrar Estado Habitaciones\n"
                + "2. Modificar Habitación\n"
                + "3. Mostrar Resumen Hotel\n"
                + "4. Salir";

        int opcion = 0;
        while (opcion != 4) {
     
            String menu = JOptionPane.showInputDialog(opciones);

            if (menu == null) {
                break;
            }

            opcion = Integer.parseInt(menu);

            switch (opcion) {
                case 1:
                    hotel.mostrarEstadoHabitaciones();
                    break;
                case 2:
                    String numeroStr = JOptionPane.showInputDialog("Ingrese el número de habitación:");
                    int numero = Integer.parseInt(numeroStr);
                    hotel.modificarHabitacion(numero);
                    break;
                case 3:
                    hotel.mostrarResumenHotel();
                    break;
                case 4:
                    break;
            }
        }

    }
}

