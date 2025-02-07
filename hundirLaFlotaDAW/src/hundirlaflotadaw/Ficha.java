package hundirlaflotadaw;

public class Ficha {

    protected int tamaño;
    protected String simbolo;
    protected int cantidad;
    protected int vida;
    protected String nombre;

    public Ficha(int tamaño, String simbolo, int vida, String nombre) {
        this.tamaño = tamaño;
        this.simbolo = simbolo;
        this.vida = vida;
        this.nombre = nombre;
    }

    public int getTamaño() {
        return tamaño;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }
}
