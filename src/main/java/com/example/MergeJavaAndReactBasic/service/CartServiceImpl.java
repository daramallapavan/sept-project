package com.example.MergeJavaAndReactBasic.service;

import com.example.MergeJavaAndReactBasic.dto.AddToCartDto;
import com.example.MergeJavaAndReactBasic.entity.Cart;
import com.example.MergeJavaAndReactBasic.entity.CartItem;
import com.example.MergeJavaAndReactBasic.entity.Product;
import com.example.MergeJavaAndReactBasic.entity.User;
import com.example.MergeJavaAndReactBasic.repository.CartItemRepository;
import com.example.MergeJavaAndReactBasic.repository.CartRepository;
import com.example.MergeJavaAndReactBasic.repository.ProductRepository;
import com.example.MergeJavaAndReactBasic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    private final CartItemRepository cartItemRepository;
    @Override
    public Cart createCart(User user) {
        Cart cart=new Cart();
        cart.setUser( user );
       return cartRepository.save( cart );

    }

    public String addToCart(AddToCartDto addToCartDto,String email){

      Product product= productRepository.findById( addToCartDto.getProductId() )
                .orElseThrow(()-> new RuntimeException("Product Not Found"));


      User user=userRepository.findByEmail(email)
              .orElseThrow(()->new RuntimeException("User Not Found"));

      Cart cart=user.getCart();
        Set<CartItem> savedCartItem =
                user.getCart().getCartItems();

        CartItem cartItem=new CartItem();
        cartItem.setProduct( product );
        cartItem.setCart(cart );
        cartItem.setQuantity( addToCartDto.getQuantity() );
        cartItem.setUnitPrice( product.getPrice() );
        cartItem.setTotalPrice( product.getPrice());


        cartItemRepository.save( cartItem );

        savedCartItem.add(cartItem  );

        return "Product added to Cart";
    }

    public Cart getCart(String email){
        return cartRepository.findByUserEmail(email);
    }


}
