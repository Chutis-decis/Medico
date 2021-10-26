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
            System.out.println("Welcome: " +UIMenu.patinetLogged.getName());
            System.out.println("1. Book an appoinment");
            System.out.println("2. My appoinment");
            System.out.println("0. Logaut");
            
            Scanner sc = new Scanner (System.in);
            response= Integer.valueOf(sc.nextLine());
            
            switch(response){
                case 1: 
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppoinmets();
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
            int k=0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                //.size sirve para cuando queramos que recorra segun el tamaño que tenga
                
                ArrayList<Doctor.AvailableAppointment>availableAppointments=
                        UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();
                /*lO QUE QUIERE DECIR ES QUE VAMOS RECPRRIENDO EL DOCTOR QUE SI TIENE LISTAS DISPONIBLES 
                Y LUEGO AL FIN ENCONTRE UNO Y get(i) le pido las fechas oficiales con el metodo 
                getAvailableAppointments()*/
                
                Map <Integer,Doctor> doctorAppoinment = new TreeMap<>();
                
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppoinment.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppoinment);
                    
                }
                Scanner sc = new Scanner (System.in);
                int responseDateSelected=Integer.valueOf(sc.nextLine());
                
                Map <Integer, Doctor>doctorAvailableSelect = doctors.get(responseDateSelected);
                Integer indexDate=0;
                Doctor doctorSelect = new Doctor ("","");
                
                for(Map.Entry<Integer,Doctor>doc : doctorAvailableSelect.entrySet()){
                    indexDate=doc.getKey();
                    doctorSelect=doc.getValue();
                }
                System.out.println(doctorSelect.getName()+
                    "Date: " + doctorSelect.getAvailableAppointments().get(indexDate).getDate() +
                    ". Time; " +
                    doctorSelect.getAvailableAppointments().get(indexDate).getTime()); 
                
                System.out.println("Confirm appoinment: \n1.Yes \n2. Change data" );
                response = Integer.valueOf(sc.nextInt());
                
                if (response == 1){
                    UIMenu.patinetLogged.addAppointmentDoctor(
                        doctorSelect,
                        doctorSelect.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelect.getAvailableAppointments().get(indexDate).getTime());

                    
                    showPatientMenu();
                }
            }
        }while (response!=0);
    }
    
    public static void showPatientMyAppoinmets(){
        int response=0;
        
        do {
            System.out.println("My Appoinmets:: ");
            if (UIMenu.patinetLogged.getAppoinmentDoctors().size()==0){
                System.out.println("Don't have appoinmets");
                break;
            }
            for (int i = 0; i < UIMenu.patinetLogged.getAppoinmentDoctors().size(); i++) {
                int j= i+1;
                System.out.println(j + ". " +
                       "Date: " + UIMenu.patinetLogged.getAppoinmentDoctors().get(i).getDate()+
                        "Time: " + UIMenu.patinetLogged.getAppoinmentDoctors().get(i).getTime()+
                        "\nDoctor: " + UIMenu.patinetLogged.getAppoinmentDoctors().get(i).getDoctor().getName());
                      
                
            }
            System.out.println("0. Return ");
        }while(response!=0);
    }
}
