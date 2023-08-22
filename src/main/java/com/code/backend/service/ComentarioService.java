package com.code.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.code.backend.model.Comentario;
import com.code.backend.repository.ComentarioRepo;

@Service
public class ComentarioService {
	
	private ComentarioRepo comentarioRepo;
	
	public ComentarioService(ComentarioRepo comentarioRepo) {
		this.comentarioRepo = comentarioRepo;
	}

	public Comentario saveComentario(Comentario Comentario) {
		return comentarioRepo.save(Comentario);
	}
	

	public List<Comentario> getComentarios() {
		return comentarioRepo.findAllOrderByData_publicacaoDesc();	
	}
}