package com.codessquad.qna.user.ui;

import com.codessquad.qna.user.application.UserService;
import com.codessquad.qna.user.domain.User;
import com.codessquad.qna.user.dto.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.codessquad.qna.common.HttpSessionUtils.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String create(@Valid UserRequest userRequest) {
        userService.save(userRequest);
        return "redirect:/users";
    }

    @PostMapping("login")
    public String login(String userId, String password, HttpSession session) {
        User user = userService.login(userId, password);
        setUserAttribute(user, session);
        return "redirect:/";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        clearSession(session);
        return "redirect:/";
    }


    @GetMapping
    public String getList(Model model) {
        model.addAttribute("users", userService.getList());
        return "user/list";
    }

    @GetMapping("{id}")
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "user/profile";
    }

    @GetMapping("{id}/form")
    public String getForm(@PathVariable Long id, Model model, HttpSession session) {
        checkAuthorization(id, session);
        model.addAttribute("user", userService.get(id));
        return "user/updateForm";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @Valid UserRequest userRequest, HttpSession session) {
        checkAuthorization(id, session);
        userService.update(id, userRequest);
        return "redirect:/users";
    }
}
