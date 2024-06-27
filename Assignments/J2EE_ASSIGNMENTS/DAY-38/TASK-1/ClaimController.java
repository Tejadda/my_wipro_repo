package com.example.demo1;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class ClaimController {
    @PostMapping("/submitClaim")
    public String submitClaim(@Valid @ModelAttribute Claim claim, BindingResult result) {
        if (result.hasErrors()) {
            return "claimForm"; // return to the form page with errors
        }
        // process the claim and redirect to a success page
        return "redirect:/claimSubmitted";
    }
}
