package modelos;

import java.util.Map;
import java.util.Scanner;

public class Convertidor {
    private String paisBase;
    private double cambio;

    private String paisCambio;
    private double resultado;

    private Map<String, Double> monedas;
    public Convertidor(Moneda monedaOmdb) {
        this.paisBase = monedaOmdb.getBase_code();
        this.monedas = monedaOmdb.getConversion_rates();

    }

    public void setCambio(String pais){
        this.cambio = monedas.get(pais);
        this.paisCambio = pais;
    }



    public Double getCambio(){
        return this.cambio;
    }


    public String getPaisBase() {
        return this.paisBase;
    }

    public String getPaisCambio(){
        return this.paisCambio;
    }

    @Override
    public String toString() {
        return "modelos.Moneda: " + paisBase +
                "Lista de Cambios: " + monedas;
    }

    public void convertir(){
        System.out.println("Digite la cantidad a convertir");
        Scanner teclado = new Scanner(System.in);
        double cantidad = teclado.nextDouble();

        this.resultado = cantidad * getCambio();
        System.out.println("Los "+ cantidad +  " "+  getPaisBase() + " Equivalen a: "+ resultado + " " + getPaisCambio() );
    }
}
