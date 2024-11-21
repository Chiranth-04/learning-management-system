package com.gigasea.learning_management.controller;

import com.gigasea.learning_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    // Handle GET requests for the login page
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        // Clear any existing error messages
        model.addAttribute("error", null); // No error on page load
        return "login"; // Return the login.html template
    }

    // Handle POST requests for the login form
    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Model model) {
        boolean isAuthenticated = userService.authenticate(email, password);
        if (isAuthenticated) {
            return "redirect:/dashboard"; // Redirect to dashboard on successful login
        } else {
            // Set error message only if authentication fails
            model.addAttribute("error", "Invalid email or password");
            return "login"; // Return to login page with error message
        }
    }
}