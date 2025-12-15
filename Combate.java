package Combat;
import GameMap.Area;
import Characters.Personaje;

public class Combate {
    private  Personaje C1;
    private  Personaje C2;


    public Combate(){
        C1 = new Personaje();
        C2 = new Personaje();
    }

    public void C1(String nombre, int pv1,int niv1, int def1,int atq1 ) {
        C1.setNombre(nombre);
        C1.setpv(pv1);
        C1.setatq(atq1);
        C1.setdef(def1);


    }


    public void C2(String nombre2,int pv2,int niv2, int def2,int atq2 ) {
        C2.setNombre(nombre2);
        C2.setpv(pv2);
        C2.setatq(atq2);
        C2.setdef(def2);



    }

}
