INSERT INTO users (username,email,first_name,last_name) values ('Terminator','terminator@gmail.com','Nadir','Yüceer');
INSERT INTO users (username,email,first_name,last_name) values ('PcNerd', 'thenerd@yahoo.com','Ahmet','Vural' );
INSERT INTO question (id, description, publishdate, title, views, votes, username) values (1,'desc', CURTIME(),'title', 0, 0 ,'Terminator');
INSERT INTO tag (id, name) values (1,'springboot');