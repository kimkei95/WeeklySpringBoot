create table events(
id serial primary key,
title varchar(255),
start_on timestamp not null,
end_on timestamp not null,
participant int not null,
location varchar(15) not null
);

create table participants(
id serial primary key,
event_id int,
participant_name varchar(255) not null,
email varchar (255) unique not null,
foreign key (event_id) references events(id)
);

create table organizer(
id serial primary key,
event_id int not null,
name_organizer varchar(255) not null,
role varchar(10) not null
foreign key(event_id) references events(id)
);