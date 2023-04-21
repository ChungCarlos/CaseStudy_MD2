package views;

import controller.CandidateManage;
import model.Address;
import model.Candidates;
import model.TestScore;
import storage.ReadFile;
import storage.WriteFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Run {

//    List<Candidates> candidates = ReadFile.readFile();

    public static void main(String[] args) {
        CandidateManage candidateManage = new CandidateManage();

//        Candidates c1 = new Candidates("Ms01","Trần Văn Chung",new Address(" 28 Hoàng Công Chất "," Từ Liêm","HN"), LocalDate.of(1995,05,10),"Nam",new TestScore(9,10,9));
//        Candidates c2 = new Candidates("Ms02","Nguyễn Minh Công",new Address(" 28 Hoàng Công Chất "," Từ Liêm","HN"),LocalDate.of(1998,04,27),"Nam",new TestScore(5,8,9));
//        Candidates c3 = new Candidates("Ms03","Phạm Minh Tuấn",new Address(" 88 Hoàng Quốc Việt "," Cầu Giấy","HN"),LocalDate.of(1998,12,17),"Nam",new TestScore(10,10,9));
//        Candidates c4 = new Candidates("Ms04","Ngô Hoàng Hải",new Address(" 112 Ba Đình "," Ba Đình","HN"), LocalDate.of(2001,05,10),"Nam",new TestScore(9,7,9));
//        Candidates c5 = new Candidates("Ms05","Đinh Thị Tú Uyên",new Address(" 36 Sầm Sơn "," Thanh Hoá","Thanh Hoá"),LocalDate.of(2000,04,27),"Nam",new TestScore(5,8,5));
//        Candidates c6 = new Candidates("Ms06","Giàng Thị Dủa",new Address(" 18 Hoa Hùng "," Hưng Yên","Hưng Yên"),LocalDate.of(1996,12,17),"Nam",new TestScore(5,10,7));
//        var list = candidateManage.getListCandidate();
//        list.add(c1);
//        list.add(c2);
//        list.add(c3);
//        list.add(c4);
//        list.add(c5);
//        list.add(c6);
//        WriteFile t = new WriteFile();
//        t.writeFile(list);


        Scanner scanner = new Scanner(in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("MENU ---------------");
            System.out.println(" 1. Insert a contact.\n" +
                    " 2.  Display by type.\n" +
                    " 3. Sort by name.\n" +
                    " 4.  Search by name.\n" +
                    " 5.  Delete a contact.\n" +
                    " 6.  Update contacts.\n" +
                    " 0.  Exit...");
            System.out.println(" Please select function: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: {
                    int x;
                    do {
                        System.out.println(
                                " Do you want to add new contestants? \n" +
                                        " ...Please select the corresponding number... \n" +
                                        " 1. Yes / Add candidate--> \n" +
                                        " 2. No / Exit-->");
                        x = Integer.parseInt(scanner.nextLine());

                        switch (x) {
                            case 1: {
                                System.out.println(" Enter a code candidate: ");
                                String code = scanner.nextLine();

                                System.out.println(" Enter name: ");
                                String name = scanner.nextLine();

                                System.out.println(" ...Address... ");
                                System.out.println(" Please enter home number: ");
                                String numberHome = scanner.nextLine();
                                System.out.println(" Please enter district: ");
                                String district = scanner.nextLine();
                                System.out.println(" Please enter province: ");
                                String province = scanner.nextLine();
                                Address address = new Address(numberHome, district, province);

                                System.out.println(" Enter date of birth: ");
                                LocalDate date = LocalDate.parse(scanner.nextLine());

                                System.out.println(" Enter gender: ");
                                String gender = scanner.nextLine();


                                System.out.println(" Enter score Math: ");
                                int scoreMath = Integer.parseInt(scanner.nextLine());
                                System.out.println(" Enter score Physics: ");
                                int scorePhysics = Integer.parseInt(scanner.nextLine());
                                System.out.println(" Enter score Chemistry: ");
                                int scoreChemistry = Integer.parseInt(scanner.nextLine());
                                TestScore testScore = new TestScore(scoreMath, scorePhysics, scoreChemistry);

                                Candidates c = new Candidates(code, name, address, date, gender, testScore);

                                candidateManage.insert(c);
                                break;
                            }
                            case 2:{
                                System.out.println("Exiting program...");
                                break;
                            }
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (x!=2);
                }
                break;
                case 2:{
                    candidateManage.displayList();
                    break;}
                case 3:{
                    System.out.println(" Enter id: ");
                    String id = scanner.nextLine();
                    System.out.println(" Enter name: ");
                    String name = scanner.nextLine();

                    break;}
                case 4:{
                    System.out.println(" Please enter the search term...");
                    String name = scanner.nextLine();
                    candidateManage.searchCandidate(name);
                    break;}
                case 5: {
                    System.out.println(" Please enter the correct candidate code to delete: ");
                    String name = scanner.nextLine();
                    candidateManage.delete(name);
                    break;
                }
                case 6:{
                    System.out.println( "Please enter the name");
                    String name = scanner.nextLine();
                    System.out.println( "Please enter telephone number");
                    String phone = scanner.nextLine();
                    break;}
                case 0:
                    scanner.close();
                default:
                    System.out.println(" Please choose the correct function number sequence above!");
            }
        }
    }
}
