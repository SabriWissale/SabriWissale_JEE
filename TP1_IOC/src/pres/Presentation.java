package pres;

import ext.DaoImpl;
import metier.MetierImpl;

//injection par instanciation statique
public class Presentation {
    public static void main(String[] args) {

        DaoImpl dao = new DaoImpl();
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);
        System.out.println(" --- Res : "+metier.calcul());
    }
}
