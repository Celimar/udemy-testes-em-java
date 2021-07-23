package br.net.gradual.services;

import br.net.gradual.excecptions.FilmeSemEstoqueException;
import br.net.gradual.excecptions.LocadoraException;
import br.net.gradual.model.Filme;
import br.net.gradual.model.Locacao;
import br.net.gradual.model.Usuario;

import java.util.Date;
import static br.net.gradual.utils.DataUtils.adicionarDias;

public class LocacaoService {

	public static final String FILME_SEM_ESTOQUE_ERROR_MESSAGE = "Filme sem estoque";
	public static final String SEM_USUARIO_ERROR_MESSAGE = "Sem usuario";
	public static final String SEM_FILME_ERROR_MESSAGE = "Sem filme";

	public Locacao alugarFilme(Usuario usuario, Filme filme) throws FilmeSemEstoqueException, LocadoraException {
		if (usuario == null)
			throw new LocadoraException(SEM_USUARIO_ERROR_MESSAGE);

		if (filme == null)
			throw new LocadoraException(SEM_FILME_ERROR_MESSAGE);

		if (filme.getEstoque() == 0 )
			throw new FilmeSemEstoqueException(FILME_SEM_ESTOQUE_ERROR_MESSAGE);

		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		
		return locacao;
	}

}