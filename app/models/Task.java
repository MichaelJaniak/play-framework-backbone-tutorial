package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;


@Entity
public class Task extends Model {
	
	@Id
	public String id;

	public String title;
	
	public Boolean completed;
	
	public Task (String title){
		this.title = title;
	}
	
	public Task(){
	}
	
    public static Finder<String,Task> find = new Finder<String,Task>(String.class, Task.class);
    
    public static Task create(Task task) {
        task.save();
        return task;
    }

    public Task fill(Task task){
    	if(task.title!=null) this.title= task.title;
    	if(task.completed!=null) this.completed = task.completed; 
    	return this;
    }
	
    
}
