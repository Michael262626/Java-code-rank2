package UserClass;

import Controller.DiaryController;
import Model.Diary;
import dtos.request.DeleteRequest;
import dtos.request.EntryCreation;
import dtos.request.LoginRequest;
import dtos.request.UpdateRequest;
import java.util.Scanner;

public class DiaryMain {
    static Scanner scanner = new Scanner(System.in);
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
                       What do you want to do?               What do you want to do?                     What do you want to do?
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
                <6> Find Diary
                <7> Home Page
                <8> Exit......
                """);
        switch(option){
            case "1" -> createEntry();
            case "2" -> updateEntry();
            case "3" -> findEntry();
            case "4" -> deleteEntry();
            case "5" -> deleteDiary();
            case "6" -> findDiary();
            case "7" -> logout();
            case "8" -> System.exit(101);
            default -> diaryMenu();
        }
    }

    private static void createEntry() {
        String title = getInput("Enter the title:\n ");
        String body = getInput("Enter the body of your entry:\n ");
        diaryController.createEntry(new Diary(), new EntryCreation(title, body));
        print("Dairy created successfully");
    }
    private static void updateEntry(){
        String title = getInput("Enter the title: ");
        String body = getInput("Enter the new body: ");
        diaryController.updateEntry(new UpdateRequest(title, body));
        print("Updated successfully");
    }
    private static void findEntry(){
        String title = getInput("Enter your title: ");
        print(diaryController.findEntry(title));

    }
    private static void deleteEntry(){
        String title = getInput("Enter the title to delete entry: ");
        print(diaryController.deleteEntry(title));
    }
    private static void deleteDiary(){
        String username = getInput("Enter your name; ");
        String password = getInput("Enter your password: ");
        print(diaryController.deleteDiary(new DeleteRequest(username, password)));
    }
    private static void logout(){
        String username = getInput("Enter your name: ");
        print(diaryController.logout(username));
        mainMenu();
    }
    private static void findDiary(){
        String username = getInput("Enter your username: ");
        print(diaryController.findDiary(username));
    }

    public static void main(String[] args) {
        mainMenu();
        diaryMenu();
    }
}

