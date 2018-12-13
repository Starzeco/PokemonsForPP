package models.Pokemon;


import models.Types.Type;


public class Pikachu extends Pokemon {
    public Pikachu(String name, int level){
        this.name=name;
        type= Type.ELEKTRYCZNY;
        if(level<=0){
            System.out.println("Zla podana dana, ustawiono lvl domsylny");
            this.level=5;
        }else{
            this.level=level;
        }

    }


    @Override
    public int countHardness() {
        if(level>=20){
            return 40;
        }
        else{
            return 10;
        }
    }
}
