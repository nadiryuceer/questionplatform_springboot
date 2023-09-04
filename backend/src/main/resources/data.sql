INSERT INTO users (username,email,first_name,last_name) values ('Terminator','terminator@gmail.com','Nadir','Yüceer');
INSERT INTO users (username,email,first_name,last_name) values ('PcNerd', 'thenerd@yahoo.com','Ahmet','Vural' );
INSERT INTO question (id, description, publishdate, title, views, votes, username) values (1,'desc', CURTIME(),'title', 0, 0 ,'Terminator');
INSERT INTO question (id, description, publishdate, title, views, votes, username) values (2,'desc2', CURTIME(),'title2', 0, 0 ,'PcNerd');
INSERT INTO answer (id, text, publishdate, votes, username, question_id) values (1,'comment', CURTIME(), 0,'Terminator', 1);
INSERT INTO tag (name) values ('springboot');