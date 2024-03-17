package com.worcester.neighbor.nourish.controller;

import com.worcester.neighbor.nourish.dto.FoodInfo;
import com.worcester.neighbor.nourish.dto.ViewResponse;
import com.worcester.neighbor.nourish.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.View;
import java.util.List;

@RestController
@RequestMapping("/view")
@CrossOrigin(origins = "*")
public class ViewFood {
    private final ViewService viewService;

    @Autowired
    public ViewFood(ViewService viewService) {
        this.viewService = viewService;
    }

    @GetMapping
    public ViewResponse view() {
        List<FoodInfo> allFoodInfo = viewService.viewFood();
        ViewResponse viewResponse = new ViewResponse();
        if (allFoodInfo != null) {
            viewResponse.setFoods(allFoodInfo);
        } else {
            viewResponse.setSuccess(false);
        }
        return viewResponse;
    }
}
