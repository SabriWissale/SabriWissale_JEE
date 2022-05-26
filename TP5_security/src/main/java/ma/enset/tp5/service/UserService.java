package ma.enset.tp5.service;

import ma.enset.tp5.entities.Role;
import ma.enset.tp5.entities.User;

import java.util.List;

public interface UserService {

    User addNewUser(User user);

    Role addNewRole(Role role);

    List<User> getAllUsers();

    User findUserByUserName(String userName);
    Role findRoleByRoleNAme(String roleNAme);

    void addRoleToUser(String username, String rolename);

    User autheticate(String username,String password);


}
