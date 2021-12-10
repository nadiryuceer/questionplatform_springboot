package com.Nadir.cs393project.service;

import com.Nadir.cs393project.dao.ShopDAO;
import com.Nadir.cs393project.dao.ShopDAOImpl;
import com.Nadir.cs393project.model.Tag;
import com.Nadir.cs393project.model.Comment;
import com.Nadir.cs393project.model.Answer;
import com.Nadir.cs393project.repo.TagRepo;
import com.Nadir.cs393project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService{
    @Autowired
    UserRepo shopRepo;
    @Autowired
    TagRepo productRepo;
    public boolean save(Answer shop) {
        try {
            if (shop.getCustomers() != null) {
                for (Tag customer : shop.getCustomers()) {
                    customer.setBank(shop);
                }
            }
            if (shop.getProducts() != null) {
                for (Comment product : shop.getProducts()) {
                    product.setShop(shop);
                }
            }
            shopRepo.save(shop);
            return true;
        } catch (Exception e){
            System.out.println(e.getCause());
            return false;
        }

    }
    public List<Answer> getByName(String name){
        return shopRepo.getByName(name);
    }
    public List<Answer> getAll(){
        List<Answer> shops = shopRepo.getAll();
        for(Answer shop : shops){
            shop.setCustomers(null);
            shop.setProducts(null);
        }
        return shops;
    }
    public Answer create(String name){
        Answer shop = new Answer();
        shop.setName(name);
        shopRepo.save(shop);
        return shop;
    }
    public void delete(int id){
        shopRepo.deleteById(id);
    }
    public Answer getWithProductsGreaterThanX(int id, double price) throws NullPointerException{
        Answer shop = shopRepo.getShopById(id);
        List<Comment> products = productRepo.getWithShopIdandGreaterThanX(id,price);
        for(Comment product : products){
            product.setShop(null);
        }
        shop.setProducts(products);
        shop.setCustomers(null);
        return shop;
    }

    @Override
    public Answer getShopById(int id) {
        return shopRepo.getShopById(id);
    }
}
