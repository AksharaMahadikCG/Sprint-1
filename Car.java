import java.util.*;


class VehicleException extends RuntimeException {
    String reason;
    int cc;

    public VehicleException(String reason, int cc) {
        super();
        this.reason = reason;
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "VehicleException  [reason=" + reason + ", cc=" + cc + "]";
    }

}

class UnsafetyException extends RuntimeException {
    String reason;
    int safety;

    public UnsafetyException(String reason, int safety) {
        super();
        this.reason = reason;
        this.safety = safety;
    }

    @Override
    public String toString() {
        return "UnsafetyException  [reason=" + reason + ", safety=" + safety + "]";
    }
}

class FourWheeler {

    String name;
    int cc,safety,price;

    public FourWheeler(String name, int cc, int safety, int price) {
        super();
        this.name = name;
        this.cc = cc;
        this.safety = safety;
        this.price = price;
    }

    void check() throws VehicleException, UnsafetyException {
        if (cc < 1000) {
            VehicleException ex = new VehicleException("It is a Two Wheeler, not Four Wheeler", cc);
            throw ex;
        }else if(cc>4000){
            VehicleException ex = new VehicleException("It is a Vehicle not a Train",cc);
            throw ex;
        } else if (safety != 5) {
            UnsafetyException ex = new UnsafetyException("Sorry, Invalid Safty features", safety);
            throw ex;
        }
    }

    @Override
    public String toString() {
        return "FourWheeler [name=" + name + ", cc=" + cc + ", safety=" + safety + ", price=" + price + "]";
    }
}


public class Car {

    public static void main(String[] args) {

        try {
            FourWheeler fourWheeler = new FourWheeler("Bentley", 1200, 3, 12000);
            System.out.println(fourWheeler);
            fourWheeler.check();

        } catch (VehicleException | UnsafetyException ex) {
            System.out.println(ex);
        }
        try {
            FourWheeler fourWheeler = new FourWheeler("Ferrari", 850, 0, 9900);
            System.out.println(fourWheeler);
            fourWheeler.check();
        } catch (VehicleException | UnsafetyException ex) {
            System.out.println(ex);
        }
        try {

            FourWheeler fourWheeler = new FourWheeler("Jaguar", 5000, 0, 129999);
            System.out.println(fourWheeler);
            fourWheeler.check();
        } catch (VehicleException | UnsafetyException ex) {
            System.out.println(ex);
        }
        try {
            FourWheeler fourWheeler = new FourWheeler("Land Rover", 1200, 5, 399999);
            System.out.println(fourWheeler);
            fourWheeler.check();
        } catch (VehicleException | UnsafetyException ex) {
            System.out.println(ex);
        }
    }
}