package com.devs.via1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devs.via1.models.OrdemServico;

public interface OrdemServicoDAO extends JpaRepository<OrdemServico, Integer>{

	List<OrdemServico> findByNumeroPedido(int numeroPedido);

	List<OrdemServico> findByCodigo(int codigo);

}
