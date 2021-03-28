package id.ac.binus.assigment_lab;

public class Transaction_History {

    private String product_name;
    private String transaction_date;
    private int product_price;

    public Transaction_History(String product_name, String transaction_date, int product_price) {
        this.product_name = product_name;
        this.transaction_date = transaction_date;
        this.product_price = product_price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }


}
