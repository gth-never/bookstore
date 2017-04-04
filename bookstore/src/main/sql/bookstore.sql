/*在category表创建之后 才可以 因为有外键*/
CREATE TABLE book(
    book_id  INT NOT NULL AUTO_INCREMENT COMMENT '图书编号',
    book_name VARCHAR(20) NOT NULL COMMENT '书名',
    author VARCHAR(20) NOT NULL COMMENT '作者',
    publisher VARCHAR(20) NOT NULL COMMENT '出版社',
    price FLOAT NOT NULL COMMENT '价格',
    category_id INT NOT NULL COMMENT '所属类别的编号',
    publish_time TIMESTAMP NOT NULL COMMENT '出版时间',
    count INT NOT NULL COMMENT '库存',
    PRIMARY KEY (book_id),
    FOREIGN KEY(category_id) REFERENCES category(category_id)
)ENGINE =InnoDB DEFAULT CHARSET=utf8 COMMENT '图书表';
INSERT INTO book(book_name, author, publisher, price, category_id, publish_time, count) VALUES
    ('c语言程序设计','谭浩强','清华大学出版社',24.00,1,'2000年1月1日',10);
INSERT INTO book(book_name, author, publisher, price, category_id, publish_time, count) VALUES
    ('疯狂java讲义','李刚','电子工业出版社',79.00,1,'2008年9月1日',10);
INSERT INTO book(book_name, author, publisher, price, category_id, publish_time, count) VALUES
    ('大话设计模式','吴强','企业管理出版社',58.00,1,'2010年7月1日',10);
INSERT INTO book(book_name, author, publisher, price, category_id, publish_time, count) VALUES
    ('操作系统','谢青松','人民邮电出版社',26.00,1,'2007年3月1日',10);
/*先创建category表*/
CREATE TABLE category(
    category_id INT NOT NULL AUTO_INCREMENT COMMENT '类别编号',
    category_name VARCHAR(20) NOT NULL COMMENT '类别名称',
    PRIMARY KEY(category_id)
)ENGINE =InnoDB DEFAULT CHARSET=utf8 COMMENT '类别表';
INSERT INTO category(category_name) VALUES ('计算机');
CREATE TABLE user(
    user_id INT AUTO_INCREMENT NOT NULL COMMENT '用户编号',
    user_name VARCHAR(20) NOT NULL COMMENT '用户名',
    password VARCHAR(20) NOT NULL COMMENT '密码',
    PRIMARY KEY (user_id)
)ENGINE =InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';
INSERT INTO user (user_name, password)VALUES ('root','root'),('never','123456');