/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.dominio.dtos;

import java.time.LocalDateTime;

/**
 *
 * @author lagar
 */
public class RegistrarCitaRespuestaDTO {
    private String folioCita;
    private String nombrePaciente;
    private String nombreMedico;
    private String consultorio;
    private LocalDateTime fechaHora;
    private boolean exito;

    public RegistrarCitaRespuestaDTO(String folioCita, String nombrePaciente, String nombreMedico, String consultorio, LocalDateTime fechaHora, boolean exito) {
        this.folioCita = folioCita;
        this.nombrePaciente = nombrePaciente;
        this.nombreMedico = nombreMedico;
        this.consultorio = consultorio;
        this.fechaHora = fechaHora;
        this.exito = exito;
    }

    public String getFolioCita() {
        return folioCita;
    }

    public void setFolioCita(String folioCita) {
        this.folioCita = folioCita;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }
}
