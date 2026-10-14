package verkocht;

public class Server extends Employee{
    //Konstruktor
    public Server(int x, int y, String eName,int upFrontPrice, int annualPay){
        xCord = x;
        yCord = y;
        name = eName;
        xp = 0;
        price = upFrontPrice;
        paycheck = annualPay;
    }

}