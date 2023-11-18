package com.project.kraamzicht.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class AuthorityKey implements Serializable {

  @Id
  private String username;
  private String authority;
}