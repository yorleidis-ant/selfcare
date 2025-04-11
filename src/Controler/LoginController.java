/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import View.vEstudiante;
import View.vProfesor;



/**
 *
 * @author Admin
 */
public class LoginController {

    // Simulando base de datos con arrays
    private String[] correos = {
        "juan.estudiante@colegio.edu",
        "luis.profesor@colegio.edu"
    };

    private String[] passwords = {
        "123", "456"
    };

    public void iniciarSesion(String correo, String contraseña, JFrame loginFrame) {
        boolean encontrado = false;

        for (int i = 0; i < correos.length; i++) {
            if (correo.equals(correos[i]) && contraseña.equals(passwords[i])) {
                encontrado = true;

                if (correo.contains(".estudiante")) {
                    new vEstudiante().setVisible(true);
                } else if (correo.contains(".profesor")) {
                    new vProfesor().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Rol no reconocido.");
                    return;
                }

                loginFrame.dispose(); // Cierra la ventana del login
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
        }
    }
}