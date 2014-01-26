# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table drink (
  id                        bigint not null,
  title                     varchar(255),
  organizer                 varchar(255),
  update_at                 timestamp,
  constraint pk_drink primary key (id))
;

create table drink_date (
  id                        bigint not null,
  date                      timestamp,
  drink_id                  bigint,
  constraint pk_drink_date primary key (id))
;

create table drink_member (
  id                        bigint not null,
  user_id                   varchar(255),
  name                      varchar(255),
  drink_id                  bigint,
  constraint pk_drink_member primary key (id))
;

create table drink_place (
  id                        bigint not null,
  shop_name                 varchar(255),
  shop_url                  varchar(255),
  station                   varchar(255),
  drink_id                  bigint,
  constraint pk_drink_place primary key (id))
;

create table user (
  id                        bigint not null,
  user_id                   varchar(255),
  oauth_type                varchar(255),
  open_id                   varchar(255),
  constraint pk_user primary key (id))
;

create sequence drink_seq;

create sequence drink_date_seq;

create sequence drink_member_seq;

create sequence drink_place_seq;

create sequence user_seq;

alter table drink_date add constraint fk_drink_date_drink_1 foreign key (drink_id) references drink (id) on delete restrict on update restrict;
create index ix_drink_date_drink_1 on drink_date (drink_id);
alter table drink_member add constraint fk_drink_member_drink_2 foreign key (drink_id) references drink (id) on delete restrict on update restrict;
create index ix_drink_member_drink_2 on drink_member (drink_id);
alter table drink_place add constraint fk_drink_place_drink_3 foreign key (drink_id) references drink (id) on delete restrict on update restrict;
create index ix_drink_place_drink_3 on drink_place (drink_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists drink;

drop table if exists drink_date;

drop table if exists drink_member;

drop table if exists drink_place;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists drink_seq;

drop sequence if exists drink_date_seq;

drop sequence if exists drink_member_seq;

drop sequence if exists drink_place_seq;

drop sequence if exists user_seq;

