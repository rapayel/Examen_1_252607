/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package examen.interfaces;

import examen.dominio.dtos.BuscarPacienteMedicosDTO;
import examen.dominio.dtos.ObtenerDetallesMedicoDTO;
import examen.dominio.dtos.RegistrarCitaDTO;

/**
 * 
 * @author lagar
 */
public interface IModeloCitas {
    void solicitarBuscarPacienteMedicos(BuscarPacienteMedicosDTO dto);
    void solicitarObtenerDetallesMedico(ObtenerDetallesMedicoDTO dto);
    void solicitarRegistrarCita(RegistrarCitaDTO dto);
}