##服务器性能时间主要参数计算方式
###连接时间connect time
* 三次握手时间 可以用建立socket初始化时间为准

###等待时间 processing time
* request and reading response time

###关键时间点
* 开始连接时间
* 已连接，开始写发送请求
* 请求写完时间
* 读取接收数据时间
* HTTP 响应头 date 数据表示为消息发送的时间

