/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.mvc.paneles;

import javax.swing.*;
import java.time.LocalDateTime;

/**
 * 
 * @author lagar
 */
public class PanelResumenCita extends JPanel {
    private JLabel lblFolio;
    private JLabel lblPaciente;
    private JLabel lblMedico;
    private JLabel lblConsultorio;
    private JLabel lblFechaHora;

    public PanelResumenCita() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createTitledBorder("Cita Confirmada"));

        lblFolio = new JLabel("Folio: -");
        lblPaciente = new JLabel("Paciente: -");
        lblMedico = new JLabel("Médico: -");
        lblConsultorio = new JLabel("Consultorio: -");
        lblFechaHora = new JLabel("Fecha/Hora: -");

        add(lblFolio);
        add(Box.createVerticalStrut(5));
        add(lblPaciente);
        add(Box.createVerticalStrut(5));
        add(lblMedico);
        add(Box.createVerticalStrut(5));
        add(lblConsultorio);
        add(Box.createVerticalStrut(5));
        add(lblFechaHora);
    }

    public void mostrarResumen(String folio, String paciente, String medico, String consultorio, LocalDateTime fechaHora) {
        lblFolio.setText("Folio: " + (folio != null ? folio : "-"));
        lblPaciente.setText("Paciente: " + (paciente != null ? paciente : "-"));
        lblMedico.setText("Médico: " + (medico != null ? medico : "-"));
        lblConsultorio.setText("Consultorio: " + (consultorio != null ? consultorio : "-"));
        lblFechaHora.setText("Fecha/Hora: " + (fechaHora != null ? fechaHora.toString() : "-"));
    }
}