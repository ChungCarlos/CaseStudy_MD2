package controller;

import model.Candidates;
import model.TestScore;
import storage.ReadFile;
import storage.WriteFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CandidateManage {
    private ArrayList<Candidates> listCandidate;
    private WriteFile<Candidates> write;
    private ReadFile<Candidates> read;

    public CandidateManage() {
        listCandidate = new ArrayList<>();
        write = new WriteFile<>();
        read = new ReadFile<>();
        listCandidate = read.readFile();
    }

    public CandidateManage(ArrayList<Candidates> listCandidate) {
        this.listCandidate = listCandidate;
    }

    public ArrayList<Candidates> getListCandidate() {
        return listCandidate;
    }

    public void setListCandidate(ArrayList<Candidates> listCandidate) {
        this.listCandidate = listCandidate;
    }


    // 1. Phương thức thêm thí sinh...
    public void insert(Candidates candidates) {
        listCandidate.add(candidates);
        write.writeFile(listCandidate);
    }

    // 2. Phương thức hiển thị...
    public void displayList() {
        System.out.println("List has: " + listCandidate.size() + " Candidate.");
        for (Candidates candidates : listCandidate) {
            System.out.println(candidates);
        }
        if (listCandidate.isEmpty()) {
            System.out.println("Empty list...");
        }
    }

    // 3. Phương thức tìm kiếm theo tên
    public void searchCandidate(String name) {
        for (Candidates candidates : listCandidate) {
            if (candidates.getName().toLowerCase().indexOf(name.toLowerCase()) >= 0) {
                System.out.println("Candidate search list: \n" + candidates);
            } else {
                System.out.println(" No information in the list...");
                break;
            }
        }
    }

    // 4. Phương thức xoá Thí sinh...theo mã thí sinh
    public void delete(String candidates) {
        listCandidate.removeIf(c -> c.getCode().equals(candidates));
        write.writeFile(listCandidate);
    }



    // 5. Phương thức sort...theo điểm...
    public void sortScoreAscending() {
        Collections.sort(this.listCandidate, new Comparator<Candidates>() {

            @Override
            public int compare(Candidates o1, Candidates o2) {
                if (o1.scoreGPA() < o2.scoreGPA()) {
                    return -1;
                } else if (o1.scoreGPA() > o2.scoreGPA()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(listCandidate);
    }

    public void sortScoreDecrease() {

        Collections.sort(listCandidate, new Comparator<Candidates>() {
            @Override
            public int compare(Candidates o1, Candidates o2) {
                if (o1.scoreGPA() < o2.scoreGPA()) {
                    return 1;
                } else if (o1.scoreGPA() > o2.scoreGPA()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(listCandidate);
    }

    // 6. Phương thức sort...theo ID...
    public void sortID() {
        Collections.sort(listCandidate, new Comparator<Candidates>() {
            @Override
            public int compare(Candidates id1, Candidates id2) {
                return id1.getCode().compareTo(id2.getCode());
            }
        });
        System.out.println(listCandidate);
    }

    // 7. Pass Ngành CNTT khối A
    public void pass(){
        for (Candidates candidates : listCandidate) {
            if (candidates.totalScore()>27){
                System.out.println(candidates.getCode() + " " + candidates.getName() + " => passed ");
            } else {
                System.out.println(candidates.getCode() + " " + candidates.getName() + " => not passed ");
            }
        }
    }
}
