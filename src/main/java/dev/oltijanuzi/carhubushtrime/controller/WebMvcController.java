package dev.oltijanuzi.carhubushtrime.controller;

import dev.oltijanuzi.carhubushtrime.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class WebMvcController {

    private final CarService carService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("featuredCars", carService.getFeaturedCars(4));
        return "index";
    }

    @GetMapping("/cars")
    public String carsPage(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "cars";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}