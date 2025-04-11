package com.devs.via1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devs.via1.models.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, String>{

	Usuario findByCpfAndSenha(String cpf, String senha);

}
