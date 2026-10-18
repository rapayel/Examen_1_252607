/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.mvc.paneles;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;
import examen.dominio.dtos.RegistrarCitaDTO;
import examen.mvc.ControladorCitas;

/**
 * 
 * @author lagar
 */
public class PanelDetalleMedico extends JPanel {
    private JLabel lblNombre;
    private JLabel lblEspecialidad;
    private JLabel lblConsultorio;
    private JLabel lblHorarios;
    private JButton btnApartar;
    private ControladorCitas controlador;

    private String nssActual;
    private String idMedicoActual;

    public PanelDetalleMedico() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createTitledBorder("Ficha del Médico"));

        lblNombre = new JLabel("Nombre: -");
        lblEspecialidad = new JLabel("Especialidad: -");
        lblConsultorio = new JLabel("Consultorio: -");
        lblHorarios = new JLabel("Horarios: -");

        btnApartar = new JButton("Apartar Cita");
        btnApartar.setEnabled(false);

        btnApartar.addActionListener(e -> {
            if (controlador != null && nssActual != null && idMedicoActual != null) {
                LocalDateTime fechaHoraReserva = LocalDateTime.now().plusDays(1).withHour(10).withMinute(0);
                controlador.registrarCita(new RegistrarCitaDTO(nssActual, idMedicoActual, fechaHoraReserva));
            }
        });

        add(lblNombre);
        add(Box.createVerticalStrut(5));
        add(lblEspecialidad);
        add(Box.createVerticalStrut(5));
        add(lblConsultorio);
        add(Box.createVerticalStrut(5));
        add(lblHorarios);
        add(Box.createVerticalStrut(15));
        add(btnApartar);
    }

    public void setControlador(ControladorCitas controlador) {
        this.controlador = controlador;
    }

    public void mostrarDetalles(String nombre, String especialidad, String consultorio, List<String> horarios, String nss, String idMedico) {
        this.nssActual = nss;
        this.idMedicoActual = idMedico;
        if (nombre != null) {
            lblNombre.setText("Nombre: " + nombre);
            lblEspecialidad.setText("Especialidad: " + (especialidad != null ? especialidad : "-"));
            lblConsultorio.setText("Consultorio: " + (consultorio != null ? consultorio : "-"));
            lblHorarios.setText("Horarios: " + (horarios != null ? String.join(", ", horarios) : "-"));
            btnApartar.setEnabled(true);
        } else {
            limpiar();
        }
    }

    public void limpiar() {
        lblNombre.setText("Nombre: -");
        lblEspecialidad.setText("Especialidad: -");
        lblConsultorio.setText("Consultorio: -");
        lblHorarios.setText("Horarios: -");
        btnApartar.setEnabled(false);
    }
}