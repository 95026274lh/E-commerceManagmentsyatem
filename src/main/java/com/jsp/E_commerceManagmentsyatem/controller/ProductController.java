package com.jsp.E_commerceManagmentsyatem.controller;

import com.jsp.E_commerceManagmentsyatem.dto.ProductRequestDto;
import com.jsp.E_commerceManagmentsyatem.dto.ProductResponseDto;
import com.jsp.E_commerceManagmentsyatem.entity.ProductEntity;
import com.jsp.E_commerceManagmentsyatem.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private  final ProductService productService;
    @PostMapping
    public ResponseEntity<ProductResponseDto> CreateProduct(@Valid @RequestBody ProductRequestDto productRequestDto){
        return productService.CreateProduct(productRequestDto);
    }
    @GetMapping("/all")
    public ResponseEntity<List<ProductEntity>> fetchallproducts(){
        return productService.fetchallproducts();
    }
    @GetMapping("/{prodid}")
    public ResponseEntity<ProductResponseDto> fetchbyid(@Valid @PathVariable @RequestBody Long prodid){
        return productService.fetchbyid(prodid);
    }
    @PutMapping("/{prodid}")
    public ResponseEntity<ProductResponseDto> Update(@Valid @PathVariable Long prodid,@RequestBody ProductRequestDto productRequestDto){
        return productService.Update(prodid,productRequestDto);

    }
    @DeleteMapping("/{proid}")
    public ResponseEntity<String> deletebyid(@Valid @PathVariable Long proid) {
        return productService.deletebyid(proid);
    }
}
