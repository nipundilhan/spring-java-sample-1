package com.example.dbsample1.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity // This tells Hibernate to make a table out of this class
public class student {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  private Integer grade;
  
  private String firstname;

  private String lastname;
  
  private String contactvalue;
  
  @ManyToOne
  @JoinColumn(name = "highschoolid")
  private highschool highscl;


}