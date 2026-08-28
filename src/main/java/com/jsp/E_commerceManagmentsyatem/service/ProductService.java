package com.jsp.E_commerceManagmentsyatem.service;

import com.jsp.E_commerceManagmentsyatem.dto.ProductRequestDto;
import com.jsp.E_commerceManagmentsyatem.dto.ProductResponseDto;
import com.jsp.E_commerceManagmentsyatem.entity.OrderEntity;
import com.jsp.E_commerceManagmentsyatem.entity.ProductEntity;
import com.jsp.E_commerceManagmentsyatem.repository.OrderRepository;
import com.jsp.E_commerceManagmentsyatem.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private  final OrderRepository orderRepository;

    public ResponseEntity<ProductResponseDto> CreateProduct(ProductRequestDto productRequestDto){
        OrderEntity order=orderRepository.findById(productRequestDto.getOrderId()).orElseThrow( ()->new RuntimeException("invalid order id"));
        ProductEntity productEntity=new ProductEntity();
        productEntity.setProdname(productRequestDto.getProdname());
        productEntity.setProdprice(productRequestDto.getProdprice());
        productEntity.setProddescription(productRequestDto.getProddescription());
        productEntity.setOrder(order);

        ProductEntity saveprod=productRepository.save(productEntity);
        ProductResponseDto productResponseDto=new ProductResponseDto();
        productResponseDto.setProductId(saveprod.getProductId());
        productResponseDto.setProdname(saveprod.getProdname());
        productResponseDto.setProdprice(saveprod.getProdprice());
        productResponseDto.setProddescription(saveprod.getProddescription());
        productResponseDto.setOrderId((long) saveprod.getOrder().getOrdid());
        return ResponseEntity.ok(productResponseDto);
    }
    public ResponseEntity<List<ProductEntity>> fetchallproducts(){
        List<ProductEntity>  products=productRepository.findAll();

        return ResponseEntity.status(HttpStatus.FOUND).body(products);
    }
    public ResponseEntity<ProductResponseDto> fetchbyid(Long prodid){
        ProductEntity productEntity=productRepository.findById(prodid).orElseThrow(()->new RuntimeException("invalid id"));
        ProductResponseDto productResponseDto=new ProductResponseDto();
        productResponseDto.setProductId(productEntity.getProductId());
        productResponseDto.setProdname(productEntity.getProdname());
        productResponseDto.setProdprice(productEntity.getProdprice());
        productResponseDto.setProddescription(productEntity.getProddescription());
        if(productEntity.getOrder()!=null){
            productResponseDto.setOrderId((long) productEntity.getOrder().getOrdid());}
        return ResponseEntity.status(HttpStatus.FOUND).body(productResponseDto);

    }
    public ResponseEntity<ProductResponseDto> Update(Long prodid,ProductRequestDto productRequestDto){
        ProductEntity productEntity=productRepository.findById(prodid).orElseThrow(()->new RuntimeException("invalid product name"));

        if (productRequestDto.getProdname()!=null)
            productEntity.setProdname(productRequestDto.getProdname());
        if(productRequestDto.getProdprice()!=null)
        productEntity.setProdprice(productRequestDto.getProdprice());
        if(productRequestDto.getProddescription()!=null)
        productEntity.setProddescription(productRequestDto.getProddescription());
//        productEntity.setOrder(productEntity.getOrder());

        ProductEntity save=productRepository.save(productEntity);
        ProductResponseDto productResponseDto=new ProductResponseDto();
        productResponseDto.setProductId(productEntity.getProductId());
        productResponseDto.setProdname(productEntity.getProdname());
        productResponseDto.setProdprice(productEntity.getProdprice());
        productResponseDto.setProddescription(productEntity.getProddescription());
        if(productEntity.getOrder()!=null){
            productResponseDto.setOrderId((long) productEntity.getOrder().getOrdid());}
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);



    }

    public ResponseEntity<String> deletebyid(Long proid) {
         productRepository.deleteById(proid);

        return ResponseEntity.ok("product deleted sucessfully");
    }
}
