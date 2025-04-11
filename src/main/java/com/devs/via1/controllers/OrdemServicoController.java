package com.devs.via1.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.devs.via1.dao.ArquivoDAO;
import com.devs.via1.dao.OrdemServicoDAO;
import com.devs.via1.models.Arquivo;
import com.devs.via1.models.EnumLojas;
import com.devs.via1.models.OrdemServico;
import com.devs.via1.models.Usuario;

@Controller
public class OrdemServicoController {
	
	@Autowired
	private OrdemServicoDAO ordemServicoDAO;
	@Autowired
	private ArquivoDAO arquivoDAO;
	
	
	@GetMapping("/adm/ordens")
	public String ordens(Model model) {
		model.addAttribute("listaOrdemServico", this.ordemServicoDAO.findAll());
		return "ordens";
	}
	
	@GetMapping("/adm/OrdemServico/{idOrdemServico}")
	//@ResponseBody
	public String exibirCurriculo1(@PathVariable("idOrdemServico") Integer idOrdemServico, Model model){
		OrdemServico ordemServico = this.ordemServicoDAO.getById(idOrdemServico);
		System.out.println(ordemServico.getCodigo());
		//List<Arquivo> arquivos = this.arquivoDAO.findAllByOrdemServico(ordemServico);
		//List<byte[]> byteArquivos = new ArrayList<>();
		//for(Arquivo arquivo: arquivos) {
		//	byteArquivos.add(arquivo.getArquivo());
		//}
		System.out.println(this.arquivoDAO.findAllByOrdemServico(ordemServico).size());
		model.addAttribute("listaDowloads", this.arquivoDAO.findAllByOrdemServico(ordemServico));

		
		return "download";
	}
	@GetMapping("/adm/baixarArquivos/{arquivoId}")
	@ResponseBody
	public byte[] baixarArquivos(@PathVariable("arquivoId") Integer id){
		Arquivo arquivo = this.arquivoDAO.getById(id);	
		return arquivo.getArquivo();
	}

	@ModelAttribute("enum_lojas")
	public List<String> getLojas() {
		List<String> lojas = EnumLojas.descricoes();
		System.out.println(lojas.size());
		return lojas;
	}
	
	@PostMapping("/adm/salvar-ordemServico")
	public String salvarCurriculo(OrdemServico ordemServico, HttpServletRequest request, @RequestParam("OrdemServicoArquivo") List<MultipartFile> files, RedirectAttributes ra) {	
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		ordemServico.setUsuario(usuario);
		
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String agoraFormatado = agora.format(formatter);
		ordemServico.setDataDeEnvio(agoraFormatado);
		
		// = 
		List<OrdemServico> ordemServicoNP= ordemServicoDAO.findByNumeroPedido(ordemServico.getNumeroPedido());	
		List<OrdemServico> ordemServicoOS= ordemServicoDAO.findByCodigo(ordemServico.getCodigo());
			if(!ordemServicoNP.isEmpty()) {
			 ra.addFlashAttribute("NumeroPDIgual", "Pedido já foi envíado!");
			}				
		 if(!ordemServicoOS.isEmpty()) {
			 ra.addFlashAttribute("NumeroOSIgual", "Ordem de Serviço já envíada!");
			}
		 
		this.ordemServicoDAO.save(ordemServico); 
		 
		try {
			
			for(MultipartFile file: files) {
				Arquivo arquivo = new Arquivo();
				arquivo.setArquivo(file.getBytes());
				arquivo.setNomeArquivo(file.getOriginalFilename());
				arquivo.setOrdemServico(ordemServico);
				this.arquivoDAO.save(arquivo);			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		ra.addFlashAttribute("mensagemSalvarServico", "Enviado!");
		ra.addFlashAttribute("enviado", "enviado");
		return "redirect:/adm/home";
	}
	
	
	
}
