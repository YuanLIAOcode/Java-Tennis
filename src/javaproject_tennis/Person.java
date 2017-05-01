/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject_tennis;

/**
 *
 * @author Yuan LIAO
 */
public class Person {
/*--------------------Attribute--------------------*/
    
    private String lastName;
    private String firstName;
    private String gender;
    private String usedName;
    private boolean maritalStatus;  //only for the person's matiral status
    private int birthDate;
    private int age;
    private String birthPlace;
    private int deathDate;
    private String nationality;
    private int taille;
    private float poids;

 
 /*--------------------Constructor--------------------*/ 
    
    public Person(){
        //this is the default constructor. If I do not wrtie it, it could not override the subclass's constructor. 
        //The compiler will report an erro. And I do not know why..........
    }
    public Person(String lastName, String firstName, String gender, String usedName, 
                 boolean maritaStatus, int birthDate, int age, String birthPlace,
             int deathDate, String nationality, int taille, float poids){
        this.lastName = lastName;
        this.firstName = firstName ;
        this.gender = gender;
        this.usedName = usedName;
        this.maritalStatus = maritaStatus;
        this.birthDate = birthDate;
        this.age = age;
        this.birthPlace = birthPlace;
        this.deathDate = deathDate;
        this.nationality = nationality;
        this.taille = taille;
        this.poids = poids;
    }
 
/*--------------------Method--------------------*/
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
//    public void setUsedName(String usedName){
//        this.usedName = usedName;
//    }
    public void setMaritalStatus(boolean maritalStatus){
        this.maritalStatus = maritalStatus;
    }
//    public void setBirthDate(int birthDate){
//        this.birthDate = birthDate;
//    }
    public void setAge(int age){
        this.age = age;
    }
//    public void setBirthPlace(String birthPlace){
//        this.birthPlace = birthPlace;
//    }
//    public void setDeathDate(int deathDate){
//        this.deathDate = deathDate;
//    }
    public void setNationality(String nationality){
        this.nationality = nationality;
    }
    public void setTaille(int taille){
        this.taille = taille;
    }
    public void setPoids(float poids){
        this.poids = poids;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getGender(){
        return this.gender;
    }
    public String getUsedName(){
        return this.usedName;
    }
    public boolean getNomCourant(){
        return this.maritalStatus;
    }
    public int getDatenaissance(){
        return this.birthDate;
    }
    public int getAGe(){
        return this.age;
    }
    public String getBirthPlace(){
        return this.birthPlace;
    }
    public int getDeathDate(){
        return this.deathDate;
    }
    public String getNationality(){
        return this.nationality;
    }
    public int getTaille(){
        return this.taille;
    }
    public float getPoids(){
        return this.poids;
    }

}
