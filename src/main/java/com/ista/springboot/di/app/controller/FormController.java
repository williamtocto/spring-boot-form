package com.ista.springboot.di.app.controller;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ista.springboot.di.app.domain.Usuario;

@Controller
@SessionAttributes("usuario")
public class FormController {
	
	@GetMapping("/form")
	public String form (Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("William");
		usuario.setNombre("Tocto");
		usuario.setIdentificador("12.356.242.3");
		model.addAttribute("titulo", "registrar Usuario");
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	
	/*@PostMapping("/form")
	public String procesar (Model model, @RequestParam String username,@RequestParam String password,@RequestParam String email) {
		model.addAttribute("titulo", "registrar form");
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		model.addAttribute("email", email);
		poco x3​pro 8/256
		Usuario usuario = new Usuario();
		usuario.setUsername(username);
		usuario.setPassword(password);
		usuario.setEmail(email);
		
		model.addAttribute("titulo", "registrar form");
		model.addAttribute("usuario", usuario);
		return "resultado";
	}*/
	
	/*@PostMapping("/form")
	public String procesar (@Valid Usuario usuario,BindingResult result, Model model) {
		
		model.addAttribute("titulo", "Registrado form");
		if(result.hasErrors()) {
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(err ->{
				errores.put(err.getField(),
						"El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
			});
			
			model.addAttribute("error", errores);
			return "form";
		}
		
		model.addAttribute("usuario", usuario);
		return "resultado";
	}*/
	
	@PostMapping("/form")
	public String procesar (@Valid Usuario usuario,BindingResult result, Model model, SessionStatus status) {
		
		model.addAttribute("titulo", "Registrado form");
		if(result.hasErrors()) {
			return "form";
		}
		model.addAttribute("usuario", usuario);
		status.setComplete();
		return "resultado";
	}
}
