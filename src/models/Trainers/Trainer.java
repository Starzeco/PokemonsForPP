package models.Trainers;

import CatchingPokemon.CatchingPokemon;
import Exceptions.NotFoundPokemonException;
import Throwing.ThrowingStyle;
import models.PokeBalls.PokeBall;
import models.Pokemon.Pokemon;


import java.util.Set;
import java.util.Stack;

abstract public class Trainer {
    protected Set<Pokemon> pokemonSet;
    protected String name;
    protected int age;
    protected Stack<PokeBall> pokeBalls;
    protected ThrowingStyle throwingStyle;
    protected CatchingPokemon catchingPokemon;

    public abstract void train(Pokemon pokemon) throws NotFoundPokemonException;

    public int getAge() {
        return age;
    }

    public Set<Pokemon> getPokemonSet() {
        return pokemonSet;
    }

    public Stack<PokeBall> getPokeBalls() {
        return pokeBalls;
    }

    public String getName() {
        return name;
    }

    public ThrowingStyle getThrowingStyle() {
        return throwingStyle;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPokeBalls(Stack<PokeBall> pokeBalls) {
        this.pokeBalls = pokeBalls;
    }
}
