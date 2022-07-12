CREATE SEQUENCE public.todo_sequence
    MINVALUE 1
    MAXVALUE 9223372036854775807
    INCREMENT 1
    START 1
    CACHE 1
;


CREATE TABLE public.todo (
    id  BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('public.todo_sequence'),
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    due_date DATE,
    owner_id BIGINT NOT NULL,

    CONSTRAINT owner_id_fk FOREIGN KEY (owner_id) REFERENCES public.todo_user (id)
);