create type admin_type as object(
	adminId number(19),
	firstName varchar2(25) ,
	lastName varchar2(25),
	userName varchar2(25),
	email varchar2(50),
	password varchar2(10)

)
/

create table admin of admin_type(
CONSTRAINT admin_pk PRIMARY KEY (adminId) 
)
/

create sequence admin_seq start with 1 increment by 1;
	
create or replace trigger admin_seq_tr
 before insert on admin for each row
 when (new.adminId is null)
begin
 select admin_seq.nextval into :new.adminId from dual;
end;
/

---------------------------------------------------------------------------------------------------------------

create type learner_type  as object(
	learnerid number(19),
	firstName varchar2(25) ,
	lastName varchar2(25),
	userName varchar2(25),
	email varchar2(50),
	password varchar2(10),
	noOfCoursesTaken number(10)
)
/

create table learner of learner_type (
CONSTRAINT learner_pk PRIMARY KEY (learnerid) 
)
/

create sequence learner_seq start with 1 increment by 1;
	
create or replace trigger learner_seq_tr
 before insert on learner for each row
 when (new.learnerid is null)
begin
 select learner_seq.nextval into :new.learnerid from dual;
end;
/

---------------------------------------------------------------------------------------------------------------

create type trainer_type as object(
	trainerId number(19),
	firstName varchar2(25) ,
	lastName varchar2(25),
	userName varchar2(25),
	email varchar2(50),
	password varchar2(10)
)
/

create table trainer of trainer_type(
CONSTRAINT trainer_pk PRIMARY KEY (trainerId) 
)
/


create sequence trainer_seq start with 1 increment by 1;
	
create or replace trigger trainer_seq_tr
 before insert on trainer for each row
 when (new.trainerId is null)
begin
 select trainer_seq.nextval into :new.trainerId from dual;
end;
/

---------------------------------------------------------------------------------------------------------------

create table course(
courseId  number(19),
courseName varchar2(100),
description varchar2(225),
code varchar2(10),
duration number(19),
startDate date,
endDate date,
CONSTRAINT course_pk PRIMARY KEY (courseId) 
)
/

create sequence course_seq start with 1 increment by 1;
	
create or replace trigger course_seq_tr
 before insert on course for each row
 when (new.courseId is null)
begin
 select course_seq.nextval into :new.courseId from dual;
end;
/

----------------------------------------------------------------------------------------------------------------


create table lesson(
lessonId  number(19),
lessonName varchar2(100),
description varchar2(225), 
duration date,
startDate date,
endDate date,
lesCourseid number(19),
CONSTRAINT lesson_pk PRIMARY KEY (lessonId), 
CONSTRAINT fk_course FOREIGN KEY (lesCourseid) REFERENCES course(courseId) ON DELETE CASCADE
)
/

create sequence lesson_seq start with 1 increment by 1;
	
create or replace trigger lesson_seq_tr
 before insert on lesson for each row
 when (new.lessonId is null)
begin
 select lesson_seq.nextval into :new.lessonId from dual;
end;
/
----------------------------------------------------------------------------------------------------------------

create table courseMaterial(
materialid  number(19),
name varchar2(100),
createdAt date,
updatedAt date,
lesnMaterialid number(19),
CONSTRAINT courseMaterial_pk PRIMARY KEY (materialid), 
CONSTRAINT fk_lesson_material FOREIGN KEY (lesnMaterialid) REFERENCES lesson(lessonId) ON DELETE CASCADE
)
/

create sequence courseMaterial_seq start with 1 increment by 1;
	
create or replace trigger courseMaterial_seq_tr
 before insert on courseMaterial for each row
 when (new.materialid is null)
begin
 select courseMaterial_seq.nextval into :new.materialid from dual;
end;
/


----------------------------------------------------------------------------------------------------------------

create table assignmentType(
id  number(19),
name varchar2(100),
CONSTRAINT assignmentType_pk PRIMARY KEY (id) 	
)
/

create sequence assignType_seq start with 1 increment by 1;
	
create or replace trigger assignType_seq_tr
 before insert on assignmentType for each row
 when (new.id is null)
begin
 select assignType_seq.nextval into :new.id from dual;
end;
/

----------------------------------------------------------------------------------------------------------------

create table assignment(
assignid number(19),
name varchar2(100),
description varchar2(225), 
startDate date,
endDate date,
submittedDate date,
trainer_assignid number(19),
lesson_assignid number(19),
assignTypeid number(19),
CONSTRAINT assignment_pk PRIMARY KEY (assignid), 
CONSTRAINT fk_trainer_assign FOREIGN KEY (trainer_assignid) REFERENCES trainer(trainerId) ON DELETE CASCADE,
CONSTRAINT fk_lesson_assign FOREIGN KEY (lesson_assignid) REFERENCES lesson(lessonId) ON DELETE CASCADE,
CONSTRAINT fk_assigntype FOREIGN KEY (assignTypeid) REFERENCES assignmentType(id) ON DELETE CASCADE 
)
/

create sequence assignment_seq start with 1 increment by 1;
	
create or replace trigger assignment_seq_tr
 before insert on assignment for each row
 when (new.assignid is null)
begin
 select assignment_seq.nextval into :new.assignid from dual;
end;
/


----------------------------------------------------------------------------------------------------------------

create table document(
id  number(19),
name varchar2(100),
createdAt date,
updatedAt date,
location varchar2(225),
docAssignid number(19),
docMaterialid number(19),
CONSTRAINT document_pk PRIMARY KEY (id), 
CONSTRAINT fk_doc_assign FOREIGN KEY (docAssignid) REFERENCES assignment(assignid) ON DELETE CASCADE,
CONSTRAINT fk_doc_material FOREIGN KEY (docMaterialid) REFERENCES courseMaterial(materialid) ON DELETE CASCADE
)
/

create sequence document_seq start with 1 increment by 1;
	
create or replace trigger document_seq_tr
 before insert on document for each row
 when (new.id is null)
begin
 select document_seq.nextval into :new.id from dual;
end;
/
----------------------------------------------------------------------------------------------------------------


create table greadetype(
id  Number(19) Not Null,
name varchar2(100) Not Null,
CONSTRAINT greadetype_pk PRIMARY KEY (id)
)
/

create sequence greadetype_seq start with 1 increment by 1;
	
create or replace trigger greadetype_seq_tr
 before insert on greadetype for each row
 when (new.id is null)
begin
 select greadetype_seq.nextval into :new.id from dual;
end;
/

----------------------------------------------------------------------------------------------------------------


create table grade(
id  number(19) Not Null,
mark number(10) Not Null,
typeid number(19),
CONSTRAINT grade_pk PRIMARY KEY (id),
CONSTRAINT fk_gradeType FOREIGN KEY (typeid) REFERENCES greadetype(id) ON DELETE CASCADE
)
/

create sequence grade_seq start with 1 increment by 1;
	
create or replace trigger grade_seq_tr
 before insert on grade for each row
 when (new.id is null)
begin
 select grade_seq.nextval into :new.id from dual;
end;
/

----------------------------------------------------------------------------------------------------------------

create table feedback(
id  number(19) Not Null,
content varchar2(225) Not Null,
courseFdbid number(19),
learnerFdbid number(19),
CONSTRAINT feedback_pk PRIMARY KEY (id),
CONSTRAINT fk_feedbacklearner FOREIGN KEY (learnerFdbid) REFERENCES learner(learnerId) ON DELETE CASCADE,
CONSTRAINT fk_feedbackCourse FOREIGN KEY (courseFdbid) REFERENCES course(courseId) ON DELETE CASCADE
)
/

create sequence feedback_seq start with 1 increment by 1;
	
create or replace trigger feedback_seq_tr
 before insert on feedback for each row
 when (new.id is null)
begin
 select feedback_seq.nextval into :new.id from dual;
end;
/

-----------------------------------------------------------------------------------------------------------------

create table notice(
id  number(19) Not Null,
title varchar2(100) Not Null,
description varchar2(225),
postedBy varchar2(100),
position varchar2(100),
postDate DATE,
createid number(19),
CONSTRAINT notice_pk PRIMARY KEY (id),
CONSTRAINT fk_notice FOREIGN KEY (createid) REFERENCES trainer(trainerId) ON DELETE CASCADE
)
/

create sequence notice_seq start with 1 increment by 1;

create or replace trigger notice_seq_tr
 before insert on notice for each row
 when (new.id is null)
begin
 select notice_seq.nextval into :new.id from dual;
end;
/

----------------------------------------------------------------------------------------------------------------

N:M

create table assignTo(
coid number(19) Not Null,
learnid number (19) Not Null,
CONSTRAINT assignTo_pk PRIMARY KEY (coid , learnid),
CONSTRAINT fk_assignTolearner FOREIGN KEY (learnid) REFERENCES learner(learnerId) ON DELETE CASCADE,
CONSTRAINT fk_assignToCourse FOREIGN KEY (coid) REFERENCES course(courseId) ON DELETE CASCADE
)
/

----------------------------------------------------------------------------------------------------------------

create table submit(
id number(19) Not Null,
tid number(19) Not Null,
CONSTRAINT submit_pk PRIMARY KEY (id, tid),
CONSTRAINT fk_submit FOREIGN KEY (tid) REFERENCES trainer(trainerId) ON DELETE CASCADE, 
CONSTRAINT fk_submitCourse FOREIGN KEY (id) REFERENCES course(courseId) ON DELETE CASCADE
)
/

----------------------------------------------------------------------------------------------------------------


create table createdBy(
aid number(19) Not Null,
lid number(19) Not Null,
CONSTRAINT createdBy_pk PRIMARY KEY (aid ,lid),
CONSTRAINT fk_createdByassign FOREIGN KEY (aid) REFERENCES assignment(assignid) ON DELETE CASCADE,
CONSTRAINT fk_acreatedBylearner FOREIGN KEY (lid) REFERENCES learner(learnerId) ON DELETE CASCADE
)
/
_____________________________________________________________________________________________________________

DROP TYPE admin_type;
DROP TYPE trainer_type;
DROP TYPE learner_type;
DROP TYPE person_type;

Drop Table admin ;
Drop Table learner; 
Drop Table trainer;
Drop Table person;

Drop Table lesson;
Drop Table course;
Drop Table courseMaterial;
Drop Table assignmentType;
Drop Table assignment;
Drop Table document;
Drop Table greadetype;
Drop Table grade;
Drop Table feedback;


DROP SEQUENCE Person_seq;
DROP SEQUENCE Person_seq;
DROP SEQUENCE Person_seq;
DROP SEQUENCE course_seq;
DROP SEQUENCE lesson_seq;
DROP SEQUENCE courseMaterial_seq ;
DROP SEQUENCE assignType_seq;
DROP SEQUENCE assignment_seq;
DROP SEQUENCE document_seq;
DROP SEQUENCE greadetype_seq;
DROP SEQUENCE grade_seq;
DROP SEQUENCE feedback_seq;
