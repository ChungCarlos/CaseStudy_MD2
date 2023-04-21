package model;

public class TestScore {
    private float scoreMath;
    private float scorePhysics;
    private float scoreChemistry;

    public TestScore(int scoreMath, int scorePhysics, int scoreChemistry) {
        this.scoreMath = scoreMath;
        this.scorePhysics = scorePhysics;
        this.scoreChemistry = scoreChemistry;
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
