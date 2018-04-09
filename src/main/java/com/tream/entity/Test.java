package com.tream.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Test {
  private Integer id;
  private String name;
  private Integer age;
  private java.sql.Date date;
  private java.sql.Timestamp datetime;
  private java.sql.Timestamp timestamp;
  private String size;
  private BigDecimal money;


}
