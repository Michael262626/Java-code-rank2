package Controller;

import Exceptions.*;
import Services.DiaryServicesImplement;
import dtos.request.DeleteRequest;
import dtos.request.LoginRequest;
import dtos.request.UpdateRequest;

public class DiaryController {
    private final DiaryServicesImplement diaryServicesImplement = new DiaryServicesImplement();
    public String registerUser(LoginRequest request){
        try{
        diaryServicesImplement.register(request);
        return "Registration was successful";
    }catch (UserNameExistException e){
            return"UserName exist";
        }
    }
    public String login(String name, String password){
        try{
            diaryServicesImplement.login(name, password);
            return "Logged in successfully";
        }catch (InvalidPasswordException | InvalidUserNameException e){
            return (e.getMessage());
        }
    }
    public String logout(String name){
        try{
            diaryServicesImplement.logout(name);
            return "Logged out successfully";
        }catch (InvalidUserNameException | DiaryNotFoundException e){
            return (e.getMessage());
        }
    }
    public String findEntry(String title){
        try{
            diaryServicesImplement.findEntry(title);
            return "Enjoy.....";
        }catch (EntryNotFoundException e){
            return (e.getMessage());
        }
    }
    public String findDiary(String username){
        try{
            diaryServicesImplement.findDiaryByUsername(username);
            return "Diary found";
        }catch (InvalidUserNameException e){
            return (e.getMessage());
        }
    }
    public String deleteEntry(String title){
        try{
            diaryServicesImplement.deleteAnEntry(title);
            return "Entry deleted successfully";
        }catch (EntryNotFoundException e){
            return (e.getMessage());
        }
    }
    public String deleteDiary(DeleteRequest request){
        try{
            diaryServicesImplement.deleteDiary(request);
            return "Diary is removed";
        }catch (InvalidUserNameException | InvalidPasswordException e){
            return (e.getMessage());
        }
    }
    public String updateEntry(UpdateRequest request) {
        try {
            diaryServicesImplement.updateEntry(request);
            return "Entry Updated";
        }catch (EntryUpdateException | EntryNotFoundException e){
            return (e.getMessage());
        }
    }
}
