import java.util.Arrays;

import com.google.gson.Gson;

public class JSONReading {
	public static void main(String[] args) {
		String departmentJson = "{'id' : 1, "
		        + "'name': 'HR',"
		        + "'users' : ["
		            + "{'name': 'Alex','id': 1}, "
		            + "{'name': 'Brian','id':2}, "
		            + "{'name': 'Charles','id': 3}]}";
		 
		Gson gson = new Gson(); 
		 
		Department department = gson.fromJson(departmentJson, Department.class);  
		 
		System.out.println(department);	
	}
}
class User 
{
    private long id;
    private String name;
     
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
 
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }
}
class Department 
{
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User[] getUsers() {
		return users;
	}

	public void setUsers(User[] users) {
		this.users = users;
	}

	private long id;
    private String name;
    private User[] users;
 
    //Getters and Setters
 
    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + ", users=" + Arrays.toString(users) + "]";
    }
}