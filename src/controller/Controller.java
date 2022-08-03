/**
 * @author francode
 * 
 * @about  this class stores data in Person Model and updates Views Accordingly
 */

package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.Backend;
import model.Person;
import view.Iview;
import view.Iview.Login;
import view.Iview.Register;

public class Controller implements Icontroller {
	
    Person person;
    Backend db =  new Backend();
	private Iview.Login lview;
	private Iview.Register rview;
	
	

	public Controller() {
		// TODO Auto-generated constructor stub
	}
	

	
	//for context of Login class
	public void setLview(Iview.Login lview) {
		this.lview = lview;
	}

	//for context of Register class
	public void setRview(Iview.Register rview) {
		this.rview = rview;
	}


	@Override
	public void onRegister(String name, String email, String password) {
		// TODO Auto-generated method stub
	       try {
			db.Connect();
			person = new Person(name, email, password);  //pass values to our model
			
			//validate
			if(name.isBlank()||email.isBlank()||password.isBlank()) {
				rview.onRegistrationFailure("Fill all fields");
			}else {
				if(db.Register(person.getName(), person.getEmail(), person.getPassword())) {
					rview.onRegistrationSuccess("User Registered Successfully");
				}else {
					rview.onRegistrationFailure("Failed to register a user");
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

	@Override
	public void onLogin(String email, String password) {
		// TODO Auto-generated method stub
		try {
			db.Connect();
			person = new Person();
			person.setEmail(email);
			person.setPassword(password);
			if(email.isBlank()||password.isBlank()) {
				lview.onLoginFailure("Empty Fields!!");
			}else {
				if(db.Login(person.getEmail(), person.getPassword())) {
					   lview.onLoginSuccess("Login Success!!");
					}else {
						lview.onLoginFailure("Invalid Incredentials!!");
					}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
