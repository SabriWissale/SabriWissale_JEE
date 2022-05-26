package ext;

import dao.IDao;

public class DaoImpl implements IDao {

    @Override
    public double getData() {

        double temp = 80;
        return temp;
    }
}
