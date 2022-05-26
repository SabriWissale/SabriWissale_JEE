package ma.enset.tp5.repositories;

import ma.enset.tp5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String userName);

    List<User> findAll();
}
