package com.devs.via1.models;

import java.util.ArrayList;
import java.util.List;

public enum EnumLojas {
	VIA_SUL_PIEDADE("Via Sul Piedade"),
	VIA_SUL_ARRUDA("Via Sul Arruda"),
	VIA_SUL_DUNAS("Via Sul Dunas"),
	JEEP_IMBIRIBEIRA("JEEP Imbiribeira"),
	JEEP_PIEDADE("JEEP Piedade"),
	JEEP_DUNAS("JEEP Dunas"),
	JEEP_SALVADOR_CJDR("JEEP Salvador(CJDR)"),
	JEEP_SALVADOR_ACM("JEEP Salvador(ACM)"),
	RENAULT_PIEDADE("Renault Piedade"),
	RENAULT_IMBIRIBEIRA("Renault Imbiribeira"),
	RENULT_IGUATEMI("Renault Iguatemi"),
	RENAULT_LAURO("Renault Lauro"),
	RENAULT_AFOGADOS("Renault Afogados"),
	RENAULT_SEMINOVOS_IMB("Renault Seminovos IMB"),
	RENAULT_JABOATAO("Renault Jaboatão"),
	NISSAN_PIEDADE("Nissan Piedade"),
	NISSAN_IGUATEMI("Nissan Iguatemi"),
	NISSAN_LAURO("Nissan Lauro"),
	NISSAN_AFOGADOS("Nissan Afogados"),
	NISSAN_IMBIRIBEIRA("Nissan Imbiribeira"),
	NISSAN_PARALELA("Nissan Paralela"),
	NISSAN_JABOATÃO("Nissan Jaboatão"),
	NISSAN_CAXANGA("Nissan Caxanga"),
	GRANVIA_IMBIRIBEIRA("Granvia Imbiribeira"),
	INTERVIA_IMBIRIBEIRA("Intervia Imbiribeira"),
	INTERVIA_PIEDADE("Intervia Piedade"),
	INTERVIA_PARALELA("Intervia Paralela");
	
	private String descricao;
		
	EnumLojas(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static List<String> descricoes(){
		//arraylist de descrições
		List<String> descricoes = new ArrayList();
		
		//variavel do tipo enumLoja, no qual pega os valores do enum e atribui a variavel
		EnumLojas[] lojas = EnumLojas.values();
		
		//para cada loja em lojas
		for(EnumLojas loja: lojas) {
			
			
			descricoes.add(loja.getDescricao());
		}
		return descricoes;
	}
}
