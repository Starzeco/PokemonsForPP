package Exceptions;

public class NotFoundPokemonException extends Exception {
    public NotFoundPokemonException(String text){
        super(text);
    }
}
