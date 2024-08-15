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

class Hotel {

    public Habitacion[][] habitaciones;

    public Hotel() {
        habitaciones = new Habitacion[5][5];
        inicializarHabitaciones();
    }

    //aqui lo que hice fue asignar los numeros a las habitaciones
    private void inicializarHabitaciones() {
        int numeroBase = 101;
        double[] precios = {30, 40, 50, 50, 50};
        String tipo;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tipo = (j % 2 == 0) ? "Simple" : "Doble";
                habitaciones[i][j] = new Habitacion(numeroBase + j, tipo, precios[i]);
            }
            numeroBase += 100;
        }
    }

    // aqui hago que se muestren
    public void mostrarEstadoHabitaciones() {
        String estado = "Estado de las Habitaciones:\n";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Habitacion hab = habitaciones[i][j];
                estado += "Habitacion " + hab.getNumero()
                        + " - " + hab.getTipo()
                        + " - " + hab.getEstado()
                        + " - Precio: $" + hab.getPrecio() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, estado);
    }
    
    
 // aqui es para modificar habitaciones 
    public void modificarHabitacion(int numero) {
        Habitacion hab = buscarHabitacion(numero);
        if (hab == null) {
            JOptionPane.showMessageDialog(null, "Habitacion no encontrada.");
            return;
        }

        String nuevoEstado = JOptionPane.showInputDialog("Ingrese nuevo estado (Libre/Ocupada/Sucia):");
        String nuevoTipo = JOptionPane.showInputDialog("Ingrese nuevo tipo (Simple/Doble):");
        double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese nuevo precio:"));
        hab.setEstado(nuevoEstado);
        hab.setTipo(nuevoTipo);
        hab.setPrecio(nuevoPrecio);
        JOptionPane.showMessageDialog(null, "Habitacion modificada con exito.");
    }

    public Habitacion buscarHabitacion(int numero) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (habitaciones[i][j].getNumero() == numero) {
                    return habitaciones[i][j];
                }
            }
        }
        return null;
    }
    
    
// esto es para mostrar el resumen de las estadisticas del hotel
    public void  mostrarResumenHotel() {
        int libres = 0, ocupadas = 0, sucias = 0;
        double gananciaActual = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Habitacion hab = habitaciones[i][j];
                switch (hab.getEstado()) {
                    case "Libre":
                        libres++;
                        break;
                    case "Ocupada":
                        ocupadas++;
                        gananciaActual += hab.getPrecio();
                        break;
                    case "Sucia":
                        sucias++;
                        break;
                }
            }
        }

        int total = libres + ocupadas + sucias;
        double porcentajeLibres = (libres * 100.0) / total;
        double porcentajeOcupadas = (ocupadas * 100.0) / total;
        double porcentajeSucias = (sucias * 100.0) / total;

        String resumen = "Resumen del Hotel:\n"
                + "Habitaciones Libres: " + libres + " (" + porcentajeLibres + "%)\n"
                + "Habitaciones Ocupadas: " + ocupadas + " (" + porcentajeOcupadas + "%)\n"
                + "Habitaciones Sucias: " + sucias + " (" + porcentajeSucias + "%)\n"
                + "Ganancia Actual: $" + gananciaActual;

        JOptionPane.showMessageDialog(null, resumen);
    }

}
