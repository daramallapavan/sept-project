package com.example.MergeJavaAndReactBasic.service;

import com.example.MergeJavaAndReactBasic.entity.CartItem;
import com.example.MergeJavaAndReactBasic.entity.OrderItem;
import com.example.MergeJavaAndReactBasic.entity.Orders;
import com.example.MergeJavaAndReactBasic.entity.User;
import com.example.MergeJavaAndReactBasic.repository.OrderRepository;
import com.example.MergeJavaAndReactBasic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl  implements OrderService{

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    @Override
    public Orders createOrder(String email) {

       User user= userRepository.findByEmail( email )
                .orElseThrow(()-> new RuntimeException("User not found"));

      Set<CartItem> cartItemList= user.getCart().getCartItems();

      for (CartItem cartItem:cartItemList){
          OrderItem orderItem=new OrderItem();

      }

        return null;
    }
}
