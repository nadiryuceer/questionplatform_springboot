INSERT INTO user (id,first_name,last_name,nickname) values (1,'Nadir','Yüceer','Terminator');
INSERT INTO user (id,first_name,last_name,nickname) values (2,'Ahmet','Vural', 'PcNerd');
INSERT INTO question (id, descript, publishdate, title, views, votes, user_id) values (1,'desc', CURTIME(),'title', 0, 0 ,1);