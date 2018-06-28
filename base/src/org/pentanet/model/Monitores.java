package org.pentanet.model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.compiere.swing.CFrame;

public class Monitores extends CFrame
{
    private javax.swing.JPanel monitor;
    private javax.swing.JPanel monitordetalle;
    
    public static void main(String[] args)
    {
        Monitores prueba=new Monitores();
    prueba.visualizaVentana();
    }
    public void visualizaVentana()
    {
        CFrame v = new CFrame("Prueba BorderLayout");
        construyeTodo(v);
        v.pack();
        v.setVisible(true);
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void start()
    {
        construyeTodo(this); 
		// aqui el timer
    }

    /**
     * Crea los paneles y los mete en el contenedor que se le pasa.
     *
     * @param contenedor Contenedor en el que meter los paneles.
     */
    private void construyeTodo(JFrame contenedor)
    {
     
        monitor = new javax.swing.JPanel();
        monitordetalle = new javax.swing.JPanel();
        monitordetalle.setLayout(new GridLayout(0,1));
        monitor.setLayout(new GridLayout(1,1));
        monitor.add(construyePanel());
      
        
        
        monitordetalle.add(construyePanel2());
        monitordetalle.add(construyePanel2());
        monitordetalle.add(construyePanel2());
        monitordetalle.add(construyePanel2());
        monitordetalle.add(construyePanel2());
        
        
        
        monitor.setBackground(new java.awt.Color(204, 204, 204));
        monitor.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout monitorLayout = new javax.swing.GroupLayout(monitor);
     //   monitor.setLayout(monitorLayout);
        
    	JScrollPane js = new JScrollPane(monitor);
        js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        
    	JScrollPane js2 = new JScrollPane(monitordetalle);
        js2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        js2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        
        
        monitorLayout.setHorizontalGroup(
            monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
        );
        monitorLayout.setVerticalGroup(
            monitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        monitordetalle.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout monitordetalleLayout = new javax.swing.GroupLayout(monitordetalle);
       // monitordetalle.setLayout(monitordetalleLayout);
        monitordetalleLayout.setHorizontalGroup(
            monitordetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
        );
        monitordetalleLayout.setVerticalGroup(
            monitordetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(contenedor.getContentPane());
        contenedor.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(js, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(js2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(js2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(js, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }
    private JScrollPane construyePanel()
    {
    	// Aqui realizo el query de monitor Padre
    	JPanel el_panel=  new JPanel();
        JButton a=new JButton("es el boton a");
        JButton b=new JButton("es el boton b");
        JButton c=new JButton("es el boton c");
        JButton d=new JButton("es el boton d");
        JButton e=new JButton("es el boton e");
        JButton f=new JButton("es el boton f");
        JButton g=new JButton("es el boton g");
        JButton h=new JButton("es el boton h");
        JButton i=new JButton("es el boton i");
        JButton j=new JButton("es el boton j");
        JButton k=new JButton("es el boton k");
        JButton l=new JButton("es el boton l");
        JButton m=new JButton("es el boton m");
        JButton n=new JButton("es el boton n");
        JButton o=new JButton("es el boton o");
        JButton p=new JButton("es el boton p");
        JButton q=new JButton("es el boton q");
        JButton r=new JButton("es el boton r");
        JButton s=new JButton("es el boton s");
        JButton t=new JButton("es el boton t");
        JButton u=new JButton("es el boton u");
        JButton v=new JButton("es el boton v");
        JButton x=new JButton("es el boton x");
      
        
        el_panel.setLayout(new GridLayout(0,1));
        el_panel.add(a);
        el_panel.add(b);
        el_panel.add(c);
        el_panel.add(d);
        el_panel.add(e);
        el_panel.add(f);
        el_panel.add(g);
        el_panel.add(h);
        el_panel.add(i);
        el_panel.add(j);
        el_panel.add(k);
        el_panel.add(l);
        el_panel.add(m);
        el_panel.add(n);
        el_panel.add(o);
        el_panel.add(p);
        el_panel.add(q);
        el_panel.add(r);
        el_panel.add(s);
        el_panel.add(t);
        el_panel.add(u);
        el_panel.add(v);
        el_panel.add(x);
        JScrollPane sc = new JScrollPane(el_panel);
        sc.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "El Monitor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION)));
        sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        return sc;   

    }
  
    
    private JScrollPane construyePanel2()
    {
    	// Aqui realizo el query de monitor hijo
    	JPanel el_panel=  new JPanel();
    	JButton a=new JButton("es el boton axx");
        JButton b=new JButton("es el boton b");
        JButton c=new JButton("es el boton c");
        JButton d=new JButton("es el boton d");
        JButton e=new JButton("es el boton e");
        JButton f=new JButton("es el boton f");
        JButton g=new JButton("es el boton g");
        JButton h=new JButton("es el boton h");
        JButton i=new JButton("es el boton i");
        JButton j=new JButton("es el boton j");
        JButton k=new JButton("es el boton k");
        JButton l=new JButton("es el boton l");
        JButton m=new JButton("es el boton m");
        JButton n=new JButton("es el boton n");
        JButton o=new JButton("es el boton 0");
        a.setPreferredSize(new Dimension(80,100));
        el_panel.setLayout(new GridLayout(3,4));
        el_panel.add(a);
        el_panel.add(b);
        el_panel.add(c);
        el_panel.add(d);
        el_panel.add(e);
        el_panel.add(f);
        el_panel.add(g);
        el_panel.add(h);
        el_panel.add(i);
        el_panel.add(j);
        el_panel.add(k);
        el_panel.add(l);
        el_panel.add(m);
        el_panel.add(n);
        el_panel.add(o);
       
        
        el_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)), "Monitores"));
        
        
        JScrollPane sc = new JScrollPane(el_panel);
        sc.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "El Monitor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION)));
        sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
  
    return sc;   

    }
        
}