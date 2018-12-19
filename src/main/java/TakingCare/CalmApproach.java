package TakingCare;

import Models.Pokemon.Pokemon;
import Models.Types.Type;

public class CalmApproach implements TakingCare {
    @Override
    public void lookAfter(Pokemon pokemon) {
        if(pokemon.countHardness()<50){
            System.out.println("Poziom jest zbyt maly");
        }else{
            if(pokemon.getType()== Type.DUCHOWY){
                System.out.println("Tym typem nie da się tak opiekowac");
            }else{
                pokemon.setLevel(pokemon.getLevel()+1);
            }
        }
    }
}
