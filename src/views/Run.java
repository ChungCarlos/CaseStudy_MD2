package views;

import controller.CandidateManage;
import model.Address;
import model.Candidates;
import model.TestScore;
import storage.ReadFile;
import storage.WriteFile;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Run {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.menu();
    }
}
