package com.Nadir.cs393project.service;

import com.Nadir.cs393project.model.User;
import com.Nadir.cs393project.model.Comment;
import com.Nadir.cs393project.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    QuestionRepo orderRepo;
    public boolean save(User order){
        try {
            if (order.getProducts() == null) return false;
            for (Comment product : order.getProducts()) {
                product.addOrder(order);
            }
            order.getCustomer().addOrder(order);
            orderRepo.save(order);
            return true;
        }catch (Exception e){
            System.out.println(e.getCause());
            return false;
        }
    }

    public List<User> getById(int id){
        return orderRepo.getById(id);
    }
}
