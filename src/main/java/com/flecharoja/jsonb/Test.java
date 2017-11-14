/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flecharoja.jsonb;

import com.flecharoja.jsonb.beans.Clientes;
import com.flecharoja.jsonb.beans.Telefonos;
import java.time.LocalDate;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.BinaryDataStrategy;
import javax.json.bind.config.PropertyNamingStrategy;
import javax.json.bind.config.PropertyOrderStrategy;

/**
 *
 * @author Gerardo Arroyo
 */
public class Test {

    public static void main(String args[]) {

        Test t = new Test();
        t.test06();

    }

    /**
     * Primer prueba con configuración default
     */
    private void test01() {
        Clientes cliente = new Clientes();
        cliente.setFechaNacimiento(LocalDate.parse("1975-01-01"));
        cliente.setNombre("Juan");
        cliente.setPrimerApellido("Perez");
        cliente.setSegundoApellido("Perez");
        cliente.setActivo(Boolean.TRUE);

        // Creamos el Jsonb y hacemos la serializacion
        Jsonb jsonb = JsonbBuilder.create();
        String result = jsonb.toJson(cliente);

        System.out.println(result);

        // Ahora deserializamos 
        cliente = jsonb.fromJson(result, Clientes.class);

        System.out.println(cliente);
    }

    /**
     * En este test; se prueba agregando una coleccion de telefonos
     */
    private void test02() {
        Clientes cliente = new Clientes();
        cliente.setFechaNacimiento(LocalDate.parse("1975-01-01"));
        cliente.setNombre("Juan");
        cliente.setPrimerApellido("Perez");
        cliente.setSegundoApellido("Perez");
        cliente.setActivo(Boolean.TRUE);

        Telefonos tel = new Telefonos();
        tel.setCodPais("506");
        tel.setNumero("22222222");
        cliente.addTelefono(tel);

        tel = new Telefonos();
        tel.setCodPais("506");
        tel.setNumero("1111111");
        cliente.addTelefono(tel);

        // Creamos el Jsonb y hacemos la serializacion
        Jsonb jsonb = JsonbBuilder.create();
        String result = jsonb.toJson(cliente);

        System.out.println(result);

        // Ahora deserializamos 
        cliente = jsonb.fromJson(result, Clientes.class);

        System.out.println(cliente);
    }

    /**
     * Aca empleados el formatting en true
     */
    private void test03() {
        Clientes cliente = new Clientes();
        cliente.setFechaNacimiento(LocalDate.parse("1975-01-01"));
        cliente.setNombre("Juan");
        cliente.setPrimerApellido("Perez");
        cliente.setSegundoApellido("Perez");
        cliente.setActivo(Boolean.TRUE);

        Telefonos tel = new Telefonos();
        tel.setCodPais("506");
        tel.setNumero("22222222");
        cliente.addTelefono(tel);

        tel = new Telefonos();
        tel.setCodPais("506");
        tel.setNumero("1111111");
        cliente.addTelefono(tel);

        // Creamos el Jsonb y hacemos la serializacion
        JsonbConfig config = new JsonbConfig()
                .withFormatting(true)
                .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES);

        Jsonb jsonb = JsonbBuilder.create(config);
        String result = jsonb.toJson(cliente);

        System.out.println(result);

        // Ahora deserializamos 
        cliente = jsonb.fromJson(result, Clientes.class);

        System.out.println(cliente);
    }

    /**
     * En este caso se prueba la estrategia de ordenamiento ANY (es decir,
     * indefinido)
     */
    private void test04() {
        Clientes cliente = new Clientes();
        cliente.setFechaNacimiento(LocalDate.parse("1975-01-01"));
        cliente.setNombre("Juan");
        cliente.setPrimerApellido("Perez");
        cliente.setSegundoApellido("Perez");
        cliente.setActivo(Boolean.TRUE);

        Telefonos tel = new Telefonos();
        tel.setCodPais("506");
        tel.setNumero("22222222");
        cliente.addTelefono(tel);

        tel = new Telefonos();
        tel.setCodPais("506");
        tel.setNumero("1111111");
        cliente.addTelefono(tel);

        // Creamos el Jsonb y hacemos la serializacion
        JsonbConfig config = new JsonbConfig()
                .withFormatting(true)
                .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES)
                .withPropertyOrderStrategy(PropertyOrderStrategy.ANY);

        Jsonb jsonb = JsonbBuilder.create(config);
        String result = jsonb.toJson(cliente);

        System.out.println(result);

        // Ahora deserializamos 
        cliente = jsonb.fromJson(result, Clientes.class);

        System.out.println(cliente);
    }

    /**
     * Con el caso de los nulos
     */
    private void test05() {
        Clientes cliente = new Clientes();
        cliente.setFechaNacimiento(LocalDate.parse("1975-01-01"));
        cliente.setNombre("Juan");
        cliente.setPrimerApellido("Perez");
        cliente.setSegundoApellido("Perez");
        cliente.setActivo(Boolean.TRUE);

        // Creamos el Jsonb y hacemos la serializacion
        JsonbConfig config = new JsonbConfig()
                .withFormatting(true)
                .withNullValues(true)
                .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES);

        Jsonb jsonb = JsonbBuilder.create(config);
        String result = jsonb.toJson(cliente);

        System.out.println(result);

        // Ahora deserializamos 
        cliente = jsonb.fromJson(result, Clientes.class);

        System.out.println(cliente);
    }
    
    
     /**
     * Con el caso de base 64
     */
    private void test06() {
        Clientes cliente = new Clientes();
        cliente.setFechaNacimiento(LocalDate.parse("1975-01-01"));
        cliente.setNombre("Juan");
        cliente.setPrimerApellido("Perez");
        cliente.setSegundoApellido("Perez");
        cliente.setActivo(Boolean.TRUE);
        cliente.setBlob("prueba de encoding".getBytes());

        // Creamos el Jsonb y hacemos la serializacion
        JsonbConfig config = new JsonbConfig()
                .withFormatting(true)
                .withNullValues(true)
                .withBinaryDataStrategy(BinaryDataStrategy.BASE_64)
                .withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES);

        Jsonb jsonb = JsonbBuilder.create(config);
        String result = jsonb.toJson(cliente);

        System.out.println(result);

        // Ahora deserializamos 
        cliente = jsonb.fromJson(result, Clientes.class);

        System.out.println(cliente);
    }
}
