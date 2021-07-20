package br.net.gradual.services;

import br.net.gradual.model.Filme;
import br.net.gradual.model.Locacao;
import br.net.gradual.model.Usuario;
import br.net.gradual.utils.DataUtils;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

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
        Assert.assertTrue(locacao.getValor() == 15.50);
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));

    }
}