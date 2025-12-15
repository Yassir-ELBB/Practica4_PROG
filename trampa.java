package GameMap;

import java.util.Random;

public class trampa {
    private String categoria;
    private int perjuicio;
    private double fracaso;


    public trampa(){
        categoria = "";
        perjuicio = 0;
        fracaso = 0;
    }

    public String getCategoria(){
        return categoria;
    }

    public int getPerjuicio() {
        return perjuicio;
    }

    public double getFracaso() {
        return fracaso;
    }

    public void setCategoria(String Pcategoria) {
        switch (Pcategoria){
            case "Pinchos":
                System.out.println("La categoria de trampa es: Pinchos");
                break;
            case "Brea":
                System.out.println("La categoria de la trampa es: Brea");
                break;
            case "Serpientes":
                System.out.println("La categoria de la trampa es: Serpientes");
                break;

            default:
                System.err.println("Elije un tipo de trampa correcto");
        }
        categoria = Pcategoria;
    }

    public void setPerjuicio(int Cperjuicio) {
        if(Cperjuicio < 5 || Cperjuicio > 20){
            System.err.println("Por favor elija un valor entre 5 y 20");
        } else System.out.println("Tu prejuicio es de: "+Cperjuicio);
        perjuicio = Cperjuicio;
    }

    public void Fracaso(double Pfracaso) {
        Random f = new Random();
        double random;
        random = (f.nextDouble()*0.75)*100;
        System.out.println("La probabilidad de que la trampa fracase es de: "+ random+" %");

        fracaso = random;

    }

    public boolean activarTrampa(){
        double AT;
        Random T = new Random();
        AT = (T.nextDouble())*100;
        boolean caido;
        if(fracaso > AT){
            caido = true;

        }else caido = false;


        if(caido == true){
            System.out.println("Felicidades, te has salvado de caer en la trampa, la probabilidad de caer esta de: "+AT+" %");
        }else System.err.println("Has caido en la trampa, con un porcentaje de: "+ AT +" % y con un perjuicio de: "+perjuicio);

        return caido;
    }

     //Practica 4, Ejercicio 2:

    // To String:

    public String toString(){
        String DevolucionDescripcion = "La trampa es de categoria: "+categoria+" con un prejuicio de: "+perjuicio+" y con una probabilidad de fracaso: "+fracaso;
        return DevolucionDescripcion;
    }

    //Equals
    public boolean equals(trampa otra){
        boolean comparacion = true;

        if(!this.categoria.equals(otra.categoria)){
            comparacion = false;
        }

        if(this.perjuicio != otra.perjuicio){
            comparacion = false;
        }

        if(this.fracaso != otra.fracaso){
            comparacion = false;
        }

        return comparacion;
    }
}
