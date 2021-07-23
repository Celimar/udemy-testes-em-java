package br.net.gradual.excecptions;

public class FilmeSemEstoqueException extends Exception {

    public FilmeSemEstoqueException(String errorMessage) {
        super(errorMessage);
    }
}
