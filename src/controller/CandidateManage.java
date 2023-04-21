package controller;

import model.Candidates;

import java.util.ArrayList;

public class CandidateManage {
    private ArrayList<Candidates>listCandidate;

    public CandidateManage() {
        this.listCandidate = new ArrayList<>();
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


    // Phương thức thêm thí sinh...
    public void insert(Candidates candidates){
        listCandidate.add(candidates);
    }

    // Phương thức xoá Thí sinh...theo mã thí sinh
    public boolean delete(Candidates candidates){
        return listCandidate.remove(candidates);
    }

    // Phương thức cập nhật danh sách...
    public void update(Candidates candidates){
        this.listCandidate.remove(candidates);
        this.listCandidate.add(candidates);
    }

    // Phương thức tra tồn tại...
    public boolean checkExits( Candidates candidates){
        boolean check = false;
        for (Candidates c : listCandidate) {
            if (c.getCode().equals(candidates.getCode()));
            check = true;
        }
        return true;
    }

    // Phương thức sort...theo điểm...
    // Phương thức tìm kiếm...
    public void searchCandidate(String name){
        for (Candidates candidates : listCandidate) {
            if (candidates.getName().indexOf(name)>=0){
                System.out.println("Candidate search list: "+ candidates);
            }
        }
    }
    // Phương thức hiển thị...
    public void displayList(){
        for (Candidates candidates : listCandidate) {
            System.out.println(candidates);
        }
        if (listCandidate.isEmpty()) {
            System.out.println("Không có sinh viên nào...");
        }
    }
}
