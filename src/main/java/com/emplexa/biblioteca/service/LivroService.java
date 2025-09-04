package com.emplexa.biblioteca.service;

import com.emplexa.biblioteca.entity.Livro;
import com.emplexa.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    //Salva os livros
    public Livro salvar(Livro livro){
        return livroRepository.save(livro);
    }

    //Lista livros
    public List<Livro>listaTodosLivros(){
        return livroRepository.findAll();
    }

    //Busca livro por id
    public Livro buscarLivroId(Long id ){
        return livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    //Deletar livro
    public void DeletarLivro(Long id){
        Livro livro = buscarLivroId(id);
        livroRepository.delete(livro);
    }

    //Verificar disponibilidade
    public boolean EstaDisponivel (Long id){
       Livro livro = buscarLivroId(id);
       return livro.isDisponivel();}

    //Atualiza Disponibilidade

    public Livro atualizarDisponibilidade(Long id, Boolean disponivel){
        Livro livro = buscarLivroId(id);
        livro.setDisponivel(disponivel);
        return livroRepository.save(livro);
    }


}
