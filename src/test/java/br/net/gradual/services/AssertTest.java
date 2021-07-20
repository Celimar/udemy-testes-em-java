package br.net.gradual.services;

import br.net.gradual.model.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class AssertTest {

    @Test
    public void test() {
        Assert.assertTrue("assertTrue ", true);
        Assert.assertFalse("assertFalse", false);

        Assert.assertEquals("assertEquals integer values", 1, 1);

        //double needs delta
        Assert.assertEquals("assertEquals double with delta", 0.123, 0.124, 0.01);

        //tratar valores de dados primitivos ou wrapper com o mesmo tipo
        int i = 5;
        Integer ii = 5;
        Assert.assertEquals("assertEquals primitive e wrapper", i, ii.intValue());

        Assert.assertTrue("assertTrue bola.equals('bola') ", "bola".equals("bola"));

        Usuario u1 = new Usuario("usu1");
        Usuario u2 = new Usuario("usu1");
        Assert.assertEquals("assertEquals u1, u2", u1, u2);
//        Assert.assertSame("assertSame u1, u2", u1, u2);
        Assert.assertNull("assertNull u1", null);
        Assert.assertNotNull("assertNotNull u1", u1);

    }
}
