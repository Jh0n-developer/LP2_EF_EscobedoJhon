package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductoEntity;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<ProductoEntity> buscarTodosProductos() {
		return productoRepository.findAll();
	}

	@Override
	public ProductoEntity buscarPorId(Integer id) {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	public void crearProducto(ProductoEntity producto) {
		productoRepository.save(producto);
	}

	@Override
	public void actualizarProducto(ProductoEntity producto) {
		productoRepository.save(producto);
	}

	@Override
	public void eliminarProducto(Integer id) {
		productoRepository.deleteById(id);
	}

}
