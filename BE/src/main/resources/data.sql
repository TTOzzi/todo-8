INSERT INTO `user` (id, user_name) VALUES (null,'nigayo');

INSERT INTO category (id, user_id, title, author) VALUES (null,'1', '할일', 'nigayo');
INSERT INTO category (id, user_id, title, author) VALUES (null,'1', '하는중','nigayo');
INSERT INTO category (id, user_id, title, author) VALUES (null,'1', '다했음', 'nigayo');

INSERT INTO card (id, category_id, title, author, contents, category_key) VALUES (null,'1','페이지네이션 UI 리서치', 'nigayo', '리서치를 열심히하자', 0);
INSERT INTO card (id, category_id, title, author, contents, category_key) VALUES (null,'1','상세페이지 API', 'nigayo','API API', 1);

INSERT INTO card (id, category_id, title, author, contents, category_key) VALUES (null,'2','이번주 기획리뷰', 'nigayo','기획이 참 좋다', 0);

INSERT INTO card (id, category_id, title, author, contents, category_key) VALUES (null,'3','설정파일 분리 리팩토링', 'nigayo','리팩토링',0);
INSERT INTO card (id, category_id, title, author, contents, category_key) VALUES (null,'3','데모 환경 분석','nigayo', '잘돌아간다', 1);
INSERT INTO card (id, category_id, title, author, contents, category_key) VALUES (null,'3','프로젝트 생성', 'nigayo','생성했다', 2);

INSERT INTO activity (id, author, action, target_name, departure, arrival) VALUES(null, 'nigayo', 'moved','github 공부하기', 0, 1);
INSERT INTO activity (id, author, action, target_name) VALUES(null, 'nigayo', 'added','설정 파일 분리 리팩토링');
INSERT INTO activity (id, author, action, target_name) VALUES(null, 'nigayo', 'deleted','삭제해보자');


