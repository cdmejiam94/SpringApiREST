package com.arkus.challenge.spring.api.persistance.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cuentas")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idCuenta;

    private String nombre;

    private String cliente;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "modified_at")
    private String modifiedAt;

    @Column(name = "responsable", insertable = false, updatable = false)
    private String responsableUser;

    @OneToMany
    private List<UserAccount> users;

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getResponsableUser() {
        return responsableUser;
    }

    public void setResponsableUser(String responsableUser) {
        this.responsableUser = responsableUser;
    }

}
