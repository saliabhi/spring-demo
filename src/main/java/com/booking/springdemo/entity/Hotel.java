package com.booking.springdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "hotel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel implements Serializable {

    @Id
    private Long id;

    private String name;

    // standard getters and setters, constructors
}
