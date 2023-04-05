CREATE TABLE public.course (
    course_id varchar(5) NOT NULL,
    subject_id varchar(4) NULL,
    course_code varchar(10) NULL,
    course_title varchar(50) NULL,
    num_of_credits int4 NULL,
    CONSTRAINT course_pkey PRIMARY KEY (course_id)
);

CREATE TABLE public.student (
    ssn int4 NOT NULL,
    first_name varchar(30) NULL,
    last_name varchar(30) NULL,
    birth_date date NULL,
    street varchar(30) NULL,
    phone varchar(30) NULL,
    zip_code varchar(5) NULL,
    CONSTRAINT student_pkey PRIMARY KEY (ssn)
);

CREATE TABLE public.enrollment (
    ssn int4 NOT NULL,
    course_id varchar(5) NOT NULL,
    date_register date NULL,
    grade bpchar(1) NULL,
    CONSTRAINT enrollment_pkey PRIMARY KEY (ssn, course_id)
);

-- public.enrollment foreign keys

ALTER TABLE public.enrollment ADD CONSTRAINT course_id_fk FOREIGN KEY (course_id) REFERENCES public.course(course_id);
ALTER TABLE public.enrollment ADD CONSTRAINT ssn_fk FOREIGN KEY (ssn) REFERENCES public.student(ssn);