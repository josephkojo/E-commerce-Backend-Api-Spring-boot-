package com.Ecomence.Ecommece.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Category_table")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String name;
    private String description;
}
