package ma.enset.tp5;

import ma.enset.tp5.entities.Role;
import ma.enset.tp5.entities.User;
import ma.enset.tp5.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class TP5Application {

    public static void main(String[] args) {
        SpringApplication.run(TP5Application.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService)
    {
        return args -> {
            User user = new User();
            user.setUsername("user");
            user.setPassword("1234");
            userService.addNewUser(user);

            User user1 = new User();
            user1.setUsername("admin");
            user1.setPassword("1234");
            userService.addNewUser(user1);

            Stream.of("STUDENT","USER","ADMIN").forEach(rL->{
                Role role = new Role();
                role.setRoleName(rL);
                userService.addNewRole(role);
            });


            userService.addRoleToUser("user","STUDENT");
            userService.addRoleToUser("user","USER");
            userService.addRoleToUser("admin","USER");
            userService.addRoleToUser("admin","ADMIN");

            try {
                User user2 = userService.autheticate("user","1234");
                System.out.println("user : ");
                System.out.println(user2.getUserId());
                System.out.println(user2.getUsername());
                System.out.println("roles : ");
                user2.getRoles().forEach(rl->{
                    System.out.println("Role => "+rl.toString());
                });
            }
            catch (Exception e)
            {

            }
        };
    }
}
