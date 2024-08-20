package com.simulate_data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Table(name = "media")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Media implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String tag;
}
