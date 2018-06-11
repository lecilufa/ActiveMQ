此包介绍和spring集成

集成的好处是，spring把开连接关连接，消息目的地都给你配置好
你只需关注关键的部分   即发消息和接受消息    其余繁杂的部分由spring处理


spring中所有示例全部是以topic模式来写的，如想切换成queue模式，只需换一下jmsTemplate和listener 即可
详细请看basic_sender.xml ，  basic_receiver.xml

ActiveMQ可以发以下几种消息

1.  文本消息   -- 这是最常用的消息种类， 一般为json格式   (basic)

2.  二进制消息  -- 用来发图片，视频 等二进制文件	(sendFile)

3.  Object消息  --  直接发JAVA对象，接收器也是接受java对象  (sendObj)

4.  Map消息  -- 个人感觉使用起来和 文本消息一模一样，  map的key和value只能是基本数据类型， 因此这种消息还是别用了吧  (sendMap)

5.  大文件消息  --  BlobMessage， 这个要配置HTTP文件服务器才能用，因此不推荐，一般也不会用MQ去发一个几G的视频吧?


spring整合后 如何发送durable请求 参看如下资料

http://blog.csdn.net/qh_java/article/details/62043886