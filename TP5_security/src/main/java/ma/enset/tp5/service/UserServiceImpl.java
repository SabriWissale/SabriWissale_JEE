package ma.enset.tp5.service;

import lombok.AllArgsConstructor;
import ma.enset.tp5.entities.Role;
import ma.enset.tp5.entities.User;
import ma.enset.tp5.repositories.RoleRepository;
import ma.enset.tp5.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public User addNewUser(User user) {

        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Role findRoleByRoleNAme(String roleNAme) {

        return roleRepository.findByRoleName(roleNAme);
    }


    @Override
    public User findUserByUserName(String userName) {

        return userRepository.findByUsername(userName);
    }


    @Override
    public void addRoleToUser(String username, String rolename) {

        User user = findUserByUserName(username);
        Role role = findRoleByRoleNAme(rolename);
        if (user.getRoles() != null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }

    }

    @Override
    public User autheticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user==null)
        {
            throw new RuntimeException("bad credentials!");
        }
        if(user.getPassword().equals(password))
        {
            return user;
        }
           throw new RuntimeException("bad credentials!");
    }


}
