package CatchingPokemon;

import Throwing.SpinnedThrow;
import models.Pokemon.Pokemon;
import models.Trainers.Trainer;

import java.util.Random;

public class CatchingPokemonLeader implements CatchingPokemon {

    @Override
    public void catchPokemon(Pokemon pokemon, Trainer trainer) {
        boolean caught=false;
        while(!trainer.getPokeBalls().isEmpty() && !caught){
            Random random=new Random();
            int chance=random.nextInt(101)+trainer.getPokeBalls().pop().getEfficiency();
            if(trainer.getThrowingStyle() instanceof SpinnedThrow){
                chance+=5;
            }

            if(chance>=pokemon.countHardness()){
                trainer.getPokemonSet().add(pokemon);
                System.out.println("Yeah złapałeś go");
                caught=true;

            }
        }if(caught==false){
            System.out.println("Nastepnym razem sie uda");
        }

    }
}
