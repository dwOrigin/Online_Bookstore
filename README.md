# online_bookstore
数据库课程设计，网上书店系统
## 操作
初始化sql放置位置为
```yaml
localhost:3306/online_bookstore
```
## 后端问题
1. 当使用代码生成器后，对应的mapper层没有添加@mapper注解，
但是在手动添加后依旧无法解决，在启动类上加上
```java
@MapperScan
```
后可以操作，且此时去除几项@mapper也可以运行【1】
## 参考链接
1. https://blog.csdn.net/qq_17589751/article/details/104795465?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-104795465-blog-90473681.pc_relevant_3mothn_strategy_recovery&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-104795465-blog-90473681.pc_relevant_3mothn_strategy_recovery&utm_relevant_index=1
