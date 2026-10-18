/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.dominio.dtos;

/**
 * 
 * @author lagar
 */
public class ObtenerDetallesMedicoDTO {
    private String idMedico;

    public ObtenerDetallesMedicoDTO(String idMedico) {
        this.idMedico = idMedico;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }
}