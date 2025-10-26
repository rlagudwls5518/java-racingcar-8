package racingcar.model;

public class Car {
    private String name;
    private int distance;


    Car(String name){
        this.name = name;
        this.distance = 0;
    }
    public void plusDistance(){
        distance++;
    }
    public int getDistance(){
        return distance;
    }
    public String getName(){
        return name;
    }


}
