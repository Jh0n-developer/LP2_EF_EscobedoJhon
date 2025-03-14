package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ProductoEntity;

public interface ProductoService {
	List<ProductoEntity>buscarTodosProductos();
	ProductoEntity buscarPorId(Integer id);
    void crearProducto(ProductoEntity producto);
    void actualizarProducto(ProductoEntity producto);
    void eliminarProducto(Integer id);
}
