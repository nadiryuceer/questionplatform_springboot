package com.Nadir.cs393project.service;

import com.Nadir.cs393project.model.Tag;
import com.Nadir.cs393project.model.User;
import com.Nadir.cs393project.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CommentRepo customerRepo;
    @Autowired
    QuestionService addressService;
    public boolean save(Tag customer) {
        try {
            if (customer.getOrders() != null) {
                for (User temp : customer.getOrders()) {
                    temp.setCustomer(customer);
                }
            }
            addressService.save(customer.getAddress());
            customerRepo.save(customer);
            return true;
        }catch (Exception e){
            System.out.println(e.getCause());
            return false;
        }
    }

    public List<Tag> findByFirstName(String firstName){
        return customerRepo.findByFirstName(firstName);
    }
    public List<Tag> findByLastName(String lastName){
        return customerRepo.findByLastName(lastName);
    }
    public List<Tag> findByFirstAndLastName(String firstName, String lastName){
        return customerRepo.findByFirstNameAndLastName(firstName,lastName);
    }
}
