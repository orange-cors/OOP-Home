package Best;

public class Main {
    public static void main(String[] args) {
        Shipment s = new Shipment();
        s.add("PK001","A",10,10);
        s.add("pk002","B",11,11);
        System.out.println(s.findById("Pk001").getReceiver());
        System.out.println(s.findById("PK002").getReceiver());
        System.out.println(s.findById("PK999") == null ? "null" : "notnull");
    }
}
