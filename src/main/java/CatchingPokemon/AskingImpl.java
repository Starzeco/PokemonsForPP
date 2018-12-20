package CatchingPokemon;

import java.util.Scanner;

public class AskingImpl implements Asking {
    @Override
    public String askForName() {
        System.out.println("Set his name now");
        Scanner reader=new Scanner(System.in);
        return reader.nextLine();
    }
}
