package views;

import controller.CandidateManage;
import model.Address;
import model.Candidates;
import model.TestScore;
import storage.WriteFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import static java.lang.System.in;

public class Menu {

    public void menu(){
        CandidateManage candidateManage = new CandidateManage();
        Regex regex = new Regex();

//        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

//        Candidates c1 = new Candidates("MS01","Trần Văn Chung",new Address(" 28 Hoàng Công Chất "," Từ Liêm","HN"), LocalDate.of(1995,05,10),"Nam",new TestScore(9,10,9,1));
//        Candidates c2 = new Candidates("MS02","Nguyễn Minh Công",new Address(" 28 Hoàng Công Chất "," Từ Liêm","HN"),LocalDate.of(1998,04,27),"Nam",new TestScore(5,1,9,1));
//        Candidates c3 = new Candidates("MS03","Phạm Minh Tuấn",new Address(" 88 Hoàng Quốc Việt "," Cầu Giấy","HN"),LocalDate.of(1998,12,17),"Nam",new TestScore(10,10,9,1));
//        var list = candidateManage.getListCandidate();
//        list.add(c1);
//        list.add(c2);
//        list.add(c3);
//        WriteFile t = new WriteFile();
//        t.writeFile(list);

        Scanner scanner = new Scanner(in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("""
                      
                      |>  --><-- MENU --><--  <|
                      || 1. Insert a contact  ||
                      || 2. Display all list  ||
          Please      || 3. Search by ID      ||
           Choice =>  || 4. Delete a contact  ||
                      || 5. Sort by score(GPA)|| 
                      || 6. Sort by ID        ||
                      || 7. Display passed    ||
                      ||      0. Exit -->     ||
                      |>======================<|                                         
                      """);
            choice = Integer.parseInt(scanner.nextLine().trim());
            switch (choice) {
                case 1: {
                    int x;
                    do {
                        System.out.println("""
                                |>---------------Please Choice---------------<|
                                |     Do you want to add new contestants?     |
                                |    Please select the corresponding number:  |
                                |          1. Yes / Add candidate ->          |
                                |               2. No / Back <-               |
                                |_____________________________________________|               
                                    """);
                        x = Integer.parseInt(scanner.nextLine().trim());

                        switch (x) {
                            case 1: {

                                try {
                                    System.out.println(" Enter a code candidate: ");
                                    String code = scanner.nextLine().trim();
                                    while (!regex.validateId(code)){
                                        System.out.println("Re-enter in the following format: MS01 ");
                                        code = scanner.nextLine().trim();
                                    }

                                    System.out.println(" Enter name: ");
                                    String name = scanner.nextLine().trim();
                                    while (!regex.validateName(name)){
                                        System.out.println("Re-enter in the following format: Tran Van Chung ");
                                        name = scanner.nextLine().trim();
                                    }

                                    System.out.println(" ...Address... ");
                                    System.out.println(" Please enter home number: ");
                                    String numberHome = scanner.nextLine().trim();
                                    System.out.println(" Please enter district: ");
                                    String district = scanner.nextLine().trim();
                                    System.out.println(" Please enter province: ");
                                    String province = scanner.nextLine().trim();
                                    Address address = new Address(numberHome, district, province);

                                    System.out.println(" Enter date of birth (dd-MM-yyyy): ");
                                    String inputDate = scanner.nextLine().trim();

                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                                    LocalDate date = LocalDate.parse(inputDate, formatter);
                                    String formattedDate = date.format(formatter);

                                    System.out.println("Date of birth entered: " + formattedDate);


                                    System.out.println(" Enter gender: ");
                                    String gender = scanner.nextLine().trim();


                                    System.out.println(" Enter score Math: ");
                                    int scoreMath = Integer.parseInt(scanner.nextLine().trim());
                                    System.out.println(" Enter score Physics: ");
                                    int scorePhysics = Integer.parseInt(scanner.nextLine().trim());
                                    System.out.println(" Enter score Chemistry: ");
                                    int scoreChemistry = Integer.parseInt(scanner.nextLine().trim());
                                    System.out.println(" Enter bonus point: ");
                                    int bonusPoint = Integer.parseInt(scanner.nextLine().trim());

                                    TestScore testScore = new TestScore(scoreMath, scorePhysics, scoreChemistry,bonusPoint);

                                    Candidates c = new Candidates(code, name, address, date, gender, testScore);
                                    candidateManage.insert(c);
                                } catch (DateTimeParseException e) {
                                    System.out.println("...Invalid date format. Please enter in the format dd-MM-yyyy...");
                                } catch (NumberFormatException e) {
                                    System.out.println("...Please enter the correct number format...");
                                }
                                break;
                            }
                            case 2: {
                                System.out.println("Returning program...");
                                break;
                            }
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (x != 2);
                }
                break;
                case 2: {
                    candidateManage.displayList();
                    break;
                }

                case 3: {
                    System.out.println(" Please enter the correct name to search:");
                    String name = scanner.nextLine().trim();
                    candidateManage.searchCandidate(name);
                    break;
                }
                case 4: {
                    System.out.println(" Please enter the correct candidate code to delete: ");
                    String name = scanner.nextLine().trim();
                    candidateManage.delete(name);
                    System.out.println(" Delete successfully!");
                    break;
                }
                case 5: {
                    int sort;
                    do {
                        System.out.println("""                       
                                |>--------------<|
                    Please      | 1. Descending. |
                     Choice =>  | 2. Ascending.  |
                                | 0. <- Back     |
                                |________________|
                                """);
                        sort = Integer.parseInt(scanner.nextLine().trim());
                        switch (sort) {
                            case 1: {
                                System.out.println(" Descending score list is: ");
                                candidateManage.sortScoreDecrease();
                                break;
                            }
                            case 2: {
                                System.out.println(" Ascending score list is: ");
                                candidateManage.sortScoreAscending();
                                break;
                            }
                            case 0:{
                                System.out.println("Returning program...");
                                break;
                            }
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }while (sort != 0);
                }
                break;
                case 6: {
                    candidateManage.sortID();
                    break;
                }
                case 7:
                    candidateManage.pass();
                    break;
                case 0:
                    scanner.close();
                default:
                    System.out.println(" Please choose the correct function number sequence above!");
            }
        }
    }
}
