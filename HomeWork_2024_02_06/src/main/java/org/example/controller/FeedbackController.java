package org.example.controller;

import org.example.entity.Product;
import org.example.entity.Store;
import org.example.entity.User;
import org.example.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FeedbackController {

    private final User currentUser;
    private final Store store;
    private final FeedbackService feedbackService;
    @Autowired
    public FeedbackController(Store store) {
        this.store = store;
        this.feedbackService = new FeedbackService(store);
        this.currentUser = new User();
    }

    @GetMapping()
    public String getMenu(Model model){
        model.addAttribute("products", store.getListProduct());
        model.addAttribute("currentUser", currentUser.getName());
        return  "/index";
    }

    @GetMapping("/store/{id}")
    public String getProduct(@PathVariable("id") int id, Model model){
        Product product = store.getProduct(id);
        model.addAttribute("product", product);
        model.addAttribute("avgRating", feedbackService.getAvgRatingInfo(product));
        model.addAttribute("feedbacks", feedbackService.getFeedbacks(product));
        return "/product";
    }

    @GetMapping("/feedback/{id}")
    public String newFeedback(@PathVariable("id") int id, Model model){
        Product product = store.getProduct(id);
        model.addAttribute("product", product);
        model.addAttribute("user", currentUser);
        return "/feedback";
    }

    @PostMapping("/product/{id}")
    public String createFeedback(@PathVariable("id") int id, @ModelAttribute("rate") Integer rate,
                                 @ModelAttribute("message") String message){
        Product product = store.getProduct(id);
        feedbackService.addFeedback(product, currentUser, rate, message);
        return "redirect:/store/{id}";
    }
}
