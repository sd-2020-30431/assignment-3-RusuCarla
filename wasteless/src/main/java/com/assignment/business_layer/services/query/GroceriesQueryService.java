package com.assignment.business_layer.services.query;

import com.assignment.presentation_layer.dto.*;
import com.assignment.persistence_layer.repository.LoginRepository;
import com.assignment.persistence_layer.repository.*;
import com.assignment.business_layer.entity.Groceries;
import com.assignment.business_layer.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service
public class GroceriesQueryService {
    @Autowired
    GroceriesRepository groceriesRepository;
    @Autowired
    LoginRepository loginRepository;

    @Transactional
    public ArrayList<GroceriesDto>  getGroceries(int id) {
        ArrayList<GroceriesDto> groceriesDtos = new ArrayList<GroceriesDto>();
        Login login = loginRepository.findById(id);
        for (Groceries g : login.getGroceryLists()) {
            groceriesDtos.add(new GroceriesDto(g.getName(),g.getQuantity(),g.getCalories(),g.getPurchase_date(),
                    g.getExpiration_date(),g.getConsumption_date(),g.computeBurndownRate()));
        }
        return groceriesDtos;
    }

    public ArrayList<Integer> getBurndownRates(int id){
        Login login = loginRepository.findById(id);
        ArrayList<Integer> rates = new ArrayList<>();
        for (Groceries g : login.getGroceryLists()) {
            rates.add(g.computeBurndownRate());
        }
        return rates;
    }

}
