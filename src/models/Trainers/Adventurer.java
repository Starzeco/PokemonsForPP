package models.Trainers;

import Throwing.ThrowingStyle;

public abstract class Adventurer extends Trainer{

    protected int sizeOfBackpack;
    protected long traveledWay;
    protected int defeatedTrainers;
    protected int numberOfBadges;


    protected abstract void preapare();

}
