-- Jan 2, 2009 2:17:31 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Column (AD_Client_ID,AD_Column_ID,AD_Element_ID,AD_Org_ID,AD_Reference_ID,AD_Table_ID,ColumnName,Created,CreatedBy,Description,EntityType,FieldLength,Help,IsActive,IsAllowLogging,IsAlwaysUpdateable,IsAutocomplete,IsEncrypted,IsIdentifier,IsKey,IsMandatory,IsParent,IsSelectionColumn,IsSyncDatabase,IsTranslated,IsUpdateable,Name,SeqNo,Updated,UpdatedBy,Version) VALUES (0,56573,290,0,30,53035,'DocumentNo',TO_TIMESTAMP('2009-01-02 02:17:28','YYYY-MM-DD HH24:MI:SS'),0,'Document sequence number of the document','EE01',30,'The document number is usually automatically generated by the system and determined by the document type of the document. If the document is not saved, the preliminary number is displayed in "<>".

If the document type of your document has no automatic document sequence defined, the field is empty if you create a new document. This is for documents which usually have an external number (like vendor invoice).  If you leave the field empty, the system will generate a document number for you. The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).','Y','Y','N','N','N','N','N','N','N','N','N','N','Y','Document No',0,TO_TIMESTAMP('2009-01-02 02:17:28','YYYY-MM-DD HH24:MI:SS'),0,1.000000000000)
;

-- Jan 2, 2009 2:17:31 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Column_Trl (AD_Language,AD_Column_ID, Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Column_ID, t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Column t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Column_ID=56573 AND EXISTS (SELECT * FROM AD_Column_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Column_ID!=t.AD_Column_ID)
;

-- Jan 2, 2009 2:17:37 AM ECT
-- Accounting Manufacturing Management
ALTER TABLE PP_Cost_Collector ADD COLUMN DocumentNo VARCHAR(30)
;

-- Jan 2, 2009 2:17:48 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Column SET IsMandatory='Y',Updated=TO_TIMESTAMP('2009-01-02 02:17:48','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Column_ID=56573
;

-- Jan 2, 2009 2:18:17 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,56573,56556,0,53053,TO_TIMESTAMP('2009-01-02 02:18:11','YYYY-MM-DD HH24:MI:SS'),0,'Document sequence number of the document',30,'EE01','The document number is usually automatically generated by the system and determined by the document type of the document. If the document is not saved, the preliminary number is displayed in "<>".

If the document type of your document has no automatic document sequence defined, the field is empty if you create a new document. This is for documents which usually have an external number (like vendor invoice).  If you leave the field empty, the system will generate a document number for you. The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).','Y','Y','Y','N','N','N','N','N','Document No',TO_TIMESTAMP('2009-01-02 02:18:11','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Jan 2, 2009 2:18:17 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=56556 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- Jan 2, 2009 2:18:19 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,53819,56557,0,53053,TO_TIMESTAMP('2009-01-02 02:18:17','YYYY-MM-DD HH24:MI:SS'),0,22,'EE01','Y','Y','Y','N','N','N','N','N','Duration Real',TO_TIMESTAMP('2009-01-02 02:18:17','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Jan 2, 2009 2:18:19 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=56557 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- Jan 2, 2009 2:18:23 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,53821,56558,0,53053,TO_TIMESTAMP('2009-01-02 02:18:19','YYYY-MM-DD HH24:MI:SS'),0,1,'EE01','Y','Y','Y','N','N','N','N','N','Is BatchTime',TO_TIMESTAMP('2009-01-02 02:18:19','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Jan 2, 2009 2:18:23 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=56558 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- Jan 2, 2009 2:18:25 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,56531,56559,0,53053,TO_TIMESTAMP('2009-01-02 02:18:23','YYYY-MM-DD HH24:MI:SS'),0,1,'EE01','Y','Y','Y','N','N','N','N','N','Is Subcontracting',TO_TIMESTAMP('2009-01-02 02:18:23','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Jan 2, 2009 2:18:25 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=56559 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- Jan 2, 2009 2:18:28 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,53831,56560,0,53053,TO_TIMESTAMP('2009-01-02 02:18:25','YYYY-MM-DD HH24:MI:SS'),0,10,'EE01','Y','Y','Y','N','N','N','N','N','Manufacturing Order Activity',TO_TIMESTAMP('2009-01-02 02:18:25','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Jan 2, 2009 2:18:28 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=56560 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- Jan 2, 2009 2:18:29 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,53832,56561,0,53053,TO_TIMESTAMP('2009-01-02 02:18:28','YYYY-MM-DD HH24:MI:SS'),0,10,'EE01','Y','Y','Y','N','N','N','N','N','Manufacturing Order Workflow',TO_TIMESTAMP('2009-01-02 02:18:28','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Jan 2, 2009 2:18:29 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=56561 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- Jan 2, 2009 2:18:32 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,53836,56562,0,53053,TO_TIMESTAMP('2009-01-02 02:18:29','YYYY-MM-DD HH24:MI:SS'),0,22,'EE01','Y','Y','Y','N','N','N','N','N','Qty Reject',TO_TIMESTAMP('2009-01-02 02:18:29','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Jan 2, 2009 2:18:32 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=56562 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- Jan 2, 2009 2:18:36 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,55311,56563,0,53053,TO_TIMESTAMP('2009-01-02 02:18:32','YYYY-MM-DD HH24:MI:SS'),0,'ID of document reversal',22,'EE01','Y','Y','Y','N','N','N','N','N','Reversal ID',TO_TIMESTAMP('2009-01-02 02:18:32','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Jan 2, 2009 2:18:36 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=56563 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- Jan 2, 2009 2:18:39 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,DisplayLength,EntityType,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,53839,56564,0,53053,TO_TIMESTAMP('2009-01-02 02:18:36','YYYY-MM-DD HH24:MI:SS'),0,22,'EE01','Y','Y','Y','N','N','N','N','N','Setup Time Real',TO_TIMESTAMP('2009-01-02 02:18:36','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Jan 2, 2009 2:18:39 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=56564 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- Jan 2, 2009 2:18:44 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,53812,56565,0,53053,TO_TIMESTAMP('2009-01-02 02:18:39','YYYY-MM-DD HH24:MI:SS'),0,'Unit of Measure',10,'EE01','The UOM defines a unique non monetary Unit of Measure','Y','Y','Y','N','N','N','N','N','UOM',TO_TIMESTAMP('2009-01-02 02:18:39','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Jan 2, 2009 2:18:44 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=56565 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- Jan 2, 2009 2:18:50 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,53806,56566,0,53053,TO_TIMESTAMP('2009-01-02 02:18:44','YYYY-MM-DD HH24:MI:SS'),0,'User within the system - Internal or Business Partner Contact',10,'EE01','The User identifies a unique user in the system. This could be an internal user or a business partner contact','Y','Y','Y','N','N','N','N','N','User/Contact',TO_TIMESTAMP('2009-01-02 02:18:44','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Jan 2, 2009 2:18:50 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=56566 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=0,IsDisplayed='N' WHERE AD_Field_ID=56557
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=0,IsDisplayed='N' WHERE AD_Field_ID=56558
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=0,IsDisplayed='N' WHERE AD_Field_ID=56559
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=0,IsDisplayed='N' WHERE AD_Field_ID=56560
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=0,IsDisplayed='N' WHERE AD_Field_ID=56561
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=0,IsDisplayed='N' WHERE AD_Field_ID=56562
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=0,IsDisplayed='N' WHERE AD_Field_ID=56563
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=0,IsDisplayed='N' WHERE AD_Field_ID=56564
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=0,IsDisplayed='N' WHERE AD_Field_ID=56565
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=0,IsDisplayed='N' WHERE AD_Field_ID=56566
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=50,IsDisplayed='Y' WHERE AD_Field_ID=56556
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=60,IsDisplayed='Y' WHERE AD_Field_ID=54088
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=70,IsDisplayed='Y' WHERE AD_Field_ID=54089
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=80,IsDisplayed='Y' WHERE AD_Field_ID=54090
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=90,IsDisplayed='Y' WHERE AD_Field_ID=54091
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=100,IsDisplayed='Y' WHERE AD_Field_ID=54092
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=110,IsDisplayed='Y' WHERE AD_Field_ID=54093
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=120,IsDisplayed='Y' WHERE AD_Field_ID=54094
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=130,IsDisplayed='Y' WHERE AD_Field_ID=54095
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=140,IsDisplayed='Y' WHERE AD_Field_ID=54096
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=150,IsDisplayed='Y' WHERE AD_Field_ID=54097
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=160,IsDisplayed='Y' WHERE AD_Field_ID=54098
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=170,IsDisplayed='Y' WHERE AD_Field_ID=54099
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=180,IsDisplayed='Y' WHERE AD_Field_ID=54100
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=190,IsDisplayed='Y' WHERE AD_Field_ID=54101
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=200,IsDisplayed='Y' WHERE AD_Field_ID=54102
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=210,IsDisplayed='Y' WHERE AD_Field_ID=54103
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=220,IsDisplayed='Y' WHERE AD_Field_ID=54104
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=230,IsDisplayed='Y' WHERE AD_Field_ID=54105
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=240,IsDisplayed='Y' WHERE AD_Field_ID=54082
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=250,IsDisplayed='Y' WHERE AD_Field_ID=54106
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=260,IsDisplayed='Y' WHERE AD_Field_ID=54107
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=270,IsDisplayed='Y' WHERE AD_Field_ID=54108
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=280,IsDisplayed='Y' WHERE AD_Field_ID=54109
;

-- Jan 2, 2009 2:19:57 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=290,IsDisplayed='Y' WHERE AD_Field_ID=54110
;

-- Jan 2, 2009 2:20:14 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET IsSameLine='Y',Updated=TO_TIMESTAMP('2009-01-02 02:20:14','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Field_ID=54088
;

-- Jan 2, 2009 2:20:32 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field (AD_Client_ID,AD_Column_ID,AD_Field_ID,AD_Org_ID,AD_Tab_ID,Created,CreatedBy,Description,DisplayLength,EntityType,Help,IsActive,IsCentrallyMaintained,IsDisplayed,IsEncrypted,IsFieldOnly,IsHeading,IsReadOnly,IsSameLine,Name,Updated,UpdatedBy) VALUES (0,56573,56567,0,53049,TO_TIMESTAMP('2009-01-02 02:20:29','YYYY-MM-DD HH24:MI:SS'),0,'Document sequence number of the document',30,'EE01','The document number is usually automatically generated by the system and determined by the document type of the document. If the document is not saved, the preliminary number is displayed in "<>".

If the document type of your document has no automatic document sequence defined, the field is empty if you create a new document. This is for documents which usually have an external number (like vendor invoice).  If you leave the field empty, the system will generate a document number for you. The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).','Y','Y','Y','N','N','N','N','N','Document No',TO_TIMESTAMP('2009-01-02 02:20:29','YYYY-MM-DD HH24:MI:SS'),0)
;

-- Jan 2, 2009 2:20:32 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Field_Trl (AD_Language,AD_Field_ID, Description,Help,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Field_ID, t.Description,t.Help,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Field t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Field_ID=56567 AND EXISTS (SELECT * FROM AD_Field_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Field_ID!=t.AD_Field_ID)
;

-- Jan 2, 2009 2:21:00 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=50,IsDisplayed='Y' WHERE AD_Field_ID=56567
;

-- Jan 2, 2009 2:21:00 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=60,IsDisplayed='Y' WHERE AD_Field_ID=53981
;

-- Jan 2, 2009 2:21:00 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=70,IsDisplayed='Y' WHERE AD_Field_ID=53982
;

-- Jan 2, 2009 2:21:00 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=80,IsDisplayed='Y' WHERE AD_Field_ID=53983
;

-- Jan 2, 2009 2:21:00 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=90,IsDisplayed='Y' WHERE AD_Field_ID=53984
;

-- Jan 2, 2009 2:21:00 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=100,IsDisplayed='Y' WHERE AD_Field_ID=53985
;

-- Jan 2, 2009 2:21:00 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=110,IsDisplayed='Y' WHERE AD_Field_ID=53987
;

-- Jan 2, 2009 2:21:00 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=120,IsDisplayed='Y' WHERE AD_Field_ID=53988
;

-- Jan 2, 2009 2:21:00 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=130,IsDisplayed='Y' WHERE AD_Field_ID=53989
;

-- Jan 2, 2009 2:21:00 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=140,IsDisplayed='Y' WHERE AD_Field_ID=53990
;

-- Jan 2, 2009 2:21:00 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=150,IsDisplayed='Y' WHERE AD_Field_ID=53991
;

-- Jan 2, 2009 2:21:00 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=160,IsDisplayed='Y' WHERE AD_Field_ID=56514
;

-- Jan 2, 2009 2:21:17 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET IsSameLine='Y',Updated=TO_TIMESTAMP('2009-01-02 02:21:17','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Field_ID=53979
;

-- Jan 2, 2009 2:21:31 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=40,IsDisplayed='Y' WHERE AD_Field_ID=56567
;

-- Jan 2, 2009 2:21:31 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET SeqNo=50,IsDisplayed='Y' WHERE AD_Field_ID=53979
;

-- Jan 2, 2009 2:22:41 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET IsReadOnly='Y',Updated=TO_TIMESTAMP('2009-01-02 02:22:41','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Field_ID=56266
;

-- Jan 2, 2009 2:23:27 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Process_Para SET IsMandatory='Y',Updated=TO_TIMESTAMP('2009-01-02 02:23:27','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Process_Para_ID=53090
;

-- Jan 2, 2009 2:23:54 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Process_Para SET IsMandatory='Y',Updated=TO_TIMESTAMP('2009-01-02 02:23:54','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Process_Para_ID=53104
;

-- Jan 2, 2009 2:24:10 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Process_Para SET IsMandatory='Y',Updated=TO_TIMESTAMP('2009-01-02 02:24:10','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Process_Para_ID=53106
;

-- Jan 2, 2009 2:25:47 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Process_Para SET IsMandatory='Y',Updated=TO_TIMESTAMP('2009-01-02 02:25:47','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Process_Para_ID=53093
;

-- Jan 2, 2009 2:26:16 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Process_Para SET IsMandatory='Y',Updated=TO_TIMESTAMP('2009-01-02 02:26:16','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Process_Para_ID=53110
;

-- Jan 2, 2009 2:26:19 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Process_Para SET IsMandatory='Y',Updated=TO_TIMESTAMP('2009-01-02 02:26:19','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Process_Para_ID=53109
;

-- Jan 2, 2009 2:30:00 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Ref_List SET Name='Activity Control',Updated=TO_TIMESTAMP('2009-01-02 02:30:00','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Ref_List_ID=53448
;

-- Jan 2, 2009 2:30:00 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Ref_List_Trl SET IsTranslated='N' WHERE AD_Ref_List_ID=53448
;

-- Jan 2, 2009 2:31:25 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Ref_List (AD_Client_ID,AD_Org_ID,AD_Ref_List_ID,AD_Reference_ID,Created,CreatedBy,Description,EntityType,IsActive,Name,Updated,UpdatedBy,Value) VALUES (0,0,53449,53226,TO_TIMESTAMP('2009-01-02 02:31:23','YYYY-MM-DD HH24:MI:SS'),0,'Components issue in Floor Stock','EE01','Y','Floor Stock',TO_TIMESTAMP('2009-01-02 02:31:23','YYYY-MM-DD HH24:MI:SS'),0,'2')
;

-- Jan 2, 2009 2:31:25 AM ECT
-- Accounting Manufacturing Management
INSERT INTO AD_Ref_List_Trl (AD_Language,AD_Ref_List_ID, Description,Name, IsTranslated,AD_Client_ID,AD_Org_ID,Created,Createdby,Updated,UpdatedBy) SELECT l.AD_Language,t.AD_Ref_List_ID, t.Description,t.Name, 'N',t.AD_Client_ID,t.AD_Org_ID,t.Created,t.Createdby,t.Updated,t.UpdatedBy FROM AD_Language l, AD_Ref_List t WHERE l.IsActive='Y' AND l.IsSystemLanguage='Y' AND l.IsBaseLanguage='N' AND t.AD_Ref_List_ID=53449 AND EXISTS (SELECT * FROM AD_Ref_List_Trl tt WHERE tt.AD_Language!=l.AD_Language OR tt.AD_Ref_List_ID!=t.AD_Ref_List_ID)
;

-- Jan 2, 2009 2:31:53 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Ref_List SET Description='Components issue in Backflush', Name='Backflush',Updated=TO_TIMESTAMP('2009-01-02 02:31:53','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Ref_List_ID=53266
;

-- Jan 2, 2009 2:31:53 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Ref_List_Trl SET IsTranslated='N' WHERE AD_Ref_List_ID=53266
;

-- Jan 2, 2009 2:32:21 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Ref_List SET Description='Components issue manuality',Updated=TO_TIMESTAMP('2009-01-02 02:32:21','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Ref_List_ID=53265
;

-- Jan 2, 2009 2:32:21 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Ref_List_Trl SET IsTranslated='N' WHERE AD_Ref_List_ID=53265
;

-- Jan 2, 2009 2:33:52 AM ECT
-- Accounting Manufacturing Management
DELETE FROM AD_Field_Trl WHERE AD_Field_ID=53527
;

-- Jan 2, 2009 2:33:52 AM ECT
-- Accounting Manufacturing Management
DELETE FROM AD_Field WHERE AD_Field_ID=53527
;

-- Jan 2, 2009 2:33:56 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET IsSameLine='N',Updated=TO_TIMESTAMP('2009-01-02 02:33:56','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Field_ID=53528
;

-- Jan 2, 2009 2:34:24 AM ECT
-- Accounting Manufacturing Management
DELETE FROM AD_Column_Trl WHERE AD_Column_ID=53384
;

-- Jan 2, 2009 2:34:24 AM ECT
-- Accounting Manufacturing Management
DELETE FROM AD_Column WHERE AD_Column_ID=53384
;

-- Jan 2, 2009 2:34:33 AM ECT
-- Accounting Manufacturing Management
DELETE FROM AD_Element_Trl WHERE AD_Element_ID=53260
;

-- Jan 2, 2009 2:34:33 AM ECT
-- Accounting Manufacturing Management
DELETE FROM AD_Element WHERE AD_Element_ID=53260
;

-- Jan 2, 2009 2:35:58 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Field SET DisplayLogic=NULL,Updated=TO_TIMESTAMP('2009-01-02 02:35:58','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Field_ID=11288
;

-- Jan 2, 2009 2:36:56 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Process SET Help='This Process allow integrate Labor and Overhead Cost to a Manufacturing Workflow 

Labor Cost Operation = (Setup Time / Qty Batch Size) * Duration * Labor Rate to this Resource 
Overhead Cost Operation =  (Setup Time / Qty Batch Size) * Duration * Overhead Rate to this Resource 

Labor Cost Workflow = Sum of every the Labor Cost Operation
Overhead Cost Workflow = Sum of every the Overhead Cost Operation

Cost Workflow = Labor Cost Workflow + Overhead Cost Workflow
',Updated=TO_TIMESTAMP('2009-01-02 02:36:56','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Process_ID=53058
;

-- Jan 2, 2009 2:36:56 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Process_Trl SET IsTranslated='N' WHERE AD_Process_ID=53058
;

-- Jan 2, 2009 2:37:12 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Process_Trl SET Help='This Process allow integrate Labor and Overhead Cost to a Manufacturing Workflow 

Labor Cost Operation = ( Setup Time / Qty Batch Size) * Duration * Labor Rate to this Resource 
Overhead Cost Operation =  (Setup Time / Qty Batch Size) * Duration * Overhead Rate to this Resource 

Labor Cost Workflow = Sum of every the Labor Cost Operation
Overhead Cost Workflow = Sum of every the Overhead Cost Operation

Cost Workflow = Labor Cost Workflow + Overhead Cost Workflow
',Updated=TO_TIMESTAMP('2009-01-02 02:37:12','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Process_ID=53058 AND AD_Language='es_MX'
;

-- Jan 2, 2009 2:38:16 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Column SET AD_Reference_ID=37,Updated=TO_TIMESTAMP('2009-01-02 02:38:16','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Column_ID=10542
;

-- Jan 2, 2009 2:38:20 AM ECT
-- Accounting Manufacturing Management
insert into t_alter_column values('ad_workflow','Cost','NUMERIC',null,'NULL')
;

-- Jan 2, 2009 2:47:41 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Column SET AD_Reference_ID=37, IsMandatory='N',Updated=TO_TIMESTAMP('2009-01-02 02:47:41','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Column_ID=53694
;

-- Jan 2, 2009 2:47:44 AM ECT
-- Accounting Manufacturing Management
insert into t_alter_column values('pp_order_workflow','Cost','NUMERIC',null,'NULL')
;

-- Jan 2, 2009 2:47:45 AM ECT
-- Accounting Manufacturing Management
insert into t_alter_column values('pp_order_workflow','Cost',null,'NULL',null)
;

-- Jan 2, 2009 2:47:50 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Column SET IsMandatory='Y',Updated=TO_TIMESTAMP('2009-01-02 02:47:50','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Column_ID=53694
;

-- Jan 2, 2009 2:51:16 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Column SET AD_Reference_ID=10,Updated=TO_TIMESTAMP('2009-01-02 02:51:16','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Column_ID=56573
;

-- Jan 2, 2009 2:51:19 AM ECT
-- Accounting Manufacturing Management
insert into t_alter_column values('pp_cost_collector','DocumentNo','VARCHAR(30)',null,'NULL')
;

-- Jan 2, 2009 2:51:20 AM ECT
-- Accounting Manufacturing Management
insert into t_alter_column values('pp_cost_collector','DocumentNo',null,'NOT NULL',null)
;

-- Jan 2, 2009 2:51:27 AM ECT
-- Accounting Manufacturing Management
UPDATE AD_Column SET IsMandatory='N',Updated=TO_TIMESTAMP('2009-01-02 02:51:27','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=0 WHERE AD_Column_ID=56573
;


