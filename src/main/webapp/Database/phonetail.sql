-- 스키마 생성 및 세션 설정
CREATE SCHEMA `phonetail` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE phonetail;
SET SESSION FOREIGN_KEY_CHECKS=0;

select*from member;
select*from product;

-- 기존 테이블 삭제
--DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS admin;
DROP TABLE IF EXISTS chat;
DROP TABLE IF EXISTS chatlist;
DROP TABLE IF EXISTS report;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS member;


-- 테이블 생성
--CREATE TABLE address
--(
--    zip_num varchar(15),
--    sido varchar(30),
--    gugun varchar(30),
--    dong varchar(30),
--    bunji varchar(20),
--    zip_code varchar(30)
--);

CREATE TABLE admin
(
    adminid varchar(45) NOT NULL,
    pwd varchar(45),
    name varchar(45),
    phone varchar(45),
    PRIMARY KEY (adminid)
);

CREATE TABLE chat
(
    cseq int NOT NULL AUTO_INCREMENT,
    content varchar(300) NOT NULL,
    indate datetime DEFAULT now() NOT NULL,
    userid varchar(45) NOT NULL,
    pseq int NOT NULL,
    lseq int,
    PRIMARY KEY (cseq)
);

 

CREATE TABLE member
(
    userid varchar(45) NOT NULL,
    pwd varchar(45) NOT NULL,
    name varchar(45) NOT NULL,
    phone varchar(45) NOT NULL,
    email varchar(100) NOT NULL,
    address1 varchar(100) NOT NULL,
    address2 varchar(100) NOT NULL,
    usestate char(1) DEFAULT 'Y' NOT NULL,
    indate datetime DEFAULT now() NOT NULL,
    PRIMARY KEY (userid)
);
-- zip_code 삭제(우편번호 찾기에서 찾아줌)
-- zip_num 삭제(우편번호 찾기에서 찾아줌)

CREATE TABLE product
(
    pseq int NOT NULL AUTO_INCREMENT,
    brand varchar(45) NOT NULL COMMENT 'company > brand로 수정',
    series varchar(45) NOT NULL COMMENT '카테고리 필터 용',
    model varchar(45) NOT NULL COMMENT '카테고리 필터 용',
    price int NOT NULL,
    comment varchar(1000),
    image varchar(200),
    saveimagefile varchar(200) COMMENT 'no image가 있을수 있어서',
    sellstate char(1) DEFAULT 'N' COMMENT 'YorN',
    indate datetime DEFAULT now() NOT NULL,
    userid varchar(45) NOT NULL,
    PRIMARY KEY (pseq)
);

CREATE TABLE question
(
    qseq int NOT NULL AUTO_INCREMENT,
    title varchar(100) NOT NULL,
    content varchar(1000) NOT NULL,
    indate datetime DEFAULT now() NOT NULL,
    userid varchar(45) NOT NULL,
    qreply varchar(1000),
    PRIMARY KEY (qseq)
);

CREATE TABLE report
(
    reseq int NOT NULL AUTO_INCREMENT,
    pseq int NOT NULL,
    userid varchar(45) NOT NULL,
    retype int NOT NULL COMMENT '--0 - 광고성 콘텐츠(거래와 관련없는 글)
   --1 - 상품정보 부정확
   --2 - 안전거래를 거부해요
   --3 - 사기가 의심돼요(외부 채널 유도)
   --4 - 전문업자 같아요',
    recontent varchar(300) NOT NULL,
    restate char(1) DEFAULT 'N' NOT NULL COMMENT 'N:대기상태 Y:처리완료',
    -- 24.05.29 신고시 해당 날짜 추가해서 list에서 정렬기준을 삼을수 있게 필드 추가했습니다
    indate datetime DEFAULT now() NOT NULL,
    PRIMARY KEY (reseq)
);

-- 채팅 테이블 추가
CREATE TABLE chatlist(
 lseq INT NOT NULL AUTO_INCREMENT,
 sid varchar(45) NOT NULL,
 bid varchar(45) NOT NULL,
 indate datetime DEFAULT now() NOT NULL,
 pseq int NOT NULL,
 PRIMARY KEY (lseq)
);

-- 외래 키 추가
ALTER TABLE chat
    ADD FOREIGN KEY (userid) REFERENCES member (userid) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE chat
    ADD FOREIGN KEY (lseq) REFERENCES chatlist (lseq) ON UPDATE CASCADE ON DELETE CASCADE;    
    
ALTER TABLE product
    ADD FOREIGN KEY (userid) REFERENCES member (userid) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE question
    ADD FOREIGN KEY (userid) REFERENCES member (userid) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE report
    ADD FOREIGN KEY (userid) REFERENCES member (userid) ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE chat
    ADD FOREIGN KEY (pseq) REFERENCES product (pseq) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE report
    ADD FOREIGN KEY (pseq) REFERENCES product (pseq) ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE chatlist
    ADD FOREIGN KEY (pseq) REFERENCES product (pseq) ON UPDATE CASCADE ON DELETE CASCADE;


-- 샘플 데이터 삽입
--INSERT INTO address (zip_num, sido, gugun, dong, bunji, zip_code) VALUES
-- 수업시간 때 받은 샘플 데이터로 인서트 대체 

INSERT INTO admin (adminid, pwd, name, phone) VALUES
('admin1', 'password1', '관리자1', '010-1234-5678'),
('admin2', 'password2', '관리자2', '010-8765-4321'),
('ad', 'ad', '관리자짱짱', '010-8765-1234');


INSERT INTO member (userid, pwd, name, phone, email, address1, address2, usestate, indate) VALUES
('user1', 'pwd1', '사용자1', '010-1111-2222', 'user1@example.com', '서울특별시 강남구 삼성동', '123-45', 'Y', now()),
('user2', 'pwd2', '사용자2', '010-3333-4444', 'user2@example.com', '부산광역시 해운대구 우동', '678-90', 'Y', now()),
('a', 'a', '테스트계정', '010-3333-4444', 'user2@example.com', '부산광역시 해운대구 우동', '678-90', 'Y', now());



INSERT INTO product (brand, series, model, price, comment, image, saveimagefile, sellstate, indate, userid) VALUES
('Apple', 'iPhone', 'iPhone 13', 1000000, '최신 아이폰 모델', 'iphone13.jpg', 'iphone13.jpg', 'Y', now(), 'user1'),
('Samsung', 'Galaxy', 'Galaxy S21', 900000, '최신 갤럭시 모델', 'galaxys21.jpg', 'galaxys21.jpg', 'N', now(), 'user2');

INSERT INTO chat (content, indate, userid, pseq, lseq) VALUES
('이 제품에 대해 질문이 있습니다.', now(), 'user2', 1 , 1),
('언제 배송되나요?', now(), 'user1', 2, 1);
('왜 읽씹하시나요?', now(), 'user1', 1, 1);

INSERT INTO question (title, content, indate, userid, qreply) VALUES
('제품 문의', '이 제품의 기능에 대해 알고 싶습니다.', now(), 'user1', '답변 대기 중'),
('배송 문의', '언제 배송되나요?', now(), 'user2', '답변 대기 중');


--24.05.29 샘플 수정(indate는 알아서 now()로 들어갑니다)->not null과 충돌되는 듯 하여 indate를 추가했습니다
INSERT INTO report (pseq, userid, retype, recontent, restate,indate) VALUES
(1, 'user2', 3, '사기가 의심됩니다.', 'N',now()),
(2, 'user1', 1, '상품 정보가 부정확합니다.', 'Y',now());






-- chatlist 테이블에 예시 데이터 삽입
INSERT INTO chatlist (sid, bid, pseq) VALUES ('S123', 'B456', 1);
INSERT INTO chatlist (sid, bid, pseq) VALUES ('S456', 'B789', 2);
INSERT INTO chatlist (sid, bid, pseq) VALUES ('S456', 'B123', 2);


-- report 테이블 샘플 데이터 40개 삽입 (pseq를 1 또는 2로 설정하고 restate를 모두 'N'으로 설정)
INSERT INTO report (pseq, userid, retype, recontent, restate) VALUES
(1, 'user1', 0, '광고성 콘텐츠입니다.', 'N'),
(2, 'user2', 1, '상품 정보가 부정확합니다.', 'N'),
(1, 'user1', 2, '안전거래를 거부합니다.', 'N'),
(2, 'user2', 3, '사기가 의심됩니다.', 'N'),
(1, 'user1', 4, '전문업자 같아요.', 'N'),
(2, 'user2', 0, '거래와 관련없는 글입니다.', 'N'),
(1, 'user1', 1, '정보가 부정확합니다.', 'N'),
(2, 'user2', 2, '거래를 거부해요.', 'N'),
(1, 'user1', 3, '사기 의심돼요.', 'N'),
(2, 'user2', 4, '전문업자 같아요.', 'N'),
(1, 'user1', 0, '광고성 콘텐츠입니다.', 'N'),
(2, 'user2', 1, '상품 정보가 부정확합니다.', 'N'),
(1, 'user1', 2, '안전거래를 거부합니다.', 'N'),
(2, 'user2', 3, '사기가 의심됩니다.', 'N'),
(1, 'user1', 4, '전문업자 같아요.', 'N'),
(2, 'user2', 0, '거래와 관련없는 글입니다.', 'N'),
(1, 'user1', 1, '정보가 부정확합니다.', 'N'),
(2, 'user2', 2, '거래를 거부해요.', 'N'),
(1, 'user1', 3, '사기 의심돼요.', 'N'),
(2, 'user2', 4, '전문업자 같아요.', 'N'),
(1, 'user1', 0, '광고성 콘텐츠입니다.', 'N'),
(2, 'user2', 1, '상품 정보가 부정확합니다.', 'N'),
(1, 'user1', 2, '안전거래를 거부합니다.', 'N'),
(2, 'user2', 3, '사기가 의심됩니다.', 'N'),
(1, 'user1', 4, '전문업자 같아요.', 'N'),
(2, 'user2', 0, '거래와 관련없는 글입니다.', 'N'),
(1, 'user1', 1, '정보가 부정확합니다.', 'N'),
(2, 'user2', 2, '거래를 거부해요.', 'N'),
(1, 'user1', 3, '사기 의심돼요.', 'N'),
(2, 'user2', 4, '전문업자 같아요.', 'N'),
(1, 'user1', 0, '광고성 콘텐츠입니다.', 'N'),
(2, 'user2', 1, '상품 정보가 부정확합니다.', 'N'),
(1, 'user1', 2, '안전거래를 거부합니다.', 'N'),
(2, 'user2', 3, '사기가 의심됩니다.', 'N'),
(1, 'user1', 4, '전문업자 같아요.', 'N'),
(2, 'user2', 0, '거래와 관련없는 글입니다.', 'N'),
(1, 'user1', 1, '정보가 부정확합니다.', 'N'),
(2, 'user2', 2, '거래를 거부해요.', 'N'),
(1, 'user1', 3, '사기 의심돼요.', 'N'),
(2, 'user2', 4, '전문업자 같아요.', 'N');

-- paging확인을 위한 question 테이블 샘플 데이터 삽입
INSERT INTO question (title, content, indate, userid, qreply) VALUES
('제품 문의', '이 제품의 기능에 대해 알고 싶습니다.', now(), 'user1', '답변 대기 중'),
('배송 문의', '언제 배송되나요?', now(), 'user2', '답변 대기 중'),
('환불 문의', '환불 절차가 궁금합니다.', now(), 'user1', '답변 대기 중'),
('AS 문의', '제품 AS는 어떻게 받나요?', now(), 'user2', '답변 대기 중'),
('제품 문의', '이 제품의 색상은 어떤가요?', now(), 'user1', '답변 대기 중'),
('배송 문의', '배송비는 얼마인가요?', now(), 'user2', '답변 대기 중'),
('환불 문의', '환불 기간은 얼마나 걸리나요?', now(), 'user1', '답변 대기 중'),
('AS 문의', 'AS 신청은 어디서 하나요?', now(), 'user2', '답변 대기 중'),
('제품 문의', '이 제품의 크기는 어떻게 되나요?', now(), 'user1', '답변 대기 중'),
('배송 문의', '배송 상태를 확인하고 싶습니다.', now(), 'user2', '답변 대기 중'),
('환불 문의', '환불 신청을 취소하고 싶습니다.', now(), 'user1', '답변 대기 중'),
('AS 문의', 'AS 진행 상황을 알고 싶습니다.', now(), 'user2', '답변 대기 중'),
('제품 문의', '이 제품은 재고가 있나요?', now(), 'user1', '답변 대기 중'),
('배송 문의', '해외 배송도 가능한가요?', now(), 'user2', '답변 대기 중'),
('환불 문의', '환불받을 계좌를 변경하고 싶습니다.', now(), 'user1', '답변 대기 중'),
('AS 문의', 'AS 비용은 얼마나 되나요?', now(), 'user2', '답변 대기 중'),
('제품 문의', '이 제품은 무게가 얼마인가요?', now(), 'user1', '답변 대기 중'),
('배송 문의', '배송 지연 사유가 궁금합니다.', now(), 'user2', '답변 대기 중'),
('환불 문의', '환불 상태를 확인하고 싶습니다.', now(), 'user1', '답변 대기 중'),
('AS 문의', 'AS 신청서를 분실했습니다.', now(), 'user2', '답변 대기 중'),
('제품 문의', '이 제품의 구성품은 무엇인가요?', now(), 'user1', '답변 대기 중'),
('배송 문의', '배송 날짜를 변경하고 싶습니다.', now(), 'user2', '답변 대기 중'),
('환불 문의', '환불 정책을 알고 싶습니다.', now(), 'user1', '답변 대기 중'),
('AS 문의', 'AS 신청 상태를 알고 싶습니다.', now(), 'user2', '답변 대기 중'),
('제품 문의', '이 제품은 어떤 소재로 만들어졌나요?', now(), 'user1', '답변 대기 중'),
('배송 문의', '배송 옵션을 변경하고 싶습니다.', now(), 'user2', '답변 대기 중'),
('환불 문의', '환불이 가능한지 알고 싶습니다.', now(), 'user1', '답변 대기 중'),
('AS 문의', 'AS 관련 문의입니다.', now(), 'user2', '답변 대기 중'),
('제품 문의', '이 제품의 보증 기간은 얼마인가요?', now(), 'user1', '답변 대기 중'),
('배송 문의', '배송 주소를 변경하고 싶습니다.', now(), 'user2', '답변 대기 중'),
('환불 문의', '환불 요청을 하고 싶습니다.', now(), 'user1', '답변 대기 중'),
('AS 문의', 'AS를 신청하려면 어떻게 해야 하나요?', now(), 'user2', '답변 대기 중'),
('제품 문의', '이 제품의 사용법을 알고 싶습니다.', now(), 'user1', '답변 대기 중'),
('배송 문의', '배송 중 파손이 걱정됩니다.', now(), 'user2', '답변 대기 중'),
('환불 문의', '환불 문의입니다.', now(), 'user1', '답변 대기 중'),
('AS 문의', 'AS 센터 위치가 어디인가요?', now(), 'user2', '답변 대기 중'),
('제품 문의', '이 제품의 사양이 궁금합니다.', now(), 'user1', '답변 대기 중'),
('배송 문의', '배송 시간대를 지정할 수 있나요?', now(), 'user2', '답변 대기 중'),
('환불 문의', '환불 절차를 알고 싶습니다.', now(), 'user1', '답변 대기 중'),
('AS 문의', 'AS 접수를 하고 싶습니다.', now(), 'user2', '답변 대기 중');

