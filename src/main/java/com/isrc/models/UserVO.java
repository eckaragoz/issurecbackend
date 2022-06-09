package com.isrc.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "Users Api model documentation", description = "Model")
public class UserVO implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy= javax.persistence.GenerationType.IDENTITY)
  @ApiModelProperty(value = "Unique id field of Duyurular object")
  private int id;

  @ApiModelProperty(value = "UserName field of User object")
  private String username;

  @ApiModelProperty(value = "Password field of User object")
  private String password;

  @ApiModelProperty(value = "Logindate field of User object")
  private Date logindate;

  @ApiModelProperty(value = "Createdate field of User object")
  private Date createdate;

  @ApiModelProperty(value = "Status field of User object")
  private int status;//0 yada 1 gönderilmeli

}
