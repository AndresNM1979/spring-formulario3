package com.learn.springbootkubernetes.modelo;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	@NotNull
    @Length(min=5, max=24)
    private String nombre;
	@NotNull
    @Length(min=10, max=24)
    private String password;
	@NotNull
    @Email
    private String email;
 
    public Usuario() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    public Usuario(String nombre, String password, String email) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
}
