package org.compiere.pos;  

import java.awt.Dimension;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.compiere.apps.ADialog;
import org.compiere.apps.AEnv;
import org.compiere.minigrid.IDColumn;
import org.compiere.model.MBankStatement;
import org.compiere.model.MOrderLine;
import org.compiere.model.MPOSKey;
import org.compiere.model.MPayment;
import org.compiere.model.MProduct;
import org.compiere.model.MRole;
import org.compiere.swing.CFrame;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.ValueNamePair;


@SuppressWarnings("unused")
public class PosFuntionKeys  implements PosKeyListener {

	PosBasePanel _posPanel = null;
	public PosFuntionKeys() {

	}

	public String BloqueaApp (PosBasePanel posPanel)
	{
//		if(MRole.getDefault(Env.getCtx(), true).isAllow_Break())
//		{
			_posPanel=posPanel;
			PosClaveMaster dlgbreak = new PosClaveMaster(_posPanel,true);
			dlgbreak.setisAccesoAccion(false);
		    AEnv.showCenterWindow(_posPanel.getm_frame(), dlgbreak);
//		}
		return "";
	}	
	
	
	public String PosWIC(PosBasePanel posPanel)
	{
		_posPanel=posPanel;
		if(!_posPanel.isPosOpen())
		{
			 JOptionPane.showMessageDialog(null, Msg.translate(Env.getCtx(),  "Debe abrir una Caja"));
			 return "";
		}		
		if(_posPanel.m_order!=null)
		{
			if(_posPanel.m_order.get_ValueAsString("docstatus").equalsIgnoreCase("DR"))
			{
				JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "!! Debe completar esta orden !!"));
				return "";
			}		
			
		}
		PanelWIC dlgWIC = new PanelWIC( posPanel,true);
		AEnv.showCenterWindow(_posPanel.getm_frame(), dlgWIC);
		if(dlgWIC.getbAcepto())
		{
		   posPanel.f_order.p_posPanel.setisWIC(true);
		   posPanel.f_order.p_posPanel.newOrder(0);
		   posPanel.setdMontoMaximoWic(BigDecimal.valueOf(Double.valueOf(dlgWIC.getfieldWICAmount().getValue().toString())));
		   posPanel.setDocumenNoWic(dlgWIC.gtfieldWICNumber().getText());
		   posPanel.getm_frame().setTitle(Msg.translate(Env.getCtx(),  "ORDER TYPE WIC Nro.")+dlgWIC.gtfieldWICNumber().getText()+Msg.translate(Env.getCtx(), " for amount of: ")+dlgWIC.getfieldWICAmount().getText());
		}
		return "";
	}

	public String PosNew(PosBasePanel posPanel)
	{

		_posPanel=posPanel;
		if(!_posPanel.isPosOpen())
		{
			 JOptionPane.showMessageDialog(null, Msg.translate(Env.getCtx(),  "Debe abrir una Caja"));
			 return "";
		}
		
		if(!(_posPanel.m_order==null))
		{
			if(_posPanel.m_order.get_ValueAsString("docstatus").equalsIgnoreCase("DR"))
			{
				JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "!! Debe completar esta orden !!"));
				return "";
			}

		}
		_posPanel.f_subpanel.getbtn_Imagen().setIcon(null);
		_posPanel.f_order.getp_Panellogo().getlabelItemCount().setText(Msg.translate(Env.getCtx(), "Su Orden Tiene")+" 0"+Msg.translate(Env.getCtx(), " Articulos"));
		_posPanel.f_curLine.getf_name().setText("");   //DENIS SEP-01


		PosNewCliente PosCliente = new PosNewCliente(_posPanel, true);
		AEnv.showCenterWindow(_posPanel.getm_frame(), PosCliente);
		if(PosCliente.getbAcepto())
		{
			_posPanel.f_order.p_posPanel.newOrder(PosCliente.getMBPartner().get_ID());	
			_posPanel.f_order.p_posPanel.setIsDescuento(PosCliente.getIsDescuento());
			// comersso
		}
		return "";
	}
	
	public String PosChekPrice(PosBasePanel posPanel)
	{
		_posPanel=posPanel;
		CheckPrice dlgChekPrice = new CheckPrice(_posPanel);
		dlgChekPrice.setMinimumSize(new Dimension(700,700));
		dlgChekPrice.setResizable(false);
		AEnv.showCenterWindow(_posPanel.getm_frame(), dlgChekPrice);
		if(dlgChekPrice.getbAddItems())
		{
			if(!_posPanel.isPosOpen())
			{
				 JOptionPane.showMessageDialog(null, Msg.translate(Env.getCtx(),  "Debe abrir una Caja"));
				 return "";
			}			
			_posPanel.f_curLine.setM_Product_ID(dlgChekPrice.getm_M_product_ID());
			_posPanel.f_curLine.setPrice();
			// Cantidades
			if(dlgChekPrice.getissoldw())
			{
				if(!dlgChekPrice.getel_peso().equals(Env.ZERO))
				{
					_posPanel.f_curLine.setQty(dlgChekPrice.getel_peso());
				}
				else
				{
					 ADialog.error(0, posPanel, Msg.translate(Env.getCtx(), "No se logro guardar la linea"));
					 return ""; 
				
      			}
			}
			else
			{
				_posPanel.f_curLine.setQty(Env.ONE);	
			}
			if ( !_posPanel.f_curLine.saveLine() )
				ADialog.error(0, posPanel,Msg.translate(Env.getCtx(),  "No se logro guardar la linea"));
				_posPanel.updateInfo();
			}
		return "";
	}
	@Override
	public void keyReturned(MPOSKey key) {
     String elyo="";
     
     elyo="YO";
	
	}

	public String History(PosBasePanel posPanel)
	{
		if(!(posPanel.m_order==null))
		{
			if(posPanel.m_order.get_ValueAsString("docstatus").equalsIgnoreCase("DR"))  //SEP 01
			{
				JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "!! Debe completar esta orden !!"));
				return "";
			}

		}	
		PosQuery qt = new QueryTicket(posPanel);
		qt.setVisible(true);

		return "";
	}
	
 
 public String Cancel (PosBasePanel posPanel)  //pero aqui esta pero no sirve
	{
		PosClaveMaster dlgbreak = new PosClaveMaster(posPanel,true);
		//dlgbreak.setisAccesoAccion(true);
		AEnv.showCenterWindow(posPanel.getm_frame(), dlgbreak);  //1 
			/*dlgbreak = new PosClaveMaster(posPanel,true);
			dlgbreak.setisAccesoAccion(true);
			AEnv.showCenterWindow(posPanel.getm_frame(), dlgbreak);*/
			if(dlgbreak.getisValidado())
			{

				
				posPanel.m_order.deleteOrder(); // aqui borro todo OK, debo limpiar todo

				posPanel.f_curLine.setmEmpty_table();
				posPanel.f_order.getf_iproduct().setText("");
				
				

				posPanel.f_subpanel.getbtn_Imagen().setIcon(null);
				posPanel.f_order.getp_Panellogo().getlabelItemCount().setText(Msg.translate(Env.getCtx(), "Su Orden Tiene")+" 0"+Msg.translate(Env.getCtx(), " Articulos"));


				posPanel.f_subpanel.getf_DocumentNo().setText("");
				posPanel.f_subpanel.getf_total().setValue(Env.ZERO);
				posPanel.f_subpanel.getf_net().setValue(Env.ZERO);
				posPanel.f_subpanel.getf_tax().setValue(Env.ZERO);
				posPanel.f_curLine.getf_name().setText("");

			}
			return "";		
}
	
	

	
	public String Preference (PosBasePanel posPanel)  //copiar bien el nombre de la funcion
	{
		CashSubFunctions csf = new CashSubFunctions(posPanel);
		csf.setVisible(true);
		return "";		
	}

	public String PosBottleReturns(PosBasePanel posPanel)
	{
//		if(MRole.getDefault(Env.getCtx(), true).isAllow_Break())
//		{		
	    	_posPanel=posPanel;
	    	PosBottleReturns BottkeReturns = new PosBottleReturns(_posPanel,true);
	    	BottkeReturns.setResizable(false);
	    	BottkeReturns.setMinimumSize(new Dimension(570,325));
	    	BottkeReturns.setTitle("Bottle Retuns");
	    	BottkeReturns.setResizable(false);
	        AEnv.showCenterWindow(_posPanel.getm_frame(), BottkeReturns);
//		}
	    return "";	    
	}
	
	public String CancelaOrden (PosBasePanel posPanel)
	{
		if(MRole.getDefault(Env.getCtx(), true).isAllow_ClearAll())
		{
			_posPanel=posPanel;
			_posPanel.m_order.deleteOrder();
			_posPanel.f_curLine.setmEmpty_table(); 
			
		}
		return "";
	}	

	public String OpenCash (PosBasePanel posPanel)
	{
		this._posPanel=	posPanel;
	    if(this._posPanel.isPosOpen())   // ya existe una caja abierta
	    {
	    	 JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "Ya existe un Pos Activo debe Cerrar el Pos,  action no Valida !!!"));
	    	return "";
	    }
	    
		if(!(_posPanel.m_order==null))
		{
			if(_posPanel.m_order.get_ValueAsString("docstatus").equalsIgnoreCase("DR"))
			{
				JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "!! Debe Completar esta Orden !!"));
				return "";
			}

		}		
		PosClaveMaster dlgbreak = new PosClaveMaster(posPanel,true);
		AEnv.showCenterWindow(posPanel.getm_frame(), dlgbreak);  //1 
			if(dlgbreak.getisValidado())
			{
				_posPanel=posPanel;
				PosOpenCash OpenCash = new PosOpenCash(_posPanel,true);
				OpenCash.setResizable(false);
				OpenCash.setMinimumSize(new Dimension(604,450));
				OpenCash.setTitle("OpenCash");
				OpenCash.setResizable(false);
		        AEnv.showCenterWindow(_posPanel.getm_frame(), OpenCash);		
				
			}

		return "";
	}		

	public String CloseCash (PosBasePanel posPanel)
	{
		this._posPanel=	posPanel;
	    if(!this._posPanel.isPosOpen())   // no existe una caja abierta
	    {
	    	 JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "No existe un Pos Activo debe Abrir el Pos,  accion no Valida !!!"));
	    	return "";
	    }
	    
		if(!(_posPanel.m_order==null))
		{
			if(_posPanel.m_order.get_ValueAsString("docstatus").equalsIgnoreCase("DR"))
			{
				JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "!! Debe Completar esta Orden !!"));
				return "";
			}

		}		
		PosClaveMaster dlgbreak = new PosClaveMaster(posPanel,true);
		AEnv.showCenterWindow(posPanel.getm_frame(), dlgbreak);  //1 
			if(dlgbreak.getisValidado())
			{
				_posPanel=posPanel;
				PosCloseCash CloseCash = new PosCloseCash(_posPanel,true);
				CloseCash.setResizable(false);
		//		CloseCash.setMinimumSize(new Dimension(604,450));
				CloseCash.setTitle("OpenCash");
				CloseCash.setResizable(false);
		        AEnv.showCenterWindow(_posPanel.getm_frame(), CloseCash);		
				
			}

		return "";
	}		
	
	
	public String Suspend (PosBasePanel posPanel)
	{
		_posPanel=posPanel;
		if(!_posPanel.isPosOpen())
		{
			 JOptionPane.showMessageDialog(null, Msg.translate(Env.getCtx(),  "Debe abrir una Caja"));
			 return "";
		}		
		PosClaveMaster dlgbreak = new PosClaveMaster(posPanel,true);
		AEnv.showCenterWindow(posPanel.getm_frame(), dlgbreak);  //1 
		if(dlgbreak.getisValidado())
		{
			_posPanel=posPanel;
			if(!(_posPanel.m_order==null))
			{
				if(_posPanel.m_order.get_ValueAsString("docstatus").equalsIgnoreCase("DR"))
				{
					_posPanel.m_order.set_CustomColumn("docstatus","IN"); // la ponemos en proceso
					_posPanel.m_order.save();
					_posPanel.f_curLine.setmEmpty_table();
					_posPanel.f_order.getf_iproduct().setText("");
					
					

					_posPanel.f_subpanel.getbtn_Imagen().setIcon(null);
					_posPanel.f_order.getp_Panellogo().getlabelItemCount().setText(Msg.translate(Env.getCtx(), "Su Orden Tiene")+" 0"+Msg.translate(Env.getCtx(), " Articulos"));


					_posPanel.f_subpanel.getf_DocumentNo().setText("");
					_posPanel.f_subpanel.getf_total().setValue(Env.ZERO);
					_posPanel.f_subpanel.getf_net().setValue(Env.ZERO);
					_posPanel.f_subpanel.getf_tax().setValue(Env.ZERO);
					_posPanel.f_curLine.getf_name().setText("");
					JOptionPane.showMessageDialog(null, Msg.translate(Env.getCtx(),  "Orden Suspendida!!!"));
					_posPanel.m_order=null;
				}
				else
				{
					JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "No Puede Suspender Esta Orden!!!"));
				}
			}
			
		}
	
		return "";
	}	
	

	public String  TransferOrder(PosBasePanel posPanel)
	{
		_posPanel=posPanel;
		if(!_posPanel.isPosOpen())
		{
			 JOptionPane.showMessageDialog(null, Msg.translate(Env.getCtx(),  "Debe abrir una Caja"));
			 return "";
		}		
		PosClaveMaster dlgbreak = new PosClaveMaster(posPanel,true);
		AEnv.showCenterWindow(posPanel.getm_frame(), dlgbreak);  //1 
		if(dlgbreak.getisValidado())
		{
			_posPanel=posPanel;
			if(!(_posPanel.m_order==null))
			{
				if(_posPanel.m_order.get_ValueAsString("docstatus").equalsIgnoreCase("DR") 	|| _posPanel.m_order.get_ValueAsString("docstatus").equalsIgnoreCase("IN"))
				{
					PosTransferOrder TrasnferOrder = new PosTransferOrder(_posPanel,true);
					TrasnferOrder.setResizable(false);
					TrasnferOrder.setMinimumSize(new Dimension(604,250));
					TrasnferOrder.setTitle("Transfer Order");
					TrasnferOrder.setResizable(false);
					
			        AEnv.showCenterWindow(_posPanel.getm_frame(), TrasnferOrder);					
				}
				else
				{
					JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "No pudo ser transferida!!!"));
				}
			}
			
		}
	
		return "";

	}

	public String  RefundsOrder(PosBasePanel posPanel)
	{
		_posPanel=posPanel;
		if(!_posPanel.isPosOpen())
		{
			 JOptionPane.showMessageDialog(null, Msg.translate(Env.getCtx(),  "Debe abrir una Caja"));
			 return "";
		}
		if(!(posPanel.m_order==null))
		{
			if(posPanel.m_order.get_ValueAsString("docstatus").equalsIgnoreCase("DR"))
			{
				JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "!! Debe Commpletar esta Orden !!"));
				return "";
			}

		}
		PosClaveMaster dlgbreak = new PosClaveMaster(posPanel,true);
		AEnv.showCenterWindow(posPanel.getm_frame(), dlgbreak);  //1 
		if(dlgbreak.getisValidado())
		{
			_posPanel=posPanel;
			if(!(_posPanel.m_order==null))
			{
				if(_posPanel.m_order.get_ValueAsString("docstatus").equalsIgnoreCase("CO") 	&& _posPanel.m_order.get_ValueAsString("docaction").equalsIgnoreCase("CL") )
				{
					PosRefunds Refunds = new PosRefunds(_posPanel,true);
					Refunds.setResizable(false);
					Refunds.setMinimumSize(new Dimension(604,250));
					Refunds.setTitle("Refunds Order");
					Refunds.setResizable(false);
					
                    Refunds.setSourceItems(_posPanel.m_order); // Llena los Valores
					
					AEnv.showCenterWindow(_posPanel.getm_frame(), Refunds);					
				}
				else
				{
					JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "No puede retornar esta orden!!!"));
				}
			}
			
		}
	
		return "";

	}
	public String  PagoPos(PosBasePanel posPanel)
	{
		_posPanel=posPanel;
		if(!_posPanel.isPosOpen())
		{
			 JOptionPane.showMessageDialog(null, Msg.translate(Env.getCtx(),  "Debe abrir una Caja"));
			 return "";
		}		
		int C_BankStatement_ID = getBankStatement(posPanel);
		
		
		try 
		
		{
			_posPanel=posPanel;
			if(!(_posPanel.m_order==null))
			{
				if(_posPanel.m_order.get_ValueAsString("docstatus").equalsIgnoreCase("DR") )
				{
					PosPago_Pagos PosPago = new PosPago_Pagos(_posPanel,true);
					PosPago.setResizable(false);
					PosPago.setTitle("Payment Order");
					PosPago.setResizable(false);
					PosPago.getdtSubtotal().setText(_posPanel.f_subpanel.getf_net().getText());
					PosPago.getdtSubtotal().setValue(_posPanel.f_subpanel.getf_net().getValue());
					
					PosPago.getdtTaxamount().setText(_posPanel.f_subpanel.getf_tax().getText());
					PosPago.getdtTaxamount().setValue(_posPanel.f_subpanel.getf_tax().getValue());
					
					PosPago.getdtGrandtotal().setText(_posPanel.f_subpanel.getf_total().getText());
					PosPago.getdtGrandtotal().setValue(_posPanel.f_subpanel.getf_total().getValue());
					PosPago.getdtPago().setText("0,00");
					PosPago.getdtPago().setValue(0);
					
					PosPago.setd_dtGrandtotal(Double.parseDouble(posPanel.f_subpanel.getf_total().getValue().toString()));
					AEnv.showCenterWindow(_posPanel.getm_frame(), PosPago);		
					// Aqui el Cierre y Ticket
					if (PosPago.getbPosPagoOK())
					{
						if ( !_posPanel.m_order.isProcessed() && !_posPanel.m_order.processOrder() )
						{
							ADialog.warn(0, _posPanel, "PosOrderProcessFailed");
							return "";
						}
						if(PosPago.getd_dtCash()!=0)
							_posPanel.m_order.payCash(BigDecimal.valueOf(PosPago.getd_dtCash()),C_BankStatement_ID);
	
						
						if(PosPago.getd_dtCheck()!=0) 
						{
							DefaultTableModel model_local = (DefaultTableModel)PosPago.getT_Data_Cheque().getModel();
					        for (int iPos = 0; iPos < model_local.getRowCount(); iPos++)
					        							        {
						    		String routingno = model_local.getValueAt(iPos, 1).toString();
						    		String accountno = model_local.getValueAt(iPos, 2).toString();
						    		String checkno = model_local.getValueAt(iPos, 3).toString();
						    		Double payamt; 
						    		payamt = Double.parseDouble(model_local.getValueAt(iPos, 4).toString());
						    		_posPanel.m_order.payCheck(BigDecimal.valueOf(payamt), accountno, routingno, checkno,C_BankStatement_ID);
						        } 
							
						}
						if(PosPago.getd_dtCcard()!=0)
						{
					        DefaultTableModel model_local = (DefaultTableModel)PosPago.getT_Data_T_Credito().getModel();
					        for (int iPos = 0; iPos < model_local.getRowCount(); iPos++) 
					        {
					    		Object CreditCard = model_local.getValueAt(iPos, 1);
					    		ValueNamePair vp = (ValueNamePair)CreditCard;
					    		String PaymentRule = vp.getValue();
					    		String number =  model_local.getValueAt(iPos, 2).toString();
					    		String name =  model_local.getValueAt(iPos, 3).toString();
					    		String Expires =  model_local.getValueAt(iPos, 4).toString();
					    		String CVC = model_local.getValueAt(iPos, 5).toString();
					    		String mmStr = Expires.trim().substring(0,2);
					    		String yyStr = Expires.trim().substring(2);
					    		Double payamt; 
					    		payamt = Double.parseDouble( model_local.getValueAt(iPos,6).toString().toString());
					    		_posPanel.m_order.payCreditCard(BigDecimal.valueOf(payamt), name,Integer.parseInt(mmStr),Integer.parseInt(yyStr), number, CVC,PaymentRule,C_BankStatement_ID);
					        }   
							
						}
						
						_posPanel.f_order.printTicket();
						_posPanel.f_curLine.setmEmpty_table();
						_posPanel.m_order=null;
						_posPanel.f_subpanel.updateOrder();
						fLimpiaEntorno();

					}

						
					
					/// Rum time other 
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "Esta orden no puede ser cancelada!!!"));
				}
			}
		}
		catch (Exception e) 
			{
			  JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "Esta orden no puede ser cancelada!!!"));
			}
	   return "";
	}
		

	
	
	public String  backhold(PosBasePanel posPanel)
	{
		_posPanel=posPanel;
		if(_posPanel.m_order!=null)
		{
			if(_posPanel.m_order.get_ValueAsString("docstatus").equalsIgnoreCase("DR"))
			{
				JOptionPane.showMessageDialog(null,Msg.translate(Env.getCtx(),  "!! Debe Completar esta Orden !!"));
				return "";
			}		
			
		}
		PosQuery qt = new QueryTicket(posPanel, true);
		qt.setVisible(true);

		return "";
	}	
/*
	public String Inventario(PosBasePanel posPanel)
	{
		_posPanel=posPanel;
		PanelWIC dlgWIC = new PanelWIC( _posPanel.getm_frame(),true);
		AEnv.showCenterWindow(_posPanel.getm_frame(), dlgWIC);
		posPanel.f_order.p_posPanel.newOrder();

		
		posPanel.setdMontoMaximoWic(BigDecimal.valueOf(Double.valueOf(dlgWIC.getfieldWICAmount().getValue().toString())));
		posPanel.setDocumenNoWic(dlgWIC.gtfieldWICNumber().getText());
		posPanel.getm_frame().setTitle(Msg.translate(Env.getCtx(),  "ORDER TYPE WIC Nro.")+dlgWIC.gtfieldWICNumber().getText()+Msg.translate(Env.getCtx(), " for amount of: ")+dlgWIC.getfieldWICAmount().getText());
		return "";
	}
	*/
	private void fLimpiaEntorno()
	{
		_posPanel.f_order.getf_iproduct().setText("");
		
		

		_posPanel.f_subpanel.getbtn_Imagen().setIcon(null);
		_posPanel.f_order.getp_Panellogo().getlabelItemCount().setText(Msg.translate(Env.getCtx(), "Su Orden Tiene")+" 0"+Msg.translate(Env.getCtx(), " Articulos"));


		_posPanel.f_subpanel.getf_DocumentNo().setText("");
		_posPanel.f_subpanel.getf_total().setValue(Env.ZERO);
		_posPanel.f_subpanel.getf_net().setValue(Env.ZERO);
		_posPanel.f_subpanel.getf_tax().setValue(Env.ZERO);
		_posPanel.f_curLine.getf_name().setText("");

	}
	public String DiscountPrice(PosBasePanel posPanel)
	{
		_posPanel=posPanel;
		if(!_posPanel.isPosOpen())
		{
			 JOptionPane.showMessageDialog(null, Msg.translate(Env.getCtx(),  "Debe abrir una Caja"));
			 return "";
		}		
		PosClaveMaster dlgbreak = new PosClaveMaster(posPanel,true);
		AEnv.showCenterWindow(posPanel.getm_frame(), dlgbreak);  //1 
		if(dlgbreak.getisValidado())
		{
			_posPanel=posPanel;
			if(!(_posPanel.m_order==null))
			{
				DiscountPrice Descuento = new DiscountPrice(_posPanel,true);
				Descuento.setResizable(false);
			//	Refunds.setMinimumSize(new Dimension(604,250));
				Descuento.setTitle("Descuento");
				Descuento.setResizable(false);
				AEnv.showCenterWindow(_posPanel.getm_frame(), Descuento);		
			}
		}

		
		return "";
			
	}
	
	private int getBankStatement(PosBasePanel posPanel)
	{
		int elRetorno=0;
		_posPanel=posPanel;
		String sql ="SELECT c_bankstatement_id FROM c_bankstatement Where c_bankstatement.c_bankaccount_id=? and  c_bankstatement.docstatus='DR'" ;		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
			{
				pstmt = DB.prepareStatement(sql, "c_bankstatement");
				pstmt.setInt(1, _posPanel.f_subpanel.p_pos.getC_BankAccount_ID());
				rs = pstmt.executeQuery();
				while (rs.next())
				{
					elRetorno=rs.getInt("c_bankstatement_id");
				}

				
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				DB.close(rs, pstmt);
				rs = null;
				pstmt = null;
			}
			return elRetorno;
		}

}
	

