package CatchingPokemon;

import models.Pokemon.Pokemon;
import models.Trainers.PasivTrainer;
import models.Trainers.Trainer;

import java.util.Random;

public class CatchingPokemonPasiv implements CatchingPokemon {
    @Override
    public void catchPokemon(Pokemon pokemon, Trainer trainer) {
        if(pokemon.countHardness()<=20){
            Random random=new Random();
            if(trainer instanceof PasivTrainer){
                trainer.getPokemonSet().add(pokemon);
                System.out.println("Yeah złapałeś go");
            }else{
                int chance=random.nextInt(101);
                if(chance>50){
                    trainer.getPokemonSet().add(pokemon);
                    System.out.println("Yeah złapałeś go");
                }else{
                    System.out.println("Pokemon uciekł, może następnym razem");
                }
            }

        }else{
            System.out.println("Niestety pokemona nie udało się złapać");
        }
    }
}
