package hundirlaflotadaw;

import java.util.Scanner;

public class JugadorIA extends Jugadores {

    public boolean repetirDisparo = false;
    public Scanner datos = new Scanner(System.in);

    public JugadorIA(String nombre) {
        super(nombre);
    }

    public void insertarBarcos(Ficha[][] tablero) {

        Ficha[] barcos = new Ficha[10];

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

        barcos[0] = velero1;
        barcos[1] = velero2;
        barcos[2] = velero3;
        barcos[3] = velero4;
        barcos[4] = fragata1;
        barcos[5] = fragata2;
        barcos[6] = fragata3;
        barcos[7] = buque1;
        barcos[8] = buque2;
        barcos[9] = portaviones;

        for (int x = 0; x < barcos.length; x++) {
            boolean repetir = false;
            do {
                try {
                    int fila = (int) (Math.random() * 10);
                    int columna = (int) (Math.random() * 10);
                    String orientacion = new String();

                    int aleatorio = (int) (Math.random() * 2);
                    if (aleatorio == 0) {
                        orientacion = "H";
                    } else if (aleatorio == 1) {
                        orientacion = "V";
                    }

                    while (!EncimaDeFicha(tablero, fila, columna, barcos[x], orientacion)) {

                        fila = (int) (Math.random() * 10);
                        columna = (int) (Math.random() * 10);
                        orientacion = new String();

                        aleatorio = (int) (Math.random() * 2);
                        if (aleatorio == 0) {
                            orientacion = "H";
                        } else if (aleatorio == 1) {
                            orientacion = "V";
                        }
                    }

                    if ((orientacion.equals("H") && (barcos[x].getTamaño() + columna) > tablero.length)
                            || (orientacion.equals("V") && (barcos[x].getTamaño() + fila) > tablero.length)) {
                        throw new ArrayIndexOutOfBoundsException();
                    }

                    repetir = true;

                    if (repetir) {
                        if (orientacion.equals("V")) {
                            for (int y = 0; y < barcos[x].getTamaño(); y++) {
                                tablero[fila][columna] = barcos[x];
                                fila++;
                            }
                        } else {
                            for (int y = 0; y < barcos[x].getTamaño(); y++) {
                                tablero[fila][columna] = barcos[x];
                                columna++;
                            }
                        }
                    }
                } catch (Exception e) {
                    repetir = false;
                }

            } while (!repetir);
        }
    }

    public boolean EncimaDeFicha(Ficha[][] tablero, int fila, int columna, Ficha barco, String orientacion) {
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
        boolean ayuda = false;
        if (tablero[fila][columna].getSimbolo().equals("~") || tablero[fila][columna].getSimbolo().equals("V")
                || tablero[fila][columna].getSimbolo().equals("F") || tablero[fila][columna].getSimbolo().equals("B")
                || tablero[fila][columna].getSimbolo().equals("P")) {
            ayuda = true;
        }
        return ayuda;
    }

    public int dispararCoordenada(Ficha[][] tablero) {
        boolean repetir = false;
        int contador = 0;
        do {
            try {
                int fila = (int) (Math.random() * 10);
                int columna = (int) (Math.random() * 10);

                while (!validarDisparo(tablero, fila, columna)) {
                    fila = (int) (Math.random() * 10);
                    columna = (int) (Math.random() * 10);
                }

                System.out.println("La IA ha disparado a la coordenada: " + traducirFilas(fila) + traducirColumnas(columna));
                repetir = true;

                if (repetir = true) {
                    if (tablero[fila][columna].getSimbolo().equals("~")) {
                        Ficha agua = new Ficha(0, "A", 0, "agua");
                        tablero[fila][columna] = agua;
                        this.repetirDisparo = false;
                    } else {
                        Ficha ayuda = new Ficha(0, "X", 0, "ayuda");
                        tablero[fila][columna].setVida(tablero[fila][columna].getVida() - 1);
                        if (tablero[fila][columna].getVida() <= 0) {
                            tablero[fila][columna] = ayuda;
                            contador++;
                            this.repetirDisparo = true;
                            System.out.println("La maquina ha acertado, disparara de nuevo");
                        } else {
                            tablero[fila][columna] = ayuda;
                            this.repetirDisparo = true;
                            System.out.println("La maquina ha acertado, disparara de nuevo");
                        }
                    }
                }
            } catch (Exception e) {
                repetir = false;
            }

        } while (!repetir);
        return contador;
    }

    public String traducirFilas(int numero) {
        String fila = "";
        if (numero == 0) {
            fila = "0";
        }
        if (numero == 1) {
            fila = "1";
        }
        if (numero == 2) {
            fila = "2";
        }
        if (numero == 3) {
            fila = "3";
        }
        if (numero == 4) {
            fila = "4";
        }
        if (numero == 5) {
            fila = "5";
        }
        if (numero == 6) {
            fila = "6";
        }
        if (numero == 7) {
            fila = "7";
        }
        if (numero == 8) {
            fila = "8";
        }
        if (numero == 9) {
            fila = "9";
        }
        return fila;
    }

    public String traducirColumnas(int numero) {
        String columna = "";
        if (numero == 0) {
            columna = "A";
        }
        if (numero == 1) {
            columna = "B";
        }
        if (numero == 2) {
            columna = "C";
        }
        if (numero == 3) {
            columna = "D";
        }
        if (numero == 4) {
            columna = "E";
        }
        if (numero == 5) {
            columna = "F";
        }
        if (numero == 6) {
            columna = "G";
        }
        if (numero == 7) {
            columna = "H";
        }
        if (numero == 8) {
            columna = "I";
        }
        if (numero == 9) {
            columna = "J";
        }
        return columna;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean repetirDisparo() {
        return repetirDisparo;
    }
}
