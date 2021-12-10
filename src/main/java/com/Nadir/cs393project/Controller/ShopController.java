package com.Nadir.cs393project.Controller;

import com.Nadir.cs393project.Exception.ShopNotFoundException;
import com.Nadir.cs393project.model.Answer;
import com.Nadir.cs393project.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ShopController {
    @Autowired
    ShopService shopService;

    @GetMapping(value = "/shop")
    public List<Answer> getAll(){
        return shopService.getAll();
    }
    @PostMapping(value = "/shop", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Answer create(@RequestBody Map<String,String> input){
        return shopService.create(input.get("name"));
    }
    @DeleteMapping(value = "/shop/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") int id){
        shopService.delete(id);
    }
    @GetMapping(value = "/shop/{id}/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Answer getWithProductsGreaterThanX(@PathVariable("id") int id, @RequestBody Map<String, Double> input){
        try{
            return shopService.getWithProductsGreaterThanX(id,input.get("price"));
        } catch(NullPointerException e){
            throw new ShopNotFoundException("Shop not found with id:"+id);
        }

    }

}
