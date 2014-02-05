# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table drink (
  seq                       bigint not null,
  title                     varchar(255),
  organizer                 varchar(255),
  update_at                 timestamp,
  constraint pk_drink primary key (seq))
;

create table drink_date (
  seq                       bigint not null,
  date                      timestamp,
  drink_seq                 bigint,
  constraint pk_drink_date primary key (seq))
;

create table drink_decision (
  seq                       bigint not null,
  user_id                   varchar(255),
  name                      varchar(255),
  drink_date_seq            bigint,
  user_seq                  bigint,
  constraint pk_drink_decision primary key (seq))
;

create table drink_member (
  seq                       bigint not null,
  drink_seq                 bigint,
  user_seq                  bigint,
  constraint pk_drink_member primary key (seq))
;

create table drink_place (
  seq                       bigint not null,
  shop_name                 varchar(255),
  shop_url                  varchar(255),
  station                   varchar(255),
  constraint pk_drink_place primary key (seq))
;

create table user (
  seq                       bigint not null,
  user_id                   varchar(255),
  name                      varchar(255),
  open_id                   varchar(255),
  constraint pk_user primary key (seq))
;

create sequence drink_seq;

create sequence drink_date_seq;

create sequence drink_decision_seq;

create sequence drink_member_seq;

create sequence drink_place_seq;

create sequence user_seq;

alter table drink_date add constraint fk_drink_date_drink_1 foreign key (drink_seq) references drink (seq) on delete restrict on update restrict;
create index ix_drink_date_drink_1 on drink_date (drink_seq);
alter table drink_decision add constraint fk_drink_decision_date_2 foreign key (drink_date_seq) references drink_date (seq) on delete restrict on update restrict;
create index ix_drink_decision_date_2 on drink_decision (drink_date_seq);
alter table drink_decision add constraint fk_drink_decision_user_3 foreign key (user_seq) references user (seq) on delete restrict on update restrict;
create index ix_drink_decision_user_3 on drink_decision (user_seq);
alter table drink_member add constraint fk_drink_member_drink_4 foreign key (drink_seq) references drink (seq) on delete restrict on update restrict;
create index ix_drink_member_drink_4 on drink_member (drink_seq);
alter table drink_member add constraint fk_drink_member_user_5 foreign key (user_seq) references user (seq) on delete restrict on update restrict;
create index ix_drink_member_user_5 on drink_member (user_seq);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists drink;

drop table if exists drink_date;

drop table if exists drink_decision;

drop table if exists drink_member;

drop table if exists drink_place;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists drink_seq;

drop sequence if exists drink_date_seq;

drop sequence if exists drink_decision_seq;

drop sequence if exists drink_member_seq;

drop sequence if exists drink_place_seq;

drop sequence if exists user_seq;

