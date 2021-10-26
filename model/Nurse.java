package model;
public class Nurse extends User{
    private String speciality;
    
    public Nurse (String name, String email){
        super(name,email);
    }
    public void showDataUser(){
        System.out.println("Enferemera de un hospital: Cruz Verde");
        System.out.println("Departamento: Nutriología y Pediatria");
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    
}
