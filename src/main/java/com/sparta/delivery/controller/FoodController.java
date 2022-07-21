package com.sparta.delivery.controller;

import com.sparta.delivery.dto.FoodRequestDto;
import com.sparta.delivery.model.Food;
import com.sparta.delivery.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @GetMapping("/restaurants/{restaurantId}/foods")
    public List<Food> getFoods() {
        List<Food> foods = foodService.getFoods();

        return foods;
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public Food registerFood(@RequestBody FoodRequestDto requestDto) {
        Food food = foodService.registerFood(requestDto);

        return food;
    }

}