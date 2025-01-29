package dev.oltijanuzi.carhubushtrime.controller;

import dev.oltijanuzi.carhubushtrime.service.impls.CarServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CarServiceImplementation carServiceImplementation;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/cars")
    public String carsPage() {

        return "cars";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

//    @GetMapping("/loginn")
//    public String login() {
//        return "loginn";
//    }
}