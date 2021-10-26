package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient  extends User{
    private String birthday;
    private double weight;
    private double height;
    private String blood;
    
    private ArrayList <AppointmentDoctor> appoinmentDoctors = new ArrayList<>();
    private ArrayList <AppointmentDoctor> appoinmentNurse = new ArrayList<>();
    
    
    
    public ArrayList<AppointmentDoctor> getAppoinmentDoctors() {
        return appoinmentDoctors;
    }

    public void aadAppoinmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appoinmetDoctor = new AppointmentDoctor(this,doctor);
        appoinmetDoctor.schedule(date, time);
        appoinmentDoctors.add(appoinmetDoctor);
    }

    public ArrayList<AppointmentDoctor> getAppoinmentNurse() {
        return appoinmentNurse;
    }

    public void setAppoinmentNurse(ArrayList<AppointmentDoctor> appoinmentNurse) {
        this.appoinmentNurse = appoinmentNurse;
    }
    
    
    
    public Patient(String name, String email){
        super(name,email);
        //mas instrucciones
    }

    // 54.5
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // 54.5 Kg. String
    public String getWeight(){
        return this.weight + " Kg.";
    }


    public String getHeight() {
        return height + " Mts.";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAge: " + birthday + "\n Weight: " +getWeight()+ "\n Height"+getHeight()+"\nBlood"+blood;
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente");
        System.out.println("Historial completo desde naciemiento");

    }

    public void addAppointmentDoctor(Doctor doctorSelect, String date, String time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
