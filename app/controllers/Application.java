package controllers;

import java.io.IOException;

import models.Task;

import org.codehaus.jackson.map.ObjectMapper;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import play.mvc.With;
import actions.CORSAction;

@With(CORSAction.class)
public class Application extends Controller {
	


	public static Result index() {
		return ok(play.libs.Json.toJson(Task.find.all()));
	}
	
	public static Result getTask (String id){
		return ok(play.libs.Json.toJson(Task.find.byId(id)));
	}

	public static Result updateTask (String id){
		Task task = null;
		try {
			task =  new ObjectMapper().readValue(request().body().asJson(), Task.class);
		} catch (IOException e) {
			return Results.notFound("json is not of format Task");
		}
		task.update();
		return ok(play.libs.Json.toJson(task));
	}

	public static Result deleteTask (String id){
		Task.find.byId(id).delete();
		return ok(play.libs.Json.toJson(new Task()));
	}

	public static Result createTask (){
		Task task = null;
		try {
			task =  new ObjectMapper().readValue(request().body().asJson(), Task.class);
		} catch (IOException e) {
			return Results.notFound("json is not of format Task");
		}
		task = Task.create(task);
		return ok(play.libs.Json.toJson(task));
	}

	
	
	public static Result options(String id) {
		return ok();
	}
	
	public static Result optionsPost() {
		return ok();
	}

	
}