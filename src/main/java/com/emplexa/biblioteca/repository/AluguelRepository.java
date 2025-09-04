package com.emplexa.biblioteca.repository;

import com.emplexa.biblioteca.entity.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
