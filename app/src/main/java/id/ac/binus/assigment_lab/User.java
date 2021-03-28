package id.ac.binus.assigment_lab;

import java.util.ArrayList;

public class User {
    private int user_id;
    private String username;
    private String password;
    private String gender;
    private String dob;
    private String phone_number;
    private int wallet;
    static private ArrayList<Transaction_History> list_transaction_history = new ArrayList<>();

    public User(int user_id, String username, String password, String gender, String dob, String phone_number, int wallet) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.phone_number = phone_number;
        this.wallet = wallet;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public ArrayList<Transaction_History> getList_transaction_history() {
        return list_transaction_history;
    }

    public void setList_transaction_history(ArrayList<Transaction_History> list_transaction_history) {
        this.list_transaction_history = list_transaction_history;
    }






}
