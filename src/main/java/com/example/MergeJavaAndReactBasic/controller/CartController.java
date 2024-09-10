package com.example.MergeJavaAndReactBasic.controller;

import com.example.MergeJavaAndReactBasic.dto.AddToCartDto;
import com.example.MergeJavaAndReactBasic.entity.Cart;
import com.example.MergeJavaAndReactBasic.service.CartService;
import com.example.MergeJavaAndReactBasic.service.CartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/${api.prefix}/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartServiceImpl cartService;

    @PostMapping("/add")
    public String addItemsToCart(@RequestBody AddToCartDto addToCartDto,
                                 @RequestParam String email){
        String response= cartService.addToCart( addToCartDto, email );
        return  response;
    }

    @GetMapping("/get")
    public Cart getCart(@RequestParam String email){
        Cart response= cartService.getCart( email );
        return  response;
    }
}
