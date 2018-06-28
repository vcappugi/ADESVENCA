package org.compiere.pos;

import java.awt.Frame;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.compiere.apps.ADialog;
import org.compiere.apps.search.InfoBPartner;
import org.compiere.grid.ed.VBPartner;
import org.compiere.grid.ed.VLocation;
import org.compiere.grid.ed.VLocationDialog;
import org.compiere.model.Lookup;
import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerInfo;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MLocation;
import org.compiere.model.MLocationLookup;
import org.compiere.swing.CDialog;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Msg;

@SuppressWarnings({ "serial", "unused" })
public class PosNewCliente extends CDialog implements ActionListener {
	public static CLogger log = CLogger.getCLogger(PosPaymenCheck.class);
	private PosBasePanel posPanel;
	private boolean bAcepto = false;
    private javax.swing.JPanel PanelCliente;
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_New;
    private javax.swing.JButton btn_Process;
    private javax.swing.JButton btn_find;
    private javax.swing.JCheckBox chDescuento;
    private javax.swing.JTextField dtName;
    private javax.swing.JTextField dtValue;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblValue;
	private MBPartner	m_bpartner;
    
	public PosNewCliente (PosBasePanel posPanel,boolean modal)
	{
		super (Env.getFrame(posPanel),Msg.translate(posPanel.getCtx(), "Cliente"), true);
		this.posPanel = posPanel;
		init();
	}
	private void init() 
	{
		initComponents();

	}		
    private void initComponents() {

        PanelCliente = new javax.swing.JPanel();
        lblValue = new javax.swing.JLabel();
        dtValue = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        dtName = new javax.swing.JTextField();
        btn_find = new javax.swing.JButton();
        btn_New = new javax.swing.JButton();
        btn_Cancel = new javax.swing.JButton();
        chDescuento = new javax.swing.JCheckBox();
        btn_Process = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PanelCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblValue.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblValue.setText("Cedula - Rif.:");

        dtValue.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        lblName.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblName.setText("Nombre:");

        dtName.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        btn_find.setIcon(Env.getImageIcon("Find24.gif")); 
        btn_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_findActionPerformed(evt);
            }
        });

        btn_New.setIcon(Env.getImageIcon("New24.gif")); 
        btn_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NewActionPerformed(evt);
            }
        });

        btn_Cancel.setIcon(Env.getImageIcon("Cancel24.gif")); 
        btn_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelActionPerformed(evt);
            }
        });

        chDescuento.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        chDescuento.setText("Descuento Autorizado");

        btn_Process.setIcon(Env.getImageIcon("Process24.gif")); 
        btn_Process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProcessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelClienteLayout = new javax.swing.GroupLayout(PanelCliente);
        PanelCliente.setLayout(PanelClienteLayout);
        PanelClienteLayout.setHorizontalGroup(
            PanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelClienteLayout.createSequentialGroup()
                        .addGroup(PanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblName)
                            .addComponent(lblValue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelClienteLayout.createSequentialGroup()
                                .addComponent(dtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_find, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_New, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(chDescuento))
                            .addComponent(dtName)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelClienteLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btn_Process, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelClienteLayout.setVerticalGroup(
            PanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValue)
                    .addComponent(dtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_New, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_find, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chDescuento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName))
                .addGap(18, 18, 18)
                .addGroup(PanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Process, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("SansSerif", 3, 12)); // NOI18N
        jLabel3.setText("Datos del Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>
    private void btn_findActionPerformed(java.awt.event.ActionEvent evt) {
    	m_bpartner = null;
    	String queryValue =  this.dtValue.getText();
    	Object result[] = null;
    	Frame frame = Env.getFrame(this);
    	if (queryValue.length() == 0 && this.dtName.getText().length() > 0)
			queryValue = this.dtName.getText();
		boolean isSOTrx = true;     //  default
		if (Env.getContext(Env.getCtx(),0, "IsSOTrx").equals("N"))
			isSOTrx = false;
		InfoBPartner ip = new InfoBPartner (frame, true,0,
			queryValue, isSOTrx, false, "1=1");
		
		ip.setVisible(true);
		boolean cancelled = ip.isCancelled();
	   	result = ip.getSelectedKeys();
	   	if(!cancelled)
	   		setC_BPartner_ID((Integer)result[0]);
	   		
/*	   	
    	
        this.dtName.setText("");
        QueryBPartner qt = new QueryBPartner(this.posPanel);
		qt.SetisOnlySearch(true);
		qt.setVisible(true);
		setC_BPartner_ID(qt.getm_C_BPartner_ID());	
		findBPartner();*/
    }

    private void btn_NewActionPerformed(java.awt.event.ActionEvent evt) {
    	setC_BPartner_ID (0);
    	VBPartner vbp = new VBPartner (Env.getFrame(this),0);
		int BPartner_ID = 0;
		boolean newRecord=true;
			vbp.loadBPartner (BPartner_ID);
		vbp.setVisible(true);
		//  get result
		int result = vbp.getC_BPartner_ID();
		if (result == 0					//	0 = not saved
			&& result == BPartner_ID)	//	the same
			return;

		setC_BPartner_ID(result);
    }

    private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {

    	this.dispose();

    }

    private void btn_ProcessActionPerformed(java.awt.event.ActionEvent evt) {
        if(!(m_bpartner==null))
        {
        	@SuppressWarnings("deprecation")
			MBPartnerLocation[] locs = 	MBPartnerLocation.getForBPartner(Env.getCtx(), m_bpartner.get_ID());
        	if(locs.length > 0)
        	{
            	
            	this.bAcepto=true;
            	this.dispose();
        		
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "Cliente no posee direccion de Facturacion"));
        		VLocationDialog ld = new VLocationDialog(Env.getFrame(this), Msg.getMsg(Env.getCtx(), "Location"), null);
        			ld.setVisible(true);
        			MBPartnerLocation	m_pLocation;
        			
        			m_pLocation = new MBPartnerLocation(m_bpartner);
        			
        			m_pLocation.setC_Location_ID(ld.getValue().get_ID());
        			//
        			if (m_pLocation.save())
        			{
        				log.fine("C_BPartner_Location_ID=" + m_pLocation.getC_BPartner_Location_ID());
                    	this.bAcepto=true;
                    	this.dispose();

        			}
        			
        			else
        				ADialog.error(0, this, "BPartnerNotSaved", Msg.translate(Env.getCtx(), "C_BPartner_Location_ID"));
        			
        			
        	}
			
        }
        else
        {
        	JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "Debe Seleccionar Un Cliente"));
        }
    }	
    
	private void findBPartner()
	{
		
		String query =  this.dtValue.getText();
		
		if (query == null || query.length() == 0)
			return;
		
		// unchanged
		if ( m_bpartner != null && m_bpartner.getName().equals(query))
			return;
		
		query = query.toUpperCase();
		//	Test Number
		boolean allNumber = true;
		boolean noNumber = true;
		char[] qq = query.toCharArray();
		for (int i = 0; i < qq.length; i++)
		{
			if (Character.isDigit(qq[i]))
			{
				noNumber = false;
				break;
			}
		}
		try
		{
			Integer.parseInt(query);
		}
		catch (Exception e)
		{
			allNumber = false;
		}
		String Value = query;
		String Name = (allNumber ? null : query);
		String EMail = (query.indexOf('@') != -1 ? query : null); 
		String Phone = (noNumber ? null : query);
		String City = null;
		//
		//TODO: contact have been remove from rv_bpartner
		MBPartnerInfo[] results = MBPartnerInfo.find(Env.getCtx(), Value, Name, 
			/*Contact, */null, EMail, Phone, City);
		
		//	Set Result
		if (results.length == 0)
		{
			setC_BPartner_ID(0);
		}
		else if (results.length == 1)
		{
			setC_BPartner_ID(results[0].getC_BPartner_ID());
			this.dtName.setText(results[0].getName());
			this.dtValue.setText(results[0].getValue());
		}
		else	//	more than one
		{
			QueryBPartner qt = new QueryBPartner(posPanel);
			qt.setResults (results);
			qt.setVisible(true);
		}
	}	//	findBPartner    
	private void setC_BPartner_ID (int C_BPartner_ID)
	{
		log.fine( "PosSubCustomer.setC_BPartner_ID=" + C_BPartner_ID);
		if (C_BPartner_ID == 0)
			m_bpartner = null;
		else
		{
			m_bpartner = new MBPartner(Env.getCtx(), C_BPartner_ID, null);
			if (m_bpartner.get_ID() == 0)
				m_bpartner = null;
		}
		
		//	Set Info
		if (m_bpartner != null)
		{
			this.dtName.setText(m_bpartner.getName());
			this.dtValue.setText(m_bpartner.getValue());
		}
		else
		{
			this.dtValue.setText(null);
			this.dtName.setText(null);
		}
		//	Sets Currency
	}	//	setC_BPartner_ID  	
	
	public boolean getbAcepto()
	{
		return this.bAcepto;
	}
	public MBPartner getMBPartner()
	{
		return this.m_bpartner;
	}
	public boolean getIsDescuento()
	{
		return this.chDescuento.isSelected();
	}
}
