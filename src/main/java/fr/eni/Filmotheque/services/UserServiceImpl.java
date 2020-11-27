package fr.eni.Filmotheque.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.eni.Filmotheque.bo.Film;
import fr.eni.Filmotheque.bo.User;
import fr.eni.Filmotheque.dal.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User login(String email, String password) {
		Optional<User> user = userRepository.login(email, password);
		System.out.println("Le user dans le service : " + user);
		
		if(user.isPresent()) {
			User userInstance = user.get();
			return userInstance;
		} else {
			return null;
		}
	}
}
