package model;

import java.io.Serializable;

public class TestScore implements Serializable {
    private float scoreMath;
    private float scorePhysics;
    private float scoreChemistry;
    private float bonusPoint;


        public TestScore(int scoreMath, int scorePhysics, int scoreChemistry, int bonusPoint) {
        this.scoreMath = scoreMath;
        this.scorePhysics = scorePhysics;
        this.scoreChemistry = scoreChemistry;
        this.bonusPoint = bonusPoint;
    }
    public TestScore() {
    }

    
    public float getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(float bonusPoint) {
        this.bonusPoint = bonusPoint;
    }


    public float getScoreMath() {
        return scoreMath;
    }

    public void setScoreMath(int scoreMath) {
        this.scoreMath = scoreMath;
    }

    public float getScorePhysics() {
        return scorePhysics;
    }

    public void setScorePhysics(int scorePhysics) {
        this.scorePhysics = scorePhysics;
    }

    public float getScoreChemistry() {
        return scoreChemistry;
    }

    public void setScoreChemistry(int scoreChemistry) {
        this.scoreChemistry = scoreChemistry;
    }


}
