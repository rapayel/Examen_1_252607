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
public class RegistrarCitaDTO {
    private String nss;
    private String idMedico;
    private LocalDateTime fechaHora;

    public RegistrarCitaDTO(String nss, String idMedico, LocalDateTime fechaHora) {
        this.nss = nss;
        this.idMedico = idMedico;
        this.fechaHora = fechaHora;
    }
    
    public String getNss() {
        return nss;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
}
