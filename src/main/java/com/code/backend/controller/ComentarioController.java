package com.code.backend.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.code.backend.model.Comentario;
import com.code.backend.service.ComentarioService;

@Controller  // Change from @RestController to @Controller
@RequestMapping("/")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping("/addComentario")
    public String saveComentario(@RequestParam("comment") String commentText) {
        Comentario comentario = new Comentario();
        comentario.setUsuario_id(4); // always user_id 4
        comentario.setTexto(commentText);
        comentarioService.saveComentario(comentario);
        return "redirect:/";  // Redirect back to the main page
    }
    
    @GetMapping("/")
    public String getRoot(Model model) {
        List<Comentario> comments = comentarioService.getComentarios();
        Collections.reverse(comments);  // Reverse the comments order
        model.addAttribute("comments", comments);
        return "comments";  // This refers to 'comments.html' under 'templates' folder
    }
}
