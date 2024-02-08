package org.example.service;

import org.example.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FeedbackService {
    private final FeedbackLog feedbackLog;

    public FeedbackService(Store store) {
        this.feedbackLog = new FeedbackLog(store);
    }


    public List<Feedback> getFeedbacks(Product product) {
        return feedbackLog.getFeedbackList(product);
    }

    public String getAvgRatingInfo(Product product) {
        AtomicInteger sumRating = new AtomicInteger(0);
        AtomicInteger countRating = new AtomicInteger(0);

        List<Feedback> feedbackList = feedbackLog.getFeedbackList(product);
        feedbackList.forEach(f-> {
            if (f.getRate()>0) {
                sumRating.addAndGet(f.getRate());
                countRating.addAndGet(1);
            }
        });
        double result = sumRating.get()/(double)countRating.get();
        return "Average rating of product based on " + countRating + " reviews: " + String.format("%.2f.",result);
    }

    public void addFeedback(Product product, User user, Integer rate, String message){

        feedbackLog.addFeedbackToList(product, user, rate, message);
    }
}
