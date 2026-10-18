/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.dominio.entidades;

import java.time.LocalDateTime;

/**
 *
 * @author lagar
 */
public class Medico {
    private String idMedico;
    private String nombre;
    private String especialidad;
    private Consultorio consultorio;

    public Medico(String idMedico, String nombre, String especialidad, Consultorio consultorio) {
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.consultorio = consultorio;
    }

    public boolean estaDisponibleEn(LocalDateTime fechaHora) {
        if (fechaHora == null || consultorio == null) {
            return false;
        }
        return consultorio.esHorarioPermitido(fechaHora);
    }

    public String obtenerFichaMedica() {
        return "Dr. " + nombre + " - " + especialidad + " (" + (consultorio != null ? consultorio.obtenerUbicacion() : "Sin consultorio") + ")";
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }
}
