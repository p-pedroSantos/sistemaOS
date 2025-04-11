package com.devs.via1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.devs.via1.dao.UsuarioDAO;
import com.devs.via1.models.Usuario;

//import com.opencsv.CSVReader;
//import com.opencsv.CSVReaderBuilder;
@Controller
public class UsuarioController {
	@Autowired
	private UsuarioDAO usuarodao;

	/*@GetMapping("/adicionar_Todos_Usuarios")
	public String inportarCSV() throws IOException {
		Reader reader = Files.newBufferedReader(Paths.get("C:\\Users\\facepe.aluno2\\Documents\\usuario2.csv"));
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(0).build();
		//System.out.println(csvReader);
		List<String[]> usuarios = csvReader.readAll();		
		System.out.println(usuarios.size());
		
		for(String[] usuario: usuarios) {
			//System.out.println(usuario[0]);
			String[] items = usuario[0].split(";");
	        List<String> itemList = new ArrayList<String>();
	        for (String item : items) {
	        	itemList.add(item);	        	
	        }
	        /* 0 nome
	         * 1 cpf
	         * 2 codigo
	         * 3 descricao
	         * 4 cargo
	         * 5 empresa
	         * 6 cgc
	         * */
	        
	       //int cpf = Integer.parseInt(items[1]);
	       //System.out.println(cpf);
	   /*     Cargos cargo = new Cargos();
	        		//items[2] codigo
	        		cargo.setNomeCargo(items[4]);
	        		cargo.setDescricao(items[3]);
	        		
	        Empresas empresa = new Empresas();
	        		empresa.setCgc(items[6]);
	        		empresa.setNomeEmpresa(items[5]);
	        		
	        Usuario usua1 = new Usuario();
	        		
	        		usua1.setCpf(items[1]);
	        		usua1.setNome(items[0]);
	        		usua1.setSenha("1234");
	        		usua1.setCargo(cargo);	
	        		
	        		usua1.setTipoAvaliacao(TipoAvaliacao.OPERACIONAL);
	        		usua1.setEmpresa(empresa);
	        		if(usua1.getSenha()=="01863044477") {
	        			usua1.setPerfil(Perfil.GESTOR_DHO);
	        		}
	        		usua1.setPerfil(Perfil.FUNCIONARIO);
	        //System.out.println(usua1.getNome());	        	         
	        		
	        //empresa.setCargo(cargo);
	             
	        this.cargo.save(cargo);
	        this.empresa.save(empresa);
	        this.usuarioDAO1.save(usua1);   
		}
		return "login";
	}*/
	
	
	
	@GetMapping("/testeController")
	public String teste() {
		Usuario usuario = new Usuario();
		usuario.setCpf("123");
		usuario.setSenha("123");
		usuario.setNome("Devs Test"); 
		this.usuarodao.save(usuario);
		return "login";
	}
}
