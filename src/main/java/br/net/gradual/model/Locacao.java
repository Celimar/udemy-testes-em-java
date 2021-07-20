package br.net.gradual.model;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Locacao {

	private Usuario usuario;
	private Filme filme;
	private Date dataLocacao;
	private Date dataRetorno;
	private Double valor;

	public Locacao(Usuario usuario, Filme filme) {
		this.usuario = usuario;
		this.filme = filme;
		this.dataLocacao = new Date();
	}
}