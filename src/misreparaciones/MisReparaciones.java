/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package misreparaciones;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class MisReparaciones {

    public static void MENU() {
        
        
        System.out.println();

        
        System.out.println("");
        System.out.println("+------------------=MENU=----------------+");
        System.out.println("|----------------------------------------|");
        System.out.println("| 1).Dar de alta un coche                |");
        System.out.println("| 2).Ver datos de todos los coches       |");
        System.out.println("| 3).Ver datos de un coche               |");
        System.out.println("| 4).Buscar coche por matricula          |");
        System.out.println("| 5).Dar de alta un propietario          |");
        System.out.println("| 6).Ver datos de todos los propietarios |");
        System.out.println("| 7).Ver datos de un propietario         |");
        System.out.println("| 8).Buscar propietario por dni          |");
        System.out.println("| 9).Asignar un propietario              |");
        System.out.println("| 10).Ver todas las reparaciones         |");
        System.out.println("| 11).Ver reparaciones de un coche       |");
        System.out.println("| 12).Reparar coche                      |");
        System.out.println("| 13).Salir                              |");
        System.out.println("+----------------------------------------+");
    }

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        ArrayList<Coche> coches = new ArrayList();
        ArrayList<Propietario> propietarios = new ArrayList();
        ArrayList<Reparacion> reparados = new ArrayList();

        
        
        int caso;
        do {
            MENU();
            caso = sn.nextInt();
            switch (caso) {
                case 1:
                    System.out.println("Matricula:");
                    String matricula = sn.next();
                    System.out.println("Marca:");
                    String marca = sn.next();
                    System.out.println("Modelo:");
                    String modelo = sn.next();
                    Coche auto = new Coche(matricula, marca, modelo);
                    coches.add(auto);
                    break;
                case 2:
                    Coche.VER_COCHES(coches);
                    break;
                case 3:
                    boolean not = true;
                    System.out.println("Que coche quires ver? Introduce matricula:");
                    String resp = sn.next();
                    for (int i = 0; i < coches.size(); i++) {
                        if (resp.equalsIgnoreCase(coches.get(i).matricula)) {
                            coches.get(i).VER_COCHE();
                            not = false;
                        }
                    }
                    if (not) {
                        System.out.println("No se encontro el coche");
                    }
                    break;
                case 4:
                    System.out.println("Que coche quieres buscar?");
                    String busqueda = sn.next();
                    int ResBus = Coche.BUSCAR_COCHE(coches, busqueda);
                    System.out.println("La posicion del coche es: " + ResBus);
                    break;
                case 5:
                    System.out.println("Cual es el nombre del propietario");
                    String nombre = sn.next();
                    System.out.println("Cual es el Dni");
                    String dni = sn.next();
                    System.out.println("Cual es el telefono");
                    int tel = sn.nextInt();
                    Propietario prop = new Propietario(dni, nombre, tel);
                    propietarios.add(prop);
                    break;
                case 6:
                    Propietario.VER_PROPIETARIOS(propietarios);
                    break;
                case 7:
                    System.out.println("Dime el Dni de el propietario a buscar");
                    String dn = sn.next();
                    boolean not2 = true;
                    for (int i = 0; i < propietarios.size(); i++) {
                        if (dn.equalsIgnoreCase(propietarios.get(i).dni)) {
                            propietarios.get(i).VER_PROPIETARIO();
                            not2 = false;
                        }
                    }
                    if (not2) {
                        System.out.println("No se encontro propietario");
                    }
                    break;
                case 8:
                    System.out.println("Dni del propietario a buscar:");
                    String nif = sn.next();
                    int dev = Propietario.BUSCAR_PROPIETARIO(propietarios, nif);
                    System.out.println("La posicion del propietario es: " + dev);
                    break;
                case 9:
                    Propietario.ASIGNA_PROP(coches, propietarios);
                    break;
                case 10:
                    Reparacion.VER_TODAS(reparados);
                    break;
                case 11:
                    Reparacion.VERxCOCHE(reparados);
                    break;
                case 12:
                    Reparacion rep = new Reparacion();
                    rep = rep.REPARA(coches);
                    reparados.add(rep);
                    System.out.println("Reparacion anotada..");

                    break;
                case 13:
                    System.out.println("Cerrando programa..");
                    break;
            }
        } while (caso != 13);
    }
}
