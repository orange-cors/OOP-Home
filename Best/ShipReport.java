package Best;

public class ShipReport {
    public static String brief(Shipment s){
        return String.format("Shipment: size=%d | totalWeight=%.2f | heavy=%d ", s.size(), s.totalWeight(), s.countHeavy());
    }
}