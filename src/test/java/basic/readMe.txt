这里是Java这边使用ActiveMQ的 基本API用法，  可从基本中了解到原理， 再去理解和spring继承就比较简单

建议从QueueProducer.java开始看  , 概念网址   http://blog.csdn.net/dwc_fly/article/details/10241345

Queue为点对点模式  
1 QueueProducer   -----发消息--->  1 QueueConsumer

Topic为订阅模式
1 TopicProducer   -----发消息---> 多个TopicConsumer


持久化订阅 （只针对topic模式有效,queue天生自带持久化，消息没消费之前一直在队列）

durable包介绍的是  持久订阅， 持久订阅的意思是，消息的接受者即便是下线了，当他再次上线的时候，还能读到他未读的消息。 这种叫持久模式。

持久化订阅，耗费很大资源，实际生产要权衡考虑.


                             
在线     意思是连接到ActiveMQ服务器
下线    与服务器断开连接