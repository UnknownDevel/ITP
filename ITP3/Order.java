package ITP3;

public class Order {
    private String product;
    private String address;
    private String price;
    
    public Order(String product, String address, String price){
        this.product = product;
        this.price = price;
        this.address = address;
    }
    public String getproduct(){
        return this.product;
    }
    public void setproduct(String product){
        this.product = product;
    }
    public String getprice(){
        return this.price;
    }
    public void setprice(String price){
        this.price = price;
    }
    public String getaddress(){
        return this.address;
    }
    public void setaddress(String address){
        this.address = address;
    }
}
