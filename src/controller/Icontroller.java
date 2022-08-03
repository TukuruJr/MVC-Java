package controller;

public interface Icontroller {

	void onRegister(String name, String email, String password); //for registering a user
	void onLogin(String email, String password); //for controlling login
}
