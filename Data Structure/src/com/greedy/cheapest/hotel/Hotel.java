package com.greedy.cheapest.hotel;

public enum Hotel {

    HAYATT(1100.0,1300.0),
    RADISSON(1000.0,1200.0),
    MARRIOT(1200.0,1500.0);

    private double weekDay;
    private double weekEnd;

    Hotel(double weekDay,double weekEnd){
        this.weekDay = weekDay;
        this.weekEnd = weekEnd;
    }

    public double getWeekDay(){
        return  this.weekDay;
    }

    public double getWeekEnd(){
        return this.weekEnd;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "weekDay=" + weekDay +
                ", weekEnd=" + weekEnd +
                '}';
    }
}
