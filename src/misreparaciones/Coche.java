/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package misreparaciones;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Coche {

    String matricula;
    String marca;
    String modelo;
    ArrayList<Propietario>propCoche=new ArrayList();
    static int total_c;

    public Coche(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        total_c++;
    }

    public static void VER_COCHES(ArrayList<Coche> coches) {
        for (int i = 0; i < coches.size(); i++) {
            System.out.println("---------------------------------");
            coches.get(i).VER_COCHE();
        }
        System.out.println("---------------------------------");
        System.out.println("El numero total de coches es: " + total_c);
    }

    public void VER_COCHE() {
        System.out.println("La matricula es: " + matricula);
        System.out.println("La marca es: " + marca);
        System.out.println("El modelo es modelo " + modelo);
         if (propCoche!=null) {
             System.out.println("--Datos del propietarios--");
             for (int i = 0; i < propCoche.size(); i++) {
                 propCoche.get(i).VER_PROPIETARIO();
             }
            
        } else {
            System.out.println("Propietario: nulo");
           
        }
    }

    public static int BUSCAR_COCHE(ArrayList<Coche> coches, String matricula) {
        int resultado = -1;
        for (int i = 0; i < coches.size(); i++) {
            if (matricula.equalsIgnoreCase(coches.get(i).matricula)) {
                resultado = i;
                break;
            }
        }
        return resultado;
    }
}
