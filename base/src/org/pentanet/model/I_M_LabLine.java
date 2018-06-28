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

/** Generated Interface for M_LabLine
 *  @author Adempiere (generated) 
 *  @version Release 3.7.0LTS (VE)
 */
public interface I_M_LabLine 
{

    /** TableName=M_LabLine */
    public static final String Table_Name = "M_LabLine";

    /** AD_Table_ID=1000110 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

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

    /** Column name M_Lab_ID */
    public static final String COLUMNNAME_M_Lab_ID = "M_Lab_ID";

	/** Set M_Lab_ID	  */
	public void setM_Lab_ID (int M_Lab_ID);

	/** Get M_Lab_ID	  */
	public int getM_Lab_ID();

	public I_M_Lab getM_Lab() throws RuntimeException;

    /** Column name M_LabLine_ID */
    public static final String COLUMNNAME_M_LabLine_ID = "M_LabLine_ID";

	/** Set M_LabLine	  */
	public void setM_LabLine_ID (int M_LabLine_ID);

	/** Get M_LabLine	  */
	public int getM_LabLine_ID();

    /** Column name M_Test_ID */
    public static final String COLUMNNAME_M_Test_ID = "M_Test_ID";

	/** Set M_Test	  */
	public void setM_Test_ID (int M_Test_ID);

	/** Get M_Test	  */
	public int getM_Test_ID();

	public org.pentanet.model.I_M_Test getM_Test() throws RuntimeException;

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

    /** Column name Result1 */
    public static final String COLUMNNAME_Result1 = "Result1";

	/** Set Result1	  */
	public void setResult1 (String Result1);

	/** Get Result1	  */
	public String getResult1();

    /** Column name Result10 */
    public static final String COLUMNNAME_Result10 = "Result10";

	/** Set Result10	  */
	public void setResult10 (String Result10);

	/** Get Result10	  */
	public String getResult10();

    /** Column name Result11 */
    public static final String COLUMNNAME_Result11 = "Result11";

	/** Set Result11	  */
	public void setResult11 (String Result11);

	/** Get Result11	  */
	public String getResult11();

    /** Column name Result12 */
    public static final String COLUMNNAME_Result12 = "Result12";

	/** Set Result12	  */
	public void setResult12 (String Result12);

	/** Get Result12	  */
	public String getResult12();

    /** Column name Result13 */
    public static final String COLUMNNAME_Result13 = "Result13";

	/** Set Result13	  */
	public void setResult13 (String Result13);

	/** Get Result13	  */
	public String getResult13();

    /** Column name Result14 */
    public static final String COLUMNNAME_Result14 = "Result14";

	/** Set Result14	  */
	public void setResult14 (String Result14);

	/** Get Result14	  */
	public String getResult14();

    /** Column name Result15 */
    public static final String COLUMNNAME_Result15 = "Result15";

	/** Set Result15	  */
	public void setResult15 (String Result15);

	/** Get Result15	  */
	public String getResult15();

    /** Column name Result16 */
    public static final String COLUMNNAME_Result16 = "Result16";

	/** Set Result16	  */
	public void setResult16 (String Result16);

	/** Get Result16	  */
	public String getResult16();

    /** Column name Result17 */
    public static final String COLUMNNAME_Result17 = "Result17";

	/** Set Result17	  */
	public void setResult17 (String Result17);

	/** Get Result17	  */
	public String getResult17();

    /** Column name Result18 */
    public static final String COLUMNNAME_Result18 = "Result18";

	/** Set Result18	  */
	public void setResult18 (String Result18);

	/** Get Result18	  */
	public String getResult18();

    /** Column name Result19 */
    public static final String COLUMNNAME_Result19 = "Result19";

	/** Set Result19	  */
	public void setResult19 (String Result19);

	/** Get Result19	  */
	public String getResult19();

    /** Column name Result2 */
    public static final String COLUMNNAME_Result2 = "Result2";

	/** Set Result2	  */
	public void setResult2 (String Result2);

	/** Get Result2	  */
	public String getResult2();

    /** Column name Result20 */
    public static final String COLUMNNAME_Result20 = "Result20";

	/** Set Result20	  */
	public void setResult20 (String Result20);

	/** Get Result20	  */
	public String getResult20();

    /** Column name Result3 */
    public static final String COLUMNNAME_Result3 = "Result3";

	/** Set Result3	  */
	public void setResult3 (String Result3);

	/** Get Result3	  */
	public String getResult3();

    /** Column name Result4 */
    public static final String COLUMNNAME_Result4 = "Result4";

	/** Set Result4	  */
	public void setResult4 (String Result4);

	/** Get Result4	  */
	public String getResult4();

    /** Column name Result5 */
    public static final String COLUMNNAME_Result5 = "Result5";

	/** Set Result5	  */
	public void setResult5 (String Result5);

	/** Get Result5	  */
	public String getResult5();

    /** Column name Result6 */
    public static final String COLUMNNAME_Result6 = "Result6";

	/** Set Result6	  */
	public void setResult6 (String Result6);

	/** Get Result6	  */
	public String getResult6();

    /** Column name Result7 */
    public static final String COLUMNNAME_Result7 = "Result7";

	/** Set Result7	  */
	public void setResult7 (String Result7);

	/** Get Result7	  */
	public String getResult7();

    /** Column name Result8 */
    public static final String COLUMNNAME_Result8 = "Result8";

	/** Set Result8	  */
	public void setResult8 (String Result8);

	/** Get Result8	  */
	public String getResult8();

    /** Column name Result9 */
    public static final String COLUMNNAME_Result9 = "Result9";

	/** Set Result9	  */
	public void setResult9 (String Result9);

	/** Get Result9	  */
	public String getResult9();

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
