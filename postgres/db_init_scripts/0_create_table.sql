create table if not exists patient
(
  id bigserial primary key,
  temp integer,
  pathogen text,
  cause text,
  symptoms text,
  kind integer,
  course integer,
  complications text
);
