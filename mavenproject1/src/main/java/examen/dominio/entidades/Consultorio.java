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
public class Consultorio {
    private String numeroConsultorio;
    private String piso;
    private String horarioAtencion;

    public Consultorio(String numeroConsultorio, String piso, String horarioAtencion) {
        this.numeroConsultorio = numeroConsultorio;
        this.piso = piso;
        this.horarioAtencion = horarioAtencion;
    }

    public boolean esHorarioPermitido(LocalDateTime fechaHora) {
        if (fechaHora == null) {
            return false;
        }
        int hora = fechaHora.getHour();
        return hora >= 7 && hora < 20;
    }

    public String obtenerUbicacion() {
        return "Consultorio " + numeroConsultorio + ", Piso " + piso;
    }

    public String getNumeroConsultorio() {
        return numeroConsultorio;
    }

    public void setNumeroConsultorio(String numeroConsultorio) {
        this.numeroConsultorio = numeroConsultorio;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }
}
