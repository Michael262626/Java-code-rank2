package Controller;

import Exceptions.*;
import Model.Diary;
import Model.Entry;
import Services.DiaryServicesImplement;
import dtos.request.DeleteRequest;
import dtos.request.EntryCreation;
import dtos.request.LoginRequest;
import dtos.request.UpdateRequest;

public class DiaryController {
    private final Entry entry = new Entry();
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

            diaryServicesImplement.login(name, password);
            return "Logged in successfully";



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
            return String.format(entry.toString());
        }catch (EntryNotFoundException e){
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
    public String createEntry(Diary diary, EntryCreation entryCreation){
            diaryServicesImplement.addEntry(diary, entryCreation);
            return "Created successfully";
    }
}
