package Models.Trainers.SpecificTrainer;

import CatchingPokemon.CatchingPokemonAdventurer;
import Exceptions.NotFoundPokemonException;
import Throwing.LinearThrow;
import Models.PokeBalls.PokeBall;
import Models.Pokemon.Pokemon;
import Models.Trainers.Adventurer;
import lombok.ToString;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;

@ToString
public class August extends Adventurer {

    public August(String name, int sizeOfBackpack){
        throwingStyle=new LinearThrow();
        catchingPokemon=new CatchingPokemonAdventurer();
       // this.pokemonSet=pokemonSet;
        this.name=name;
        age=18;
        this.pokeBalls=new Stack<PokeBall>() {{
            push(new PokeBall());
            push(new PokeBall());
            push(new PokeBall());
        }};
        this.pokemonSet=new HashSet<Pokemon>();
        this.sizeOfBackpack=sizeOfBackpack;
        traveledWay=0l;
        defeatedTrainers=0;
        numberOfBadges=0;
    }


    @Override
    protected void preapare() {
        for(int i=0;i<3;i++) pokeBalls.push(new PokeBall());

    }

    @Override
    public void train(Pokemon pokemon) throws NotFoundPokemonException {
        Optional<Pokemon> pokemonOptional=pokemonSet
                .stream()
                .filter(pokemon1 -> pokemon.getName().equals(pokemon1.getName()))
                .findFirst();
        if(pokemonOptional.isPresent()){
            Pokemon pokemonFound=pokemonOptional.get();
            if(defeatedTrainers%4>2){
                pokemonFound.setLevel(pokemonFound.getLevel()+2);
            }else{
                pokemonFound.setLevel(pokemonFound.getLevel()+1);
            }

        }else{
            throw new NotFoundPokemonException("Nie posiadasz takiego pokemona");
        }
    }
}
