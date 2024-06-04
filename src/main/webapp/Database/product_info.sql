CREATE TABLE `phonetail`.`product_info` (
  `model` VARCHAR(100) NOT NULL,
  `series` VARCHAR(100) NULL DEFAULT '',
  `brand` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`model`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- APPLE 브랜드 삽입
INSERT INTO product_info (model, series, brand) VALUES 
('아이폰 15 PRO MAX', '15시리즈', 'APPLE'),
('아이폰 15 PRO', '15시리즈', 'APPLE'),
('아이폰 15 Plus', '15시리즈', 'APPLE'),
('아이폰 15', '15시리즈', 'APPLE'),
('아이폰 14 PRO MAX', '14시리즈', 'APPLE'),
('아이폰 14 PRO', '14시리즈', 'APPLE'),
('아이폰 14 Plus', '14시리즈', 'APPLE'),
('아이폰 14', '14시리즈', 'APPLE'),
('아이폰 13 PRO MAX', '13시리즈', 'APPLE'),
('아이폰 13 PRO', '13시리즈', 'APPLE'),
('아이폰 13', '13시리즈', 'APPLE'),
('아이폰 13 mini', '13시리즈', 'APPLE'),
('아이폰 12 PRO MAX', '12시리즈', 'APPLE'),
('아이폰 12 PRO', '12시리즈', 'APPLE'),
('아이폰 12', '12시리즈', 'APPLE'),
('아이폰 12 mini', '12시리즈', 'APPLE'),
('아이폰 11 PRO MAX', '11시리즈', 'APPLE'),
('아이폰 11 PRO', '11시리즈', 'APPLE'),
('아이폰 11', '11시리즈', 'APPLE'),
('아이폰 XS MAX', 'X/XS 시리즈', 'APPLE'),
('아이폰 XS', 'X/XS 시리즈', 'APPLE'),
('아이폰 XR', 'X/XS 시리즈', 'APPLE'),
('아이폰 X', 'X/XS 시리즈', 'APPLE'),
('아이폰8 plus', '7,8 시리즈', 'APPLE'),
('아이폰8', '7,8 시리즈', 'APPLE'),
('아이폰7 plus', '7,8 시리즈', 'APPLE'),
('아이폰7', '7,8 시리즈', 'APPLE');

--Samsung 브랜드 삽입

-- Samsung 시리즈 삽입
INSERT INTO product_info (model, series, brand) VALUES 
('갤럭시노트20 ULTRA', '노트시리즈', 'Samsung'),
('갤럭시노트20', '노트시리즈', 'Samsung'),
('갤럭시노트10 Plus', '노트시리즈', 'Samsung'),
('갤럭시노트10', '노트시리즈', 'Samsung'),
('갤럭시노트9', '노트시리즈', 'Samsung'),
('갤럭시노트8', '노트시리즈', 'Samsung'),
('갤럭시 S24 ULTRA', 'S 시리즈', 'Samsung'),
('갤럭시 S24 Plus', 'S 시리즈', 'Samsung'),
('갤럭시 S24', 'S 시리즈', 'Samsung'),
('갤럭시 S23 ULTRA', 'S 시리즈', 'Samsung'),
('갤럭시 S23 Plus', 'S 시리즈', 'Samsung'),
('갤럭시 S23', 'S 시리즈', 'Samsung'),
('갤럭시 S22 ULTRA', 'S 시리즈', 'Samsung'),
('갤럭시 S22 Plus', 'S 시리즈', 'Samsung'),
('갤럭시 S22', 'S 시리즈', 'Samsung'),
('갤럭시 S21', 'S 시리즈', 'Samsung'),
('갤럭시 S20', 'S 시리즈', 'Samsung'),
('갤럭시 S10', 'S 시리즈', 'Samsung'),
('갤럭시 S10 E', 'S 시리즈', 'Samsung'),
('갤럭시 S9 Plus', 'S 시리즈', 'Samsung'),
('갤럭시 S9', 'S 시리즈', 'Samsung'),
('갤럭시 Z폴드 5', 'Z 시리즈', 'Samsung'),
('갤럭시 Z플립 5', 'Z 시리즈', 'Samsung'),
('갤럭시 Z폴드 4', 'Z 시리즈', 'Samsung'),
('갤럭시 Z플립 4', 'Z 시리즈', 'Samsung'),
('갤럭시 Z폴드 3', 'Z 시리즈', 'Samsung'),
('갤럭시 Z플립 3', 'Z 시리즈', 'Samsung'),
('갤럭시 Z폴드 2', 'Z 시리즈', 'Samsung'),
('갤럭시 Z플립 2', 'Z 시리즈', 'Samsung'),
('갤럭시 Z폴드', 'Z 시리즈', 'Samsung'),
('갤럭시 Z플립', 'Z 시리즈', 'Samsung'),
('갤럭시 A25', 'A 시리즈', 'Samsung'),
('갤럭시 A24', 'A 시리즈', 'Samsung'),
('갤럭시 A23', 'A 시리즈', 'Samsung'),
('갤럭시 A15', 'A 시리즈', 'Samsung'),
('갤럭시 A13', 'A 시리즈', 'Samsung'),
('갤럭시 퀸텀4', 'A 시리즈', 'Samsung'),
('갤럭시 퀸텀3', 'A 시리즈', 'Samsung'),
('갤럭시 퀸텀2', 'A 시리즈', 'Samsung'),
('갤럭시 JUMP3', 'A 시리즈', 'Samsung'),
('갤럭시 JUMP2', 'A 시리즈', 'Samsung');

-- LG 시리즈 삽입
INSERT INTO product_info (model, series, brand) VALUES 
('LG G8 ThinQ', 'G 시리즈', 'LG'),
('LG G7 ThinQ', 'G 시리즈', 'LG'),
('LG G6', 'G 시리즈', 'LG'),
('LG V50S ThinQ', 'V 시리즈', 'LG'),
('LG V50 ThinQ', 'V 시리즈', 'LG'),
('LG V40 ThinQ', 'V 시리즈', 'LG'),
('LG V30 ThinQ', 'V 시리즈', 'LG');
