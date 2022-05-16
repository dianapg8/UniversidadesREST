package com.ibm.academia.apirest.datos;

import com.ibm.academia.apirest.entities.*;
import com.ibm.academia.apirest.enums.TipoEmpleado;

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
