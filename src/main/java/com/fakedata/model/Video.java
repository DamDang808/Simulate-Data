package com.fakedata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Table(name = "video")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Video implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String url;
    private String category;
}
