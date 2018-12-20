package CatchingPokemon;

import Throwing.LinearThrow;
import Models.Pokemon.Pokemon;
import Models.Trainers.Trainer;

import java.util.Random;
import java.util.Scanner;

public class CatchingPokemonAdventurer implements CatchingPokemon {
    final public Asking asking=new AskingImpl();

    @Override
    public void catchPokemon(Pokemon pokemon, Trainer trainer) {
        boolean caught=false;
        int counter=1;
        for(int i=0;i<5 && caught!=true && i<trainer.getPokeBalls().size();i++){
            Random random=new Random();
            int chance=random.nextInt(101)+trainer.getPokeBalls().pop().getEfficiency();
            if(trainer.getThrowingStyle() instanceof LinearThrow){
                chance+=5;
            }

            if(chance>=pokemon.countHardness()){
                if(trainer.getPokemonSet().size()==6){
                    System.out.println("Sadly you've got too many pokemons, this one was sent to dr.Oak, you used "+counter+" pokeballs");
                    caught=true;
                }else{
                    System.out.println("Yeah! You've got him and you used "+counter+" pokeballs");
                    pokemon.setName(asking.askForName());
                    trainer.getPokemonSet().add(pokemon);


                    caught=true;
                }
            }
            counter+=i;
        }if(caught==false){
            if(trainer.getPokeBalls().isEmpty()){
                System.out.println("You failed this time. Don't worry and try once again! But remember you've got no Pokeballs");
            }else{
                System.out.println("You failed this time. Don't worry and try once again!");
            }

        }
    }
}
