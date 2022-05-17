package com.ibm.academia.apirest.datos;

import com.ibm.academia.apirest.enums.TipoEmpleado;
import com.ibm.academia.apirest.enums.TipoPizarron;
import com.ibm.academia.apirest.models.entities.*;

import java.math.BigDecimal;

public class DatosDummy
{
    public static Carrera carrera01()
    {
        return new Carrera(null, "Ingenieria en Sistemas", 50, 5);
    }

    public static Carrera carrera02()
    {
        return new Carrera(null, "Licenciatura en Sistemas", 45, 4);
    }

    public static Carrera carrera03()
    {
        return new Carrera(null, "Ingenieria Industrial", 60, 5);
    }

    public static Aula aula01()
    {
        return new Aula(null, 15, "20.5", 27, TipoPizarron.PIZARRA_BLANCA);
    }

    public static Aula aula02()
    {
        return new Aula(null, 7, "18.9", 32, TipoPizarron.PIZARRA_TIZA);
    }

    public static Persona empleado01()
    {
        return new Empleado(null, "Lautero", "Lopez", "23724", new Direccion(), new BigDecimal("5325.34"), TipoEmpleado.ADMINISTRATIVO);
    }

    public static Persona empleado02()
    {
        return new Empleado(null, "Leandro", "Lopez", "49875", new Direccion(), new BigDecimal("2478.24"), TipoEmpleado.MANTENIMIENTO);
    }

    public static Persona profesor01()
    {
        return new Profesor(null, "Martin", "Lugone", "96454", new Direccion(), new BigDecimal("74498.84"));
    }

    public static Persona profesor02()
    {
        return new Profesor(null, "Carlos", "Hernandez", "32153", new Direccion(), new BigDecimal("13466.234"));
    }

    public static Persona profesor03()
    {
        return new Profesor(null, "Carmen", "Aguila", "32649", new Direccion(), new BigDecimal("34987.34"));
    }

    public static Pabellon pabellon01()
    {
        return new Pabellon(null, 12.4, "PabellonUno", new Direccion("calle1", "1", null, null, null, "Pachuca"));
    }

    public static Pabellon pabellon03()
    {
        return new Pabellon(null, 13.1, "PabellonTres", new Direccion("calle3", "3", null, null, null, "Jalapa"));
    }

    public static Pabellon pabellon02()
    {
        return new Pabellon(null, 11.6, "PabellonDos", new Direccion("calle2", "2", null, null, null, "Tonala"));
    }

    public static Persona alumno01()
    {
        return new Alumno(null, "Joaquin", "Leon", "98345", new Direccion());
    }

    public static Persona alumno02()
    {
        return new Alumno(null, "Laura", "Benites", "12487", new Direccion());
    }

    public static Persona alumno03()
    {
        return new Alumno(null, "Braulio", "Montes", "24325", new Direccion());
    }
}
