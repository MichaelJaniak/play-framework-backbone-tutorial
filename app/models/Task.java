package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;


@Entity
public class Task extends Model {
	
	@Id
	public String id;

	public String title;
	
	public boolean completed = false;
	
	public Task (String title){
		this.title = title;
	}
	
	public Task(){
	}
	
    public static Finder<String,Task> find = new Finder<String,Task>(String.class, Task.class);
    
    public static Task create(Task task) {
//    	Is this ok? Using a static method to persist then returning an object looks dicey
        task.save();
        return task;
    }

	
    
}
