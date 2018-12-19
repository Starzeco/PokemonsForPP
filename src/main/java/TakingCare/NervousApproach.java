package TakingCare;

import Models.Pokemon.Pokemon;
import Models.Types.Type;

public class NervousApproach implements TakingCare {
    @Override
    public void lookAfter(Pokemon pokemon) {
        if(pokemon.countHardness()>50){
            System.out.println("Poziom jest zbyt duzy");
        }else{
            if(pokemon.getType()== Type.WODNY){
                System.out.println("Tym typem nie da się tak opiekowac");
            }else{
                pokemon.setLevel(pokemon.getLevel()+1);
            }
        }
    }
}
