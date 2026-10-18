/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.mvc;

import examen.dominio.dtos.*;
import examen.dominio.fachada.IFachadaCitas;
import examen.interfaces.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lagar
 */
public class ModeloCitas implements IModeloCitas, IModeloLectura {
    private final List<Observador> observadores;
    private final IFachadaCitas fachadaCitas;

    private String nombrePaciente;
    private String nssPaciente;
    private List<String> listaMedicos;

    private String nombreMedicoDetalle;
    private String especialidadMedicoDetalle;
    private String consultorioMedicoDetalle;
    private List<String> diasHorariosMedicoDetalle;

    private String folioCita;
    private String nombrePacienteCita;
    private String nombreMedicoCita;
    private String consultorioCita;
    private LocalDateTime fechaHoraCita;
    private boolean exitoCita;

    private String nssActual;
    private String idMedicoSeleccionado;
    private String mensajeError;

    public ModeloCitas(IFachadaCitas fachadaCitas) {
        this.observadores = new ArrayList<>();
        this.fachadaCitas = fachadaCitas;
    }

    @Override
    public void registrarObservador(Observador o) {
        if (!observadores.contains(o)) {
            observadores.add(o);
        }
    }

    @Override
    public void removerObservador(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores() {
        for (Observador o : observadores) {
            o.update(this);
        }
    }

    @Override
    public void solicitarBuscarPacienteMedicos(BuscarPacienteMedicosDTO dto) {
        this.mensajeError = null;
        try {
            if (dto != null) {
                this.nssActual = dto.getNss();
            }
            BuscarPacienteMedicosRespuestaDTO res = fachadaCitas.buscarPacienteMedicos(dto);
            if (res != null) {
                this.nombrePaciente = res.getNombrePaciente();
                this.nssPaciente = res.getNssPaciente();
                this.listaMedicos = res.getListaMedicos();
            } else {
                this.nombrePaciente = null;
                this.nssPaciente = null;
                this.listaMedicos = null;
            }
            limpiarDetallesMedico();
            limpiarResumenCita();
        } catch (Exception ex) {
            this.mensajeError = ex.getMessage();
        }
        notificarObservadores();
    }

    @Override
    public void solicitarObtenerDetallesMedico(ObtenerDetallesMedicoDTO dto) {
        this.mensajeError = null;
        try {
            if (dto != null) {
                this.idMedicoSeleccionado = dto.getIdMedico();
            }
            ObtenerDetallesMedicoRespuestaDTO res = fachadaCitas.obtenerDetallesMedico(dto);
            if (res != null) {
                this.nombreMedicoDetalle = res.getNombreMedico();
                this.especialidadMedicoDetalle = res.getEspecialidad();
                this.consultorioMedicoDetalle = res.getConsultorio();
                this.diasHorariosMedicoDetalle = res.getDiasHorarios();
            } else {
                limpiarDetallesMedico();
            }
        } catch (Exception ex) {
            this.mensajeError = ex.getMessage();
        }
        notificarObservadores();
    }

    @Override
    public void solicitarRegistrarCita(RegistrarCitaDTO dto) {
        this.mensajeError = null;
        try {
            RegistrarCitaRespuestaDTO res = fachadaCitas.registrarCita(dto);
            if (res != null) {
                this.folioCita = res.getFolioCita();
                this.nombrePacienteCita = res.getNombrePaciente();
                this.nombreMedicoCita = res.getNombreMedico();
                this.consultorioCita = res.getConsultorio();
                this.fechaHoraCita = res.getFechaHora();
                this.exitoCita = res.isExito();

                if (this.exitoCita) {
                    limpiarDetallesMedico();
                }
            } else {
                limpiarResumenCita();
            }
        } catch (Exception ex) {
            this.mensajeError = ex.getMessage();
        }
        notificarObservadores();
    }

    private void limpiarDetallesMedico() {
        this.nombreMedicoDetalle = null;
        this.especialidadMedicoDetalle = null;
        this.consultorioMedicoDetalle = null;
        this.diasHorariosMedicoDetalle = null;
    }

    private void limpiarResumenCita() {
        this.folioCita = null;
        this.nombrePacienteCita = null;
        this.nombreMedicoCita = null;
        this.consultorioCita = null;
        this.fechaHoraCita = null;
        this.exitoCita = false;
    }

    @Override public String getNombrePaciente() { return nombrePaciente; }
    @Override public String getNssPaciente() { return nssPaciente; }
    @Override public List<String> getListaMedicos() { return listaMedicos; }

    @Override public String getNombreMedicoDetalle() { return nombreMedicoDetalle; }
    @Override public String getEspecialidadMedicoDetalle() { return especialidadMedicoDetalle; }
    @Override public String getConsultorioMedicoDetalle() { return consultorioMedicoDetalle; }
    @Override public List<String> getDiasHorariosMedicoDetalle() { return diasHorariosMedicoDetalle; }

    @Override public String getFolioCita() { return folioCita; }
    @Override public String getNombrePacienteCita() { return nombrePacienteCita; }
    @Override public String getNombreMedicoCita() { return nombreMedicoCita; }
    @Override public String getConsultorioCita() { return consultorioCita; }
    @Override public LocalDateTime getFechaHoraCita() { return fechaHoraCita; }
    @Override public boolean isExitoCita() { return exitoCita; }

    @Override public String getMensajeError() { return mensajeError; }
    @Override public String getNssActual() { return nssActual; }
    @Override public String getIdMedicoSeleccionado() { return idMedicoSeleccionado; }
}