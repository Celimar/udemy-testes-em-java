package br.net.gradual.services;

import br.net.gradual.model.Filme;
import br.net.gradual.model.Locacao;
import br.net.gradual.model.Usuario;
import br.net.gradual.utils.DataUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.Date;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class LocacaoServiceTest {

    @Rule
    public ErrorCollector error = new ErrorCollector();

    @Test
    public void testeLocacao() {
        //cenário
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("user");
        Filme filme = new Filme("One", 5, 15.50);

        //ação
        Locacao locacao = service.alugarFilme(usuario, filme);

        //verificação
        error.checkThat(locacao.getValor(), is( equalTo(10)) );
        error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(false));
        error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
    }
}