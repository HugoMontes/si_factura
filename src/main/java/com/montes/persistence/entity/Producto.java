package com.montes.persistence.entity;
// Generated 02-12-2017 09:08:33 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Productos generated by hbm2java
 */
@Entity
@Table(name="productos"
    ,catalog="si_factura"
)
public class Producto implements java.io.Serializable {

     private Integer id;
     private String nombre;
     private Double precio;
     private Integer stock;
     private Date createdAt;
     private Date updatedAt;
     private Set<Detalle> detalles = new HashSet<Detalle>(0);

    public Producto() {
    }

    public Producto(String nombre, Double precio, Integer stock, Date createdAt, Date updatedAt, Set detalles) {
       this.nombre = nombre;
       this.precio = precio;
       this.stock = stock;
       this.createdAt = createdAt;
       this.updatedAt = updatedAt;
       this.detalles = detalles;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="nombre")
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="precio", precision=8)
    public Double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    
    @Column(name="stock")
    public Integer getStock() {
        return this.stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", length=19)
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at", length=19)
    public Date getUpdatedAt() {
        return this.updatedAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="producto")
    public Set<Detalle> getDetalles() {
        return this.detalles;
    }
    
    public void setDetalles(Set<Detalle> detalles) {
        this.detalles = detalles;
    }




}


