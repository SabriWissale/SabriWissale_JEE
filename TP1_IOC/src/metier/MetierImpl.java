package metier;

import dao.IDao;

public class MetierImpl implements IMetier{


    private IDao dao;

    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double tmp = dao.getData();
        double resultat=tmp*540/Math.cos(tmp*Math.PI);
        return resultat;
    }



}
