/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package examen.dominio.fachada;

import examen.dominio.dtos.*;
/**
 *
 * @author lagar
 */
public interface IFachadaCitas {
    public BuscarPacienteMedicosRespuestaDTO buscarPacienteMedicos(BuscarPacienteMedicosDTO dto);
    public ObtenerDetallesMedicoRespuestaDTO obtenerDetallesMedico(ObtenerDetallesMedicoDTO dto);
    public RegistrarCitaRespuestaDTO registrarCita(RegistrarCitaDTO dto);
}
