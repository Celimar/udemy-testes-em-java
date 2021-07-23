package br.net.gradual.services;

import br.net.gradual.model.Filme;
import br.net.gradual.model.Locacao;
import br.net.gradual.model.Usuario;
import br.net.gradual.utils.DataUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class LocacaoServiceTest {

    @Test
    public void teste() {
        //cenário
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("user");
        Filme filme = new Filme("One", 5, 15.50);

        //ação
        Locacao locacao = service.alugarFilme(usuario, filme);

        //verificação
        assertEquals(locacao.getValor(), is(not(20.50) ));
        assertEquals(locacao.getValor(), is( equalTo(15.50)) );
        assertEquals(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
        assertEquals(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
    }
}