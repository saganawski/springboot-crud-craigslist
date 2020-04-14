CREATE DATABASE craigslist;

Create table craigslist.category (
	id int(11) NOT NULL auto_increment,
    name VARCHAR(145) NOT NULL UNIQUE,
    updated_date datetime DEFAULT current_timestamp ON UPDATE current_timestamp,
    created_date datetime DEFAULT current_timestamp,
    primary key (id)
);

create table craigslist.post(
	id int(11) NOT NULL auto_increment,
    name VARCHAR(145) NOT NULL UNIQUE,
    updated_date datetime DEFAULT current_timestamp ON UPDATE current_timestamp,
    created_date datetime DEFAULT current_timestamp,
    category_id int(11) NOT NULL,
    primary key (id),
    KEY fk_category (category_id),
    CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

insert into craigslist.category (name) 
	values ('Apartments'),
    ('Jobs'),
    ('Cars');


insert into craigslist.post (name, category_id) 
	values('High Rise one bed $1800', 1),
    ('studio 850', 1),
    ('2bed 1650', 1),
    ('Developer needed', 2),
    ('Java dev', 2),
    ('Jr dev 8 years experince needed', 2),
    ('89 plymoth sundance', 3),
    ('94 bonnivle', 3),
    ('94 dodge dokota', 3);




