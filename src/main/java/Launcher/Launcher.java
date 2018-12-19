package Launcher;





import Models.Pokemon.Charizard;
import Models.Pokemon.Pikachu;
import Models.Pokemon.Pokemon;
import Models.Trainers.Adventurer;
import Models.Trainers.SpecificTrainer.August;
import Models.Trainers.SpecificTrainer.Henryk;
import Models.Trainers.SpecificTrainer.Stanisław;
import Models.Trainers.Trainer;
import Models.Types.Type;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Launcher {
    Trainer trainer;

    public void run(){
        showCreateMenu();
       // System.out.println(trainer.toString()); TODO delete this
        showPlayMenu();
    }
    private void showCreateMenu() {
        System.out.println("Which trainer would you like to choose?");
        System.out.println("1.Adventurer");
        System.out.println("2.Leader of Gym");
        System.out.println("3.Pasiv Trainer");
        Scanner reader = new Scanner(System.in);
        boolean stop=false;
        while (!stop) {
            String input = reader.nextLine();
            if (StringUtils.isNumeric(input)) {

                switch (Integer.parseInt(input)) {
                    case 1:
                        createAdventure();
                        stop=true;
                        break;
                    case 2:
                        createLeader();
                        stop=true;
                        break;
                    case 3:
                        createPasiv();
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



    private void createAdventure(){
        System.out.println("Write your nickname");
        Scanner reader=new Scanner(System.in);
        String nickname=reader.nextLine();
        System.out.println("Choose your backpack");
        System.out.println("1.Large (10kg)");
        System.out.println("2.Slight (5kg)");

        boolean stop=false;
        while(!stop){
            String input=reader.nextLine();
            if(StringUtils.isNumeric(input)){
                switch (Integer.parseInt(input)) {
                    case 1:
                        trainer=new August(nickname,10);
                        stop=true;
                        break;
                    case 2:
                        trainer=new August(nickname,5);
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
    private void createLeader(){
        System.out.println("Write your nickname");
        Scanner reader=new Scanner(System.in);
        String nickname=reader.nextLine();
        System.out.println("Choose your type");
        boolean stop=false;
        while(!stop){
            String input=reader.nextLine();
            if(StringUtils.isNumeric(input)){
                switch (Integer.parseInt(input)) {
                    case 1:
                        Set<Pokemon> tmp=new HashSet<Pokemon>();
                        tmp.add(new Charizard("default",10));
                        trainer=new Henryk(tmp,nickname, Type.OGNISTY);
                        stop=true;
                        break;
                    case 2:
                        Set<Pokemon> tmp2=new HashSet<Pokemon>();
                        tmp2.add(new Pikachu("default",10));
                        trainer=new Henryk(tmp2,nickname, Type.ELEKTRYCZNY);
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
    private void createPasiv(){
        System.out.println("Write your nickname");
        Scanner reader=new Scanner(System.in);
        String nickname=reader.nextLine();
        System.out.println("Is he/she working? Y-yes/N-no");

        boolean isWorking=booleanQuestion();

        System.out.println("Does he/she work at home? Y-yes/N-no");

        boolean staysInHome=booleanQuestion();

        System.out.println("Where do you live?");
        String place=reader.nextLine();
        System.out.println("How big is your home?");
        boolean stop=false;
        String size="";
        while(!stop){
            size=reader.nextLine();
            if(StringUtils.isNumeric(size)){
                stop=true;
            }
            else{
                System.out.println("Enter number please");
            }
        }
        trainer=new Stanisław(nickname,isWorking,staysInHome,place,Integer.parseInt(size));

    }

    private boolean booleanQuestion(){
        Scanner reader=new Scanner(System.in);
        if(reader.nextLine()=="Y") return true;
        else return false;
    }
    private void showPlayMenu(){
        System.out.println("What you wanna do?");
        System.out.println("1.Find Pokemon");
        System.out.println("Other not supported yet");
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
            default:
                System.out.println("Not supported option");
        }
    }

    private void findPokemon(){

    }
}
