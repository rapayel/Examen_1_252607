/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.mvc.paneles;

import javax.swing.*;
import java.awt.*;
import examen.dominio.dtos.BuscarPacienteMedicosDTO;
import examen.mvc.ControladorCitas;

/**
 * 
 * @author lagar
 */
public class PanelNssBusqueda extends JPanel {
    private JTextField txtNss;
    private JButton btnBuscar;
    private ControladorCitas controlador;

    public PanelNssBusqueda() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        add(new JLabel("Número de Seguridad Social (NSS):"));
        
        txtNss = new JTextField(15);
        add(txtNss);

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> {
            if (controlador != null && !txtNss.getText().trim().isEmpty()) {
                controlador.buscarPacienteMedicos(new BuscarPacienteMedicosDTO(txtNss.getText().trim()));
            }
        });
        add(btnBuscar);
    }

    public void setControlador(ControladorCitas controlador) {
        this.controlador = controlador;
    }

    public String getNssIngresado() {
        return txtNss.getText().trim();
    }
}