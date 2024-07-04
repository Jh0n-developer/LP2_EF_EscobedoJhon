package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_producto")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProducto", columnDefinition = "INT")
	private Integer idProducto;
	
	@Column(name = "nombreProducto", columnDefinition = "VARCHAR(100)", nullable = false)
	private String nombreProducto;
	
	@Column(name = "precio", columnDefinition = "DECIMAL(10, 2)", nullable = false)
	private Double precio;
	
	@Column(name = "stock", columnDefinition = "INT", nullable = false)
	private Integer stock;
	
	@ManyToOne
	@JoinColumn(name = "idCategoria", columnDefinition = "INT", nullable = false)
	private CategoriaEntity categoriaEntity;
}
