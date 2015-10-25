/**
 * Praktikum TIPR2, WS 15/16
 * Gruppe: Alexander Mendel (alexander.mendel@haw-hamburg.de)
 *         Karl-Fabian Witte (karl-fabian.witte@haw-hamburg.de)
 * Aufgabe: Aufgabenblatt 1, Aufgabe 2 ("Wiederholung PM1/PT")
 *
 */
package aufgabenblatt1;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student>{
//----------Variablen---------
private String vorname;
private String nachname;
private int matrikelnummer;
private List<Pruefungsleistung> plListe;
//---------Konstruktor--------
public Student (String vorname, String nachname, int matrikelnummer){
  this.vorname = vorname;
  this.nachname = nachname;
  this.matrikelnummer = matrikelnummer;
  plListe = new ArrayList<Pruefungsleistung>();
}

//------------Getter---------
public String getVorname() {
	return vorname;
}
public int getMatrikelnummer() {
	return matrikelnummer;
}
public String getNachname() {
	return nachname;
}
public List<Pruefungsleistung> getPlListe() {
	return plListe;
}
//-------------Setter---------
public void setVorname(String vorname) {
	this.vorname = vorname;
}
public void setNachname(String nachname) {
	this.nachname = nachname;
}
public void setMatrikelnummer(int matrikelnummer) {
	this.matrikelnummer = matrikelnummer;
}
public void setPlListe(List<Pruefungsleistung> plListe) {
	this.plListe = plListe;
}

@Override
public int compareTo(Student tStudent) {
 
if(tStudent != null){	  
  Student other = (Student) tStudent;
	
  if (getMatrikelnummer() > other.getMatrikelnummer()){ 
    return 1;
  }
  else if (getMatrikelnummer() < other.getMatrikelnummer()){ 
    return -1;
  }
  else if (getMatrikelnummer() == other.getMatrikelnummer()){
    return 0;  
  }
}
  return -1;
}
}
