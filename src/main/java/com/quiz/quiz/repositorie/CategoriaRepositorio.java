package com.quiz.quiz.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quiz.quiz.entity.Categoria;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{
}
