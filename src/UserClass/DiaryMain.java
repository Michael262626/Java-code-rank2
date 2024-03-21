package UserClass;

import Controller.DiaryController;
import Model.Diary;
import Model.Entry;
import Services.DiaryServicesImplement;
import dtos.request.EntryCreation;
import dtos.request.LoginRequest;

import javax.swing.*;
import java.util.Scanner;

public class DiaryMain {
    static Scanner scanner = new Scanner(System.in);
    private static final LoginRequest loginRequest = new LoginRequest();
    private static final EntryCreation entryCreation=new EntryCreation();
    private static final DiaryController diaryController = new DiaryController();
    private static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    private static void print(String message){
        System.out.println(message);
    }
    private static void mainMenu() {
        String userInput = getInput("""
                <<===========>> WELCOME TO MY NEW DIARY <<===============>>
                <1>  Sign Up                          <2> Sign In                          <3> Exit....
                """);

        switch (userInput) {
            case "1" -> register();
            case "2" -> login();
            case "3" -> System.exit(101);
            default ->  mainMenu();
        }
    }
    private static void register() {
        String username = getInput("Enter your name: ");
        String password = getInput("Enter your password: ");
        diaryController.registerUser(new LoginRequest(username, password));
        }
    private static void login(){
        String username = getInput("Enter your name: ");
        String password = getInput("Enter your password: ");
        diaryController.login(username, password);
    }

    private static void diaryMenu(){
        String option = getInput("""
                <1> Create Entry
                <2> Update Entry
                <3> Find Entry
                <4> Delete Entry
                <5> Delete Diary
                <6> Home Page
                <7> Exit... 
                """);
        switch(option){
            case "1" -> createEntry();
            case "2" -> updateEntry();
            case "3" -> findEntry();
            case "4" -> deleteEntry();
            case "5" -> deleteDiary();
            case "5" -> mainMenu();
            case "6" -> System.exit(101);
            case default -> diaryMenu();
        }
    }

    private static void createEntry() {
        String title = getInput("Enter the title:\n ");
        String body = getInput("Enter the body of your entry:\n ");
        diaryController.createEntry(new EntryCreation(title, body));
    }
}

