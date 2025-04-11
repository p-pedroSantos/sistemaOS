package com.devs.via1.acesso;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devs.via1.dao.UsuarioDAO;
import com.devs.via1.models.EnumLojas;
import com.devs.via1.models.Usuario;

@Controller
public class AcessoController {
	
	//private String usuarioLogadoCpf;
	
	@Autowired
	public UsuarioDAO usuarioDAO;

	@GetMapping("/")
	public String login() {
		return "login";
	}
	
	@GetMapping("/adm/home")
	public String home(Usuario usuarioLogado) {
		
			return "options";
		}
	@ModelAttribute("enum_lojas")
	public List<String> getLojas() {
		List<String> lojas = EnumLojas.descricoes();
		System.out.println(lojas.size());
		return lojas;
	}
	
	@GetMapping("/adm/os")
	public String os(Model model) {
		model.addAttribute("enum_lojas",EnumLojas.descricoes());
		return "home";
	}

	@PostMapping("/login")
	public String efetuarLogin(String cpf, String senha, HttpSession session, RedirectAttributes ra) {
		// Buscar se existe um usuario com o login e senha informados
		
		Usuario usuarioLogado = this.usuarioDAO.findByCpfAndSenha(cpf, senha);
		//this.usuarioLogadoCpf=cpf;
		if (usuarioLogado == null) {
			ra.addFlashAttribute("mensagem", "Login/senha inválidos");
			return "redirect:/";			
		} else {
			session.setAttribute("usuarioLogado", usuarioLogado);
			return "redirect:/adm/home";
		}		
	}
	
	
	@GetMapping("/sair")
	public String sair(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping()
	public String sessionConfig(HttpSession session) {
		
		return "''";
	}
	@GetMapping("/acessoNegado")
	public String acessoNegado() {
		return "acesso_negado";
	}
}
