package CatchingPokemon;

import CatchingPokemon.Questions.Asking;
import CatchingPokemon.Questions.AskingImpl;
import Throwing.SpinnedThrow;
import Models.Pokemon.Pokemon;
import Models.Trainers.Trainer;

import java.util.Random;

public class CatchingPokemonLeader implements CatchingPokemon {
    final public Asking asking=new AskingImpl();
    @Override
    public void catchPokemon(Pokemon pokemon, Trainer trainer) {
        boolean caught=false;
        int counter=1;
        while(!trainer.getPokeBalls().isEmpty() && !caught){
            Random random=new Random();
            int chance=random.nextInt(101)+trainer.getPokeBalls().pop().getEfficiency();
            if(trainer.getThrowingStyle() instanceof SpinnedThrow){
                chance+=5;
            }

            if(chance>=pokemon.countHardness()){
                System.out.println("Yeah, You've got him and you used "+counter+" pokeballs");
                pokemon.setName(asking.askForName());
                trainer.getPokemonSet().add(pokemon);

                caught=true;

            }
            counter+=1;
        }if(caught==false){
            if(trainer.getPokeBalls().isEmpty()) {
                System.out.println("Next time you'll be successful! But remember you've got no Pokeballs");
            }else{
                System.out.println("Next time you'll be successful!");
            }
        }

    }
}
