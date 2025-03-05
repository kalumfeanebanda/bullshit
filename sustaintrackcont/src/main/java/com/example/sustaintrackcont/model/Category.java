package com.example.sustaintrackcont.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;




@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "First name can not be blank")
    @Size(min=2, max=50, message = "First name must be between 2 and 50 characters")
    @Column(name="name", nullable=false)
    private String name;
    @NotBlank(message = "First name can not be blank")
    @Size(min=2, max=50, message = "Last name must be between 2 and 50 characters")
    @Column(name="description", nullable=false)
    private String description;
    @NotBlank(message = "First name can not be blank")
    @Size(min=2, max=50, message = "Last name must be between 2 and 50 characters")
    @Column(name="unit", nullable=false)
    private String unit;
    @NotBlank(message = "First name can not be blank")
    @Size(min=2, max=50, message = "Last name must be between 2 and 50 characters")
    @Column(name="calculation", nullable=false)
    private String calculation;





    public Category() {
    }
    public Category(Long id, String name, String description, String unit, String calculation) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.calculation = calculation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCalculation() {
        return calculation;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }
}
