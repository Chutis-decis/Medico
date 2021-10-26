package ui;

import java.util.ArrayList;
import java.util.Scanner;
import model.Doctor;

public class UIDoctorMenu {
    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();
    
    public static void showDoctorMenu(){
        int response=0; 
        do{
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " + UIMenu.doctorLogged.getName ());
            //doctorLogged es el que nos esta permitiendo entrar con el correo electronico
            System.out.println("1. Add available Appoinment");
            System.out.println("2. My Schedule appoinments");
            System.out.println("0. Lagout");
            
            Scanner sc = new Scanner (System.in);
            response = Integer.valueOf(sc.nextLine());
            
            switch(response){
                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;
                case 2: 
                    break;
                case 0: 
                    UIMenu.showMenu();
                    break; 
            }
        }while (response != 0);
    }
     private static void showAddAvailableAppointmentsMenu(){
        int response = 0;
        do {
            System.out.println();
            System.out.println("::Add Available Appointment");
            System.out.println(":: Select a Month");

            for (int i = 0; i < 3; i++) {
                /*Se utiliza la variable j debido a 
                que es una variable temporal y por otro lado 
                si fuera la variable i alteraria los datos de 
                la misma variable 
                Nos va a servir la variable j para el listado 
                de meses*/
                int j =  i + 1;
                System.out.println(j + ". " + UIMenu.MONTHS[i]);
            }
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response > 0 && response < 4){
                //1,2,3
                int monthSelected = response;
                System.out.println(monthSelected + " . " + UIMenu.MONTHS[monthSelected -1]);
                //le tenemos que colocar -1 por que nosotros queremos los indices

                System.out.println("Insert the date available: [dd/mm/yyyy]");
                String date = sc.nextLine();

                System.out.println("Your date is: " + date + "\n1. Correct \n2. Change Date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2) continue;
                /*continue no se sale del ciclo solamente evita la siguiente linea
                y vuelve al lugar donde se quedo pero no se sale del ciclo */

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time available for date: " + date + " [16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is: " + time + "\n1. Correct \n2. Change Time");
                    responseTime = Integer.valueOf(sc.nextLine());
                }while (responseTime == 2);

                UIMenu.doctorLogged.addAvailableAppointment(date,time);
                checkDoctorAvailableAppointments(UIMenu.doctorLogged);


            }else if(response == 0){
                showDoctorMenu();
            }

        }while (response != 0);
    }


    private static void checkDoctorAvailableAppointments(Doctor doctor){
        //Este metodo nos servira solamente para ver que doctores tienen disponibles citas 
        if (doctor.getAvailableAppointments().size() > 0 //Nos indica que si si tiene citas el doctor
            && !doctorsAvailableAppointments.contains(doctor)){//Nos indica que el doctor no existe 
            doctorsAvailableAppointments.add(doctor);//Añadir al doctor qe me estan pasando 
        }
    }
}
