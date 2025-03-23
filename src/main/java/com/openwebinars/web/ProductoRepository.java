package com.openwebinars.web;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoRepository {
    public List<Producto> findAll(){
        return List.of(
                new Producto(1L, "Laptop", 1200.99, false),
                new Producto(2L, "Laptop", 1200.99, true),
                new Producto(3L, "Laptop", 1200.99, false),
                new Producto(4L, "Laptop", 1200.99, true),
                new Producto(5L, "Laptop", 1200.9,true),
                new Producto(6L, "Laptop", 1200.99, false)
        );
    }
}
