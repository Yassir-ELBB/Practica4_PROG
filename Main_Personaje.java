package Misc;
import GameMap.trampa;
import Characters.Personaje;
public class Main_Personaje {
    public static void main(String[] args) {
        trampa t = new trampa();
        t.setCategoria("Pinchos");
        t.setPerjuicio(5);


        Personaje p = new Personaje();
        p.setNombre("nombre del perosnaje");
        p.setatq(20);
        p.setdef(40);
        p.setpv(20);
        p.subirnivel();
        p.estaMuerto();
        p.nivel(60);
        System.out.println("-------------------------");
        System.out.println(p.toString());
    }
}