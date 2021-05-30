--Table: StudentData

Create table public.student (
        id serial PRIMARY KEY,
        name varchar(20),
        surname varchar(20),
        assignment1 int,
        assignment2 int,
        assignment3 int,
        yearMark int,
        examEntranceStatus varchar(20)

);
