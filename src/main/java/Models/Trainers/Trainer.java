package Models.Trainers;

import CatchingPokemon.CatchingPokemon;
import Exceptions.NotFoundPokemonException;
import Throwing.ThrowingStyle;
import Models.PokeBalls.PokeBall;
import Models.Pokemon.Pokemon;
import lombok.Getter;


import java.util.Set;
import java.util.Stack;

@Getter
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

    public void showPokemons() {
        if (!pokemonSet.isEmpty()) {
            pokemonSet.stream()
                    .forEach(pokemon -> System.out.println(pokemon));
        }else{
            System.out.println("You don't have pokemons");
        }
    }
}
