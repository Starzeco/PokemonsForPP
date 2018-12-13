package CatchingPokemon;

import Throwing.LinearThrow;
import Throwing.SpinnedThrow;
import models.Pokemon.Pokemon;
import models.Trainers.Trainer;

import java.util.Random;

public class CatchingPokemonAdventurer implements CatchingPokemon {


    @Override
    public void catchPokemon(Pokemon pokemon, Trainer trainer) {
        boolean caught=false;

        for(int i=0;i<5 && caught!=true;i++){
            Random random=new Random();
            int chance=random.nextInt(101)+trainer.getPokeBalls().pop().getEfficiency();
            if(trainer.getThrowingStyle() instanceof LinearThrow){
                chance+=5;
            }

            if(chance>=pokemon.countHardness()){
                if(trainer.getPokemonSet().size()==6){
                    System.out.println("Niestety masz za duzo pokemonow i zostal on wyslane do dr.Oak");
                    caught=true;
                }else{
                    trainer.getPokemonSet().add(pokemon);
                    System.out.println("Yeah złapałeś go");
                    caught=true;
                }
            }
        }if(caught==false){
            System.out.println("Nastepnym razem sie uda");
        }
    }
}
