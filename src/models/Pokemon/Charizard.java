package models.Pokemon;



import models.Types.Type;


public class Charizard extends Pokemon {

    public Charizard(String name, int level){
        this.name=name;
        type= Type.OGNISTY;
        this.level=level;
    }

    @Override
    public int countHardness() {
        if(level>=20 && level<70){
            return 50;
        }else if(level>=70){
            return 90;
        }else{
            return 40;
        }

    }
}
