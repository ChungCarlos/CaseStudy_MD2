package model;

import controller.CandidateManage;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Candidates implements Serializable {
    private String code;
    private String name;
    private Address address;
    private LocalDate dateBirth;
    private String gender;
    private TestScore score;


    public Candidates(String name) {
    }

public Candidates(String code, String name, Address address, LocalDate dateBirth, String gender, TestScore score) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.dateBirth = dateBirth;
        this.gender = gender;
        this.score = score;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public TestScore getScore() {
        return score;
    }

    public void setScore(TestScore score) {
        this.score = score;
    }

    public float scoreGPA() {
        return  totalScore()/3;
    }
    public float totalScore(){
        return score.getScoreMath() + score.getScorePhysics()+score.getScoreChemistry()+score.getBonusPoint();
    }

    @Override
    public String toString() {
        return
                " |------------Candidates------------| \n" +
                " | Id: " +getCode() + "\n" +
                " | Name: " +getName() + "\n" +
                " | Home number: " +address.getNumberHome() + "\n" +
                " | District: " +address.getDistrict() + "\n" +
                " | Province: " +address.getProvince() + "\n" +
                " | Date of Birth: " +getDateBirth() + "\n" +
                " | Gender: " +getGender() + "\n" +
                " | Math: " +score.getScoreMath()+ "\n" +
                " | Physics: " +score.getScorePhysics()+ "\n" +
                " | Chemistry: " +score.getScoreChemistry()+"\n" +
                " | Bonus: " +score.getBonusPoint()+"\n"
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidates that = (Candidates) o;
        return code.equals(that.code) && name.equals(that.name) && address.equals(that.address) && dateBirth.equals(that.dateBirth) && gender.equals(that.gender) && score.equals(that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, address, dateBirth, gender, score);
    }
}
