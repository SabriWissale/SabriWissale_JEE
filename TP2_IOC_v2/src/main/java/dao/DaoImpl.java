package dao;


import org.springframework.stereotype.Repository;

@Repository("dao")
public class DaoImpl implements IDao{
    @Override
    public double getData() {

        //db version
        double temp = Math.random()*40;
        return temp;
    }

    public void init(){
        System.out.println("instanciation par DaoImpl ");
    }
}
