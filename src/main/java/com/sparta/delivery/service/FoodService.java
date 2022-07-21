package com.sparta.delivery.service;

import com.sparta.delivery.dto.FoodRequestDto;
import com.sparta.delivery.model.Food;
import com.sparta.delivery.repository.FoodRepository;
import com.sparta.delivery.repository.RestaurantRepository;
import com.sparta.delivery.validator.RegisterFoodValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public List<Food> getFoods() {
        List<Food> foods = foodRepository.findAll();

        return foods;
    }

    public Food registerFood(FoodRequestDto requestDto) {

        //음식 유효성 검사
        RegisterFoodValidator.validateFoodInput(requestDto);

        //통과시 저장
        Food food = new Food(requestDto);
        foodRepository.save(food);

        return food;
    }

}