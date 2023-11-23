package com.project.kraamzicht.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "authorities")
public class AuthorityKey implements Serializable {

  @Id
  private String username;
  private String authority;
}