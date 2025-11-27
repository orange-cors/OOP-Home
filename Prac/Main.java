package Prac;

public class Main {
    public static void main(String[] args) {
        Shipment s = new Shipment();
        s.add(new Parcel("PK001","A",10,100));
        s.add("PK002","B",5,50); // overloading
        System.out.println("size=" + s.size());
    }
}
