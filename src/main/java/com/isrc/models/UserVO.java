package com.isrc.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class UserVO implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy= javax.persistence.GenerationType.IDENTITY)
  private int id;

  private String username;

  private String password;

  private Date logindate;

  private Date createdate;

  private int status;//0 yada 1 gönderilmeli

}
