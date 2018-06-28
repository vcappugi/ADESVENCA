/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2007 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.pentanet.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for HR_WorkedTimeLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE)
 */
public interface I_HR_WorkedTimeLine 
{

    /** TableName=HR_WorkedTimeLine */
    public static final String Table_Name = "HR_WorkedTimeLine";

    /** AD_Table_ID=1000138 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name Activity10_ID */
    public static final String COLUMNNAME_Activity10_ID = "Activity10_ID";

	/** Set Activity10_ID	  */
	public void setActivity10_ID (int Activity10_ID);

	/** Get Activity10_ID	  */
	public int getActivity10_ID();

	public org.compiere.model.I_C_Activity getActivity10() throws RuntimeException;

    /** Column name Activity11_ID */
    public static final String COLUMNNAME_Activity11_ID = "Activity11_ID";

	/** Set Activity11_ID	  */
	public void setActivity11_ID (int Activity11_ID);

	/** Get Activity11_ID	  */
	public int getActivity11_ID();

	public org.compiere.model.I_C_Activity getActivity11() throws RuntimeException;

    /** Column name Activity12_ID */
    public static final String COLUMNNAME_Activity12_ID = "Activity12_ID";

	/** Set Activity12_ID	  */
	public void setActivity12_ID (int Activity12_ID);

	/** Get Activity12_ID	  */
	public int getActivity12_ID();

	public org.compiere.model.I_C_Activity getActivity12() throws RuntimeException;

    /** Column name Activity13_ID */
    public static final String COLUMNNAME_Activity13_ID = "Activity13_ID";

	/** Set Activity13_ID	  */
	public void setActivity13_ID (int Activity13_ID);

	/** Get Activity13_ID	  */
	public int getActivity13_ID();

	public org.compiere.model.I_C_Activity getActivity13() throws RuntimeException;

    /** Column name Activity14_ID */
    public static final String COLUMNNAME_Activity14_ID = "Activity14_ID";

	/** Set Activity14_ID	  */
	public void setActivity14_ID (int Activity14_ID);

	/** Get Activity14_ID	  */
	public int getActivity14_ID();

	public org.compiere.model.I_C_Activity getActivity14() throws RuntimeException;

    /** Column name Activity15_ID */
    public static final String COLUMNNAME_Activity15_ID = "Activity15_ID";

	/** Set Activity15_ID	  */
	public void setActivity15_ID (int Activity15_ID);

	/** Get Activity15_ID	  */
	public int getActivity15_ID();

	public org.compiere.model.I_C_Activity getActivity15() throws RuntimeException;

    /** Column name Activity16_ID */
    public static final String COLUMNNAME_Activity16_ID = "Activity16_ID";

	/** Set Activity16_ID	  */
	public void setActivity16_ID (int Activity16_ID);

	/** Get Activity16_ID	  */
	public int getActivity16_ID();

	public org.compiere.model.I_C_Activity getActivity16() throws RuntimeException;

    /** Column name Activity17_ID */
    public static final String COLUMNNAME_Activity17_ID = "Activity17_ID";

	/** Set Activity17_ID	  */
	public void setActivity17_ID (int Activity17_ID);

	/** Get Activity17_ID	  */
	public int getActivity17_ID();

	public org.compiere.model.I_C_Activity getActivity17() throws RuntimeException;

    /** Column name Activity18_ID */
    public static final String COLUMNNAME_Activity18_ID = "Activity18_ID";

	/** Set Activity18_ID	  */
	public void setActivity18_ID (int Activity18_ID);

	/** Get Activity18_ID	  */
	public int getActivity18_ID();

	public org.compiere.model.I_C_Activity getActivity18() throws RuntimeException;

    /** Column name Activity19_ID */
    public static final String COLUMNNAME_Activity19_ID = "Activity19_ID";

	/** Set Activity19_ID	  */
	public void setActivity19_ID (int Activity19_ID);

	/** Get Activity19_ID	  */
	public int getActivity19_ID();

	public org.compiere.model.I_C_Activity getActivity19() throws RuntimeException;

    /** Column name Activity1_ID */
    public static final String COLUMNNAME_Activity1_ID = "Activity1_ID";

	/** Set Activity1_ID	  */
	public void setActivity1_ID (int Activity1_ID);

	/** Get Activity1_ID	  */
	public int getActivity1_ID();

	public org.compiere.model.I_C_Activity getActivity1() throws RuntimeException;

    /** Column name Activity20_ID */
    public static final String COLUMNNAME_Activity20_ID = "Activity20_ID";

	/** Set Activity20_ID	  */
	public void setActivity20_ID (int Activity20_ID);

	/** Get Activity20_ID	  */
	public int getActivity20_ID();

	public org.compiere.model.I_C_Activity getActivity20() throws RuntimeException;

    /** Column name Activity21_ID */
    public static final String COLUMNNAME_Activity21_ID = "Activity21_ID";

	/** Set Activity21_ID	  */
	public void setActivity21_ID (int Activity21_ID);

	/** Get Activity21_ID	  */
	public int getActivity21_ID();

	public org.compiere.model.I_C_Activity getActivity21() throws RuntimeException;

    /** Column name Activity22_ID */
    public static final String COLUMNNAME_Activity22_ID = "Activity22_ID";

	/** Set Activity22_ID	  */
	public void setActivity22_ID (int Activity22_ID);

	/** Get Activity22_ID	  */
	public int getActivity22_ID();

	public org.compiere.model.I_C_Activity getActivity22() throws RuntimeException;

    /** Column name Activity23_ID */
    public static final String COLUMNNAME_Activity23_ID = "Activity23_ID";

	/** Set Activity23_ID	  */
	public void setActivity23_ID (int Activity23_ID);

	/** Get Activity23_ID	  */
	public int getActivity23_ID();

	public org.compiere.model.I_C_Activity getActivity23() throws RuntimeException;

    /** Column name Activity24_ID */
    public static final String COLUMNNAME_Activity24_ID = "Activity24_ID";

	/** Set Activity24_ID	  */
	public void setActivity24_ID (int Activity24_ID);

	/** Get Activity24_ID	  */
	public int getActivity24_ID();

	public org.compiere.model.I_C_Activity getActivity24() throws RuntimeException;

    /** Column name Activity25_ID */
    public static final String COLUMNNAME_Activity25_ID = "Activity25_ID";

	/** Set Activity25_ID	  */
	public void setActivity25_ID (int Activity25_ID);

	/** Get Activity25_ID	  */
	public int getActivity25_ID();

	public org.compiere.model.I_C_Activity getActivity25() throws RuntimeException;

    /** Column name Activity26_ID */
    public static final String COLUMNNAME_Activity26_ID = "Activity26_ID";

	/** Set Activity26_ID	  */
	public void setActivity26_ID (int Activity26_ID);

	/** Get Activity26_ID	  */
	public int getActivity26_ID();

	public org.compiere.model.I_C_Activity getActivity26() throws RuntimeException;

    /** Column name Activity27_ID */
    public static final String COLUMNNAME_Activity27_ID = "Activity27_ID";

	/** Set Activity27_ID	  */
	public void setActivity27_ID (int Activity27_ID);

	/** Get Activity27_ID	  */
	public int getActivity27_ID();

	public org.compiere.model.I_C_Activity getActivity27() throws RuntimeException;

    /** Column name Activity28_ID */
    public static final String COLUMNNAME_Activity28_ID = "Activity28_ID";

	/** Set Activity28_ID	  */
	public void setActivity28_ID (int Activity28_ID);

	/** Get Activity28_ID	  */
	public int getActivity28_ID();

	public org.compiere.model.I_C_Activity getActivity28() throws RuntimeException;

    /** Column name Activity29_ID */
    public static final String COLUMNNAME_Activity29_ID = "Activity29_ID";

	/** Set Activity29_ID	  */
	public void setActivity29_ID (int Activity29_ID);

	/** Get Activity29_ID	  */
	public int getActivity29_ID();

	public org.compiere.model.I_C_Activity getActivity29() throws RuntimeException;

    /** Column name Activity2_ID */
    public static final String COLUMNNAME_Activity2_ID = "Activity2_ID";

	/** Set Activity2_ID	  */
	public void setActivity2_ID (int Activity2_ID);

	/** Get Activity2_ID	  */
	public int getActivity2_ID();

	public org.compiere.model.I_C_Activity getActivity2() throws RuntimeException;

    /** Column name Activity30_ID */
    public static final String COLUMNNAME_Activity30_ID = "Activity30_ID";

	/** Set Activity30_ID	  */
	public void setActivity30_ID (int Activity30_ID);

	/** Get Activity30_ID	  */
	public int getActivity30_ID();

	public org.compiere.model.I_C_Activity getActivity30() throws RuntimeException;

    /** Column name Activity31_ID */
    public static final String COLUMNNAME_Activity31_ID = "Activity31_ID";

	/** Set Activity31_ID	  */
	public void setActivity31_ID (int Activity31_ID);

	/** Get Activity31_ID	  */
	public int getActivity31_ID();

	public org.compiere.model.I_C_Activity getActivity31() throws RuntimeException;

    /** Column name Activity3_ID */
    public static final String COLUMNNAME_Activity3_ID = "Activity3_ID";

	/** Set Activity3_ID	  */
	public void setActivity3_ID (int Activity3_ID);

	/** Get Activity3_ID	  */
	public int getActivity3_ID();

	public org.compiere.model.I_C_Activity getActivity3() throws RuntimeException;

    /** Column name Activity4_ID */
    public static final String COLUMNNAME_Activity4_ID = "Activity4_ID";

	/** Set Activity4_ID	  */
	public void setActivity4_ID (int Activity4_ID);

	/** Get Activity4_ID	  */
	public int getActivity4_ID();

	public org.compiere.model.I_C_Activity getActivity4() throws RuntimeException;

    /** Column name Activity5_ID */
    public static final String COLUMNNAME_Activity5_ID = "Activity5_ID";

	/** Set Activity5_ID	  */
	public void setActivity5_ID (int Activity5_ID);

	/** Get Activity5_ID	  */
	public int getActivity5_ID();

	public org.compiere.model.I_C_Activity getActivity5() throws RuntimeException;

    /** Column name Activity6_ID */
    public static final String COLUMNNAME_Activity6_ID = "Activity6_ID";

	/** Set Activity6_ID	  */
	public void setActivity6_ID (int Activity6_ID);

	/** Get Activity6_ID	  */
	public int getActivity6_ID();

	public org.compiere.model.I_C_Activity getActivity6() throws RuntimeException;

    /** Column name Activity7_ID */
    public static final String COLUMNNAME_Activity7_ID = "Activity7_ID";

	/** Set Activity7_ID	  */
	public void setActivity7_ID (int Activity7_ID);

	/** Get Activity7_ID	  */
	public int getActivity7_ID();

	public org.compiere.model.I_C_Activity getActivity7() throws RuntimeException;

    /** Column name Activity8_ID */
    public static final String COLUMNNAME_Activity8_ID = "Activity8_ID";

	/** Set Activity8_ID	  */
	public void setActivity8_ID (int Activity8_ID);

	/** Get Activity8_ID	  */
	public int getActivity8_ID();

	public org.compiere.model.I_C_Activity getActivity8() throws RuntimeException;

    /** Column name Activity9_ID */
    public static final String COLUMNNAME_Activity9_ID = "Activity9_ID";

	/** Set Activity9_ID	  */
	public void setActivity9_ID (int Activity9_ID);

	/** Get Activity9_ID	  */
	public int getActivity9_ID();

	public org.compiere.model.I_C_Activity getActivity9() throws RuntimeException;

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name C_BPartner_ID */
    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";

	/** Set Business Partner .
	  * Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID);

	/** Get Business Partner .
	  * Identifies a Business Partner
	  */
	public int getC_BPartner_ID();

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException;

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name D10_ID */
    public static final String COLUMNNAME_D10_ID = "D10_ID";

	/** Set D10_ID	  */
	public void setD10_ID (int D10_ID);

	/** Get D10_ID	  */
	public int getD10_ID();

	public org.pentanet.model.I_HR_Turn getD10() throws RuntimeException;

    /** Column name D11_ID */
    public static final String COLUMNNAME_D11_ID = "D11_ID";

	/** Set D11_ID	  */
	public void setD11_ID (int D11_ID);

	/** Get D11_ID	  */
	public int getD11_ID();

	public org.pentanet.model.I_HR_Turn getD11() throws RuntimeException;

    /** Column name D12_ID */
    public static final String COLUMNNAME_D12_ID = "D12_ID";

	/** Set D12_ID	  */
	public void setD12_ID (int D12_ID);

	/** Get D12_ID	  */
	public int getD12_ID();

	public org.pentanet.model.I_HR_Turn getD12() throws RuntimeException;

    /** Column name D13_ID */
    public static final String COLUMNNAME_D13_ID = "D13_ID";

	/** Set D13_ID	  */
	public void setD13_ID (int D13_ID);

	/** Get D13_ID	  */
	public int getD13_ID();

	public org.pentanet.model.I_HR_Turn getD13() throws RuntimeException;

    /** Column name D14_ID */
    public static final String COLUMNNAME_D14_ID = "D14_ID";

	/** Set D14_ID	  */
	public void setD14_ID (int D14_ID);

	/** Get D14_ID	  */
	public int getD14_ID();

	public org.pentanet.model.I_HR_Turn getD14() throws RuntimeException;

    /** Column name D15_ID */
    public static final String COLUMNNAME_D15_ID = "D15_ID";

	/** Set D15_ID	  */
	public void setD15_ID (int D15_ID);

	/** Get D15_ID	  */
	public int getD15_ID();

	public org.pentanet.model.I_HR_Turn getD15() throws RuntimeException;

    /** Column name D16_ID */
    public static final String COLUMNNAME_D16_ID = "D16_ID";

	/** Set D16_ID	  */
	public void setD16_ID (int D16_ID);

	/** Get D16_ID	  */
	public int getD16_ID();

	public org.pentanet.model.I_HR_Turn getD16() throws RuntimeException;

    /** Column name D17_ID */
    public static final String COLUMNNAME_D17_ID = "D17_ID";

	/** Set D17_ID	  */
	public void setD17_ID (int D17_ID);

	/** Get D17_ID	  */
	public int getD17_ID();

	public org.pentanet.model.I_HR_Turn getD17() throws RuntimeException;

    /** Column name D18_ID */
    public static final String COLUMNNAME_D18_ID = "D18_ID";

	/** Set D18_ID	  */
	public void setD18_ID (int D18_ID);

	/** Get D18_ID	  */
	public int getD18_ID();

	public org.pentanet.model.I_HR_Turn getD18() throws RuntimeException;

    /** Column name D19_ID */
    public static final String COLUMNNAME_D19_ID = "D19_ID";

	/** Set D19_ID	  */
	public void setD19_ID (int D19_ID);

	/** Get D19_ID	  */
	public int getD19_ID();

	public org.pentanet.model.I_HR_Turn getD19() throws RuntimeException;

    /** Column name D1_ID */
    public static final String COLUMNNAME_D1_ID = "D1_ID";

	/** Set D1_ID	  */
	public void setD1_ID (int D1_ID);

	/** Get D1_ID	  */
	public int getD1_ID();

	public org.pentanet.model.I_HR_Turn getD1() throws RuntimeException;

    /** Column name D20_ID */
    public static final String COLUMNNAME_D20_ID = "D20_ID";

	/** Set D20_ID	  */
	public void setD20_ID (int D20_ID);

	/** Get D20_ID	  */
	public int getD20_ID();

	public org.pentanet.model.I_HR_Turn getD20() throws RuntimeException;

    /** Column name D21_ID */
    public static final String COLUMNNAME_D21_ID = "D21_ID";

	/** Set D21_ID	  */
	public void setD21_ID (int D21_ID);

	/** Get D21_ID	  */
	public int getD21_ID();

	public org.pentanet.model.I_HR_Turn getD21() throws RuntimeException;

    /** Column name D22_ID */
    public static final String COLUMNNAME_D22_ID = "D22_ID";

	/** Set D22_ID	  */
	public void setD22_ID (int D22_ID);

	/** Get D22_ID	  */
	public int getD22_ID();

	public org.pentanet.model.I_HR_Turn getD22() throws RuntimeException;

    /** Column name D23_ID */
    public static final String COLUMNNAME_D23_ID = "D23_ID";

	/** Set D23_ID	  */
	public void setD23_ID (int D23_ID);

	/** Get D23_ID	  */
	public int getD23_ID();

	public org.pentanet.model.I_HR_Turn getD23() throws RuntimeException;

    /** Column name D24_ID */
    public static final String COLUMNNAME_D24_ID = "D24_ID";

	/** Set D24_ID	  */
	public void setD24_ID (int D24_ID);

	/** Get D24_ID	  */
	public int getD24_ID();

	public org.pentanet.model.I_HR_Turn getD24() throws RuntimeException;

    /** Column name D25_ID */
    public static final String COLUMNNAME_D25_ID = "D25_ID";

	/** Set D25_ID	  */
	public void setD25_ID (int D25_ID);

	/** Get D25_ID	  */
	public int getD25_ID();

	public org.pentanet.model.I_HR_Turn getD25() throws RuntimeException;

    /** Column name D26_ID */
    public static final String COLUMNNAME_D26_ID = "D26_ID";

	/** Set D26_ID	  */
	public void setD26_ID (int D26_ID);

	/** Get D26_ID	  */
	public int getD26_ID();

	public org.pentanet.model.I_HR_Turn getD26() throws RuntimeException;

    /** Column name D27_ID */
    public static final String COLUMNNAME_D27_ID = "D27_ID";

	/** Set D27_ID	  */
	public void setD27_ID (int D27_ID);

	/** Get D27_ID	  */
	public int getD27_ID();

	public org.pentanet.model.I_HR_Turn getD27() throws RuntimeException;

    /** Column name D28_ID */
    public static final String COLUMNNAME_D28_ID = "D28_ID";

	/** Set D28_ID	  */
	public void setD28_ID (int D28_ID);

	/** Get D28_ID	  */
	public int getD28_ID();

	public org.pentanet.model.I_HR_Turn getD28() throws RuntimeException;

    /** Column name D29_ID */
    public static final String COLUMNNAME_D29_ID = "D29_ID";

	/** Set D29_ID	  */
	public void setD29_ID (int D29_ID);

	/** Get D29_ID	  */
	public int getD29_ID();

	public org.pentanet.model.I_HR_Turn getD29() throws RuntimeException;

    /** Column name D2_ID */
    public static final String COLUMNNAME_D2_ID = "D2_ID";

	/** Set D2_ID	  */
	public void setD2_ID (int D2_ID);

	/** Get D2_ID	  */
	public int getD2_ID();

	public org.pentanet.model.I_HR_Turn getD2() throws RuntimeException;

    /** Column name D30_ID */
    public static final String COLUMNNAME_D30_ID = "D30_ID";

	/** Set D30_ID	  */
	public void setD30_ID (int D30_ID);

	/** Get D30_ID	  */
	public int getD30_ID();

	public org.pentanet.model.I_HR_Turn getD30() throws RuntimeException;

    /** Column name D31_ID */
    public static final String COLUMNNAME_D31_ID = "D31_ID";

	/** Set D31_ID	  */
	public void setD31_ID (int D31_ID);

	/** Get D31_ID	  */
	public int getD31_ID();

	public org.pentanet.model.I_HR_Turn getD31() throws RuntimeException;

    /** Column name D3_ID */
    public static final String COLUMNNAME_D3_ID = "D3_ID";

	/** Set D3_ID	  */
	public void setD3_ID (int D3_ID);

	/** Get D3_ID	  */
	public int getD3_ID();

	public org.pentanet.model.I_HR_Turn getD3() throws RuntimeException;

    /** Column name D4_ID */
    public static final String COLUMNNAME_D4_ID = "D4_ID";

	/** Set D4_ID	  */
	public void setD4_ID (int D4_ID);

	/** Get D4_ID	  */
	public int getD4_ID();

	public org.pentanet.model.I_HR_Turn getD4() throws RuntimeException;

    /** Column name D5_ID */
    public static final String COLUMNNAME_D5_ID = "D5_ID";

	/** Set D5_ID	  */
	public void setD5_ID (int D5_ID);

	/** Get D5_ID	  */
	public int getD5_ID();

	public org.pentanet.model.I_HR_Turn getD5() throws RuntimeException;

    /** Column name D6_ID */
    public static final String COLUMNNAME_D6_ID = "D6_ID";

	/** Set D6_ID	  */
	public void setD6_ID (int D6_ID);

	/** Get D6_ID	  */
	public int getD6_ID();

	public org.pentanet.model.I_HR_Turn getD6() throws RuntimeException;

    /** Column name D7_ID */
    public static final String COLUMNNAME_D7_ID = "D7_ID";

	/** Set D7_ID	  */
	public void setD7_ID (int D7_ID);

	/** Get D7_ID	  */
	public int getD7_ID();

	public org.pentanet.model.I_HR_Turn getD7() throws RuntimeException;

    /** Column name D8_ID */
    public static final String COLUMNNAME_D8_ID = "D8_ID";

	/** Set D8_ID	  */
	public void setD8_ID (int D8_ID);

	/** Get D8_ID	  */
	public int getD8_ID();

	public org.pentanet.model.I_HR_Turn getD8() throws RuntimeException;

    /** Column name D9_ID */
    public static final String COLUMNNAME_D9_ID = "D9_ID";

	/** Set D9_ID	  */
	public void setD9_ID (int D9_ID);

	/** Get D9_ID	  */
	public int getD9_ID();

	public org.pentanet.model.I_HR_Turn getD9() throws RuntimeException;

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name Help */
    public static final String COLUMNNAME_Help = "Help";

	/** Set Comment/Help.
	  * Comment or Hint
	  */
	public void setHelp (String Help);

	/** Get Comment/Help.
	  * Comment or Hint
	  */
	public String getHelp();

    /** Column name HR_WorkedTime_ID */
    public static final String COLUMNNAME_HR_WorkedTime_ID = "HR_WorkedTime_ID";

	/** Set HR_WorkedTime	  */
	public void setHR_WorkedTime_ID (int HR_WorkedTime_ID);

	/** Get HR_WorkedTime	  */
	public int getHR_WorkedTime_ID();

	public org.pentanet.model.I_HR_WorkedTime getHR_WorkedTime() throws RuntimeException;

    /** Column name HR_WorkedTimeLine_ID */
    public static final String COLUMNNAME_HR_WorkedTimeLine_ID = "HR_WorkedTimeLine_ID";

	/** Set HR_WorkedTimeLine	  */
	public void setHR_WorkedTimeLine_ID (int HR_WorkedTimeLine_ID);

	/** Get HR_WorkedTimeLine	  */
	public int getHR_WorkedTimeLine_ID();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name Value */
    public static final String COLUMNNAME_Value = "Value";

	/** Set Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value);

	/** Get Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public String getValue();
}
