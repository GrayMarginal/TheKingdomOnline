package ru.kingdom.online.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kingdom.online.CurrentUser;
import ru.kingdom.online.entities.User;
import ru.kingdom.online.repositories.UserRepository;

import javax.jws.WebMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthorizationController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signin(Model model, HttpServletRequest req){
        if(req.getParameter("email")!=null && req.getParameter("password")!=null){
            //User user = new User(req.getParameter("email"), req.getParameter(req.getParameter("password")));
            User user = userRepository.findByEmail(req.getParameter("email"));
            if(user!=null) {
                if (user.getPassword().equals(req.getParameter("password"))) {
                    model.addAttribute("result", "true");
                    CurrentUser.setEmail(user.getEmail());
                    CurrentUser.setId(user.getId());
                    return "pages\\index";
                } else {
                    model.addAttribute("result", "false");
                }
            }else {
                model.addAttribute("result", "false");
            }
        }
        return "pages\\authorization";
    }
}
