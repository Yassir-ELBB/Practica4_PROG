package Characters;

import GameMap.trampa;
import java.util.Random;

public class Personaje {
    private int pv;
    private int atq;
    private int def;
    private int nivel;
    private String nombre;

    public Personaje(){
        pv = 0;
        atq = 0;
        def = 0;
        nivel = 0;
        nombre = "";
    }

    public Personaje (String nombre, int pv, int atq, int def, int nivel){
        this.pv = pv;
        this.atq = atq;
        this.def = def;
        this.nivel = nivel;
        this.nombre = nombre;
    }

    public Personaje (String nombre){
     setNombre(nombre);
     setnivel(1);
     Random r = new Random();
     setpv(r.nextInt(101));
     setatq(r.nextInt(101));
     setdef(r.nextInt(101));
    }

    public Personaje (String nombre, int nivel){
        setNombre(nombre);
        setnivel(nivel);
        Random r = new Random();
        setpv(r.nextInt(101));

    }

    public Personaje (Personaje copia){
        this.nombre = copia.nombre;
        this.pv = copia.pv;
        this.def = copia.def;
        this.atq = copia.atq;
        this.nivel = copia.nivel;
    }


    public String getNombre(){
        return nombre;
    }

    public int getpv(){
        return pv;
    }

    public int getAtq(){
        return atq;
    }

    public int getdef(){
        return def;
    }

    public int getNivel(){
        return nivel;
    }

    public void setNombre(String n){
        if( n.equals("") || n.equals("GM") || n.equals("2") ){
            System.err.println("Error. El nombre no es correcto");
        }else nombre = n;
    }

    public void setpv(int puntosVida){
        if (puntosVida < 0){
            System.err.println("Error. Pv no puede ser menor de cero");
        }else{
            pv = puntosVida;

        }

    }

    public void setatq(int puntosAtq){
        if(puntosAtq < 0){
            System.err.println("Error. EL atque no puede ser menor que cero");
        }else{
            atq = puntosAtq;

        }

    }

    public void setdef(int puntosDef){
        if(puntosDef < 0){
            System.err.println("Error. La defensa no puede ser menor que 0");
        }else{
            def = puntosDef;

        }

    }

    public void setnivel(int puntosNivel){
        if(puntosNivel < 1 || nivel > 100){
            System.err.println("Error. El nivel no es correcto");
        }else{
            nivel = puntosNivel;

        }
    }

    public void beberPocion(int pocion){
        if(pv < 30){
            pv += pocion;
            System.out.println("Has bebido la pocion, ahora tienes: "+ pv +" puntos de vida");
        }else System.err.println("No puedes beber la pocion ya que tu vida es mayor de 30 puntos");
    }


    public void inspirar(int cantidad, String tipo) {
        if (tipo == "atq") {
            atq += cantidad;
            System.out.println("Has aumentado: "+tipo+" En una cantidad de: "+cantidad+" puntos, ahora tienes: "+atq+" Puntos de defensa");
        } else if (tipo == "def") {
            def += cantidad;
            System.out.println("Has aumentado: "+tipo+" En una cantidad de: "+cantidad+" puntos, ahora tienes: "+def+" Puntos de defensa");
        } else {
            System.err.println("Error. No es correcto, elija entre atq o def");
        }
    }

    public void subirnivel(){
        Random r = new Random();
        int aleatorio;
        aleatorio = r.nextInt(3) ;

        if(aleatorio == 1){
            pv++;
            System.out.println("Felicidades, tienes un punto de vida extra, ahora tienes: "+ pv);
        } else if (aleatorio == 2) {
            atq++;
            System.out.println("Felicidades, tienes un punto de ataque extra, ahora tienes: "+ atq);
        } else{
            def++;
            System.out.println("Felicidades, tienes un punto de defensa extra, ahora tienes: "+ def );
        }

    }

    public void estaMuerto() {
        if(pv < 0){
            System.out.println("Analizando tu vida se determina que estas muerto");
        }else System.out.println("Analizando tu vida se determina que sigues vivo");

    }

    public void caerTrampa(trampa t){

        boolean AC = t.activarTrampa();
        String Tipo = t.getCategoria();
        int Quita = t.getPerjuicio();


        if (AC == true){
            switch (Tipo){
                case "Pinchos":
                    System.out.println("Estacas afiladas salen de la superficie cercana y atraviesan a: "+nombre+" por un prejuicio de: "+Quita+" puntos de daño");
                    pv -= Quita;
                    break;
                case "Brea":
                    System.out.println("Aceite biscoso le cae de pronto a: "+nombre+" impidiendo que se mueva con libertad, por un prejuicio de: "+Quita+" puntos de daño");
                    def -= Quita;
                    break;
                case "Serpientes":
                    System.out.println("Un nido de viboras y culebras aparecen frente a: "+nombre+" La vision es tan terrorifica que pierde las ganas de continuar , por un prejuicio de: "+Quita+" puntos de daño");
                    atq -= Quita;
                    break;

            }

        }else System.out.println("Felicidades, "+nombre+" !escapaste indemne¡");


    }

    //Practica 4, Ejercicio 2
    //Clone:

    public Personaje clon(){
        Personaje clone = new Personaje(this.nombre, this.pv, this.atq, this.def,this.nivel);
        return clone;
    }

    //Equals:

    public boolean equals(Personaje otro) {
        boolean comparacion = true;

        if (!this.nombre.equals(otro.nombre)) {
            comparacion = false;
        }
        if(this.pv != otro.pv) {
            comparacion = false;
        }

        if(this.def != otro.def) {
            comparacion = false;
        }

        if(this.atq != otro.atq) {
            comparacion = false;
        }

        if(this.nivel != otro.nivel){
            comparacion = false;
        }

        return comparacion;
    }

    //To String:
    public String toString(){
        String DevolucionDescribcion = "Tu personaje llamado: "+nombre+" con una cantidad de pundos de vida de: "+pv+" , Puntos de defensa: "+def+" , Puntos de ataque: "+atq+" y puntos de nivel: "+nivel;
        return DevolucionDescribcion;
    }

}
