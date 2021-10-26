package ui;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import model.Doctor;

public class UIPatientMenu {
    
    public static void showPatientMenu(){
        int response=0;
        
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome: " +UIMenu.patinetLogged);
            System.out.println("1. Book an appoinment");
            System.out.println("2. My appoinment");
            System.out.println("0. Logaut");
            
            Scanner sc = new Scanner (System.in);
            response= Integer.valueOf(sc.nextLine());
            
            switch(response){
                case 1: 
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        }while (response!=0);
    }
    public static void showBookAppointmentMenu(){
        int response=0;
        
        do{
            System.out.println("::Book an appointment");
            System.out.println("::Select ");
            /*Indice de fecha seleccionada 
            [doctors]
            1. Doctor 1
                -1 fecha1
                2- fecha2
            2. doctor 2
            3. doctor 3*/
            Map<Integer, Map<Integer,Doctor>> doctors = new TreeMap<>();
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                //.size sirve para cuando queramos que recorra segun el tamaño que tenga
                
                ArrayList<Doctor.AvailableAppointment>availableAppointments=
                        UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();
                /*lO QUE QUIERE DECIR ES QUE VAMOS RECPRRIENDO EL DOCTOR QUE SI TIENE LISTAS DISPONIBLES 
                Y LUEGO AL FIN ENCONTRE UNO Y get(i) le pido las fechas oficiales con el metodo 
                getAvailableAppointments()*/
            }
        }while (response!=0);
    }
}
