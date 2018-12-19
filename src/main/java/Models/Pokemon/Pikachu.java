package Models.Pokemon;


import Models.Types.Type;


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

    public int dodge(){
        if(level>=20){
            return 15;
        }
        else{
            return 10;
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
