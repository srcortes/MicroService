package com.formacionbdi.springboot.app.productos.models.entity;

import com.formacionbdi.springboot.app.productos.annotation.GeneralAnnotation;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="productos")
@GeneralAnnotation(value = "This class representant a entity for H2")
public class Producto implements Serializable {

    @GeneralAnnotation(value = "implements serializable when object trip into red")
    private static final long serialVersionUID = -3705505440435868427L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", unique = true)
    private Long id;

    private String nombre;

    private Double precio;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    @GeneralAnnotation(value = "The Temporal annotation allow us keep only date")
    private Date createAt;

    @Transient
    private Integer port;
}