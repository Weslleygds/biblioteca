package com.emplexa.biblioteca.controller;

import com.emplexa.biblioteca.entity.Livro;
import com.emplexa.biblioteca.service.LivroService;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> listar() {
        return livroService.listaTodosLivros();
    }

    @PostMapping
    public Livro cadastrar(@RequestBody Livro livro){
        return livroService.salvar(livro);
    }

    @PutMapping("/{id}/disponivel")
    public Livro atualizarDisponibilidade(@PathVariable Long id, @RequestParam Boolean disponivel){
        return livroService.atualizarDisponibilidade(id, disponivel);
    }

    @DeleteMapping("{id}")
    public void deletar (@PathVariable Long id){
        livroService.DeletarLivro(id);
    }
}
