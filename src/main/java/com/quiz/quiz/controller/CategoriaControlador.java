package com.quiz.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.quiz.quiz.entity.Categoria;
import com.quiz.quiz.service.CategoriaServicio;

@Controller
public class CategoriaControlador {

    @Autowired
    private CategoriaServicio servicio;

    @GetMapping({"/categorias", "/"})
    public String listarCategorias(Model modelo){
        modelo.addAttribute("categorias", servicio.listarTodasLasCategorias());
        return "categorias";
    }
    
    @GetMapping({"/categorias/nuevo"})
    public String mostrarFormularioRegistroCategorias(Model modelo){
        Categoria categoria = new Categoria();
        modelo.addAttribute("categoria", categoria);
        return "crear_categoria";
    }

    @PostMapping("/categorias")
    public String guardarCategoria(@ModelAttribute("categoria") Categoria categoria) {
        servicio.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/editar/{id}")
    public String mostrarFormularioEditarCategoria(@PathVariable Long id, Model modelo){
        modelo.addAttribute("categoria", servicio.obtenerCategoriaPorCodigo(id));
        return "editar_categoria";
    }

    @PostMapping("/categorias/{id}")
    public String actualizarCategoria(@PathVariable Long id, @ModelAttribute("categoria") Categoria categoria, Model modelo){
        Categoria categoriaExistente = servicio.obtenerCategoriaPorCodigo(id);
        categoriaExistente.setId(id);
        categoriaExistente.setNombreProducto(categoria.getNombreProducto());
        categoriaExistente.setDescripcion(categoria.getDescripcion());

        servicio.actualizarCategoria(categoriaExistente);
        return "redirect:categorias";
    }

    @GetMapping("/categorias/{id}")
    public String eliminarCategoria(@PathVariable Long id){
        servicio.eliminarCategoria(id);
        return "redirect:/categorias";
    }


}
