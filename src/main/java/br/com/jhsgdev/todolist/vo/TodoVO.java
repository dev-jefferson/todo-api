package br.com.jhsgdev.todolist.vo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

//import br.com.jhsgdev.todolist.service.validation.TodoInsert;

//@TodoInsert
public class TodoVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 1, max = 80, message = "O tamanho deve conter entre 1 e 80 caracteres")
	private String nome;
	@CreationTimestamp
	private Date createdAt;
	@UpdateTimestamp
	private Date updatedAt;
	private Boolean concluido = false;
	
	
	public TodoVO() {
		super();
	}
	public TodoVO(Integer id, String nome, Date createdAt, Date updatedAt, Boolean concluido) {
		super();
		this.id = id;
		this.nome = nome;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.concluido = concluido;
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Boolean getConcluido() {
		return concluido;
	}
	public void setConcluido(Boolean concluido) {
		this.concluido = concluido;		
	}
	
}
