package Prac;

import java.util.Arrays;

public class Shipment {
    private Parcel[] items;
    private int count;
    private static final int max_Capacity = 200;

    public Shipment() {
        this.items = new Parcel[max_Capacity];
        this.count = 0;
    }

    public Shipment(int capacity) {
        this.items = new Parcel[capacity];
        this.count = 0;
    }

    public void add(Parcel p) {
        if (count <= items.length) {
            items[count] = p;
            count++;
        } else
            System.out.println("Eror!");
    }

    public void add(String id, String receiver, double weightKg, int distanceKm) {
        Parcel p = new Parcel(id, receiver, weightKg, distanceKm);
        add(p);
    }

    public int size() {
        return count;
    }

    public Parcel findById(String id){
        String key = id.trim();
        for(int i =0;i<count;i++){
            String tmp = items[i].getId();
            if(tmp.equalsIgnoreCase(key))
                return items[i];    
        }
        return null;
    }

    public Parcel[] filterByReceiver(String keyword){
        if(keyword==null)
            return new Parcel[0];
        String inp = keyword.trim().toLowerCase();
        int add_count = 0;
        Parcel[] tmpArr = new Parcel[count];
        for(int i=0;i<count;i++){
            String tmp = items[i].getReceiver().trim().toLowerCase();
            if(tmp.contains(inp)){
                tmpArr[add_count] = items[i];
                add_count++;
            }
        }return Arrays.copyOf(tmpArr, add_count);
    }

    public double totalWeight(){
        double res = 0;
        for(int i=0;i<count;i++){
            res+=items[i].getWeightKg();
        }return res;
    }

    public Parcel heaviest(){
        double res = items[0].getWeightKg();
        int idx = 0;
        for(int i=1;i<count;i++){
            if(res<items[i].getWeightKg()){
                res = items[i].getWeightKg();
                idx = i;
            }
        }return items[idx];

    }

    public int countHeavy(){
        int count = 0;
        for(int i=0;i<count;i++){
            if(items[i].isHeavy()){
                count++;
            }
        }return count;
    }
}
