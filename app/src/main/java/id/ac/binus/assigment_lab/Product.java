package id.ac.binus.assigment_lab;

public class Product {
    private int product_id;
    private String product_name;
    private int product_min_player;
    private int product_max_player;
    private int product_price;
    private double product_longitude;
    private double product_latitude;

    public Product(int product_id, String product_name, int product_min_player, int product_max_player, int product_price, double product_longitude, double product_latitude) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_min_player = product_min_player;
        this.product_max_player = product_max_player;
        this.product_price = product_price;
        this.product_longitude = product_longitude;
        this.product_latitude = product_latitude;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_min_player() {
        return product_min_player;
    }

    public void setProduct_min_player(int product_min_player) {
        this.product_min_player = product_min_player;
    }

    public int getProduct_max_player() {
        return product_max_player;
    }

    public void setProduct_max_player(int product_max_player) {
        this.product_max_player = product_max_player;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public double getProduct_longitude() {
        return product_longitude;
    }

    public void setProduct_longitude(double product_longitude) {
        this.product_longitude = product_longitude;
    }

    public double getProduct_latitude() {
        return product_latitude;
    }

    public void setProduct_latitude(double product_latitude) {
        this.product_latitude = product_latitude;
    }

}
