package hundirlaflotadaw;

public class Tablero {

    private Ficha[][] tableroJugador;
    private Ficha[][] tableroIA;
    private Ficha[][] tableroDelJuego;

    public Tablero(Ficha[][] tableroJugador, Ficha[][] tableroIA, Ficha[][] tableroDelJuego) {
        this.tableroJugador = tableroJugador;
        this.tableroIA = tableroIA;
        this.tableroDelJuego = tableroDelJuego;
    }

    public void presentacion() {
        System.out.println("******************************************************************************");
        System.out.println("*                                                                            *");
        System.out.println("*              BIENVENIDOS AL HUNDIR LA FLOTA DE ROBIN Y ALONSO              *");
        System.out.println("*                                                                            *");
        System.out.println("******************************************************************************");
        System.out.println("");
        System.out.println("");
    }

    public void tableroVacio(Ficha ficha) {
        for (int x = 0; x < tableroJugador.length; x++) {
            for (int y = 0; y < tableroJugador[0].length; y++) {
                tableroJugador[x][y] = ficha;
            }
        }

        for (int x = 0; x < tableroIA.length; x++) {
            for (int y = 0; y < tableroIA[0].length; y++) {
                tableroIA[x][y] = ficha;
            }
        }

        for (int x = 0; x < tableroDelJuego.length; x++) {
            for (int y = 0; y < tableroDelJuego[0].length; y++) {
                tableroDelJuego[x][y] = ficha;
            }
        }
    }

    public void mostrarTableroJugador(Ficha[][] tableroJugador) {
        System.out.println("     A   B   C   D   E   F   G   H   I   J");
        System.out.println("");
        for (int x = 0; x < tableroJugador.length; x++) {
            for (int y = 0; y < tableroJugador[0].length; y++) {
                if (y == 0) {
                    System.out.print(x + "    " + tableroJugador[x][y].simbolo);
                } else {
                    System.out.print("   " + tableroJugador[x][y].simbolo);
                }
            }
            System.out.println();
        }
    }

    public void mostrarTableros(Ficha[][] tableroJugador, Ficha[][] tableoDelJugador) {
        System.out.println("             TABLERO DEL JUGADOR                                   TABLERO DE LA MAQUINA");
        System.out.println("    ***************************************               ****************************************");
        System.out.println("     A   B   C   D   E   F   G   H   I   J                 A   B   C   D   E   F   G   H   I   J");
        System.out.println("");
        for (int x = 0; x < tableroJugador.length; x++) {
            for (int y = 0; y < tableroJugador[0].length; y++) {
                if (y == 0) {
                    System.out.print(x + "    " + tableroJugador[x][y].simbolo);
                } else {
                    System.out.print("   " + tableroJugador[x][y].simbolo);
                }
            }
            System.out.print("            ");
            for (int y = 0; y < tableroJugador[0].length; y++) {
                if (y == 0) {
                    System.out.print(x + "    " + tableoDelJugador[x][y].simbolo);
                } else {
                    System.out.print("   " + tableoDelJugador[x][y].simbolo);
                }
            }
            System.out.println();
        }
    }
}
