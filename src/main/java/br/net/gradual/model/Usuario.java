package br.net.gradual.model;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	private String nome;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Usuario usuario = (Usuario) o;
		return Objects.equals(nome, usuario.nome);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
}
