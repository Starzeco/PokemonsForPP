package Models.Pokemon;


import Models.Types.Type;

import java.util.Objects;


abstract public class Pokemon {
    protected Type type;
    protected String name;
    protected int level;

    public abstract int countHardness();

    public Type getType(){

        return type;
    }
    public String getName(){
        return name;

    }
    public int getLevel(){
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(name, pokemon.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
