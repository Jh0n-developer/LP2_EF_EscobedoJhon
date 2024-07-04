package com.example.demo.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {
	
	@Id
	@Column(name = "correo", columnDefinition = "VARCHAR(100)", nullable = false)
	private String correo;
	
	@Column(name = "password", columnDefinition = "VARCHAR(100)", nullable = false)
	private String password;
	
	@Column(name = "nombres", columnDefinition = "VARCHAR(100)", nullable = false)
	private String nombres;
	
	@Column(name = "apellidos", columnDefinition = "VARCHAR(100)", nullable = false)
	private String apellidos;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaNacimiento", columnDefinition = "DATE", nullable = false)
	private Date fechaNacimiento;
	
	@Column(name = "urlFotoPerfil", columnDefinition = "VARCHAR(100)", nullable = false)
	private String urlFotoPerfil;
}
