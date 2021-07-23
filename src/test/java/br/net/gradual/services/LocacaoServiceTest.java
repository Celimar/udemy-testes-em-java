package br.net.gradual.services;

import br.net.gradual.excecptions.FilmeSemEstoqueException;
import br.net.gradual.excecptions.LocadoraException;
import br.net.gradual.model.Filme;
import br.net.gradual.model.Locacao;
import br.net.gradual.model.Usuario;
import br.net.gradual.utils.DataUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import java.util.Date;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class LocacaoServiceTest {

    @Rule
    public ErrorCollector error = new ErrorCollector();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testeLocacao() {
        //cenário
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("user");
        Filme filme = new Filme("One", 0, 15.50);

        //ação
        Locacao locacao = null;
        try {
            locacao = service.alugarFilme(usuario, filme);
            //verificação
            error.checkThat(locacao.getValor(), is( equalTo(10)) );
            error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(false));
            error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    @Test(expected = Exception.class)
    public void testeLocacao_filmeSemEstoque() throws Exception {
        //cenário
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("user");
        Filme filme = new Filme("One", 0, 15.50);

        //ação
        Locacao locacao = service.alugarFilme(usuario, filme);
    }

    @Test
    public void testeLocacao_usuarioVazio() throws FilmeSemEstoqueException {
        //cenário
        LocacaoService service = new LocacaoService();
        Filme filme = new Filme("One", 10, 15.50);

        //ação
        try {
            Locacao locacao = service.alugarFilme(null, filme);
            Assert.fail();
        } catch (LocadoraException e) {
            assertEquals(e.getMessage(), LocacaoService.SEM_USUARIO_ERROR_MESSAGE);
        }
    }

    @Test
    public void testeLocacao_filmeVazio() throws FilmeSemEstoqueException, LocadoraException {
        //cenário
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("user");

        exception.expect(LocadoraException.class);
        exception.expectMessage(LocacaoService.SEM_FILME_ERROR_MESSAGE);

        //ação
        Locacao locacao = service.alugarFilme(usuario, null);
    }

}