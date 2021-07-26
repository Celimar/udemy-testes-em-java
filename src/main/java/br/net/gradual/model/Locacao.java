package br.net.gradual.model;


import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Locacao {

	private Usuario usuario;
	private List<Filme> filmes = new ArrayList<Filme>();
	private Date dataLocacao;
	private Date dataRetorno;
	private Double valor;

	public Locacao(Usuario usuario, List<Filme> filmes ) {
		this.usuario = usuario;
		this.filmes = filmes;
		this.dataLocacao = new Date();
	}
}