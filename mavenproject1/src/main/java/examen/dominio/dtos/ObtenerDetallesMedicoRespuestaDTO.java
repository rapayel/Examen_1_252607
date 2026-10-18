/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.dominio.dtos;

import java.util.List;

/**
 *
 * @author lagar
 */
public class ObtenerDetallesMedicoRespuestaDTO {
    private String nombreMedico;
    private String especialidad;
    private String consultorio;
    private List<String> diasHorarios;

    public ObtenerDetallesMedicoRespuestaDTO(String nombreMedico, String especialidad, String consultorio, List<String> diasHorarios) {
        this.nombreMedico = nombreMedico;
        this.especialidad = especialidad;
        this.consultorio = consultorio;
        this.diasHorarios = diasHorarios;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public List<String> getDiasHorarios() {
        return diasHorarios;
    }

    public void setDiasHorarios(List<String> diasHorarios) {
        this.diasHorarios = diasHorarios;
    }
}
