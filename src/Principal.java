import java.util.*;

public class Principal {
    /*
    clase que contiene el main y se encarga del flujo de ejecucion del programa
    aqui se crean dispositivos y se interactua con el ususario
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //creamos un movil, un Galaxy con 5GB
        Dispositivo movil = new Dispositivo("Samsung Galaxy", 5000);

        int opcion = 0;

        /*
        bucle principal del menu:
        se repite hasta que el usuario elija la opcion de salir (7)
         */
        do {
            System.out.println("\n===== GESTOR DE APLICACIONES =====");
            System.out.println("1. Instalar nueva aplicacion");
            System.out.println("2. Desinstalar aplicacion");
            System.out.println("3. Listar aplicaciones instaladas");
            System.out.println("4. Obtener datos de una aplicacion concreta");
            System.out.println("5. Consultar almacenamiento disponible");
            System.out.println("6. Actualizar aplicacion (EXTRA)");
            System.out.println("7. Salir");
            System.out.print("Elige una opcion (1-7): ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiamos el buffer para que no salte el proximo nextLine

            switch (opcion) {
                case 1:
                    /*
                    instalar aplicacion:
                    -1. preguntar tipo de app (1. Juego o 2. Utilidad)
                    -2. pedir datos comunes: nombre, version y peso en MB
                    -3. segun el tipo de app pedir el dato especifico
                    -4. instanciar usando polimorfismo con la clase base Aplicacion
                    -5. llamar al metodo instalarApp del dispositivo
                    -6. si devuelve true muestra mensaje de exito
                    -7. si devuelve false muestra mensaje de falta de espacio
                     */
                    System.out.println("\n--- Instalar Aplicacion ---");
                    System.out.println("Que tipo de app quieres instalar?");
                    System.out.println("1. Juego");
                    System.out.println("2. Utilidad");
                    System.out.print("Opcion: ");
                    int tipoApp = sc.nextInt();//1.
                    sc.nextLine();//1.

                    if (tipoApp != 1 && tipoApp != 2) {
                        System.out.println("Opcion incorrecta. Solo 1 (Juego) o 2 (Utilidad).");
                        break;
                    }

                    System.out.print("Nombre de la aplicacion: ");
                    String nombre = sc.nextLine();//2.

                    System.out.print("Version: ");
                    String version = sc.nextLine();//2.

                    System.out.print("Peso en MB: ");
                    double pesoMB = sc.nextDouble();//2.
                    sc.nextLine();//2.

                    Aplicacion nuevaApp = null;//4.

                    if (tipoApp == 1) {
                        System.out.print("Tiene modo multijugador? (s/n): ");
                        String multi = sc.nextLine().trim();//3.
                        boolean esMulti = multi.equalsIgnoreCase("s");//3.
                        nuevaApp = new Juego(nombre, version, pesoMB, esMulti);//4.
                    } else {
                        System.out.print("Categoria (ej: Redes, Productividad, Herramientas): ");
                        String categoria = sc.nextLine();//3.
                        nuevaApp = new Utilidad(nombre, version, pesoMB, categoria);//4.
                    }

                    boolean exito = movil.instalarApp(nuevaApp);//5.
                    if (exito) {//6.
                        System.out.println("Aplicacion '" + nuevaApp.getNombre() + "' instalada correctamente.");//6.
                    } else {//7.
                        System.out.println("Error: No hay suficiente espacio disponible para instalar esta app.");//7.
                    }
                    break;

                case 2:
                    /*
                    desinstalar una app:
                    -1. pedir por consola el nombre de la aplicacion que queremos borrar
                    -2. llamar al metodo desinstalarApp pasando el nombre por parametro
                    -3. si devuelve true muestra que se borro y libero memoria
                    -4. si devuelve false avisa que no se encontro la app
                     */
                    System.out.println("\n--- Desinstalar Aplicacion ---");
                    System.out.print("Introduce el nombre de la aplicacion a borrar: ");
                    String nombreBorrar = sc.nextLine();//1.

                    boolean borrada = movil.desinstalarApp(nombreBorrar);//2.

                    if (borrada) {//3.
                        System.out.println("Aplicacion '" + nombreBorrar + "' desinstalada y memoria liberada.");//3.
                    } else {//4.
                        System.out.println("No se encontro ninguna aplicacion con el nombre '" + nombreBorrar + "'.");//4.
                    }
                    break;

                case 3:
                    /*
                    listar apps instaladas:
                    -1. imprime la cabecera
                    -2. llama al metodo mostrarAppsInstaladas del dispositivo
                     */
                    System.out.println("\n--- Listado de Aplicaciones Instaladas ---");//1.
                    movil.mostrarAppsInstaladas();//2.
                    break;

                case 4:
                    /*
                    consultar datos de una app:
                    -1. pedir por consola el nombre de la app a buscar
                    -2. llamar al metodo informacionApp del dispositivo pasandole el nombre
                    -3. comprobar si devuelve null: si es null avisa que no existe la app
                    -4. si no es null muestra por consola la info obtenida
                     */
                    System.out.println("\n--- Consultar Datos de una Aplicacion ---");
                    System.out.print("Introduce el nombre de la app a consultar: ");
                    String nombreBuscar = sc.nextLine();//1.

                    String info = movil.informacionApp(nombreBuscar);//2.

                    if (info != null) {//3.
                        System.out.println("\n" + info);//4.
                    } else {//3.
                        System.out.println("La aplicacion '" + nombreBuscar + "' no esta instalada en el dispositivo.");//3.
                    }
                    break;

                case 5:
                    /*
                    almacenamiento disponible:
                    -1. imprime la cabecera
                    -2. llama al metodo obtenerAlmacenamientoDisponible del dispositivo
                    -3. muestra por consola los MB libres que quedan
                     */
                    System.out.println("\n--- Almacenamiento Disponible ---");//1.
                    double espacioLibre = movil.obtenerAlmacenamientoDisponible();//2.
                    System.out.println("Espacio disponible: " + espacioLibre + " MB");//3.
                    break;

                case 6:
                    /*
                    EXTRA: actualizar aplicacion:
                    -1. pedir por consola el nombre de la app a actualizar
                    -2. pedir el nuevo peso en MB
                    -3. llamar al metodo actualizarApp del dispositivo
                    -4. si se actualiza con exito muestra mensaje
                    -5. si no hay suficiente memoria avisa del error
                     */
                    System.out.println("\n--- Actualizar Aplicacion (EXTRA) ---");
                    System.out.print("Introduce el nombre de la aplicacion a actualizar: ");
                    String nombreAct = sc.nextLine();//1.

                    if (movil.informacionApp(nombreAct) == null) {
                        System.out.println("La aplicacion '" + nombreAct + "' no esta instalada.");
                        break;
                    }

                    System.out.print("Introduce el nuevo peso en MB: ");
                    double nuevoPeso = sc.nextDouble();//2.
                    sc.nextLine();//2.

                    boolean actualizada = movil.actualizarApp(nombreAct, nuevoPeso);//3.
                    if (actualizada) {//4.
                        System.out.println("Aplicacion '" + nombreAct + "' actualizada a " + nuevoPeso + " MB con exito.");//4.
                    } else {//5.
                        System.out.println("Error: No hay suficiente espacio disponible para esta actualizacion.");//5.
                    }
                    break;

                case 7:
                    /*
                    salir del programa:
                    -muestra mensaje de despedida
                     */
                    System.out.println("Saliendo del gestor...chao!");
                    break;

                default:
                    System.out.println("Opcion no valida. Debe ser del 1 al 7, mendrugo.");
                    break;
            }

        } while (opcion != 7);

        sc.close();
    }
}
