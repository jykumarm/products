package com.sample.products.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.products.model.ProductDTO;
import com.sample.products.repository.ProductsLocalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductsLocalRepository productsLocalRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<ProductDTO> getProducts(){
        List<ProductDTO> list = objectMapper.convertValue(productsLocalRepository.getProducts(), new TypeReference<>(){});
        return list;
    }

}
