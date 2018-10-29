package com.flipkart.fdsg.accounting.entities;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by amith.prasad on 25/10/18.
 */
@Getter
@Table(name="employees")
@Entity(name = "employees")
public class Employee  implements Serializable {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;
}
