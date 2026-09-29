import java.util.ArrayList;
import java.util.Collections;

public class Dispositivo {
    //atributos
    private String marca;
    private double almacenamientoTotal;
    private double almacenamientoDisponible;
    private ArrayList<Aplicacion> appsInstaladas;

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
    public boolean desinstalarApp(String nombreApp) {//1.
        for (int i = 0; i < appsInstaladas.size(); i++) {//2.
            Aplicacion app = appsInstaladas.get(i);//2.
            if (app.getNombre().equalsIgnoreCase(nombreApp)) {//3.
                almacenamientoDisponible += app.getPesoMB();//4.
                appsInstaladas.remove(i);//5.
                return true;//6.
            }
        }
        return false;//7.
    }

    /*
    listar apps:
    -1. devuelve un array de string
    -2. crea una lista vacia de textos
    -3. recorre la lista de apps instaladas
    -4. añade al array la info de cada app
    -5. al salir del bucle, retorna la lista
     */
    public ArrayList<String> listadoApps() {//1.
        ArrayList<String> listaApps = new ArrayList<>();//2.
        for (Aplicacion app : appsInstaladas) {//3.
            listaApps.add(app.devolverInfoString());//4.
        }
        return listaApps;//5.
    }

    /*
    mostrar apps instaladas:
    -1. primero comprueba que haya apps instaladas con el if
    -2. si no las hay, muestra un mensaje
    -3. EXTRA: ordenamos la lista alfabeticamente con Collections.sort usando el compareTo
    -4. si las hay, recorre todo el array de apps intaladas
    -5. imprime por consola el resultado de la llamada al metdo devolverInfoString
     */
    public void mostrarAppsInstaladas() {
        if (appsInstaladas.isEmpty()) {//1.
            System.out.println("No hay apps instaladas");//2.
        } else {
            Collections.sort(appsInstaladas);//3.
            for (Aplicacion app : appsInstaladas) {//4.
                System.out.println(app.devolverInfoString());//5.
                System.out.println("-------------");//5.
            }
        }

    }

    /*
    informacion App:
    -recibe el nombre que buscamos por parámetro
    -1. recorre todas las app instaladas
    -2. si el nombre coincide, muestra la info de la app
    -3. si no encuentra coincidencia, devuelve null
     */
    public String informacionApp(String nombreApp) {
        for (Aplicacion app : appsInstaladas) {
            if (app.getNombre().equalsIgnoreCase(nombreApp)) {
                return app.devolverInfoString();
            }
        }
        return null;
    }

    /*
    EXTRA: actualizar una app:
    -1. recorre la lista buscando la app por nombre
    -2. calcula la diferencia entre el peso nuevo y el actual
    -3. comprueba si hay memoria libre suficiente para el aumento
    -4. actualiza el peso de la app llamando a su metodo
    -5. resta la diferencia al almacenamiento disponible
    -6. devuelve true si se pudo actualizar
    -7. si no encuentra la app devuelve false
     */
    public boolean actualizarApp(String nombreApp, double nuevoPeso) {
        for (Aplicacion app : appsInstaladas) {//1.
            if (app.getNombre().equalsIgnoreCase(nombreApp)) {//1.
                double diferencia = nuevoPeso - app.getPesoMB();//2.
                if (diferencia > almacenamientoDisponible) {//3.
                    return false;//3. no hay espacio para la actualizacion
                }
                app.actualizar(nuevoPeso);//4.
                almacenamientoDisponible -= diferencia;//5.
                return true;//6.
            }
        }
        return false;//7.
    }

    /*
    metodo bastante sencillo y directo
     */
    public double obtenerAlmacenamientoDisponible() {
        return this.almacenamientoDisponible;
    }

}
