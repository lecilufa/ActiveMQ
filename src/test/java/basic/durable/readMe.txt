持久化一般是指对 topic的 持久化,  queue天生自带持久化，消息没消费之前一直在队列

topic消息持久化测试步骤如下

必须先注册consumer，  再发布消息才能看到效果

先运行 consumer， 再关闭程序，  可在管理页面看到 Offline Durable Topic Subscribers 有你的clientId
说明已经注册成功


留意Pending Queue Size   此时是0

当你运行producer的时候  Pending Queue Size 会+1

再运行 再 +1  

此时再运行 consumer， 一上线马上把所有的 Pending Queue 推给你， 你就能看到所有的离线消息全部打印出来

就是这么个运用原理



持久化 topic这种模式  
1. consumer必须指定clientId  
2. producer设定  producer.setDeliveryMode(DeliveryMode.PERSISTENT);



queue模式天生自带消息持久化， 即 发出去的消息没被消费之前会一直保留在服务器，直到被消费为止
可以多个consumer一起消费一个queue， 他们会分摊之。