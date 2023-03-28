package com.quiz.quiz.service;

import java.util.List;
import com.quiz.quiz.entity.Categoria;

public interface CategoriaServicio {
    
    public List<Categoria> listarTodasLasCategorias();

    public Categoria guardarCategoria(Categoria categoria);

    public Categoria obtenerCategoriaPorCodigo(Long id);

    public Categoria actualizarCategoria(Categoria categoria);

    public void eliminarCategoria(Long id);


}
