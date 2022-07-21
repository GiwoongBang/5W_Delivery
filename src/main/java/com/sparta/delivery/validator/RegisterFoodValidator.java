package com.sparta.delivery.validator;

import com.sparta.delivery.dto.FoodRequestDto;
import com.sparta.delivery.model.Food;

import java.util.Optional;

public class RegisterFoodValidator {

    public static void validateFoodInput(FoodRequestDto requestDto) {

        //음식을 등록하는 메소드
        String name = requestDto.getName();
        int price = requestDto.getPrice();

        //유효성 검사
        if(name == requestDto.getName()) {
            throw new IllegalArgumentException("동일한 메뉴는 추가할 수 없습니다.");
        } else if (price < 100 || price > 1000000) {
            throw new IllegalArgumentException("음식 가격은 100원 이상 1,000,000원 이하로 입력해주세요.");
        } else if (price % 100 != 0) {
            throw new IllegalArgumentException("음식 가격은 100원 단위로 입력해주세요.");
        }
    }
}
