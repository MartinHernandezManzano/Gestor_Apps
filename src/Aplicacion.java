public abstract class Aplicacion implements Imprimible{
    /*
    la clase abstracta aplicación q implementa
    la interfaz imprimible
     */

    //atributos
    protected String nombre;
    protected String version;
    protected double pesoMB;

    //constructor
    public Aplicacion(String nombre, String version, double pesoMB) {
        this.nombre = nombre;
        this.version = version;
        this.pesoMB = pesoMB;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public double getPesoMB() {
        return pesoMB;
    }

    public void setPesoMB(double pesoMB) {
        this.pesoMB = pesoMB;
    }

    //metodo sobrescrito
    @Override
    public String devolverInfoString() {
        return "Nombre: " + nombre + "\nVersion: " + version + "\nPeso MB: " + pesoMB;
    }
}
