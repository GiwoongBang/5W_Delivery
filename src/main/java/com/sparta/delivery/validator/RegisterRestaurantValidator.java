package com.sparta.delivery.validator;

import com.sparta.delivery.dto.RestaurantRequestDto;
import org.springframework.stereotype.Component;

@Component
public class RegisterRestaurantValidator {

    public static void validateRestaurantInput(RestaurantRequestDto requestDto) {
        // 음식점을 등록하는 메소드
        int minOrderPrice = requestDto.getMinOrderPrice();
        int deliveryFee = requestDto.getDeliveryFee();

        // 유효성 검사
        if (minOrderPrice < 1000 || minOrderPrice > 100000) {
            throw new IllegalArgumentException("최소주문금액은 1,000원 이상 100,000원 이하로 입력해주세요.");
        } else if (minOrderPrice % 100 != 0) {
            throw new IllegalArgumentException("최소 입력단위는 100원입니다.");
        } else if (deliveryFee < 0 || deliveryFee > 10000) {
            throw new IllegalArgumentException("배달비는 0원 이상 10,000원 이하로 입력해주세요.");
        } else if (deliveryFee % 500 != 0) {
            throw new IllegalArgumentException("배달비는 500원 단위로 입력해주세요.");
        }
    }

}
