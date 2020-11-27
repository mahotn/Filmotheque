package fr.eni.Filmotheque.services;

import fr.eni.Filmotheque.bo.User;

public interface UserService {
	User login(String email, String password);
}
