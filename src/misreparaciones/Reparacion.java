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
public class Reparacion {

    int cod;
    static int contcod = 1;
    String dia;
    String hora;
    Coche CocheRep = null;

    public Reparacion REPARA(ArrayList<Coche> coches) {
        Scanner sn = new Scanner(System.in);
        Reparacion rep = new Reparacion();

        System.out.println("Que dia se realizo la reparacion?");
        rep.dia = sn.next();
        System.out.println("Que hora?");
        rep.hora = sn.next();

        int pos = -1;
        while (pos == -1) {
            System.out.println("Nombre de la matricula del coche reparado:");
            String matricula = sn.next();
            pos = Coche.BUSCAR_COCHE(coches, matricula);
        }

        rep.CocheRep = coches.get(pos);
        rep.cod = contcod;
        contcod++;

        return rep;
    }

    public static void VERxCOCHE(ArrayList<Reparacion> reparados) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Introduzca Matricula para ver reparaciones:");
        String mat = sn.next();
        boolean not = true;
        for (int i = 0; i < reparados.size(); i++) {
            if (reparados.get(i).CocheRep.matricula.equalsIgnoreCase(mat)) {
                reparados.get(i).CocheRep.VER_COCHE();
                not = false;
            }
        }
        if (not) {
            System.out.println("No se encotro matricula");
        }
    }

    public static void VER_TODAS(ArrayList<Reparacion> reparados) {
        for (int i = 0; i < reparados.size(); i++) {
            System.out.println("---------------------------------");
            System.out.println("Codigo: " + reparados.get(i).cod);
            System.out.println("Dia/hora: " + reparados.get(i).dia + " // " + reparados.get(i).hora);
            if (reparados.get(i).CocheRep != null) {
                System.out.println("--Datos del coche--");
                reparados.get(i).CocheRep.VER_COCHE();
            } else {
                System.out.println("Coche: null");
                System.out.println("Propietario: null");
            }
        }
        if (reparados.size() == 0) {
            System.out.println("No hay reparaciones.");
        }
    }
}
