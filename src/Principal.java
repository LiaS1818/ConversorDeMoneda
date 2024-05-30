import modelos.Convertidor;
import modelos.Moneda;
import modelos.MonedaOmdb;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String pais = null;
        String paisCambio = null;
        int opcion = 0;
        while (opcion != 7){
            System.out.println("*************************************************");
            System.out.println("Sea bienvenido/a al Conversor de modelos.Moneda");
            System.out.println(""" 
                                  1. D\u00D3LAR ==> PESO ARGENTINO 
                                  2.PESO ARGENTINO ==> D\u00D3LAR
                                  3.D\u00D3LAR ==> REAL BRASILE\u00D1O
                                  4. REAL BRASILE\u00D1O ==> D\u00D3LAR
                                  5. D\u00D3LAR A ==> PESO COLOMBIANO
                                  6. PESO COLOMBINANO ==> D\u00D3LAR
                                  7. SALIR
                                  Elija una opcion validad:
                                  **********************************************
                              """);
            Scanner teclado = new Scanner(System.in);
             opcion = teclado.nextInt();

            MonedaOmdb monedaOmdb;

            switch (opcion) {
                case 1:
                    pais = "USD";
                    paisCambio = "ARS";
                    break;
                case 2:
                    pais = "ARS";
                    paisCambio = "USD";
                break;
                case 3:
                    pais = "USD";
                    paisCambio = "BRL";
                break;
                case 4:
                    pais = "BRL";
                    paisCambio = "USD";
                break;
                case 5:
                    pais = "USD";
                    paisCambio = "COP";
                break;
                case 6:
                    pais = "COP";
                    paisCambio = "USD";
                break;
                default:
                    System.out.println("Opcion no valida");
                break;
            }
            Moneda moneda = new Moneda();
            monedaOmdb = moneda.getInfoMonedas(pais);
            Convertidor convertidor = new Convertidor(monedaOmdb);
            convertidor.setCambio(paisCambio);
            convertidor.convertir();
        }


    }
}
