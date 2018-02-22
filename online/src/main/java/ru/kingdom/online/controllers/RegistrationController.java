package ru.kingdom.online.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kingdom.online.entities.User;
import ru.kingdom.online.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(HttpServletRequest req, Model model){
        if(req.getParameter("email")!=null && req.getParameter("password")!=null){
            String email = req.getParameter("email");
            String pass = req.getParameter("password");
            User user = userRepository.findByEmail(email);
            if(user==null){
                user = new User(email, pass);
                userRepository.save(user);
                return "pages\\registration";
            }else {
                model.addAttribute("status", "Такой пользователь уже зарегистрирован!");
            }
        }
        return "pages\\registration";
    }
}
