package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    private String speciality;
    public Doctor (String name, String email){
        super (name,email);
        System.out.println("El nombre del doctor es: " + name);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    ArrayList <AvailableAppointment> availableAppointments = new ArrayList<>();
    public void addAvailableAppointment(String date, String time){
        
        availableAppointments.add(new Doctor.AvailableAppointment(date, time));
    }
    public ArrayList <AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }
    @Override
    public String toString(){
        return super.toString() +  "\nSpeciality: " + speciality + "\nAvailable: " + availableAppointments.toString();
    }
    @Override
    public void showDataUser(){
        System.out.println("Empleado de un Hospital: Cruz Roja");
        System.out.println("Departamento: Cancerología ");
    }
    public static class AvailableAppointment {
        private int id;
        private Date date;
        private String time; 
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        //Para darle un formato a la fecha 
        
        public AvailableAppointment (String date, String time){
            try{
                this.date = format.parse(date);
            }catch(ParseException e){
                e.printStackTrace();
            }
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }
        public String getDate(String DATE){
            return format.format(date);
        }
        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public SimpleDateFormat getFormat() {
            return format;
        }

        public void setFormat(SimpleDateFormat format) {
            this.format = format;
        }
        @Override
        public String toString(){
            return "Available Appointments \\nDate: " + date + "\nTime: " + time;
        }
        
    }
}
