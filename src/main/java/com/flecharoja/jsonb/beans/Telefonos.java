/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flecharoja.jsonb.beans;

import javax.json.bind.annotation.JsonbProperty;

/**
 *
 * @author Gerardo Arroyo
 */
public class Telefonos {
    @JsonbProperty("codigo-pais")
    private String codPais;
    private String numero;

    /**
     * @return the codPais
     */
    public String getCodPais() {
        return codPais;
    }

    /**
     * @param codPais the codPais to set
     */
    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Telefonos{" + "codPais=" + codPais + ", numero=" + numero + '}';
    }
    
    
    
}
