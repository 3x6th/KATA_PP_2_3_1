package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value = "/")
    public String printUsers(ModelMap model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "users";
    }

    @GetMapping(value = "/addNewUser")
    public String addNewUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "user-info";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/updateInfo/{id}")
    public String updateUser(ModelMap model, @PathVariable int id) {
        model.addAttribute("user", userService.getUser(id));
        return "user-info";
    }

    @PostMapping(value = "deleteUser/{id}")
    public String deleteUser(@PathVariable int id, ModelMap model) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
