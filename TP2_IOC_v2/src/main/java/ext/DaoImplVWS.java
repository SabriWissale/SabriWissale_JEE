package ext;

import dao.IDao;
import org.springframework.stereotype.Repository;

@Repository
public class DaoImplVWS implements IDao {
    @Override
    public double getData() {
        //version web service
        return 95;
    }
}
