/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.mvc;

import examen.dominio.dtos.BuscarPacienteMedicosDTO;
import examen.dominio.dtos.ObtenerDetallesMedicoDTO;
import examen.dominio.dtos.RegistrarCitaDTO;
import examen.interfaces.IModeloCitas;

public class ControladorCitas {
    private final IModeloCitas modelo;

    public ControladorCitas(IModeloCitas modelo) {
        this.modelo = modelo;
    }

    public void buscarPacienteMedicos(BuscarPacienteMedicosDTO dto) {
        modelo.solicitarBuscarPacienteMedicos(dto);
    }

    public void obtenerDetallesMedico(ObtenerDetallesMedicoDTO dto) {
        modelo.solicitarObtenerDetallesMedico(dto);
    }

    public void registrarCita(RegistrarCitaDTO dto) {
        modelo.solicitarRegistrarCita(dto);
    }
}