package hundirlaflotadaw;

import java.util.Scanner;

public class HundirLaFlotaDAW {

    public static Scanner datos = new Scanner(System.in);

    public static void main(String[] args) {
        int contadorJugador = 0;
        int contadorIA = 0;
        int contadorAyudaJugador = 0;
        int contadorAyudaIA = 0;
        Ficha[][] tableroJugador = new Ficha[10][10];
        Ficha[][] tableroIA = new Ficha[10][10];
        Ficha[][] tableroDelJuego = new Ficha[10][10];
        Ficha agua = new Ficha(0, "~", 0, "Agua");
        Tablero t1 = new Tablero(tableroJugador, tableroIA, tableroDelJuego);

        Ficha velero1 = new Ficha(1, "V", 1, "Velero 1");
        Ficha velero2 = new Ficha(1, "V", 1, "Velero 2");
        Ficha velero3 = new Ficha(1, "V", 1, "Velero 3");
        Ficha velero4 = new Ficha(1, "V", 1, "Velero 4");
        Ficha fragata1 = new Ficha(2, "F", 2, "Fragata 1");
        Ficha fragata2 = new Ficha(2, "F", 2, "Fragata 2");
        Ficha fragata3 = new Ficha(2, "F", 2, "Fragata 3");
        Ficha buque1 = new Ficha(3, "B", 3, "Buque 1");
        Ficha buque2 = new Ficha(3, "B", 3, "Buque 2");
        Ficha portaviones = new Ficha(4, "P", 4, "Portaviones");

        Ficha[] misFichas = new Ficha[10];

        misFichas[0] = velero1;
        misFichas[1] = velero2;
        misFichas[2] = velero3;
        misFichas[3] = velero4;
        misFichas[4] = fragata1;
        misFichas[5] = fragata2;
        misFichas[6] = fragata3;
        misFichas[7] = buque1;
        misFichas[8] = buque2;
        misFichas[9] = portaviones;

        String ayuda = "";

        do {
            t1.presentacion();
            t1.tableroVacio(agua);

            JugadorIA maquina = new JugadorIA("Inteligencia Artificial");
            maquina.insertarBarcos(tableroIA);

            System.out.println("Introduzca tu nombre:");
            String nombre = datos.nextLine();
            Jugador1 persona = new Jugador1(nombre);

            t1.mostrarTableros(tableroJugador, tableroDelJuego);

            for (int x = 0; x < misFichas.length; x++) {
                System.out.println("Introduce la posicion del " + misFichas[x].getNombre() + ":");
                persona.insertarBarco(misFichas[x], tableroJugador);
                t1.mostrarTableros(tableroJugador, tableroDelJuego);
            }
            
            contadorJugador = 0;
            contadorIA = 0;
            contadorAyudaJugador = 0;
            contadorAyudaIA = 0;
            
            while (contadorJugador != 10 && contadorIA != 10) {
                contadorJugador = contadorAyudaJugador + persona.dispararCoordenada(tableroIA, tableroDelJuego);
                contadorAyudaJugador = contadorJugador;
                while (persona.repetirDisparo()) {
                    t1.mostrarTableros(tableroJugador, tableroDelJuego);
                    contadorJugador = contadorAyudaJugador + persona.dispararCoordenada(tableroIA, tableroDelJuego);
                    contadorAyudaJugador = contadorJugador;
                }

                contadorIA = contadorAyudaIA + maquina.dispararCoordenada(tableroJugador);
                contadorAyudaIA = contadorIA;

                while (maquina.repetirDisparo()) {
                    t1.mostrarTableros(tableroJugador, tableroDelJuego);
                    contadorIA = contadorAyudaIA + maquina.dispararCoordenada(tableroJugador);
                    contadorAyudaIA = contadorIA;
                }
                
                t1.mostrarTableros(tableroJugador, tableroDelJuego);
            }

            if (contadorJugador == 10) {
                System.out.println("Ha ganado " + persona.getNombre());
            } else if (contadorIA == 10) {
                System.out.println("Ha ganado " + maquina.getNombre());
            } else if (contadorJugador == 10 && contadorIA == 10) {
                System.out.println("EMPATE");
            }

            System.out.println("¿Deseas juagar otra partida? (si/no)");
            ayuda = datos.nextLine();

            while (!ayuda.equalsIgnoreCase("si") && !ayuda.equalsIgnoreCase("no")) {
                System.out.println("Error, ¿Deseas juagar otra partida? (si/no)");
                ayuda = datos.nextLine();
            }

        } while (!ayuda.equalsIgnoreCase("no"));
    }
}
