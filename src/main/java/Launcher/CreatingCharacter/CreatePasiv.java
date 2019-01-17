package Launcher.CreatingCharacter;

import Models.Trainers.SpecificTrainer.Stanisław;
import Models.Trainers.Trainer;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class CreatePasiv extends CreateCharacter {

    @Override
    public Trainer createCharacter() {

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
        return new Stanisław(nickname,isWorking,staysInHome,place,Integer.parseInt(size));
    }
    private boolean booleanQuestion(){
        Scanner reader=new Scanner(System.in);
        if(reader.nextLine()=="Y") return true;
        else return false;
    }
}
