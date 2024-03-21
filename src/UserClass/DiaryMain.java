package UserClass;

import Controller.DiaryController;
import Exceptions.InvalidUserNameException;
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
                <1>  Sign Up                                            <2> Sign In                                                       <3> Exit....
                       What do you want to do?                           What do you want to do?                                    What do you want to do?
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
        while(username.trim().isEmpty()){
            print("Name field is required");
            username = getInput("Enter your first name: ");
        }
        String password = getInput("Enter your password: ");
        while(password.trim().isEmpty()){
            print("Password field is required");
            password = getInput("Enter your first name: ");
        }
        print(diaryController.registerUser(new LoginRequest(username.toLowerCase(), password)));
        diaryMenu();
        }
    private static void login(){
        try{
        String name = getInput("Enter your name to login: ");
        while(name.trim().isEmpty()){
            print("Name field is required");
            name = getInput("Enter your first name: ");
        }
        String password = getInput("Enter your password: ");
        while(password.trim().isEmpty()){
            print("Password field is required");
            password = getInput("Enter your first name: ");
        }
        print(diaryController.login(name.toLowerCase(), password));
        diaryMenu();
    }catch (InvalidUserNameException e){
            print(e.getMessage());
            mainMenu();
        }
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
                What do you want to do?
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
        while (title.trim().isEmpty()){
            print("Title field is required");
            title = getInput("Enter the title:\n ");
        }
        String body = getInput("Enter the body of your entry:\n ");
        print(diaryController.createEntry(new Diary(), new EntryCreation(title.toUpperCase(), body)));

    }
    private static void updateEntry(){
        String title = getInput("Enter the title: ");
        String body = getInput("Enter the new body: ");
        print(diaryController.updateEntry(new UpdateRequest(title.toUpperCase(), body)));

    }
    private static void findEntry(){
        String title = getInput("Enter your title: ");
        print(diaryController.findEntry(title.toUpperCase()));

    }
    private static void deleteEntry(){
        String title = getInput("Enter the title to delete entry: ");
        print(diaryController.deleteEntry(title.toUpperCase()));
        diaryMenu();
    }
    private static void deleteDiary(){
        String username = getInput("Enter your name; ");
        while(username.trim().isEmpty()){
            print("Name field is required");
            username = getInput("Enter your name: ");
        }
        String password = getInput("Enter your password: ");
        while(password.trim().isEmpty()){
            print("Password field is required");
            password = getInput("Enter your password");
        }
        print(diaryController.deleteDiary(new DeleteRequest(username.toLowerCase(), password)));
        mainMenu();
    }
    private static void logout(){
        String username = getInput("Enter your name: ");
        while(username.trim().isEmpty()){
            print("Name field is required");
            username = getInput("Enter your name: ");
        }
        print(diaryController.logout(username.toLowerCase()));
        mainMenu();
    }
    private static void findDiary(){
        String username = getInput("Enter your username: ");
        while(username.trim().isEmpty()){
            print("Name field is required");
            username = getInput("Enter your name: ");
        }
        print(diaryController.findDiary(username.toLowerCase()));
    }

    public static void main(String[] args) {
        mainMenu();
        diaryMenu();
    }
}

