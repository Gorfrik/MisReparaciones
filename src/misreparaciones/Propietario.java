/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misreparaciones;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Propietario {

    String dni;
    String nombre;
    int tlf;
    static int total_p;

    public Propietario(String dni, String nombre, int tlf) {
        this.dni = dni;
        this.nombre = nombre;
        this.tlf = tlf;
        total_p++;
    }

    public static void VER_PROPIETARIOS(ArrayList<Propietario> propietarios) {
        for (int i = 0; i < propietarios.size(); i++) {
            System.out.println("---------------------------------");
            propietarios.get(i).VER_PROPIETARIO();
            System.out.println();
        }
        System.out.println("---------------------------------");
        System.out.println("El total de propietarios es: " + total_p);
    }

    public void VER_PROPIETARIO() {
        System.out.println("--El dni es " + dni);
        System.out.println("--El nombre es " + nombre);
        System.out.println("--El telefono es " + tlf);
    }

    public static int BUSCAR_PROPIETARIO(ArrayList<Propietario> propietarios, String dni) {
        int resultado = -1;
        for (int i = 0; i < propietarios.size(); i++) {
            if (dni.equalsIgnoreCase(propietarios.get(i).dni)) {
                resultado = i;
            }
        }
        return resultado;
    }

    public static void ASIGNA_PROP(ArrayList<Coche> coches, ArrayList<Propietario> propietarios) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Matricula del coche");
        String mat = sn.next();
        boolean propi = true;
        boolean cochi = true;
        for (int i = 0; i < coches.size(); i++) {
            if (mat.equalsIgnoreCase(coches.get(i).matricula)) {
                cochi = false;
                System.out.println("Dni del propietario");
                String dni = sn.next();
                for (int j = 0; j < propietarios.size(); j++) {
                    if (dni.equalsIgnoreCase(propietarios.get(j).dni)) {
                        propi = false;
                        
                            coches.get(i).propCoche.add(propietarios.get(j));
                            
                        
                    }
                }
                if (propi) {
                    System.out.println("No se encontro el propietarios");
                }
            }
        }
        if (cochi) {
            System.out.println("No se encontro el coche");
        }
    }

}
