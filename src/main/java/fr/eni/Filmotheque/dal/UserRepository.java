package fr.eni.Filmotheque.dal;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.eni.Filmotheque.bo.User;

public interface UserRepository extends JpaRepository<User, Long> {
	// Méthode pour se connecter.
	@Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
	Optional<User> login(@Param("email") String email, @Param("password") String password);
}