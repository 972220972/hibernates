package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2017/3/3.
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    private int id;
    private String name;
}
