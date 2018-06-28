<%--
 *  Product: Posterita Web-Based POS and Adempiere Plugin
 *  Copyright (C) 2007  Posterita Ltd
 *  This file is part of POSterita
 *  
 *  POSterita is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc.,
 *  51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * @author Ashley
--%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ page import="org.posterita.Constants" %>
<%@ page import="org.posterita.user.*" %>
<%@ page import="org.posterita.beans.*" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>	
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>	
<%@ taglib uri="/WEB-INF/pos.tld" prefix="pos"%>


<logic:notPresent name="<%=WebUserInfo.NAME%>" scope="session">
	<jsp:forward page="/POSLogin.do"/>
</logic:notPresent>

<bean:define id="title"><pos:message textOnly="true" key="attribute"/></bean:define>
<%@ include file="/jsp/include/posHeader.jsp" %>
<%@ include file="/jsp/include/errors.jsp" %>

	<table class="view" width="400px">		
		<tr>
			<td>
				<html:form action="/EditPOSAttributeValueAction">
				<html:hidden property="action" value="editAttributeValue"/>
				<html:hidden property="attributeId"/>	
				<html:hidden property="attributeValueId"/>
					<table>
						<tr>
							<td><label><pos:message key="old.attribute.value"/>:</label></td>
							<td><html:text property="name" readonly="true" styleClass="text"></html:text>
						</tr>
						<tr>
							<td><label><pos:message key="new.attribute.value"/>:</label></td>
							<td><html:text property="newName" styleClass="text"></html:text>
						</tr>
						<tr>
							<td colspan="2" align="right">
								<html:submit styleClass="save smallbutton">&nbsp;</html:submit>
							</td>
						</tr>
					</table>
				</html:form>
			</td>
		</tr>
	</table>
<%@ include file="/jsp/include/posFooter.jsp" %>