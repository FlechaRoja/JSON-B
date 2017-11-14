/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flecharoja.jsonb.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.json.bind.annotation.JsonbDateFormat;

/**
 *
 * @author Gerardo Arroyo
 */
public class Clientes {

    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    
    @JsonbDateFormat("dd.MM.yyyy")
    private LocalDate fechaNacimiento;
    private Boolean activo;
    
    private byte[] blob;

    private List<Telefonos> telefonos;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the primerApellido
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * @param primerApellido the primerApellido to set
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * @return the segundoApellido
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * @param segundoApellido the segundoApellido to set
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /**
     * @return the fechaNacimiento
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the activo
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /**
     * @return the telefonos
     */
    public List<Telefonos> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefonos> telefonos) {
        this.telefonos = telefonos;
    }

    /**
     * @param tel
     * @param telefonos the telefonos to set
     */
    public void addTelefono(Telefonos tel) {
        if (telefonos == null) {
            telefonos = new ArrayList<>();
        }
        this.telefonos.add(tel);
    }

    @Override
    public String toString() {
        return "Clientes{" + "nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", fechaNacimiento=" + fechaNacimiento + ", activo=" + activo + ", telefonos=" + telefonos + '}';
    }

    /**
     * @return the blob
     */
    public byte[] getBlob() {
        return blob;
    }

    /**
     * @param blob the blob to set
     */
    public void setBlob(byte[] blob) {
        this.blob = blob;
    }

}
