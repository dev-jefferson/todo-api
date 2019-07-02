package br.com.jhsgdev.todolist.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.jhsgdev.todolist.domain.Todo;
import br.com.jhsgdev.todolist.repository.TodoRepository;
import br.com.jhsgdev.todolist.resources.exceptions.FildMessage;
import br.com.jhsgdev.todolist.vo.TodoVO;

public class TodoInsertValidator implements ConstraintValidator<TodoInsert, TodoVO> {

    @Autowired
    private TodoRepository repository;
    
    @Override
    public void initialize(TodoInsert ann) {
    }

    @Override
    public boolean isValid(TodoVO objDto, ConstraintValidatorContext context) {
        List<FildMessage> listFildError = new ArrayList<>();
        
        Todo validacaoObj = this.repository.findByNome(objDto.getNome());
        if(validacaoObj != null){
            if(objDto.getId() == null){                
                listFildError.add(new FildMessage("nome", "Nome já existente"));
            }
            if(validacaoObj.getNome().equals(objDto.getNome())){
                if(!validacaoObj.getId().equals(objDto.getId())){
                    listFildError.add(new FildMessage("nome", "Não é possivel atualizar, nome já existente"));
                }
            }
        }
        
        
        for (FildMessage e : listFildError) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return listFildError.isEmpty();
    }
}
