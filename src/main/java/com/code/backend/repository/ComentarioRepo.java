package com.code.backend.repository;

import com.code.backend.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComentarioRepo extends JpaRepository<Comentario, Long> {
    @Query("SELECT c FROM Comentario c ORDER BY c.data_publicacao DESC")
    List<Comentario> findAllOrderByData_publicacaoDesc();
}
