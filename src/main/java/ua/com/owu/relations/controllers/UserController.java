package ua.com.owu.relations.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.owu.relations.dao.UserDAO;
import ua.com.owu.relations.models.Car;
import ua.com.owu.relations.models.Product;
import ua.com.owu.relations.models.User;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private UserDAO userDAO;

    @GetMapping("/save")
    public void save(){
        User user = new User();
        user.setName("Vasya");
        List<Product> productList= new ArrayList<>();
        productList.add(new Product("milk"));
        productList.add(new Product("abrikos"));
        user.setProducts(productList);
        userDAO.save(user);
    }
    @GetMapping("/saveCars")
    public void saveCars(){
        User user = new User("Anton");
        List<Car> cars =new ArrayList<>();
        cars.add(new Car("Subaru"));
        cars.add(new Car("Mersedes"));
        user.setCars(cars);
        userDAO.save(user);
    }
}
