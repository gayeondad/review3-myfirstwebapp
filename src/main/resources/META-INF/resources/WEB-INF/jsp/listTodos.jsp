<!doctype html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
  </head>
  <body>
    <div class="container m-5 border rounded p-0">
    	<h1>${sessname} : List Todos page</h1>
	    <div class="p-3">
	    	<table class="table">
	    		<thead>
	    			<tr>
	    				<th>Id.</th>
	    				<th>Username</th>
	    				<th>Description</th>
	    				<th>Target Date</th>
	    				<th>Is Done?</th>
	    				<th>Delete</th>
	    				<th>Update</th>
	    			</tr>
	    		</thead>
	    		<tbody>
	    			<tr th:each="todo : ${todos}">
	    				<td><span th:text="${todo.id}"></span></td>
	    				<td><span th:text="${todo.username}"></span></td>
	    				<td><span th:text="${todo.description}"></span></td>
	    				<td><span th:text="${todo.targetDate}"></span></td>
	    				<td><span th:text="${todo.done}"></span></td>
	    				<td><a th:href="@{delete-todo?id={id}(id=${todo.id})}" class="btn btn-warning">Delete</a></td>
	    				<td><a href="@{update-todo?id={id}(id=${todo.id})}" class="btn btn-success">Update</a></td>
	    			</tr>
	    		</tbody>
	    	</table>
	    	<div>
	    		<a href="add-todo" class="btn btn-success">Add Todo</a>
	    	</div>
	    </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
  </body>
</html>