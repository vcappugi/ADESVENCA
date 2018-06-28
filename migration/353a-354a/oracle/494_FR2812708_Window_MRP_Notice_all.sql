-- 26.06.2009 14:52:44 EEST
-- -
INSERT INTO AD_Window (IsActive,Created,AD_Client_ID,Help,UpdatedBy,AD_Org_ID,AD_Window_ID,Name,WindowType,Description,CreatedBy,Updated,IsSOTrx,AD_Image_ID,EntityType,Processing,IsDefault,IsBetaFunctionality) VALUES ('Y',TO_DATE('2009-06-26 14:52:36','YYYY-MM-DD HH24:MI:SS'),0,'The system creates notices will running MRP process. In this window you can view them.
',0,0,53085,'MRP Notice (all)','T','View all MRP Notices',0,TO_DATE('2009-06-26 14:52:36','YYYY-MM-DD HH24:MI:SS'),'Y',107,'EE01','N','N','N')
;

-- 26.06.2009 14:52:45 EEST
-- -
INSERT INTO AD_Window_Trl (AD_Language,AD_Window_ID, Help,Name,Description, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Window_ID, t.Help,t.Name,t.Description, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Window t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Window_ID=53085 AND EXISTS (SELECT * FROM AD_Window_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Window_ID!=t.AD_Window_ID)
;

-- 26.06.2009 14:54:29 EEST
-- -
UPDATE AD_Window_Trl SET IsTranslated='Y',Name='Notificare MRP (all)',Description='Vizualizarea tuturor notific�rilor MRP f�cute de sistem',Help='Este un grup de mesaje generate �n timpul proces�rii MRP-ului. Acestea indic� planificatorului ac�iunile necesare pentru a ajunge la MPS. Mesajele (ac�iunile) sunt transmise planificatorului ca Note c�nd intr� �ntr-o sesiune de lucru �n ADempiere.
',Updated=TO_DATE('2009-06-26 14:54:29','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Window_ID=53085 AND AD_Language='ro_RO'
;

-- 26.06.2009 14:57:04 EEST
-- -
INSERT INTO AD_Tab (SeqNo,IsSingleRow,HasTree,AD_Table_ID,WhereClause,AD_Tab_ID,Description,Help,AD_Window_ID,AD_Client_ID,AD_Org_ID,Created,CreatedBy,Updated,IsActive,IsTranslationTab,Name,IsReadOnly,IsInfoTab,IsSortTab,UpdatedBy,EntityType,ImportFields,Processing,TabLevel,IsInsertRecord,IsAdvancedTab) VALUES (10,'Y','N',389,'EXISTS (SELECT 1 FROM AD_Message m WHERE m.AD_Message_ID=AD_Note.AD_Message_ID AND m.Value like ''MRP-%'')',53237,'MRP Notice','The Notice Tab provides a method of viewing messages that are generated by MRP process.',53085,0,0,TO_DATE('2009-06-26 14:57:03','YYYY-MM-DD HH24:MI:SS'),0,TO_DATE('2009-06-26 14:57:03','YYYY-MM-DD HH24:MI:SS'),'Y','N','Notice','N','N','N',0,'EE01','N','N',0,'N','N')
;

-- 26.06.2009 14:57:04 EEST
-- -
INSERT INTO AD_Tab_Trl (AD_Language,AD_Tab_ID, Description,Help,CommitWarning,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Tab_ID, t.Description,t.Help,t.CommitWarning,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Tab t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Tab_ID=53237 AND EXISTS (SELECT * FROM AD_Tab_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Tab_ID!=t.AD_Tab_ID)
;

-- 26.06.2009 14:57:16 EEST
-- -
UPDATE AD_Tab_Trl SET Name='Notificare',Description='Notificare MRP',Help=NULL,Updated=TO_DATE('2009-06-26 14:57:16','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Tab_ID=53237 AND AD_Language='ro_RO'
;

-- 26.06.2009 14:57:36 EEST
-- -
INSERT INTO AD_Field (SortNo,IsFieldOnly,DisplayLength,SeqNo,AD_Field_ID,IsEncrypted,Name,AD_Tab_ID,AD_Column_ID,IsDisplayed,UpdatedBy,IsActive,Created,IsSameLine,IsHeading,CreatedBy,AD_Client_ID,Updated,Description,AD_Org_ID,IsReadOnly,IsCentrallyMaintained,EntityType) VALUES (1,'N',14,10,57318,'N','Notice',53237,4825,'N',0,'Y',TO_DATE('2009-06-26 14:57:35','YYYY-MM-DD HH24:MI:SS'),'N','N',0,0,TO_DATE('2009-06-26 14:57:35','YYYY-MM-DD HH24:MI:SS'),'System Notice',0,'Y','Y','EE01')
;

-- 26.06.2009 14:57:36 EEST
-- -
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Help,Name,Description, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Help,t.Name,t.Description, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=57318 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- 26.06.2009 14:57:37 EEST
-- -
INSERT INTO AD_Field (SortNo,IsFieldOnly,DisplayLength,SeqNo,AD_Field_ID,Help,IsEncrypted,Name,AD_Tab_ID,AD_Column_ID,IsDisplayed,UpdatedBy,IsActive,Created,IsSameLine,IsHeading,CreatedBy,AD_Client_ID,Updated,Description,AD_Org_ID,IsReadOnly,IsCentrallyMaintained,EntityType) VALUES (0,'N',1,20,57319,'There are two methods of making records unavailable in the system: One is to delete the record, the other is to de-activate the record. A de-activated record is not available for selection, but available for reports. 
There are two reasons for de-activating and not deleting records: 
(1) The system requires the record for audit purposes. 
(2) The record is referenced by other records. E.g., you cannot delete a Business Partner, if there are invoices for this partner record existing. You de-activate the Business Partner and prevent that this record is used for future entries.','N','Active',53237,4828,'N',0,'Y',TO_DATE('2009-06-26 14:57:36','YYYY-MM-DD HH24:MI:SS'),'N','N',0,0,TO_DATE('2009-06-26 14:57:36','YYYY-MM-DD HH24:MI:SS'),'The record is active in the system',0,'N','Y','EE01')
;

-- 26.06.2009 14:57:37 EEST
-- -
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Help,Name,Description, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Help,t.Name,t.Description, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=57319 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- 26.06.2009 14:57:38 EEST
-- -
INSERT INTO AD_Field (SortNo,IsFieldOnly,DisplayLength,SeqNo,AD_Field_ID,Help,IsEncrypted,Name,AD_Tab_ID,AD_Column_ID,IsDisplayed,UpdatedBy,IsActive,Created,IsSameLine,IsHeading,CreatedBy,AD_Client_ID,Updated,Description,AD_Org_ID,IsReadOnly,IsCentrallyMaintained,EntityType) VALUES (0,'N',14,30,57320,'A Client is a company or a legal entity. You cannot share data between Clients. Tenant is a synonym for Client.','N','Client',53237,4826,'Y',0,'Y',TO_DATE('2009-06-26 14:57:37','YYYY-MM-DD HH24:MI:SS'),'N','N',0,0,TO_DATE('2009-06-26 14:57:37','YYYY-MM-DD HH24:MI:SS'),'Client/Tenant for this installation.',0,'Y','Y','EE01')
;

-- 26.06.2009 14:57:38 EEST
-- -
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Help,Name,Description, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Help,t.Name,t.Description, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=57320 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- 26.06.2009 14:57:39 EEST
-- -
INSERT INTO AD_Field (SortNo,IsFieldOnly,DisplayLength,SeqNo,AD_Field_ID,Help,IsEncrypted,Name,AD_Tab_ID,AD_Column_ID,IsDisplayed,UpdatedBy,IsActive,Created,IsSameLine,IsHeading,CreatedBy,AD_Client_ID,Updated,Description,AD_Org_ID,IsReadOnly,IsCentrallyMaintained,EntityType) VALUES (0,'N',14,40,57321,'An organization is a unit of your client or legal entity - examples are store, department. You can share data between organizations.','N','Organization',53237,4827,'Y',0,'Y',TO_DATE('2009-06-26 14:57:38','YYYY-MM-DD HH24:MI:SS'),'Y','N',0,0,TO_DATE('2009-06-26 14:57:38','YYYY-MM-DD HH24:MI:SS'),'Organizational entity within client',0,'Y','Y','EE01')
;

-- 26.06.2009 14:57:39 EEST
-- -
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Help,Name,Description, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Help,t.Name,t.Description, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=57321 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- 26.06.2009 14:57:40 EEST
-- -
INSERT INTO AD_Field (SortNo,IsFieldOnly,DisplayLength,SeqNo,AD_Field_ID,Help,IsEncrypted,Name,AD_Tab_ID,AD_Column_ID,IsDisplayed,UpdatedBy,IsActive,Created,IsSameLine,IsHeading,CreatedBy,AD_Client_ID,Updated,Description,AD_Org_ID,IsReadOnly,IsCentrallyMaintained,EntityType) VALUES (0,'N',14,50,57322,'Information and Error messages','N','Message',53237,6768,'Y',0,'Y',TO_DATE('2009-06-26 14:57:39','YYYY-MM-DD HH24:MI:SS'),'N','N',0,0,TO_DATE('2009-06-26 14:57:39','YYYY-MM-DD HH24:MI:SS'),'System Message',0,'Y','Y','EE01')
;

-- 26.06.2009 14:57:40 EEST
-- -
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Help,Name,Description, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Help,t.Name,t.Description, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=57322 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- 26.06.2009 14:57:40 EEST
-- -
INSERT INTO AD_Field (SortNo,IsFieldOnly,DisplayLength,SeqNo,AD_Field_ID,Help,IsEncrypted,Name,AD_Tab_ID,AD_Column_ID,IsDisplayed,UpdatedBy,IsActive,Created,IsSameLine,IsHeading,CreatedBy,AD_Client_ID,Updated,Description,AD_Org_ID,IsReadOnly,IsCentrallyMaintained,EntityType) VALUES (-1,'N',20,60,57323,'The Created field indicates the date that this record was created.','N','Created',53237,4829,'Y',0,'Y',TO_DATE('2009-06-26 14:57:40','YYYY-MM-DD HH24:MI:SS'),'Y','N',0,0,TO_DATE('2009-06-26 14:57:40','YYYY-MM-DD HH24:MI:SS'),'Date this record was created',0,'Y','Y','EE01')
;

-- 26.06.2009 14:57:40 EEST
-- -
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Help,Name,Description, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Help,t.Name,t.Description, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=57323 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- 26.06.2009 14:57:41 EEST
-- -
INSERT INTO AD_Field (SortNo,IsFieldOnly,DisplayLength,SeqNo,AD_Field_ID,Help,IsEncrypted,Name,AD_Tab_ID,AD_Column_ID,IsDisplayed,UpdatedBy,IsActive,Created,IsSameLine,IsHeading,CreatedBy,AD_Client_ID,Updated,Description,AD_Org_ID,IsReadOnly,IsCentrallyMaintained,EntityType) VALUES (0,'N',14,70,57324,'The User identifies a unique user in the system. This could be an internal user or a business partner contact','N','User/Contact',53237,5946,'Y',0,'Y',TO_DATE('2009-06-26 14:57:40','YYYY-MM-DD HH24:MI:SS'),'N','N',0,0,TO_DATE('2009-06-26 14:57:40','YYYY-MM-DD HH24:MI:SS'),'User within the system - Internal or Business Partner Contact',0,'Y','Y','EE01')
;

-- 26.06.2009 14:57:41 EEST
-- -
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Help,Name,Description, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Help,t.Name,t.Description, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=57324 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- 26.06.2009 14:57:42 EEST
-- -
INSERT INTO AD_Field (SortNo,IsFieldOnly,DisplayLength,SeqNo,AD_Field_ID,Help,IsEncrypted,Name,AD_Tab_ID,AD_Column_ID,IsDisplayed,UpdatedBy,IsActive,Created,IsSameLine,IsHeading,CreatedBy,AD_Client_ID,Updated,Description,AD_Org_ID,IsReadOnly,IsCentrallyMaintained,EntityType) VALUES (0,'N',14,80,57325,'The Workflow Activity is the actual Workflow Node in a Workflow Process instance','N','Workflow Activity',53237,10807,'Y',0,'Y',TO_DATE('2009-06-26 14:57:41','YYYY-MM-DD HH24:MI:SS'),'N','N',0,0,TO_DATE('2009-06-26 14:57:41','YYYY-MM-DD HH24:MI:SS'),'Workflow Activity',0,'Y','Y','EE01')
;

-- 26.06.2009 14:57:42 EEST
-- -
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Help,Name,Description, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Help,t.Name,t.Description, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=57325 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- 26.06.2009 14:57:43 EEST
-- -
INSERT INTO AD_Field (SortNo,IsFieldOnly,DisplayLength,SeqNo,AD_Field_ID,Help,IsEncrypted,Name,AD_Tab_ID,AD_Column_ID,IsDisplayed,UpdatedBy,IsActive,Created,IsSameLine,IsHeading,CreatedBy,AD_Client_ID,Updated,Description,AD_Org_ID,IsReadOnly,IsCentrallyMaintained,EntityType) VALUES (0,'N',14,90,57326,'The Database Table provides the information of the table definition','N','Table',53237,5957,'Y',0,'Y',TO_DATE('2009-06-26 14:57:42','YYYY-MM-DD HH24:MI:SS'),'N','N',0,0,TO_DATE('2009-06-26 14:57:42','YYYY-MM-DD HH24:MI:SS'),'Database Table information',0,'Y','Y','EE01')
;

-- 26.06.2009 14:57:43 EEST
-- -
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Help,Name,Description, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Help,t.Name,t.Description, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=57326 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- 26.06.2009 14:57:43 EEST
-- -
INSERT INTO AD_Field (SortNo,IsFieldOnly,DisplayLength,SeqNo,AD_Field_ID,Help,IsEncrypted,Name,AD_Tab_ID,AD_Column_ID,IsDisplayed,UpdatedBy,IsActive,Created,IsSameLine,IsHeading,CreatedBy,AD_Client_ID,Updated,Description,AD_Org_ID,IsReadOnly,IsCentrallyMaintained,EntityType) VALUES (0,'N',23,100,57327,'The Record ID is the internal unique identifier of a record. Please note that zooming to the record may not be successful for Orders, Invoices and Shipment/Receipts as sometimes the Sales Order type is not known.','N','Record ID',53237,5958,'Y',0,'Y',TO_DATE('2009-06-26 14:57:43','YYYY-MM-DD HH24:MI:SS'),'Y','N',0,0,TO_DATE('2009-06-26 14:57:43','YYYY-MM-DD HH24:MI:SS'),'Direct internal record ID',0,'Y','Y','EE01')
;

-- 26.06.2009 14:57:43 EEST
-- -
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Help,Name,Description, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Help,t.Name,t.Description, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=57327 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- 26.06.2009 14:57:44 EEST
-- -
INSERT INTO AD_Field (SortNo,IsFieldOnly,DisplayLength,SeqNo,AD_Field_ID,Help,IsEncrypted,Name,AD_Tab_ID,AD_Column_ID,IsDisplayed,UpdatedBy,IsActive,Created,IsSameLine,IsHeading,CreatedBy,AD_Client_ID,Updated,Description,AD_Org_ID,IsReadOnly,IsCentrallyMaintained,EntityType) VALUES (0,'N',60,110,57328,'The Reference displays the source document number.','N','Reference',53237,5950,'Y',0,'Y',TO_DATE('2009-06-26 14:57:43','YYYY-MM-DD HH24:MI:SS'),'N','N',0,0,TO_DATE('2009-06-26 14:57:43','YYYY-MM-DD HH24:MI:SS'),'Reference for this record',0,'Y','Y','EE01')
;

-- 26.06.2009 14:57:44 EEST
-- -
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Help,Name,Description, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Help,t.Name,t.Description, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=57328 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- 26.06.2009 14:57:45 EEST
-- -
INSERT INTO AD_Field (SortNo,IsFieldOnly,DisplayLength,SeqNo,AD_Field_ID,IsEncrypted,Name,AD_Tab_ID,AD_Column_ID,IsDisplayed,UpdatedBy,IsActive,Created,IsSameLine,IsHeading,CreatedBy,AD_Client_ID,Updated,Description,AD_Org_ID,IsReadOnly,IsCentrallyMaintained,EntityType) VALUES (0,'N',60,120,57329,'N','Text Message',53237,10806,'Y',0,'Y',TO_DATE('2009-06-26 14:57:44','YYYY-MM-DD HH24:MI:SS'),'N','N',0,0,TO_DATE('2009-06-26 14:57:44','YYYY-MM-DD HH24:MI:SS'),'Text Message',0,'Y','Y','EE01')
;

-- 26.06.2009 14:57:45 EEST
-- -
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Help,Name,Description, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Help,t.Name,t.Description, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=57329 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- 26.06.2009 14:57:46 EEST
-- -
INSERT INTO AD_Field (SortNo,IsFieldOnly,DisplayLength,SeqNo,AD_Field_ID,Help,IsEncrypted,Name,AD_Tab_ID,AD_Column_ID,IsDisplayed,UpdatedBy,IsActive,Created,IsSameLine,IsHeading,CreatedBy,AD_Client_ID,Updated,Description,AD_Org_ID,IsReadOnly,IsCentrallyMaintained,EntityType) VALUES (0,'N',60,130,57330,'A description is limited to 255 characters.','N','Description',53237,10581,'Y',0,'Y',TO_DATE('2009-06-26 14:57:45','YYYY-MM-DD HH24:MI:SS'),'N','N',0,0,TO_DATE('2009-06-26 14:57:45','YYYY-MM-DD HH24:MI:SS'),'Optional short description of the record',0,'N','Y','EE01')
;

-- 26.06.2009 14:57:46 EEST
-- -
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Help,Name,Description, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Help,t.Name,t.Description, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=57330 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- 26.06.2009 14:57:47 EEST
-- -
INSERT INTO AD_Field (SortNo,IsFieldOnly,DisplayLength,SeqNo,AD_Field_ID,Help,IsEncrypted,Name,AD_Tab_ID,AD_Column_ID,IsDisplayed,UpdatedBy,IsActive,Created,IsSameLine,IsHeading,CreatedBy,AD_Client_ID,Updated,Description,AD_Org_ID,IsReadOnly,IsCentrallyMaintained,EntityType) VALUES (0,'N',1,140,57331,'The Acknowledged checkbox indicates if this notice does not need to be retained.','N','Acknowledge',53237,5949,'Y',0,'Y',TO_DATE('2009-06-26 14:57:46','YYYY-MM-DD HH24:MI:SS'),'N','N',0,0,TO_DATE('2009-06-26 14:57:46','YYYY-MM-DD HH24:MI:SS'),'System Notice acknowledged',0,'N','N','EE01')
;

-- 26.06.2009 14:57:47 EEST
-- -
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Help,Name,Description, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Help,t.Name,t.Description, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=57331 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- 26.06.2009 14:57:47 EEST
-- -
INSERT INTO AD_Field (SortNo,IsFieldOnly,DisplayLength,SeqNo,AD_Field_ID,IsEncrypted,Name,AD_Tab_ID,AD_Column_ID,IsDisplayed,UpdatedBy,IsActive,Created,IsSameLine,IsHeading,CreatedBy,AD_Client_ID,Updated,AD_Org_ID,IsReadOnly,IsCentrallyMaintained,EntityType) VALUES (0,'N',23,150,57332,'N','Process Now',53237,9954,'Y',0,'Y',TO_DATE('2009-06-26 14:57:47','YYYY-MM-DD HH24:MI:SS'),'Y','N',0,0,TO_DATE('2009-06-26 14:57:47','YYYY-MM-DD HH24:MI:SS'),0,'N','Y','EE01')
;

-- 26.06.2009 14:57:47 EEST
-- -
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Help,Name,Description, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Help,t.Name,t.Description, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=57332 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- 26.06.2009 14:58:44 EEST
-- -
INSERT INTO AD_Menu (Name,CreatedBy,Updated,UpdatedBy,IsActive,Created,Description,Action,AD_Menu_ID,AD_Window_ID,IsSummary,AD_Client_ID,IsSOTrx,AD_Org_ID,EntityType,IsReadOnly) VALUES ('MRP Notice (all)',0,TO_DATE('2009-06-26 14:58:43','YYYY-MM-DD HH24:MI:SS'),0,'Y',TO_DATE('2009-06-26 14:58:43','YYYY-MM-DD HH24:MI:SS'),'View all MRP Notices','W',53224,53085,'N',0,'N',0,'EE01','N')
;

-- 26.06.2009 14:58:44 EEST
-- -
INSERT INTO AD_Menu_Trl (AD_Language,AD_Menu_ID, Name,Description, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Menu_ID, t.Name,t.Description, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Menu t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Menu_ID=53224 AND EXISTS (SELECT * FROM AD_Menu_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Menu_ID!=t.AD_Menu_ID)
;

-- 26.06.2009 14:58:44 EEST
-- -
INSERT INTO AD_TreeNodeMM (AD_Client_ID,AD_Org_ID, IsActive,Created,CreatedBy,Updated,UpdatedBy, AD_Tree_ID, Node_ID, Parent_ID, SeqNo) SELECT t.AD_Client_ID,0, 'Y', SysDate, 0, SysDate, 0,t.AD_Tree_ID, 53224, 0, 999 FROM AD_Tree t WHERE t.AD_Client_ID=0 AND t.IsActive='Y' AND t.IsAllNodes='Y' AND t.TreeType='MM' AND NOT EXISTS (SELECT * FROM AD_TreeNodeMM e WHERE e.AD_Tree_ID=t.AD_Tree_ID AND Node_ID=53224)
;

-- 26.06.2009 14:58:57 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=0, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=218
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=1, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=153
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=2, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=263
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=3, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=166
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=4, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=203
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=5, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=236
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=6, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=183
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=7, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=160
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=8, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=278
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=9, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=345
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=10, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=1000000
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=11, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53083
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=12, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53014
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=13, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53108
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=14, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=1000089
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=15, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=1500041
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=16, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=518
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=17, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=519
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=18, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=1500016
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=19, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=1500084
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=20, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=1500087
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=21, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=1500098
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=22, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=1500103
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=23, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=1500108
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=24, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=1500121
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=25, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=1500124
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=0, SeqNo=26, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=1500158
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=53034, SeqNo=0, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53035
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=53034, SeqNo=1, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53036
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=53034, SeqNo=2, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53037
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=53034, SeqNo=3, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53038
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=53034, SeqNo=4, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53039
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=53034, SeqNo=5, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53040
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=53034, SeqNo=6, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53041
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=53034, SeqNo=7, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53224
;

-- 26.06.2009 14:58:58 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=53034, SeqNo=8, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53042
;

-- 26.06.2009 14:59:10 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=53034, SeqNo=0, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53035
;

-- 26.06.2009 14:59:10 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=53034, SeqNo=1, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53036
;

-- 26.06.2009 14:59:10 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=53034, SeqNo=2, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53037
;

-- 26.06.2009 14:59:10 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=53034, SeqNo=3, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53038
;

-- 26.06.2009 14:59:10 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=53034, SeqNo=4, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53039
;

-- 26.06.2009 14:59:10 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=53034, SeqNo=5, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53040
;

-- 26.06.2009 14:59:10 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=53034, SeqNo=6, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53224
;

-- 26.06.2009 14:59:10 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=53034, SeqNo=7, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53041
;

-- 26.06.2009 14:59:11 EEST
-- -
UPDATE AD_TreeNodeMM SET Parent_ID=53034, SeqNo=8, Updated=SysDate WHERE AD_Tree_ID=10 AND Node_ID=53042
;

