package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.repository.UserRepository;

@RestController
public class TestController {

    @Autowired
    UserRepository employeeRepository;

    @GetMapping("/test")
    public String test() {
        long count = employeeRepository.count(); // Hibernate DOIT accéder à la DB => tables créées
        return "OK = " + count;
    }
}

