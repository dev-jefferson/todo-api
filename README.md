# todo-api

Criado Api Rest em Spring, Hibernate e JPA. Sendo implementado todo o CRUD de Tarefas. E foi publicado no heroku com o seguinte endpoint: https://jhsg-todo-api.herokuapp.com/todos

Retorna todas as tarefas
GET: https://jhsg-todo-api.herokuapp.com/todos

Retorna uma tarefa
GET: https://jhsg-todo-api.herokuapp.com/todos/id

Cria uma tarefa
POST: https://jhsg-todo-api.herokuapp.com/todos
  body: {
	  "nome": "Desenhar"
  }

Edita uma tarefa
PUT: https://jhsg-todo-api.herokuapp.com/todos/id
  body: {
	  "nome": "Tarefa"
  }

Retorna todas as tarefas
DELETE: https://jhsg-todo-api.herokuapp.com/todos/id
