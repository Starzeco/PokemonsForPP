package Launcher;





import Launcher.CreatingCharacter.CreateAdventurer;
import Launcher.CreatingCharacter.CreateCharacter;
import Launcher.CreatingCharacter.CreateLeader;
import Launcher.CreatingCharacter.CreatePasiv;
import Models.PokeBalls.PokeBall;
import Models.Pokemon.Charizard;
import Models.Pokemon.Pikachu;
import Models.Pokemon.Pokemon;

import Models.Trainers.SpecificTrainer.August;
import Models.Trainers.SpecificTrainer.Henryk;
import Models.Trainers.SpecificTrainer.Stanisław;
import Models.Trainers.Trainer;
import Models.Types.Type;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Launcher {
    private Trainer trainer;
    private boolean launcherRun=true;
    private CreateCharacter createCharacter;

    public void run(){
        showCreateMenu();

        while(launcherRun){
            showPlayMenu();
        }

    }
    private void showCreateMenu() {
        trainerChoice();
        Scanner reader = new Scanner(System.in);
        boolean stop=false;
        while (!stop) {
            String input = reader.nextLine();
            if (StringUtils.isNumeric(input)) {

                switch (Integer.parseInt(input)) {
                    case 1:
                        createCharacter=new CreateAdventurer();
                        trainer=createCharacter.createCharacter();
                        stop=true;
                        break;
                    case 2:
                        createCharacter=new CreateLeader();
                        trainer=createCharacter.createCharacter();
                        stop=true;
                        break;
                    case 3:
                        createCharacter=new CreatePasiv();
                        trainer=createCharacter.createCharacter();
                        stop=true;
                        break;
                    default:
                        System.out.println("Wrong number, try again");
                }

            }else{
                System.out.println("Wrong number, try again");
            }

        }
    }
    private void showPlayMenu(){
        playMenu();
        Scanner reader=new Scanner(System.in);
        boolean stop=false;
        String answear="";
        while(!stop){
            answear=reader.nextLine();
            if(!StringUtils.isNumeric(answear)){
                System.out.println("Enter number please");
            }else{
                stop=true;
            }
        }
        switch (Integer.parseInt(answear)){
            case 1:
                findPokemon();
                break;
            case 2:
                trainer.showPokemons();
                break;
            case 3:
                trainer.getPokeBalls().add(new PokeBall());
                break;
            case 4:
                System.out.println("You have "+trainer.getPokeBalls().size()+" pokeballs");
                break;
            case 99:
                launcherRun=false;
                break;
            default:
                System.out.println("Not supported option");
        }
    }
    private void playMenu(){
        System.out.println("-------------------");
        System.out.println("What you wanna do?");
        System.out.println("1.Find Pokemon");
        System.out.println("2.Show my pokemon list");
        System.out.println("3.Buy pokeballs");
        System.out.println("4.How many do I have pokeballs?");
        System.out.println("Others are not supported yet");
        System.out.println("99.Stop game");
    }
    private void trainerChoice(){
        System.out.println("Which trainer would you like to choose?");
        System.out.println("1.Adventurer");
        System.out.println("2.Leader of Gym");
        System.out.println("3.Pasiv Trainer");
    }

    private void findPokemon(){
        Random random=new Random();
        int chance=random.nextInt(101);
        if(chance>=50){
            System.out.println("You've got luck, there is something!");
            int pokChance=random.nextInt(2);
            Pokemon pokToCatch;
            if(pokChance==0){
                int level=random.nextInt(101);
                pokToCatch=new Pikachu("wild",level);
            }else{
                int level=random.nextInt(101);
                pokToCatch=new Charizard("wild",level);
            }
            trainer.getCatchingPokemon().catchPokemon(pokToCatch,trainer);
        }else{
            System.out.println("There is nothing in this bush");
        }
    }
}
