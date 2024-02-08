package org.example.entity;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class FeedbackLog {
    private final Random rnd = new Random();
    private List<Feedback> feedbackList;

    public FeedbackLog(Store store) {
        this.feedbackList = new ArrayList<>();
        List<Product> products = store.getListProduct();
        for (int i = 0; i < products.size(); i++) {
            for (int j = 0; j < 10; j++) {
                feedbackList.add(new Feedback(products.get(i),new User(), rnd.nextInt(0,6),
                        "Excellent product"));
            }
        }
    }

    public List<Feedback> getFeedbackList(Product product) {
        return feedbackList.stream().filter(f-> f.getProduct()==product).collect(Collectors.toList());
    }

    public void addFeedbackToList(Product product, User user, Integer rate, String message) {
        this.feedbackList.add(new Feedback(product, user, rate, message));
    }


}
