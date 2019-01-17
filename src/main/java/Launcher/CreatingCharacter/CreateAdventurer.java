package Launcher.CreatingCharacter;

import Models.Trainers.SpecificTrainer.August;
import Models.Trainers.Trainer;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class CreateAdventurer extends CreateCharacter {

    @Override
    public Trainer createCharacter() {
        System.out.println("Write your nickname");
        Scanner reader=new Scanner(System.in);
        String nickname=reader.nextLine();
        System.out.println("Choose your backpack");
        System.out.println("1.Large (10kg)");
        System.out.println("2.Slight (5kg)");

        boolean stop=false;
        Trainer trainer=new August("default",10);
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
        return trainer;
    }
}
