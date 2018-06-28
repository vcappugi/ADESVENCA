package org.compiere.pos;
import java.awt.event.*;

import javax.swing.event.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.table.*;

import org.compiere.util.Env;
@SuppressWarnings("serial")
public class PosPago_Transferencia_Grid extends javax.swing.JDialog {

    /**
     * Creates new form PosPago_Transferencia_Grid
     */
    public PosPago_Transferencia_Grid(java.awt.Frame parent, boolean modal,double dBalance) {
        super(parent, modal);
        initComponents();
        // valores visualizacion //
        Tabla_Modelo = (DefaultTableModel) Tabla_Data.getModel();
        dMontoItem = new javax.swing.JFormattedTextField(new DecimalFormat("#0.00"));
        dMontoItem.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        dMontoItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dMontoItem.setFont(new java.awt.Font("SansSerif", 1, 14)); 
        dMontoItem.setValue(0.00);
        
        comboBox_Bancos.setFont(new Font("SansSerif", Font.PLAIN, 12));
        Tabla_Data.getColumnModel().getColumn(1).setCellEditor(defaultCellEditorBancos);
        defaultCellEditorMonto=new DoubleCellEditor(dMontoItem);
        Tabla_Data.getColumnModel().getColumn(3).setCellEditor(defaultCellEditorMonto);
        
        this.Txt_Balance.setText(String.valueOf(dBalance));
        el_Balance=dBalance*-1;
        Tabla_Data.getModel().addTableModelListener(
            new TableModelListener() 
        {
            public void tableChanged(TableModelEvent evt) 
            {
               ActualizaMonto_Items();
            }
        });  
    }
    // Variables declaration - do not modify
    private javax.swing.JLabel EFE_Titulo;
    private javax.swing.JButton Tabla_Aceptar;
    private javax.swing.JButton Tabla_Add;
    private javax.swing.JButton Tabla_Cancelar;
    private javax.swing.JTable Tabla_Data;
    private javax.swing.JButton Tabla_Eli;
    private javax.swing.JTextField Tabla_Suma;
    private javax.swing.JTextField Txt_Balance;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration    
    // Valores Referencias
    private DefaultTableModel Tabla_Modelo = null;
    private boolean bAcepto = false;
    private double el_Balance=0;    
    private static final String[] DATA_BANCOS = { "Banesco", "Bicentenario", "Caribe", "CityBank", "CorpBanca", "Provincial", "Venezuela" };

    private JComboBox comboBox_Bancos = new JComboBox(DATA_BANCOS);
    private javax.swing.JFormattedTextField dMontoItem = new javax.swing.JFormattedTextField();
    private DefaultCellEditor defaultCellEditorBancos=new DefaultCellEditor(comboBox_Bancos);
    private DefaultCellEditor defaultCellEditorMonto=null;
    // Para la actualizacion hacia PosPago
    public boolean getAcepto()
    {
        return this.bAcepto;
    } 
    public javax.swing.JTextField getTxt_Balance()
    {
        return this.Txt_Balance;
    }
    public javax.swing.JTextField getTabla_Suma()
    {
        return this.Tabla_Suma;
    }
    public DefaultTableModel getTabla_Modelo()
    {
        return Tabla_Modelo;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        EFE_Titulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla_Data = new javax.swing.JTable();
        Tabla_Cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Tabla_Suma = new javax.swing.JTextField();
        Txt_Balance = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        Tabla_Aceptar = new javax.swing.JButton();
        Tabla_Eli = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        Tabla_Add = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        EFE_Titulo.setFont(new java.awt.Font("SansSerif", 3, 24));
        EFE_Titulo.setText("Transferencia");

        Tabla_Data.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Tabla_Data.setFont(new java.awt.Font("SansSerif", 0, 14));
        Tabla_Data.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] { },
                new String [] {"Nro. Transferencia", "Banco", "Nombre", "Monto" }
            ) 
            {
                @SuppressWarnings("rawtypes")
				Class[] types = new Class [] {java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class};
                @SuppressWarnings("rawtypes")
				public Class getColumnClass(int columnIndex) 
                {
                    return types [columnIndex];
                }
            });
        Tabla_Data.setColumnSelectionAllowed(true);
        Tabla_Data.setRowHeight(20);
        Tabla_Data.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tabla_Data.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                EventoMonto(evt);
            }
        });
        jScrollPane2.setViewportView(Tabla_Data);
        Tabla_Data.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tabla_Data.getColumnModel().getColumn(0).setPreferredWidth(120);
        Tabla_Data.getColumnModel().getColumn(1).setPreferredWidth(80);
        Tabla_Data.getColumnModel().getColumn(2).setPreferredWidth(150);

        Tabla_Cancelar.setIcon(Env.getImageIcon("pe_Edc_Cancelar.png")); // NOI18N
        Tabla_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tabla_CancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Suma");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18));
        jLabel3.setText("Balance");

        Tabla_Suma.setEditable(false);
        Tabla_Suma.setFont(new java.awt.Font("SansSerif", 1, 18));
        Tabla_Suma.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        Txt_Balance.setEditable(false);
        Txt_Balance.setFont(new java.awt.Font("SansSerif", 1, 18));
        Txt_Balance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        filler1.setBackground(new java.awt.Color(0, 0, 0));
        filler1.setOpaque(true);

        Tabla_Aceptar.setIcon(Env.getImageIcon("pe_Edc_Aceptar.png")); // NOI18N
        Tabla_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tabla_AceptarActionPerformed(evt);
            }
        });

        Tabla_Eli.setIcon(Env.getImageIcon("pe_Edc_eliminar.png")); // NOI18N
        Tabla_Eli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tabla_EliActionPerformed(evt);
            }
        });

        filler2.setBackground(new java.awt.Color(0, 0, 0));
        filler2.setOpaque(true);

        Tabla_Add.setIcon(Env.getImageIcon("pe_new.png")); // NOI18N
        Tabla_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tabla_AddActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                    .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 447, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tabla_Suma, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Tabla_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Tabla_Eli, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 396, Short.MAX_VALUE)
                        .addComponent(Tabla_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Tabla_Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filler2, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Txt_Balance, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(290, 454, Short.MAX_VALUE))
                    .addComponent(EFE_Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Tabla_Aceptar, Tabla_Add, Tabla_Cancelar, Tabla_Eli});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EFE_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Txt_Balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Tabla_Suma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tabla_Add, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(Tabla_Eli, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(Tabla_Cancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(Tabla_Aceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void Tabla_EliActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) Tabla_Data.getModel();
        if (model.getColumnCount()>0)
        {
             int[] selectedRow = Tabla_Data.getSelectedRows();
             
             for (int i = 0; i < selectedRow.length; i++) {
                  
                 model.removeRow(selectedRow[i]);
             }
              ActualizaMonto_Items();
        }       
    }                                         
   private void ActualizaMonto_Items()
    {
        DefaultTableModel model = (DefaultTableModel) Tabla_Data.getModel();
        Tabla_Modelo = model;    // referencia base pare enviar al PosPago
        double total_item = 0;
        if (model.getColumnCount()>0)
        {
           for (int i = 0, rows = model.getRowCount(); i < rows; i++)
               {
                   total_item += Double.valueOf(model.getValueAt(i, 3).toString().replaceAll(",", "").toString());
                           
                   
               }
         this.Tabla_Suma.setText(String.valueOf(total_item));
         
         ActualizaBalance();
        }
    }
    
    private void ActualizaBalance()
    {
        double el_monto = Double.valueOf(this.Tabla_Suma.getText().replaceAll(",", "").toString());
        
        double dPAGO_BALANCE=this.el_Balance-el_monto;
    
    //   if((dMonto_de_la_Venta>dTOTAL_PAGO))
        this.Txt_Balance.setText(Double.toString(dPAGO_BALANCE));      
            
    }
    private void Tabla_AceptarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
         this.bAcepto=true;
         this.dispose();
    }                                             

    private void Tabla_CancelarActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        this.bAcepto=false;
        this.dispose();
    }                                              

    private void EventoMonto(java.awt.event.InputMethodEvent evt) {                             
        // TODO add your handling code here:
         ActualizaBalance();
    }                            

    private void Tabla_AddActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        DefaultTableModel tm = (DefaultTableModel) Tabla_Data.getModel();
        tm.addRow(new Object[] {"","","",0});           
    }                                         

    private static class DoubleCellEditor extends DefaultCellEditor 
    {
       private static final Border red = new LineBorder(Color.red);
       private static final Border black = new LineBorder(Color.black);
       private final JFormattedTextField textField;
       public DoubleCellEditor(final JFormattedTextField textField) 
       {
          super(textField);
          this.textField = textField;
          this.textField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jSoloNumero(evt);
            }
        });
    }
    private void jSoloNumero(java.awt.event.KeyEvent evt) 
    {
       char caracter = evt.getKeyChar();
       if (!(Character.isDigit(evt.getKeyChar()) ||  
              (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) ||  
              (evt.getKeyChar() == KeyEvent.VK_DELETE) || 
              (caracter == '.' ) ||
              (evt.getKeyChar() == KeyEvent.VK_ENTER)) ) 
       {  
                evt.consume();  
                JOptionPane.showMessageDialog(null, "Solo se Aceptan Numeros", "Error!", JOptionPane.ERROR_MESSAGE);
       }         

    }  
       @Override
       public boolean stopCellEditing() 
       {
          try 
          {
             Double v = Double.valueOf(textField.getText());
             if (v <= 0) {
                throw new NumberFormatException();
             }
             else
             {
                textField.setText(String.valueOf(v));   

             }
           } 
           catch (NumberFormatException e) 
           {
               textField.setBorder(red);
               textField.selectAll();
               return false;
           }
       
      // tm..getValueAt(tm.getRowCount()-1,0);

        return super.stopCellEditing();
       }
       @Override
       public Object getCellEditorValue() 
       {
          JTextField tf = (JTextField)getComponent();
          String str = tf.getText();
          Double d;
           // Try to parse double
          try 
          {
             d = new Double(str);
          } 
          catch (NumberFormatException ex) 
          {            
             d= new Double(0.0);
          }
          return d;
       } 
    
       @Override
       public Component getTableCellEditorComponent(JTable table,Object value, boolean isSelected, int row, int column) 
       {
          
          textField.setBorder(black);

//             textField.setValue(8000);
//             textField.setText("8000");
             textField.selectAll();
        
          // this.textField.selectAll();
          return super.getTableCellEditorComponent(table, value, isSelected, row, column);
       }
        
   }



}
