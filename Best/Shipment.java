package Best;

import java.util.Arrays;

public class Shipment {

    private Parcel[] items;
    private int count;
    public final static int DEFAULT_CAPACITY = 200;

    public Shipment() {
        this.items = new Parcel[DEFAULT_CAPACITY];
        this.count = 0;
    }

    public Shipment(int capacity) {
        if (capacity <= 0) {
            capacity = DEFAULT_CAPACITY;
        }
        this.items = new Parcel[capacity];
        this.count = 0;
    }

    public void add(Parcel p){
        if(this.count<=this.items.length){
            this.items[this.count]=p;
            count++;
        }else
            System.out.println("Full!");
    }

    public void add(String id, String receiver, double weightKg, int distanceKm){
        Parcel p = new Parcel(id, receiver, weightKg, distanceKm);
        add(p);
    }

    public int size(){
        return this.count;
    }

    public Parcel findById(String id){
        String key = id.toUpperCase();
        if(key==null) return null;
        for(int i =0;i<this.count;i++){
            if(this.items[i].getId().toUpperCase().equals(key))
                return this.items[i];
        }return null;
    }

    public double totalWeight(){
        double tmp = 0.0;
        for(int i =0;i<this.count;i++){
            tmp += this.items[i].getWeightKg();
        }return tmp;
    }
    
    public Parcel heaviest(){
        if(this.count==0){
            return null;
        }
        Parcel tmp = this.items[0];
        for(int i =1;i<this.count;i++){
            if(this.items[i].getWeightKg()>tmp.getWeightKg())
                tmp = this.items[i];
        }return tmp;
    }

    public int countHeavy(){
        int count = 0;
        for(int i =0;i<this.count;i++){
            if(this.items[i].isHeavy())
                count++;
        }return count;
    }

    public Parcel[] filterByReceiver(String keyword){
        if(keyword==null||keyword.trim().isEmpty()){
            return new Parcel[0];
        }
        String keyString = keyword.trim().toUpperCase();
        Parcel[] tmp = new Parcel[this.count];
        int res_count = 0;

        for(int i = 0;i<this.count;i++){
            String tmp_recei = this.items[i].getReceiver().toUpperCase();
            if(tmp_recei.contains(keyString)){
                tmp[res_count]=this.items[i];
                res_count++;
            }
        }
        return Arrays.copyOf(tmp, res_count);
    }
}