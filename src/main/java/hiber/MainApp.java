package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Objects;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car car = new Car("Toyota", 5);

//        userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Nissan", 4)));
//        userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Toyota", 5)));
//        userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Mitsubishi", 6)));
//        userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("BMW", 7)));

        List<User> users = userService.listUsers();

        for (User user : users) {
            if (Objects.equals(user.getCar().getModel(), car.getModel())) {
                System.out.println(user);
                System.out.println();
            }
        }

        User user = userService.GetUserByCar(car);

        if (user != null) {
            System.out.println(user);
        }

        context.close();
    }
}
