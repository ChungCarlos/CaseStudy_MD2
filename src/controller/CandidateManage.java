package controller;

import model.Address;
import model.Candidates;
import model.TestScore;
import storage.ReadFile;
import storage.WriteFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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
        if (listCandidate.removeIf(c -> c.getCode().equals(candidates))) {
            System.out.println(" Delete successfully!");
            write.writeFile(listCandidate);
        } else {
            System.out.println(" Candidates not on the list. Can't delete!!!");
        }
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
        displayList();
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
        displayList();
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
    public void pass() {
        for (Candidates candidates : listCandidate) {
            if (candidates.totalScore() > 27) {
                System.out.println(candidates.getCode() + " " + candidates.getName() + " => passed ");
            } else {
                System.out.println(candidates.getCode() + " " + candidates.getName() + " => not passed ");
            }
        }
    }
// update

    public void update(String name) {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        for (Candidates candidates : listCandidate) {
            if (candidates.getName().toLowerCase().indexOf(name.toLowerCase()) >= 0) {
                check = true;
                System.out.println("Candidate search list: \n" + candidates);
                System.out.println("""
                         |>-----------------------<|
                         |    What do you          |
                         |         want to edit?   |
                         |>-----------------------<|
                         |  1. ID                  |
                         |  2. Name                |
                         |  3. Address             |
                         |  4. Date of birth       |
                         |  5. Gender              |
                         |  6. Score               |
                         |>-----------------------<|
                        """);
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        System.out.println(" Edit ID: ");
                        String newID = scanner.nextLine().trim();
                        candidates.setCode(newID);
                        break;
                    case 2:
                        System.out.println(" Edit name: ");
                        String newName = scanner.nextLine().trim();
                        candidates.setName(newName);
                        break;
                    case 3:
                        System.out.println(" Edit address: ");
                        System.out.println(" Please enter home number: ");
                        String numberHome = scanner.nextLine().trim();
                        System.out.println(" Please enter district: ");
                        String district = scanner.nextLine().trim();
                        System.out.println(" Please enter province: ");
                        String province = scanner.nextLine().trim();

                        Address address = new Address(numberHome, district, province);
                        candidates.setAddress(address);
                        break;
                    case 4:
                        System.out.println(" Edit date of birth:");
                        String newDate = scanner.nextLine().trim();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate date = LocalDate.parse(newDate, formatter);
                        candidates.setDateBirth(LocalDate.parse(newDate));
                        break;
                    case 5:
                        System.out.println(" Edit gender: ");
                        String newGender = scanner.nextLine().trim();
                        candidates.setGender(newGender);
                        break;
                    case 6:
                        System.out.println(" Edit Score: ");
                        System.out.println(" Please enter score math: ");
                        int scoreMath = Integer.parseInt(scanner.nextLine().trim());
                        System.out.println(" Please enter score Physics: ");
                        int scorePhysics = Integer.parseInt(scanner.nextLine().trim());
                        System.out.println(" Please enter score chemistry: ");
                        int scoreChemistry = Integer.parseInt(scanner.nextLine().trim());
                        System.out.println(" Please enter bonus point: ");
                        int bonusPoint = Integer.parseInt(scanner.nextLine().trim());

                        TestScore score = new TestScore(scoreMath, scorePhysics, scoreChemistry, bonusPoint);
                        candidates.setScore(score);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                break;
            } else {
                check = false;
            }
        }
        if(!check){
            System.out.println(" No information in the list...");
        }
        write.writeFile(listCandidate);
    }
}

