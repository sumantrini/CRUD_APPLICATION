package CRUD_APPLICATION;

import java.io.Serializable;;

public class User implements Serializable{
    
    private String aadhar, name, dob, gender, address, contact, email;
    private int  income;

    private static final long serialVersionUID= 1L;

    public User(){

    }

    public User(String Aadhar, String name, String dob, String gender, String address, String contact, String email, int income){

        this.aadhar= Aadhar;
        this.name= name;
        this.dob= dob;
        this.gender= gender;
        this.address= address;
        this.contact= contact;
        this.email= email;
        this.income= income;
    }

    public String getAadhar(){
        return aadhar;
    }
    public void setAadhar(String Aadhar){
        this.aadhar= Aadhar;
    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name= name;
    }

    public String getDob(){
        return dob;
    }
    public void setDob(String dob){
        this.dob= dob;
    }

    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender= gender;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address= address;
    }

    public String getContact(){
        return contact;
    }
    public void setContact(String contact){
        this.contact= contact;
    }

    public int getIncome(){
        return income;
    }
    public void setIncome(int income){
        this.income= income;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email= email;
    }
}
