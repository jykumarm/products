package com.sample.products.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.products.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;


@Component
@RequiredArgsConstructor
@Slf4j
public class ProductsLocalRepository {


    @Value("classpath:/data/Products.json")
    private Resource resource;

    private final ObjectMapper objectMapper;

    private List<Product> products;

    @PostConstruct
    private void loadResource() throws IOException {

        var resourceInputStream  = resource.getInputStream();
        var data = objectMapper.readTree(resourceInputStream);
        products = objectMapper.readValue(data.get("products").toString(), new TypeReference<>() {
        });
        log.info("{} Products details are loaded.. ", products.size());
    }

    public List<Product> getProducts(){
        return products;
    }


}
