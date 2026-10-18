/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.dominio.fachada;

import examen.dominio.dtos.*;
import examen.dominio.entidades.Cita;
/**
 *
 * @author lagar
 */
public class FachadaCitas implements IFachadaCitas {
    private Cita citaPrincipal;

    public FachadaCitas(Cita citaPrincipal) {
        this.citaPrincipal = citaPrincipal;
    }

    @Override
    public BuscarPacienteMedicosRespuestaDTO buscarPacienteMedicos(BuscarPacienteMedicosDTO dto) {
        if (dto == null || dto.getNss() == null) {
            throw new IllegalArgumentException("El DTO o el NSS no pueden ser nulos.");
        }
        return citaPrincipal.buscarPacienteMedicos(dto.getNss());
    }

    @Override
    public ObtenerDetallesMedicoRespuestaDTO obtenerDetallesMedico(ObtenerDetallesMedicoDTO dto) {
        if (dto == null || dto.getIdMedico() == null) {
            throw new IllegalArgumentException("El DTO o el ID del médico no pueden ser nulos.");
        }
        return citaPrincipal.obtenerDetallesMedico(dto.getIdMedico());
    }

    @Override
    public RegistrarCitaRespuestaDTO registrarCita(RegistrarCitaDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("El DTO de registro de cita no puede ser nulo.");
        }
        return citaPrincipal.registrarCita(dto.getNss(), dto.getIdMedico(), dto.getFechaHora());
    }
}
