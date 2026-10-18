/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.dominio.entidades;

import examen.dominio.dtos.BuscarPacienteMedicosRespuestaDTO;
import examen.dominio.dtos.ObtenerDetallesMedicoRespuestaDTO;
import examen.dominio.dtos.RegistrarCitaRespuestaDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lagar
 */
public class Cita {
    private String idCita;
    private LocalDateTime fechaHora;
    private String estado;
    private Paciente paciente;
    private Medico medico;
    private Consultorio consultorio;

    public Cita() {
        this.estado = "PENDIENTE";
    }

    public Cita(String idCita, LocalDateTime fechaHora, String estado, Paciente paciente, Medico medico, Consultorio consultorio) {
        this.idCita = idCita;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
    }

    public void cargarDatos(Paciente paciente, Medico medico, Consultorio consultorio) {
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
    }

    public BuscarPacienteMedicosRespuestaDTO buscarPacienteMedicos(String nss) {
        List<String> medicos = new ArrayList<>();
        if (this.medico != null) {
            medicos.add(this.medico.obtenerFichaMedica());
        }

        String nombrePaciente = (this.paciente != null) ? this.paciente.obtenerNombreCompleto() : "Paciente No Registrado";
        return new BuscarPacienteMedicosRespuestaDTO(nombrePaciente, nss, medicos);
    }

    public ObtenerDetallesMedicoRespuestaDTO obtenerDetallesMedico(String idMedico) {
        if (this.medico == null) {
            throw new IllegalStateException("No hay información de médico configurada.");
        }

        List<String> horarios = List.of("Lunes a Viernes 07:00 - 20:00");
        String ubicacion = (this.medico.getConsultorio() != null) ? this.medico.getConsultorio().obtenerUbicacion() : "Sin consultorio";

        return new ObtenerDetallesMedicoRespuestaDTO(
                this.medico.getNombre(),
                this.medico.getEspecialidad(),
                ubicacion,
                horarios
        );
    }

    public RegistrarCitaRespuestaDTO registrarCita(String nss, String idMedico, LocalDateTime fechaHora) {
        boolean exito = confirmarCita(this.paciente, this.medico, this.consultorio, fechaHora);

        return new RegistrarCitaRespuestaDTO(
                this.idCita,
                this.paciente != null ? this.paciente.obtenerNombreCompleto() : "",
                this.medico != null ? this.medico.getNombre() : "",
                this.consultorio != null ? this.consultorio.obtenerUbicacion() : "",
                this.fechaHora,
                exito
        );
    }
    
    public boolean confirmarCita(Paciente paciente, Medico medico, Consultorio consultorio, LocalDateTime fechaHora) {
        if (paciente == null || !paciente.validarNss()) {
            throw new IllegalStateException("El paciente no es válido o está inactivo.");
        }
        if (medico == null || !medico.estaDisponibleEn(fechaHora)) {
            throw new IllegalStateException("El médico no está disponible en la fecha u hora seleccionada.");
        }
        if (consultorio == null || !consultorio.esHorarioPermitido(fechaHora)) {
            throw new IllegalStateException("El consultorio no atiende en el horario seleccionado.");
        }
        if (!validarDisponibilidadHorario(fechaHora)) {
            throw new IllegalStateException("La fecha u hora de la cita es inválida.");
        }

        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
        this.fechaHora = fechaHora;
        this.estado = "CONFIRMADA";
        this.idCita = "CIT-" + System.currentTimeMillis();

        return true;
    }

    public boolean validarDisponibilidadHorario(LocalDateTime fechaHora) {
        return fechaHora != null && fechaHora.isAfter(LocalDateTime.now());
    }

    public String obtenerResumenCita() {
        if (!"CONFIRMADA".equals(estado)) {
            return "Cita no confirmada.";
        }
        return "Folio: " + idCita + " | Paciente: " + paciente.obtenerNombreCompleto() 
                + " | Médico: " + medico.getNombre() + " | " + consultorio.obtenerUbicacion() 
                + " | Fecha/Hora: " + fechaHora.toString();
    }

    public String getIdCita() { return idCita; }
    public void setIdCita(String idCita) { this.idCita = idCita; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }
    public Consultorio getConsultorio() { return consultorio; }
    public void setConsultorio(Consultorio consultorio) { this.consultorio = consultorio; }
}
