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
    private String transaction_history_data;

    public void convert_arraylist_to_string(){
        this.transaction_history_data = "";
        for(int i = 0; i < this.list_transaction_history.size(); i++){
            transaction_history_data += this.list_transaction_history.get(i).getProduct_name() + "," + this.list_transaction_history.get(i).getTransaction_date() + "," + this.list_transaction_history.get(i).getProduct_price()+ ";";
        }
    }

    public void convert_string_to_arraylist(){
        String[] all_transaction_data = this.transaction_history_data.split(";");
//        "ExplodingKitten,28/3/2021,12000"
//        "CardsAgainstHumanity,28/3/2021,20000"
        for(int i = 0 ; i < all_transaction_data.length; i++){
            String[] all_transaction_list_attribute = all_transaction_data[i].split(",");
            this.list_transaction_history.add(new Transaction_History(all_transaction_list_attribute[0],all_transaction_list_attribute[1], Integer.parseInt(all_transaction_list_attribute[2]))) ;
        }
//        "ExplodingKitten"
//        "28/3/2021"
//        "12000"

//        "ExplodingKitten"
//        "28/3/2021"
//        "12000"
    }

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
