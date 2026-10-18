/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.mvc;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import examen.dominio.dtos.ObtenerDetallesMedicoDTO;
import examen.interfaces.*;
import examen.mvc.paneles.*;

public class FrmRegistroCita extends JFrame implements Observador {
    private ControladorCitas controlador;
    
    private PanelNssBusqueda panelNssBusqueda;
    private JLabel lblPaciente;
    private JList<String> listMedicos;
    private DefaultListModel<String> modelMedicos;
    
    private JPanel panelDerecho;
    private PanelDetalleMedico panelDetalleMedico;
    private PanelResumenCita panelResumenCita;
    private CardLayout cardLayoutDerecho;

    public FrmRegistroCita(ControladorCitas controlador, IModeloLectura modelo) {
        this.controlador = controlador;
        modelo.registrarObservador(this);

        setTitle("Registrar Cita Médica");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        panelNssBusqueda = new PanelNssBusqueda();
        panelNssBusqueda.setControlador(controlador);
        add(panelNssBusqueda, BorderLayout.NORTH);

        JPanel panelIzquierdo = new JPanel(new BorderLayout(5, 5));
        panelIzquierdo.setBorder(BorderFactory.createTitledBorder("Médicos Disponibles"));
        
        lblPaciente = new JLabel("Paciente: (Ingrese NSS)");
        panelIzquierdo.add(lblPaciente, BorderLayout.NORTH);

        modelMedicos = new DefaultListModel<>();
        listMedicos = new JList<>(modelMedicos);
        listMedicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listMedicos.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && listMedicos.getSelectedValue() != null) {
                controlador.obtenerDetallesMedico(new ObtenerDetallesMedicoDTO("MED-01"));
            }
        });
        panelIzquierdo.add(new JScrollPane(listMedicos), BorderLayout.CENTER);
        add(panelIzquierdo, BorderLayout.WEST);

        cardLayoutDerecho = new CardLayout();
        panelDerecho = new JPanel(cardLayoutDerecho);

        panelDetalleMedico = new PanelDetalleMedico();
        panelDetalleMedico.setControlador(controlador);

        panelResumenCita = new PanelResumenCita();

        panelDerecho.add(panelDetalleMedico, "FICHA");
        panelDerecho.add(panelResumenCita, "RESUMEN");

        add(panelDerecho, BorderLayout.CENTER);

        cardLayoutDerecho.show(panelDerecho, "FICHA");
    }

    @Override
    public void update(IModeloLectura modelo) {
        actualizarVista(modelo);
    }

    private void actualizarVista(IModeloLectura modelo) {
        if (modelo.getMensajeError() != null) {
            JOptionPane.showMessageDialog(this, modelo.getMensajeError(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (modelo.getNombrePaciente() != null) {
            lblPaciente.setText("Paciente: " + modelo.getNombrePaciente());
            modelMedicos.clear();
            List<String> medicos = modelo.getListaMedicos();
            if (medicos != null) {
                for (String m : medicos) {
                    modelMedicos.addElement(m);
                }
            }
        }

        if (modelo.getNombreMedicoDetalle() != null) {
            panelDetalleMedico.mostrarDetalles(
                    modelo.getNombreMedicoDetalle(),
                    modelo.getEspecialidadMedicoDetalle(),
                    modelo.getConsultorioMedicoDetalle(),
                    modelo.getDiasHorariosMedicoDetalle(),
                    modelo.getNssActual(),
                    modelo.getIdMedicoSeleccionado()
            );
            cardLayoutDerecho.show(panelDerecho, "FICHA");
        }

        if (modelo.isExitoCita()) {
            panelResumenCita.mostrarResumen(
                    modelo.getFolioCita(),
                    modelo.getNombrePacienteCita(),
                    modelo.getNombreMedicoCita(),
                    modelo.getConsultorioCita(),
                    modelo.getFechaHoraCita()
            );
            cardLayoutDerecho.show(panelDerecho, "RESUMEN");
        }
    }
}