package com.javafullstackcourse.palindrome_checker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class PalindromeController {

    @GetMapping("/palindrome")
    public String checkIfPalindrome(@RequestParam(name="input", required = false, defaultValue = "") String s, Model model) {
        String[] elements = s.split(" ");

        HashMap<String, Boolean> checkedElements = new HashMap<>();

        for (String string : elements) {
            checkedElements.put(string, isPalindrome(string.toLowerCase()));
        }

        model.addAttribute("elements", checkedElements);

        return "Palindrome";
    }

    private static boolean isPalindrome(String input) {
        // The input is a substring of the characters between i and j
        StringBuilder plain = new StringBuilder(input);

        // The reversed form of the above
        StringBuilder reverse = plain.reverse();

        // Returns true if the string is a palindrome
        return (reverse.toString()).equals(input);
    }
}
