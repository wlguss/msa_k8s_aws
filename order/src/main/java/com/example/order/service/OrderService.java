package com.example.order.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.order.dao.OrderRepository;
import com.example.order.domain.dto.OrderRequestDTO;
import com.example.order.domain.dto.OrderResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final ProductOpenFeignService   productOpenFeignService ; 
    private final OrderRepository           orderRepository;

    public OrderResponseDTO orderFeignKafkaCreate(OrderRequestDTO request, String email) {
        System.out.println(">>>> order service orderFeignKafkaCreate ");
        System.out.println(">>>> 재고 유무 판단을 위해서 product-service Feign 통신");
        productOpenFeignService.getProductId(request.getProductId(), email);
        return null ;
    }
}
