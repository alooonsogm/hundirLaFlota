package hundirlaflotadaw;

import static hundirlaflotadaw.HundirLaFlotaDAW.datos;

public class Jugador1 extends Jugadores {

    private boolean repetirDisparo = false;

    public Jugador1(String nombre) {
        super(nombre);
    }

    public void insertarBarco(Ficha barco, Ficha[][] tablero) {
        boolean repetir = false;
        do {
            try {
                String cadena = datos.nextLine();

                while (!validarCoordenada(cadena)) {
                    System.out.println("ERROR, introduce la coordenada correcta:");
                    cadena = datos.nextLine();
                }

                char[] cadenaArray = cadena.toCharArray();
                int fila = traducirFilas(cadenaArray);
                int columna = traducirColumnas(cadenaArray);

                System.out.println("¿En Vertical (V) u Horizontal (H)?");
                String orientacion = datos.nextLine();

                while (!orientacion.equalsIgnoreCase("V") && !orientacion.equalsIgnoreCase("H")) {
                    System.out.println("Error, debes introducir V o H");
                    orientacion = datos.nextLine();
                }

                while (!EncimaDeFicha(tablero, fila, columna, cadenaArray, barco, orientacion)) {
                    System.out.println("ERROR, introduce la coordenada correcta:");
                    cadena = datos.nextLine();
                    cadenaArray = cadena.toCharArray();
                    fila = traducirFilas(cadenaArray);
                    columna = traducirColumnas(cadenaArray);

                    System.out.println("¿En Vertical (V) u Horizontal (H)?");
                    orientacion = datos.nextLine();

                    while (!orientacion.equalsIgnoreCase("V") && !orientacion.equalsIgnoreCase("H")) {
                        System.out.println("Error, debes introducir V o H");
                        orientacion = datos.nextLine();
                    }
                }

                if ((orientacion.equalsIgnoreCase("H") && (barco.getTamaño() + columna) > tablero.length)
                        || (orientacion.equalsIgnoreCase("V") && (barco.getTamaño() + fila) > tablero.length)) {
                    throw new ArrayIndexOutOfBoundsException("Fuera de los límites del tablero, Introduce de nuevo la coordenada");
                }

                repetir = true;

                if (repetir) {
                    if (orientacion.equalsIgnoreCase("V")) {
                        for (int x = 0; x < barco.getTamaño(); x++) {
                            tablero[fila][columna] = barco;
                            fila++;
                        }
                    } else if (orientacion.equalsIgnoreCase("H")) {
                        for (int x = 0; x < barco.getTamaño(); x++) {
                            tablero[fila][columna] = barco;
                            columna++;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Fuera de los límites del tablero, Introduce de nuevo la coordenada");
                repetir = false;
            }

        } while (!repetir);
    }

    public boolean validarCoordenada(String cadena) {
        if (!cadena.equalsIgnoreCase("0A") && !cadena.equalsIgnoreCase("1A") && !cadena.equalsIgnoreCase("2A") && !cadena.equalsIgnoreCase("3A") && !cadena.equalsIgnoreCase("4A") && !cadena.equalsIgnoreCase("5A") && !cadena.equalsIgnoreCase("6A") && !cadena.equalsIgnoreCase("7A") && !cadena.equalsIgnoreCase("8A") && !cadena.equalsIgnoreCase("9A")
                && !cadena.equalsIgnoreCase("0B") && !cadena.equalsIgnoreCase("1B") && !cadena.equalsIgnoreCase("2B") && !cadena.equalsIgnoreCase("3B") && !cadena.equalsIgnoreCase("4B") && !cadena.equalsIgnoreCase("5B") && !cadena.equalsIgnoreCase("6B") && !cadena.equalsIgnoreCase("7B") && !cadena.equalsIgnoreCase("8B") && !cadena.equalsIgnoreCase("9B")
                && !cadena.equalsIgnoreCase("0C") && !cadena.equalsIgnoreCase("1C") && !cadena.equalsIgnoreCase("2C") && !cadena.equalsIgnoreCase("3C") && !cadena.equalsIgnoreCase("4C") && !cadena.equalsIgnoreCase("5C") && !cadena.equalsIgnoreCase("6C") && !cadena.equalsIgnoreCase("7C") && !cadena.equalsIgnoreCase("8C") && !cadena.equalsIgnoreCase("9C")
                && !cadena.equalsIgnoreCase("0D") && !cadena.equalsIgnoreCase("1D") && !cadena.equalsIgnoreCase("2D") && !cadena.equalsIgnoreCase("3D") && !cadena.equalsIgnoreCase("4D") && !cadena.equalsIgnoreCase("5D") && !cadena.equalsIgnoreCase("6D") && !cadena.equalsIgnoreCase("7D") && !cadena.equalsIgnoreCase("8D") && !cadena.equalsIgnoreCase("9D")
                && !cadena.equalsIgnoreCase("0E") && !cadena.equalsIgnoreCase("1E") && !cadena.equalsIgnoreCase("2E") && !cadena.equalsIgnoreCase("3E") && !cadena.equalsIgnoreCase("4E") && !cadena.equalsIgnoreCase("5E") && !cadena.equalsIgnoreCase("6E") && !cadena.equalsIgnoreCase("7E") && !cadena.equalsIgnoreCase("8E") && !cadena.equalsIgnoreCase("9E")
                && !cadena.equalsIgnoreCase("0F") && !cadena.equalsIgnoreCase("1F") && !cadena.equalsIgnoreCase("2F") && !cadena.equalsIgnoreCase("3F") && !cadena.equalsIgnoreCase("4F") && !cadena.equalsIgnoreCase("5F") && !cadena.equalsIgnoreCase("6F") && !cadena.equalsIgnoreCase("7F") && !cadena.equalsIgnoreCase("8F") && !cadena.equalsIgnoreCase("9F")
                && !cadena.equalsIgnoreCase("0G") && !cadena.equalsIgnoreCase("1G") && !cadena.equalsIgnoreCase("2G") && !cadena.equalsIgnoreCase("3G") && !cadena.equalsIgnoreCase("4G") && !cadena.equalsIgnoreCase("5G") && !cadena.equalsIgnoreCase("6G") && !cadena.equalsIgnoreCase("7G") && !cadena.equalsIgnoreCase("8G") && !cadena.equalsIgnoreCase("9G")
                && !cadena.equalsIgnoreCase("0H") && !cadena.equalsIgnoreCase("1H") && !cadena.equalsIgnoreCase("2H") && !cadena.equalsIgnoreCase("3H") && !cadena.equalsIgnoreCase("4H") && !cadena.equalsIgnoreCase("5H") && !cadena.equalsIgnoreCase("6H") && !cadena.equalsIgnoreCase("7H") && !cadena.equalsIgnoreCase("8H") && !cadena.equalsIgnoreCase("9H")
                && !cadena.equalsIgnoreCase("0I") && !cadena.equalsIgnoreCase("1I") && !cadena.equalsIgnoreCase("2I") && !cadena.equalsIgnoreCase("3I") && !cadena.equalsIgnoreCase("4I") && !cadena.equalsIgnoreCase("5I") && !cadena.equalsIgnoreCase("6I") && !cadena.equalsIgnoreCase("7I") && !cadena.equalsIgnoreCase("8I") && !cadena.equalsIgnoreCase("9I")
                && !cadena.equalsIgnoreCase("0J") && !cadena.equalsIgnoreCase("1J") && !cadena.equalsIgnoreCase("2J") && !cadena.equalsIgnoreCase("3J") && !cadena.equalsIgnoreCase("4J") && !cadena.equalsIgnoreCase("5J") && !cadena.equalsIgnoreCase("6J") && !cadena.equalsIgnoreCase("7J") && !cadena.equalsIgnoreCase("8J") && !cadena.equalsIgnoreCase("9J")) {

            return false;
        } else {
            return true;
        }
    }

    public boolean EncimaDeFicha(Ficha[][] tablero, int fila, int columna, char[] cadenaArray, Ficha barco, String orientacion) {
        boolean ayuda = true;
        if (orientacion.equalsIgnoreCase("H")) {
            for (int x = 0; x < barco.getTamaño(); x++) {
                if (!tablero[fila][columna].getSimbolo().equals("~")) {
                    ayuda = false;
                }

                if (columna == 0 || columna == 9) {
                    if (columna == 0) {
                        if (!tablero[fila][columna + 1].getSimbolo().equals("~")) {
                            ayuda = false;
                        }
                    } else {
                        if (!tablero[fila][columna - 1].getSimbolo().equals("~")) {
                            ayuda = false;
                        }
                    }
                } else {
                    if (!tablero[fila][columna - 1].getSimbolo().equals("~")) {
                        ayuda = false;
                    }
                    if (!tablero[fila][columna + 1].getSimbolo().equals("~")) {
                        ayuda = false;
                    }
                }

                if (fila == 0 || fila == 9) {
                    if (fila == 0) {
                        if (!tablero[fila + 1][columna].getSimbolo().equals("~")) {
                            ayuda = false;
                        }
                    } else {
                        if (!tablero[fila - 1][columna].getSimbolo().equals("~")) {
                            ayuda = false;
                        }
                    }
                } else {
                    if (!tablero[fila + 1][columna].getSimbolo().equals("~")) {
                        ayuda = false;
                    }
                    if (!tablero[fila - 1][columna].getSimbolo().equals("~")) {
                        ayuda = false;
                    }
                }
                columna++;
            }
        }

        if (orientacion.equalsIgnoreCase("V")) {
            for (int x = 0; x < barco.getTamaño(); x++) {
                if (!tablero[fila][columna].getSimbolo().equals("~")) {
                    ayuda = false;
                }

                if (columna == 0 || columna == 9) {
                    if (columna == 0) {
                        if (!tablero[fila][columna + 1].getSimbolo().equals("~")) {
                            ayuda = false;
                        }
                    } else {
                        if (!tablero[fila][columna - 1].getSimbolo().equals("~")) {
                            ayuda = false;
                        }
                    }
                } else {
                    if (!tablero[fila][columna - 1].getSimbolo().equals("~")) {
                        ayuda = false;
                    }
                    if (!tablero[fila][columna + 1].getSimbolo().equals("~")) {
                        ayuda = false;
                    }
                }

                if (fila == 0 || fila == 9) {
                    if (fila == 0) {
                        if (!tablero[fila + 1][columna].getSimbolo().equals("~")) {
                            ayuda = false;
                        }
                    } else {
                        if (!tablero[fila - 1][columna].getSimbolo().equals("~")) {
                            ayuda = false;
                        }
                    }
                } else {
                    if (!tablero[fila + 1][columna].getSimbolo().equals("~")) {
                        ayuda = false;
                    }
                    if (!tablero[fila - 1][columna].getSimbolo().equals("~")) {
                        ayuda = false;
                    }
                }
                fila++;
            }
        }
        return ayuda;
    }

    public boolean validarDisparo(Ficha[][] tablero, int fila, int columna) {
        boolean ayuda = true;
        if (tablero[fila][columna].getSimbolo().equals("A") || tablero[fila][columna].getSimbolo().equals("V")
                || tablero[fila][columna].getSimbolo().equals("F") || tablero[fila][columna].getSimbolo().equals("B")
                || tablero[fila][columna].getSimbolo().equals("P")) {
            ayuda = false;
        }
        return ayuda;
    }

    public int traducirColumnas(char[] cadenaArray) {
        int columnaNum = 0;
        if (cadenaArray[1] == 'A' || cadenaArray[1] == 'a') {
            columnaNum = 0;
        }
        if (cadenaArray[1] == 'B' || cadenaArray[1] == 'b') {
            columnaNum = 1;
        }
        if (cadenaArray[1] == 'C' || cadenaArray[1] == 'c') {
            columnaNum = 2;
        }
        if (cadenaArray[1] == 'D' || cadenaArray[1] == 'd') {
            columnaNum = 3;
        }
        if (cadenaArray[1] == 'E' || cadenaArray[1] == 'e') {
            columnaNum = 4;
        }
        if (cadenaArray[1] == 'F' || cadenaArray[1] == 'f') {
            columnaNum = 5;
        }
        if (cadenaArray[1] == 'G' || cadenaArray[1] == 'g') {
            columnaNum = 6;
        }
        if (cadenaArray[1] == 'H' || cadenaArray[1] == 'h') {
            columnaNum = 7;
        }
        if (cadenaArray[1] == 'I' || cadenaArray[1] == 'i') {
            columnaNum = 8;
        }
        if (cadenaArray[1] == 'J' || cadenaArray[1] == 'j') {
            columnaNum = 9;
        }
        return columnaNum;
    }

    public int traducirFilas(char[] cadenaArray) {
        int columnaNum = 0;
        if (cadenaArray[0] == '0') {
            columnaNum = 0;
        }
        if (cadenaArray[0] == '1') {
            columnaNum = 1;
        }
        if (cadenaArray[0] == '2') {
            columnaNum = 2;
        }
        if (cadenaArray[0] == '3') {
            columnaNum = 3;
        }
        if (cadenaArray[0] == '4') {
            columnaNum = 4;
        }
        if (cadenaArray[0] == '5') {
            columnaNum = 5;
        }
        if (cadenaArray[0] == '6') {
            columnaNum = 6;
        }
        if (cadenaArray[0] == '7') {
            columnaNum = 7;
        }
        if (cadenaArray[0] == '8') {
            columnaNum = 8;
        }
        if (cadenaArray[0] == '9') {
            columnaNum = 9;
        }
        return columnaNum;
    }

    public int dispararCoordenada(Ficha[][] tableroIA, Ficha[][] tableroDelJuego) {
        boolean repetir = false;
        this.repetirDisparo = false;
        int contador = 0;
        do {
            try {
                System.out.println("Ingresa la posición del disparo (fila-columna)");
                String cadena = datos.nextLine();

                while (!validarCoordenada(cadena)) {
                    System.out.println("ERROR, introduce la coordenada correcta:");
                    cadena = datos.nextLine();
                }

                char[] cadenaArray = cadena.toCharArray();
                int fila = traducirFilas(cadenaArray);
                int columna = traducirColumnas(cadenaArray);

                while (!validarDisparo(tableroDelJuego, fila, columna)) {
                    System.out.println("ERROR, posicion ya disparada:");
                    cadena = datos.nextLine();
                    while (!validarCoordenada(cadena)) {
                        System.out.println("ERROR, introduce la coordenada correcta:");
                        cadena = datos.nextLine();
                    }
                    cadenaArray = cadena.toCharArray();
                    fila = traducirFilas(cadenaArray);
                    columna = traducirColumnas(cadenaArray);
                }

                repetir = true;

                if (repetir = true) {
                    if (tableroIA[fila][columna].getSimbolo().equals("~")) {
                        Ficha agua = new Ficha(0, "A", 0, "agua");
                        System.out.println("Agua");
                        tableroIA[fila][columna] = agua;
                        tableroDelJuego[fila][columna] = agua;
                        this.repetirDisparo = false;
                    } else if (!tableroIA[fila][columna].getSimbolo().equals("~")) {
                        Ficha ayuda = tableroIA[fila][columna];
                        tableroDelJuego[fila][columna] = ayuda;
                        tableroIA[fila][columna].setVida(tableroIA[fila][columna].getVida() - 1);
                        if (tableroIA[fila][columna].getVida() <= 0) {
                            System.out.println("Tocado y hundido");
                            this.repetirDisparo = true;
                            contador++;
                            System.out.println("Has acertado, dispara de nuevo ");
                        } else {
                            System.out.println("Tocado");
                            this.repetirDisparo = true;
                            System.out.println("Has acertado, dispara de nuevo ");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                repetir = false;
            }

        } while (!repetir);
        return contador;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean repetirDisparo() {
        return repetirDisparo;
    }
}
