public class Juego extends Aplicacion{

    /*
    añadimos el atributo multijugador
     */
    protected boolean multijugador;
    //constructor que matchea el super
    //añadimos el atributo multijugador
    public Juego(String nombre, String version, double pesoMB, boolean multijugador) {
        super(nombre, version, pesoMB);
        this.multijugador = multijugador;
    }

    //getters y setters
    public boolean isMultijugador() {
        return multijugador;
    }

    public void setMultijugador(boolean multijugador) {
        this.multijugador = multijugador;
    }
    //sobrescritura con nueva info
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + "\nmultijugador: " + (multijugador ? "Sí" : "No");
    }
}
