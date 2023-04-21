package views;

import controller.CandidateManage;
import model.Address;
import model.Candidates;
import model.TestScore;
import storage.ReadFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Run {

    List<Candidates> candidates = ReadFile.readFile();

    public static void main(String[] args) {
        CandidateManage candidateManage = new CandidateManage();
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
                    System.out.println(" Please enter the name to delete: ");
                    String name = scanner.nextLine();
                    Candidates c = new Candidates(name);
                    System.out.println("Xoá sinh viên trong danh sách: " + candidateManage.delete(c));
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
