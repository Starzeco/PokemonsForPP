package Models.Trainers;


import Models.Types.Type;


public abstract class LeaderOfGym extends Trainer {
    protected Type sala;
    protected int subChallenges;
    protected int defeatedTrainers;
    protected int difficultyLevel;
    protected double potential;


    protected abstract int countLevelOfGym();

}
