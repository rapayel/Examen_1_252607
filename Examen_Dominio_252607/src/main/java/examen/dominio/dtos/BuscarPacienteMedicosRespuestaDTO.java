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
public class BuscarPacienteMedicosRespuestaDTO {
    private String nombrePaciente;
    private String nssPaciente;
    private List<String> listaMedicos;

    public BuscarPacienteMedicosRespuestaDTO(String nombrePaciente, String nssPaciente, List<String> listaMedicos) {
        this.nombrePaciente = nombrePaciente;
        this.nssPaciente = nssPaciente;
        this.listaMedicos = listaMedicos;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNssPaciente() {
        return nssPaciente;
    }

    public void setNssPaciente(String nssPaciente) {
        this.nssPaciente = nssPaciente;
    }

    public List<String> getListaMedicos() {
        return listaMedicos;
    }

    public void setListaMedicos(List<String> listaMedicos) {
        this.listaMedicos = listaMedicos;
    }
}
