create table if not exists `Users`(
    `user_id` integer not null primary key comment '主键' AUTO_INCREMENT,
    `user_email` varchar(50) not null comment '用户邮箱',
    `user_name` varchar(50) not null comment '用户名',
    `user_password` varchar(50) not null default 'haha' comment '用户密码',
    `user_address` varchar(50) not null comment '收货地址',
    `user_or_register` boolean not null default false comment '是否为注册用户'
);
create table if not exists `Books`(
    `ISBN` integer not null primary key comment '主键',
    `book_name` varchar(50) not null comment '书籍名称',
    `book_author` varchar(50) not null comment '书籍作者',
    `book_price` double not null comment '书籍价格',
    `book_quantities` integer comment '书籍剩余数目',
    `book_sale_numbers` integer comment '书籍销售数目',
    `book_introduction` varchar(50) not null comment '书籍简介',
    `book_image` varchar(255) not null comment '书籍封面'
);
create table if not exists`Search`(
    `search_id` integer not null primary key comment '主键',
    `search_user_id` integer  comment '搜索用户id',
    `search_book_ISBN` integer  comment '书籍ISBN',
    `search_book_name` varchar(50)  comment '书籍名称',
    `search_book_author` varchar(50) comment '书籍作者',
    foreign key (search_book_ISBN)REFERENCES Books(ISBN),
    foreign key (search_user_id)REFERENCES Users(user_id)
);
create table if not exists `Shoppings`(
    `shopping_id` integer not null primary key comment '订单号',
    `shopping_book_ISBN` integer not null comment '书籍ISBN',
    `shopping_book_user_id` integer not null comment '购书人',
    `shopping_book_quantities` integer comment '购买数量',
    `shopping_status` boolean not null default false comment '付款状态',
    foreign key (shopping_book_ISBN)REFERENCES  Books(ISBN),
    foreign key(shopping_book_user_id)REFERENCES users(user_id)
);

