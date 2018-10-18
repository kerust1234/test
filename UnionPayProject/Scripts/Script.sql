--查询Amanet用户账号密码
Select * from db2inst1.zdb001w where d01ada=7584860 with ur;
Select * from db2inst1.zdb001w where D01ENC='Y' fetch first 100 rows ONLY WITH ur;
--忠實顧客健康指標查詢
select * from DB2INST1.LQREBBP where R2IABO = 7533206;
--人员主户籍信息
select * from DB2INST1.DSTMST fetch first 100 row only;