package models.Trainers.SpecificTrainer;

import CatchingPokemon.CatchingPokemonPasiv;
import Exceptions.NotFoundPokemonException;
import TakingCare.CalmApproach;
import TakingCare.TakingCare;
import Throwing.EasyThrow;

import models.PokeBalls.PokeBall;
import models.Pokemon.Pokemon;
import models.Trainers.PasivTrainer;

import java.util.Optional;
import java.util.Set;
import java.util.Stack;

public class Stanisław extends PasivTrainer {

    public Stanisław(Set<Pokemon> pokemonSet, String name, boolean isWorking, boolean staysInHome, String place, int sizeOfField){
        this.pokemonSet=pokemonSet;
        this.name=name;
        age=40;
        this.pokeBalls=new Stack<PokeBall>() {{
                push(new PokeBall());
                push(new PokeBall());
                push(new PokeBall());
                push(new PokeBall());
                push(new PokeBall());

        }};

        throwingStyle=new EasyThrow();
        catchingPokemon=new CatchingPokemonPasiv();
        this.isWorking=isWorking;
        this.staysInHome=staysInHome;
        this.place=place;
        this.sizeOfField=sizeOfField;
        takingCare=new CalmApproach();
    }


    public void setApproach(TakingCare takingCare){
        this.takingCare=takingCare;
    }

    @Override
    protected void report() {
         pokemonSet.forEach(pokemon->System.out.println(pokemon.toString()));

    }

    @Override
    public void train(Pokemon pokemon) throws NotFoundPokemonException {
        Optional<Pokemon> pokemonOptional=pokemonSet
                .stream()
                .filter(pokemon1 -> pokemon.getName().equals(pokemon1.getName()))
                .findFirst();
        if(pokemonOptional.isPresent()){
            Pokemon pokemonFound=pokemonOptional.get();
            if(sizeOfField>=100 && staysInHome==true){
                pokemonFound.setLevel(pokemonFound.getLevel()+2);
            }else{
                pokemonFound.setLevel(pokemonFound.getLevel()+1);
            }

        }else{
            throw new NotFoundPokemonException("Nie posiadasz takiego pokemona");
        }
    }
}
