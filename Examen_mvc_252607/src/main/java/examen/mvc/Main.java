/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen.mvc;

import examen.dominio.entidades.Cita;
import examen.dominio.entidades.Consultorio;
import examen.dominio.entidades.Medico;
import examen.dominio.entidades.Paciente;
import examen.dominio.fachada.FachadaCitas;
import examen.dominio.fachada.IFachadaCitas;
import examen.mvc.*;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Consultorio c1 = new Consultorio("101", "1", "07:00 - 20:00");
            Consultorio c2 = new Consultorio("102", "1", "07:00 - 20:00");
            Consultorio c3 = new Consultorio("201", "2", "07:00 - 20:00");

            Medico m1 = new Medico("MED-01", "Roberto Gómez", "Medicina General", c1);
            Medico m2 = new Medico("MED-02", "Ana María Torres", "Cardiología", c2);
            Medico m3 = new Medico("MED-03", "Carlos Mendoza", "Pediatría", c3);

            Paciente p1 = new Paciente("12345678901", "Luis Rafael", "Lagarda Encinas", true);
            Paciente p2 = new Paciente("98765432109", "María José", "López Hernández", true);

            Cita citaDominio = new Cita();
            citaDominio.cargarDatos(p1, m1, c1);

            IFachadaCitas fachada = new FachadaCitas(citaDominio);
            ModeloCitas modelo = new ModeloCitas(fachada);
            ControladorCitas controlador = new ControladorCitas(modelo);

            FrmRegistroCita vista = new FrmRegistroCita(controlador, modelo);
            vista.setVisible(true);
        });
    }
}