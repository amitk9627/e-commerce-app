package com.ecom.order.service;

import com.ecom.order.dto.OrderRequestDto;
import com.ecom.order.model.Order;
import com.ecom.order.repository.OrderRepository;
import com.ecom.user.model.User;
import com.ecom.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
//    @Autowired
//    OrderRepository orderRepository;
    @Autowired
    UserService userService;

    public void createNewOrder(OrderRequestDto reqBody){

/*
* 1 - by finding the user -> get user object
* 2 calculate the total price -> by product
* 3 create order
*
*
*/
        User user= userService.findById(reqBody.getUserId());
        Order order = new Order();

//        reqBody.getOrderItems();
//        reqBody.getAddress();
//        reqBody.getPaymentStatus();
        order.setPaymentMethod(reqBody.getPaymentMethod());
        order.setAddress(reqBody.getAddress());
//        order.getTotalAmount();
        order.setUser(user);

//        order.setOrderItems([]);


//        return  order;

    }

}
