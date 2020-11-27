package fr.eni.Filmotheque.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.Filmotheque.bo.User;
import fr.eni.Filmotheque.services.UserService;

@Controller
@SessionAttributes({"user"})
public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/login")
	public String login(@RequestParam(name="email") String email, @RequestParam(name="password") String password, Model response) {
		String errorMsg = "Les identifiants sont incorrects";
		// On récupère les infos de l'utilisateur.
		System.out.println("Les infos : " + email + " " + password);
		// Appel de la méthode pour se connecter.
		User user = userService.login(email, password);
		
		if(user != null) {
			response.addAttribute("user", user);
			System.out.println("La rep : " + response);
		} else {
			System.out.println("Identifiants incorrects");
			response.addAttribute("error", errorMsg);
			System.out.println("La rep : " + response);
		}
		
		return "redirect:index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
		System.out.println("Déconnexion demandée");
		session.invalidate();
		if(model.containsAttribute("user")) {
			model.asMap().remove("user");
		}
		return "redirect:index";
	}
}
