package CatchingPokemon;

import CatchingPokemon.Questions.Asking;
import CatchingPokemon.Questions.AskingImpl;
import Models.Pokemon.Pokemon;
import Models.Trainers.PasivTrainer;
import Models.Trainers.Trainer;

import java.util.Random;

public class CatchingPokemonPasiv implements CatchingPokemon {
    final public Asking asking=new AskingImpl();
    @Override
    public void catchPokemon(Pokemon pokemon, Trainer trainer) {
        if(!trainer.getPokeBalls().isEmpty()) {
            if (pokemon.countHardness() <= 20) {
                Random random = new Random();
                if (trainer instanceof PasivTrainer) {
                    System.out.println("Yeah, you've got him");
                    pokemon.setName(asking.askForName());
                    trainer.getPokemonSet().add(pokemon);

                } else {
                    int chance = random.nextInt(101);
                    if (chance > 50) {
                        System.out.println("Yeah, you've got him");
                        pokemon.setName(asking.askForName());
                        trainer.getPokemonSet().add(pokemon);

                    } else {
                        System.out.println("Pokemon has escaped, try next time");
                    }
                }

            } else {
                System.out.println("You failed this time, try again later");
            }
        }else{
            System.out.println("You have no pokeballs");
        }
    }
}
