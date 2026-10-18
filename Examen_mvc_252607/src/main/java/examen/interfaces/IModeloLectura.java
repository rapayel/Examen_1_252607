/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package examen.interfaces;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 
 * @author lagar
 */
public interface IModeloLectura {
    void registrarObservador(Observador o);
    void removerObservador(Observador o);
    void notificarObservadores();

    String getNombrePaciente();
    String getNssPaciente();
    List<String> getListaMedicos();

    String getNombreMedicoDetalle();
    String getEspecialidadMedicoDetalle();
    String getConsultorioMedicoDetalle();
    List<String> getDiasHorariosMedicoDetalle();

    String getFolioCita();
    String getNombrePacienteCita();
    String getNombreMedicoCita();
    String getConsultorioCita();
    LocalDateTime getFechaHoraCita();
    boolean isExitoCita();

    String getMensajeError();
    String getNssActual();
    String getIdMedicoSeleccionado();
}