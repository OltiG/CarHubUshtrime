package dev.oltijanuzi.carhubushtrime.controller;

import dev.oltijanuzi.carhubushtrime.dto.UserLoginDto;
import dev.oltijanuzi.carhubushtrime.dto.UserRegisterDto;
import dev.oltijanuzi.carhubushtrime.exceptions.EmailExistsException;
import dev.oltijanuzi.carhubushtrime.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/loginn")
    public String showLogin(Model model) {
        model.addAttribute("userLoginDto", new UserLoginDto());
        model.addAttribute("userRegisterDto", new UserRegisterDto());
        return "loginn";
    }

    @PostMapping("/loginn")
    public String login(@Valid @ModelAttribute("userLoginDto") UserLoginDto userLoginDto,
                        BindingResult bindingResult,
                        @RequestParam(value = "returnUrl", required = false) String returnUrl,
                        Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("userRegisterDto", new UserRegisterDto());
            return "loginn";
        }

        try {
            var userDto = userService.login(userLoginDto.getEmail(), userLoginDto.getPassword());
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("loginError", "Invalid credentials");
            model.addAttribute("userRegisterDto", new UserRegisterDto());
            return "loginn";
        }
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("userRegisterDto") UserRegisterDto userRegisterDto,
                           BindingResult bindingResult,
                           Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("userLoginDto", new UserLoginDto());
            return "loginn";
        }

        try {
            userService.register(userRegisterDto);
            return "redirect:/loginn?registered=true";
        } catch (Exception e) { // Generic exception handler
            model.addAttribute("error", "Registration failed: " + e.getMessage());
            model.addAttribute("userLoginDto", new UserLoginDto());
            return "loginn";
        }
    }

}
