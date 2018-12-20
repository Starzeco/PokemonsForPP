package Models.Trainers.SpecificTrainer;

import CatchingPokemon.CatchingPokemonAdventurer;
import CatchingPokemon.CatchingPokemonLeader;
import Exceptions.NotFoundPokemonException;
import Throwing.LinearThrow;
import Throwing.SpinnedThrow;

import Models.PokeBalls.PokeBall;
import Models.Pokemon.Pokemon;
import Models.Trainers.LeaderOfGym;
import Models.Types.Type;
import lombok.ToString;

import java.util.*;

@ToString
public class Henryk extends LeaderOfGym {


    public Henryk(Set<Pokemon> set, String name, Type sala) {
        this.pokemonSet=set;
        this.name=name;
        this.age=30;
        this.pokeBalls=new Stack<PokeBall>();
        this.sala=sala;
        this.subChallenges=0;
        this.defeatedTrainers=0;
        this.difficultyLevel=10;
        this.potential=50;
        this.throwingStyle=new LinearThrow();
        this.catchingPokemon=new CatchingPokemonLeader();
    }


    public void switchThrowingStyle(){
        if(throwingStyle instanceof LinearThrow){
            this.throwingStyle=new SpinnedThrow();
        }
        else{
            this.throwingStyle=new LinearThrow();
        }
    }

    public void switchCatchPokemon(){
        if(catchingPokemon instanceof CatchingPokemonLeader){
            this.catchingPokemon=new CatchingPokemonAdventurer();
        }else{
            this.catchingPokemon=new CatchingPokemonLeader();
        }
    }


    @Override
    protected int countLevelOfGym() {
        int number=difficultyLevel;
        if(age>=30){
            number+=10;
        }
        if(subChallenges>5){
            number+=20;
        }else{
            number+=10;
        }


        return number;
    }

    @Override
    public void train(Pokemon pokemon) throws NotFoundPokemonException {
        Optional<Pokemon> pokemonOptional=pokemonSet
                .stream()
                .filter(pokemon1 -> pokemon.getName().equals(pokemon1.getName()))
                .findFirst();

        if(pokemonOptional.isPresent()){
            Pokemon foundPokemon=pokemonOptional.get();
            if(defeatedTrainers%10>5){
                foundPokemon.setLevel(foundPokemon.getLevel()+2);
            }
            else{
                foundPokemon.setLevel(foundPokemon.getLevel()+1);
            }
        }else{
            throw new NotFoundPokemonException("You don't have this pokemon");
        }

    }


}
