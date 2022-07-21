package com.sparta.delivery.service;

import com.sparta.delivery.dto.RestaurantRequestDto;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.RestaurantRepository;
import com.sparta.delivery.validator.RegisterRestaurantValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();

        return restaurants;
    }


    public Restaurant registerRestaurant(RestaurantRequestDto requestDto) {
        // 음식점 유효성 검사
        RegisterRestaurantValidator.validateRestaurantInput(requestDto);

        // 통과시 저장
        Restaurant restaurant = new Restaurant(requestDto);
        restaurantRepository.save(restaurant);

        return restaurant;
    }

}