--신상품 정렬 View
create or replace view new_product
as
select pseq, model, price, image, saveimagefile, userid from product where sellstate='N'  order by indate desc limit 3;

select * from new_product;

--product 테이블에 조회수용 readcount/ 찜수확인용 wantcount 콜롬 추가
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
    readcount int default 0,
	wantcount int default 0,
    userid varchar(45) NOT NULL,
    PRIMARY KEY (pseq)
);


--wantlist 생성
CREATE TABLE `phonetail`.`wantlist` (
  `wseq` INT NOT NULL AUTO_INCREMENT,
  `pseq` INT NOT NULL,
  `userid` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`wseq`),
  INDEX `pk1_idx` (`pseq` ASC) VISIBLE,
  INDEX `pk2_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `pk1`
    FOREIGN KEY (`pseq`)
    REFERENCES `phonetail`.`product` (`pseq`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `pk2`
    FOREIGN KEY (`userid`)
    REFERENCES `phonetail`.`member` (`userid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

select * from wantlist;


