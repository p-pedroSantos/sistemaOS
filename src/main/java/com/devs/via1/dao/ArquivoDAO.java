package com.devs.via1.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devs.via1.models.Arquivo;
import com.devs.via1.models.OrdemServico;

public interface ArquivoDAO extends JpaRepository<Arquivo, Integer>{

	List<Arquivo> findAllByOrdemServico(OrdemServico ordemServico);

}
