package com.quiz.quiz.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre producto", nullable = false, length = 50)
    private String nombreProducto;
    
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    
    public Categoria(){

    }

    public Categoria(Long id, String nombreProducto, String descripcion) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
