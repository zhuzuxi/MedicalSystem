package com.zzs.common;

public enum AppointmentFee {
    NORMAL(5),
    PROFESSOR(15);
    private final float fee ;
     AppointmentFee(float fee){
        this.fee=fee;
    }

    public float getFee(){
        return fee;
    }
}
