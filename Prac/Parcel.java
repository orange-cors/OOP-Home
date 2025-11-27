package Prac;

public class Parcel {
    private String id;
    private String receiver;
    private double weightKg;
    private int distanceKm;

    public Parcel(String id, String receiver, double weightKg, int distanceKm){
        this.id = id.trim();
        this.receiver = receiver.trim();
        setWeightKg(weightKg);
        setDistanceKm(distanceKm);
    }

    public String getId() {
        return id;
    }

    public String getReceiver() {
        return receiver;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg){
        if(weightKg<0)
            this.weightKg = 0;
        else 
            this.weightKg = weightKg;    
    }

    public void setDistanceKm(int distanceKm){
        if(distanceKm<0)
            this.distanceKm = 0;
        else 
            this.distanceKm = distanceKm;    
    }

    public double baseFee(){
        return weightKg * 5000;
    }

    public double distanceFee(){
        return distanceKm * 200;
    }

    public double totalFee(){
        return baseFee() + distanceFee();
    }

    public boolean isHeavy(){
        if(getWeightKg()<20)
            return false;
        return true;    
    } 

    public String toString(){
        return String.format("%s - %s - %.2f - %d - fee=%.2f", id, receiver, weightKg, distanceKm, totalFee());
    }

    
}
