public class Utilidad extends Aplicacion{
    //añadimos el atributo categoria
    protected String categoria;

    /*
    constructor con super y nuevo atributo
     */
    public Utilidad(String nombre, String version, double pesoMB, String categoria) {
        super(nombre, version, pesoMB);
        this.categoria = categoria;
    }

    //getter y setter
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    //sobrescritura con nueva info

    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() +  "\ncategoria: " + categoria;
    }
}
