/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.dominio.dtos;

/**
 *
 * @author lagar
 */
public class BuscarPacienteMedicosDTO {
    private String nss;

    public BuscarPacienteMedicosDTO(String nss) {
        this.nss = nss;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }
}