-- Jul 31, 2008 12:23:46 PM COT
-- [ 2034138 ] HR_Employee.ImageURL wrongly defined
UPDATE AD_Column SET AD_Reference_ID=40, FieldLength=120,Updated=TO_TIMESTAMP('2008-07-31 12:23:46','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Column_ID=54750
;

ALTER TABLE HR_Employee DROP COLUMN ImageURL
;

ALTER TABLE HR_Employee ADD ImageURL VARCHAR(120) DEFAULT  NULL
;