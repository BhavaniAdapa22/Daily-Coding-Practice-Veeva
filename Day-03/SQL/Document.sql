create table documents(id int, name varchar(20), status varchar(20),document_type varchar(20));

INSERT INTO documents VALUES
(1, 'Doc_A', 'Approved', 'Promotional'),
(2, 'Doc_B', 'Pending', 'Legal'),
(3, 'Doc_C', 'Approved', 'Clinical'),
(4, 'Doc_D', 'Rejected', 'Regulatory'),
(5, 'Doc_E', 'Pending', 'Promotional'),
(6, 'Doc_F', 'Approved', 'Legal'),
(7, 'Doc_G', 'Rejected', 'Financial'),
(8, 'Doc_H', 'Pending', 'Clinical'),
(9, 'Doc_I', 'Approved', 'Promotional'),
(10, 'Doc_J', 'Rejected', 'Legal'),
(11, 'Doc_K', 'Approved', 'Regulatory'),
(12, 'Doc_L', 'Pending', 'Financial'),
(13, 'Doc_M', 'Approved', 'Clinical'),
(14, 'Doc_N', 'Rejected', 'Promotional'),
(15, 'Doc_O', 'Pending', 'Legal'),
(16, 'Doc_P', 'Approved', 'Promotional'),
(17, 'Doc_Q', 'Rejected', 'Clinical'),
(18, 'Doc_R', 'Pending', 'Regulatory'),
(19, 'Doc_S', 'Approved', 'Legal'),
(20, 'Doc_T', 'Rejected', 'Financial'); 

select * from documents where status in  ('Approved') and document_type in ('Promotional','Legal') order by name desc;
