package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;

	@GetMapping({ "/index", "/", "", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", "textoIndex");
		return "index";
	}

	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Cristian");
		usuario.setApellido("Alvias");
		usuario.setEmail("cristian@alvias.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "textoPerfil".concat(usuario.getNombre()));
		return "perfil";
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "textoListar");
		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> pasarUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Krohz", "Krozty", "ades@adad.com"));
		usuarios.add(new Usuario("Krohz2", "Krozty", "ades@adad.com"));
		usuarios.add(new Usuario("Krohz3", "Krozty", "ades@adad.com"));

		return usuarios;
	}

}
