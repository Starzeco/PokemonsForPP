package models.Trainers;

import TakingCare.TakingCare;

public abstract class PasivTrainer extends Trainer{

    protected boolean isWorking;
    protected boolean staysInHome;
    protected String place;
    protected int sizeOfField;
    protected TakingCare takingCare;

    protected abstract void report();

}
