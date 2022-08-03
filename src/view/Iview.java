package view;

public interface Iview {

	interface Register{
		void onRegistrationSuccess(String message);
		void onRegistrationFailure(String message);
	}

	interface Login{
		void onLoginSuccess(String message);
		void onLoginFailure(String message);
	}

	
}
