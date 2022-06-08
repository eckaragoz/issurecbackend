package com.isrc.exceptions;

public class Exceptions extends RuntimeException{

  public Exceptions(String Ad)
  {
    super("User Not Found:" + Ad);
  }

}
