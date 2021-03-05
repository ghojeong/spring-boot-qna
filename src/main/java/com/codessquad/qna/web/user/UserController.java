package com.codessquad.qna.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserMapper userMapper = new UserMapper();

    @PostMapping("/user/create")
    public String user_create(User user) {
        userMapper.add(user);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String user_list(Model model) {
        model.addAttribute("users", userMapper.getUsers());
        return "user/list";
    }

    @GetMapping("/users/{userId}")
    public String user_profile(@PathVariable("userId") String userId, Model model) {
        model.addAttribute("user", userMapper.getUser(userId));
        return "user/profile";
    }

    @GetMapping("/users/{userId}/form")
    public String user_form(@PathVariable("userId") String userId, Model model) {
        model.addAttribute("user", userMapper.getUser(userId));
        return "user/updateForm";
    }

    @PostMapping("/users/{userId}/update")
    public String user_update(@PathVariable("userId") String userId, User user) {
        userMapper.update(userId, user);
        return "redirect:/users";
    }
}
