package br.net.gradual.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Filme {

	private String nome;
	private Integer estoque;
	private Double precoLocacao;
}