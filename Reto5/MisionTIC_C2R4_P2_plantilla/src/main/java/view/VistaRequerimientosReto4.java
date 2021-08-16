package view;

import controller.ControladorRequerimientosReto4;
import model.vo.LiderCiudad;
import model.vo.LiderCiudad;
import model.vo.SumaProveedor;
import model.vo.ProyectoCiudad;
import model.vo.SumaProveedor;
import javax.swing.*;
import javax.swing.plaf.ScrollPaneUI;

import java.awt.event.*;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


public class VistaRequerimientosReto4 extends JFrame {
    private JLabel lbTitulo;
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JTable tabla;
    public static  ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
    
    public VistaRequerimientosReto4(){
        //contenedor
        this.setTitle("Consultas DB");
        this.setBounds(300,10, 950, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        //label titulo
        lbTitulo = new JLabel();
        lbTitulo.setText("CONSULTAS A LA DATABASE PROYECTOS CONSTRUCCION");
        lbTitulo.setBounds(40, 0, 700, 100);
        lbTitulo.setVerticalAlignment(JLabel.CENTER);
        lbTitulo.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbTitulo);

        // boton consulta 1 proyecto ciudad
        boton1 = new JButton();
        boton1.setText("Proyectos de la ciudad de Pereira. ");
        boton1.setBounds(10, 90,250, 50);
        this.add(boton1);
        // boton consulta 2 suma proveedor
        boton2 = new JButton();
        boton2.setText("Compras prooveedor HOMECENTER.");
        boton2.setBounds(10, 150,250, 50);
        this.add(boton2);
        // boton consulta 3 LIDER CIUDAD
        boton3 = new JButton();
        boton3.setText("Lideres de la ciudad LONDRES.");
        boton3.setBounds(10, 210,250, 50);
        this.add(boton3);

        //tabla resultados
        tabla = new JTable();
        tabla.setBounds(300, 90, 450, 550);
        this.add(tabla);
    

        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try{
                    DefaultTableModel tbl= new DefaultTableModel();
                    tbl.setColumnIdentifiers(new Object[]{"CONTRUCTORA", "FECHA INICIO", "CLASIFICACION"});
                    tabla.setModel(tbl);
                    tbl.addRow(new Object[]{"   CONTRUCTORA", "   FECHA INICIO", "   CLASIFICACION"});
                    ArrayList<ProyectoCiudad> proyectos = controlador.consultarProyectoCiudad();
                    for (ProyectoCiudad p : proyectos){
                        
                        tbl.addRow(new Object[]{p.getConstructora(),p.getFechaInicio(),p.getClasificacion()});
                    }
                }
                catch(SQLException e){
                    System.out.println("Error !!" + e); 
                } 
            }
        });

        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try{
                    DefaultTableModel tbl= new DefaultTableModel();
                    tbl.setColumnIdentifiers(new Object[]{"Suma"}); 
                    tbl.addRow(new Object[]{" SUMA"});                
                    tabla.setModel(tbl);
                   
                    ArrayList<SumaProveedor> sumaProveedores = controlador.consultarSumaProveedor();
                    for (SumaProveedor s : sumaProveedores){
                        
                        tbl.addRow(new Object[]{s.getSuma()});
                    }
                }
                catch(SQLException e){
                    System.out.println("Error !!" + e);   
                } 
            }
        });

        boton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try{
                    DefaultTableModel tbl= new DefaultTableModel();
                    tbl.setColumnIdentifiers(new Object[]{"Lider"});
                    tbl.addRow(new Object[]{" LIDER"});
                    tabla.setModel(tbl);
                    ArrayList<LiderCiudad> liderCiudades = controlador.consultarLiderCiudad();
                    for (LiderCiudad l : liderCiudades){
                        tbl.addRow(new Object[]{l.getLider()});
                    }
                }
                catch(SQLException e){
                    System.out.println("Error !!" + e);   
                } 
            }
        });


    }
    /*
    public static void requerimiento1() {
        System.out.println("-----Proyecto Ciudad-------");
        System.out.println("Constructora Fecha_Inicio Clasificación");
        try{
            ArrayList<ProyectoCiudad> proyectos = controlador.consultarProyectoCiudad();
            
            for (ProyectoCiudad p : proyectos){
                System.out.printf("%s %s %s %n",p.getConstructora(),p.getFechaInicio(),p.getClasificacion());
            }
        }
        catch(SQLException e){
            System.out.println("Error !!" + e);
            
        }

    }

    public static void requerimiento3() {
        
        System.out.println("-----Suma Cantidades-------");
        System.out.println("Suma Cantidades");
        try{
                ArrayList<SumaProveedor> sumaProveedores = controlador.consultarSumaProveedor();

                for (SumaProveedor s : sumaProveedores){
                    System.out.printf("%s %n",s.getSuma());
                }
            }
            catch(SQLException e){
                System.out.println("Error !!" + e);
                
            }

    

    public static void requerimiento4() {
        System.out.println("-----Líder Ciudad-------");
        System.out.println("Nombre Líder");
        try{
                ArrayList<LiderCiudad> liderCiudades = controlador.consultarLiderCiudad();
                    
                for (LiderCiudad l : liderCiudades){
                        System.out.printf("%s %n",l.getLider());
                    }
            }
            catch(SQLException e){
                System.out.println("Error !!" + e);
            }

    }}*/

}
