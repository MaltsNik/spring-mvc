package com.nikita.javamaster.controller;

import com.nikita.javamaster.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class OrderController {
    private static Set<Order> orders = new HashSet<>();

    static {
        orders.add(new Order("iphone", 1234));
        orders.add(new Order("book", 4321));
        orders.add(new Order("chair", 2134));
        orders.add(new Order("table", 4567));
    }

    private static Set<Order> manageOrder(Order order) {
        if (order != null)
            orders.add(order);
        return orders;
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("orders", manageOrder(null));
        model.addAttribute("order", new Order());
        return "order.html";
    }

    @PostMapping("/createOrder")
    public String createOrder(@ModelAttribute Order order) {
        System.out.println("order is: " + order);
        manageOrder(order);
        return "redirect:/orders";
    }
}
