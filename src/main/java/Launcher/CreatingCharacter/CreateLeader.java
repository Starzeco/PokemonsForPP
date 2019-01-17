package Launcher.CreatingCharacter;

import Models.Pokemon.Charizard;
import Models.Pokemon.Pikachu;
import Models.Pokemon.Pokemon;
import Models.Trainers.SpecificTrainer.Henryk;
import Models.Trainers.Trainer;
import Models.Types.Type;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CreateLeader extends CreateCharacter {

    @Override
    public Trainer createCharacter() {
        System.out.println("Write your nickname");
        Scanner reader=new Scanner(System.in);
        String nickname=reader.nextLine();
        System.out.println("Choose your type");
        System.out.println("1.Fire");
        System.out.println("2.Electric");

        Trainer trainer=new Henryk();
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
        return trainer;
    }
}
