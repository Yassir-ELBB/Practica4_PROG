package Misc;
import Characters.Personaje;
import GameMap.Area;
public class Main_Area {
    public static void main(String[] args) {

        Personaje p = new Personaje();
        Area a = new Area();
        System.out.println("Por favor selecciones uno de estos biomas: Pradera, Jungla, Desierto, Montaña, Mazmorra.");
        a.setBioma("Jungla");
        a.asignarNivel("Jungla");
        p.setpv(20);
        int modificacionPV = a.generarPocion("Jungla");
        int resultadoPVRAMDOM = modificacionPV + p.getpv();
        System.out.println("Como tu eleccion de bioma es "+ a.getBioma() + ", tu vida de "+p.getpv()+" puntos de vida, ha sido modificada con "+modificacionPV+" puntos de vida, con un total de "+resultadoPVRAMDOM);

    }
}
