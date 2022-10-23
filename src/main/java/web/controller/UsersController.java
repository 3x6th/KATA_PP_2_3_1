package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/")
public class UsersController {

    private final UserServiceImpl userService;

    public UsersController(UserServiceImpl userService) {
        this.userService = userService;
    }

//    @GetMapping(value = "/")
//    public String printWelcome(ModelMap model) {
//        List<String> messages = new ArrayList<>();
//        messages.add("Hello!");
//        model.addAttribute("messages", messages);
//        return "index";
//    }

//    @GetMapping(value = "/create")
//    public String create(ModelMap model) {
//        List<String> messages = new ArrayList<>();
//        messages.add("Create page!");
//        model.addAttribute("messages", messages);
//        return "create";
//    }

    @GetMapping(value = "/")
    public String printUsers(ModelMap model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "users";
    }
}
