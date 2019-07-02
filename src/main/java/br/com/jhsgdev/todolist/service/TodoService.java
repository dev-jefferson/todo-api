package br.com.jhsgdev.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jhsgdev.todolist.domain.Todo;
import br.com.jhsgdev.todolist.repository.TodoRepository;
import br.com.jhsgdev.todolist.service.exceptions.ObjectNotFoundException;
import br.com.jhsgdev.todolist.vo.TodoVO;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;

	public Todo find(Integer id) {
		Optional<Todo> obj = this.repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Todo.class.getName()));
	}

	public List<Todo> findAll() {
		return this.repository.findAll();
	}
	

	public Todo insert(Todo obj) {
		obj.setId(null); 
		return this.repository.save(obj);
	}

	public Todo update(Todo obj) {
		Todo todo = this.find(obj.getId()); 
		obj.setCreatedAt(todo.getCreatedAt());
		
		return this.repository.save(obj); 
	}

	public void delete(Integer id) {
		this.find(id); 
		this.repository.deleteById(id);
		
	}

	public Todo toTodo(TodoVO objVO) {
		Todo obj = new Todo(objVO.getNome(), objVO.getCreatedAt(), objVO.getUpdatedAt(), objVO.getConcluido());
		return obj;
	}
	
	public TodoVO toTodoVO(Todo obj) {
		TodoVO objVO = new TodoVO(obj.getId(), obj.getNome(), obj.getCreatedAt(), obj.getUpdatedAt(), obj.getConcluido());
		return objVO;
	}

}
