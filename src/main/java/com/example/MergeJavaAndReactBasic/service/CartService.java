package com.example.MergeJavaAndReactBasic.service;

import com.example.MergeJavaAndReactBasic.dto.AddToCartDto;
import com.example.MergeJavaAndReactBasic.entity.Cart;
import com.example.MergeJavaAndReactBasic.entity.User;

public interface CartService {

    Cart createCart(User user);


}
