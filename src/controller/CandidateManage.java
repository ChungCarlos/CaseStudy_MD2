package controller;

import model.Candidates;
import storage.ReadFile;
import storage.WriteFile;

import java.util.ArrayList;
import java.util.Iterator;

public class CandidateManage {
    private ArrayList<Candidates>listCandidate;
    private WriteFile<Candidates> write;
    private ReadFile<Candidates> read;

    public CandidateManage() {
        listCandidate = new ArrayList<>();
        write =new WriteFile<>();
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


    // Phương thức thêm thí sinh...
    public void insert(Candidates candidates){
        listCandidate.add(candidates);
        write.writeFile(listCandidate);
    }


    // Phương thức xoá Thí sinh...theo mã thí sinh
//    public void delete(Candidates candidates){
//        for (Candidates c : listCandidate) {
//            if (c.getCode().equals(candidates)){
//                listCandidate.remove(c);
//                break;
//            }
//        }
//        write.writeFile(listCandidate);
//        System.out.println(" Successfully deleted!!!" + listCandidate);
//    }

//    public void delete(Candidates candidates) {
//        Iterator<Candidates> iterator = listCandidate.iterator();
//        while (iterator.hasNext()) {
//            Candidates c = iterator.next();
//            if (c.getCode().equals(candidates.getCode())) {
//                iterator.remove();
//                break;
//            }
//        }
//        write.writeFile(listCandidate);
//        System.out.println("Successfully deleted: " + candidates);
//    }

        public void delete(String candidates) {
            listCandidate.removeIf(c -> c.getCode().equals(candidates));
    }






    // Phương thức cập nhật danh sách...
    public void update(Candidates candidates){
        this.listCandidate.remove(candidates);
        this.listCandidate.add(candidates);
        write.writeFile(listCandidate);
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
