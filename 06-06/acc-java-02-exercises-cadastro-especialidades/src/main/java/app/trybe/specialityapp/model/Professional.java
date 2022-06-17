package app.trybe.specialityapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professional {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  private String speciality;

  public Professional(String name, String speciality) {
    this.name = name;
    this.speciality = speciality;
  }

  /**
   * constructor for new Professional instance.
   * 
   * @param id the id.
   * @param name the name.
   * @param speciality the speciality.
   */
  public Professional(Integer id, String name, String speciality) {
    this.id = id;
    this.name = name;
    this.speciality = speciality;
  }


  public Professional() {
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSpeciality() {
    return this.speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }

}
