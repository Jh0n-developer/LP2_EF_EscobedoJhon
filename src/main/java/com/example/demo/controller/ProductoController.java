package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.ProductoEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.service.CategoriaService;
import com.example.demo.service.ProductoService;
import com.example.demo.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductoController {
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ProductoService productoService;
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/menu")
	public String showMenu(HttpSession session, Model model) {
	    if (session.getAttribute("usuario") == null) {
	        return "redirect:/";
	    }

	    String correo = session.getAttribute("usuario").toString();
	    UsuarioEntity usuarioEntity = usuarioService.buscarUsuarioPorCorreo(correo);
	    model.addAttribute("usuario", usuarioEntity);

	    List<ProductoEntity> productos = productoService.buscarTodosProductos();
	    model.addAttribute("productos", productos);

	    return "menu";
	}
	
	@GetMapping("/agregar")
	public String showAgregarProductoForm(Model model) {
	    model.addAttribute("producto", new ProductoEntity());
	    model.addAttribute("categorias", categoriaService.buscarTodasCategorias()); 
	    return "agregar_producto";
	}

    @PostMapping("/agregar")
    public String agregarProducto(ProductoEntity producto) {
        productoService.crearProducto(producto);
        return "redirect:/menu";
    }
    
    @GetMapping("/actualizar/{id}")
    public String showActualizarProductoForm(@PathVariable Integer id, Model model) {
        ProductoEntity producto = productoService.buscarPorId(id);
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaService.buscarTodasCategorias()); 
        return "actualizar_producto";
    }

    @PostMapping("/actualizar")
    public String actualizarProducto(ProductoEntity producto) {
        productoService.actualizarProducto(producto);
        return "redirect:/menu";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
        return "redirect:/menu";
    }
}
