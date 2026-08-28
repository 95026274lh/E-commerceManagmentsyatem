package com.jsp.E_commerceManagmentsyatem.service;

import com.jsp.E_commerceManagmentsyatem.dto.CartResponseDto;
import com.jsp.E_commerceManagmentsyatem.dto.CartRequestDto;
import com.jsp.E_commerceManagmentsyatem.entity.CartEntity;
import com.jsp.E_commerceManagmentsyatem.entity.ProductEntity;
import com.jsp.E_commerceManagmentsyatem.repository.CartRepository;
import com.jsp.E_commerceManagmentsyatem.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private  final CartRepository cartRepository;
    private  final ProductRepository productRepository;

    public ResponseEntity<CartResponseDto> Addproduct(Long productid, CartRequestDto cartRequestDto){

        ProductEntity productEntity=productRepository.findById(productid).orElseThrow( ()->new RuntimeException("invalid product id"));
        CartEntity cartEntity=new CartEntity();
        List<ProductEntity>products=new ArrayList<>();
        products.add(productEntity);
        cartEntity.setProducts(products);
        CartEntity save=cartRepository.save(cartEntity);
        CartResponseDto cartResponseDto=new CartResponseDto();
        cartResponseDto.setCartid(save.getCartid());
        cartResponseDto.setProductId(productEntity.getProductId());
        cartResponseDto.setProdname(productEntity.getProdname());
        cartResponseDto.setProdprice(productEntity.getProdprice());
        cartResponseDto.setProddescription(productEntity.getProddescription());
        return ResponseEntity.ok(cartResponseDto);
    }
    public ResponseEntity <List<CartEntity>>fetchall(){
        List<CartEntity> cart=cartRepository.findAll();
        return ResponseEntity.ok(cart);
    }
    public String Deleteall(){
        cartRepository.deleteAll();
        return " all products deleted sucessfully";
    }
}
