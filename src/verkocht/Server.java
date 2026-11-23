package verkocht;

public class Server extends Employee{
    //Konstruktor
    public Server(int x, int y, String eName,int upFrontPrice, int annualPay){
        super(x, y, eName, new Item[1], upFrontPrice, annualPay);
    }
}