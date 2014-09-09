package br.ufcg.ppgcc.compor.ir.impl;

import java.util.ArrayList;
import java.util.List;

import br.ufcg.ppgcc.compor.ir.ExcecaoImpostoDeRenda;
import br.ufcg.ppgcc.compor.ir.FachadaExperimento;
import br.ufcg.ppgcc.compor.ir.FontePagadora;
import br.ufcg.ppgcc.compor.ir.Titular;

public class ImpostoDeRenda implements FachadaExperimento{
	
	List<FontePagadora> fontesSalvas = new ArrayList<FontePagadora>();
	List<Titular> titulares = new ArrayList<Titular>();
	public void criarNovoTitular(Titular titular){
		
		
		if (titular.getNome() == null){
			throw new ExcecaoImpostoDeRenda("O campo nome é obrigatório");
		}else if (titular.getCpf() == null){
			throw new ExcecaoImpostoDeRenda("O campo CPF é obrigatório");

		}else if (titular.getCpf().length() != 14){
			throw new ExcecaoImpostoDeRenda("O campo CPF está inválido");
		}
		titulares.add(titular); 
	
	}
	

	public List<Titular> listarTitulares() {
		
		return titulares;
	}


	public void criarFontePagadora(Titular titular, FontePagadora fonte) {
		fontesSalvas.add(fonte);
	}


	public List<FontePagadora> listarFontes(Titular titular) {
		return fontesSalvas;
	}
      
}