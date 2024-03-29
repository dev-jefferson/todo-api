package br.com.jhsgdev.todolist.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.jhsgdev.todolist.domain.Todo;
import br.com.jhsgdev.todolist.service.TodoService;
import br.com.jhsgdev.todolist.vo.TodoVO;

@RestController
@RequestMapping(value = "/todos")
public class TodoResource {

	@Autowired
	private TodoService service;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Todo> find(@PathVariable Integer id) { 
																		
		Todo obj = this.service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<TodoVO>> findAll() {

		List<Todo> list = this.service.findAll();

		List<TodoVO> listVO = list.stream().map(todo -> this.service.toTodoVO(todo) ).collect(Collectors.toList());
		return ResponseEntity.ok().body(listVO);
	}

	@PostMapping() 
	public ResponseEntity<Void> insert(@RequestBody TodoVO objVO) { 
																				
		Todo obj = this.service.toTodo(objVO);

		obj = this.service.insert(obj); 
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		// retornar o status 201 com a uri
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody TodoVO objVO, @PathVariable Integer id) {

		Todo obj = this.service.toTodo(objVO);

		obj.setId(id); 
		obj = this.service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		this.service.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}
