import java.util.ArrayList;

public class Dispositivo {
    //atributos
    protected String marca;
    protected double almacenamientoTotal;
    protected double almacenamientoDisponible;
    protected ArrayList<Aplicacion> appsInstaladas;

    //Metodos

    /*
    --CONSTRUCTOR--
    en el constructor solo pediremos la marca y el almacenamiento total.
    el almacenamiento disponible al principio será el total y se creará
    un array nuevo desde cero con la lista de apps instaladas
     */
    public Dispositivo(String marca, double almacenamientoTotal) {
        this.marca = marca;
        this.almacenamientoTotal = almacenamientoTotal;
        this.almacenamientoDisponible = almacenamientoTotal; // empieza con todo libre
        this.appsInstaladas = new ArrayList<>();              // lista vacía lista para usar
    }

    /*
    instalar la app:
    -1. comprobar que haya memoria
    -2. añadirla al array
    -3. restar el peso al almacenamiento disponible
    -4. devolver true
    -5. si no entra al if devuelve false
     */
    public boolean instalarApp(Aplicacion app) {
        if (almacenamientoDisponible >= app.getPesoMB()) { //1.

            appsInstaladas.add(app);//2.

            almacenamientoDisponible -= app.getPesoMB();//3.
            return true;//4.
        }
        return false;//5.
        }
    }
    /*
    Desinstalar una app:
    1. recibe por parámetro el nombre de la aplicación que queremos borrar.
    2. recorre la lista buscando el nombre
    3. si hay match de nombres entra en el if
    4. suma el peso de la app al almacenamiento
    5. elimina la app de la lista
    6. devuelve true
    7. si no completa el if, devuelve false
     */
    public void desinstalarApp(String nombreApp) {//1.
        for (int i = 0; i < appsInstaladas.size(); i++) {
            Aplicacion app = appsInstaladas.get(i);
            if (app.getNombre().equalsIgnoreCase(nombreApp)) {
                // 1. Devolver el espacio: sumar peso a almacenamientoDisponible
                // 2. Eliminar de la lista: appsInstaladas.remove(i);
                // 3. return true;
            }
        }
        return false; // Si termina el bucle y no la encontró
    }

    public void listadoApps(){

    }

    public void mostrarAppsInstaladas(){
    }

    public void informacionApp(String nombreApp){
    }

    public void obtenerAlmacenamientoDisponible(){

    }

}
    //setters y getters


void main() {
}
