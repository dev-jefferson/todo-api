package br.com.jhsgdev.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jhsgdev.todolist.domain.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{

	@Transactional(readOnly = true)             
	Todo findByNome(String nome);     
    
}
