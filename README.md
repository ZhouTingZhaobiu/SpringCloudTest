# SpringCloudTest

学习spring cloud搭建的简单demo，参考地址https://blog.csdn.net/forezp/article/details/70148833。
服务注册、发现、追踪、断路器、feign已经连通，后续将会以这个项目继续慢慢深化。

在服务追踪部分，自己参考博客写的遇到些问题，在这先记录，
zipkin追踪服务时，服务必须要有返回Sampler.ALWAYS_SAMPLE的方法，否则，zipkin不会记录，等于没有这个就没有像zipkin注册一样
调用顺序上面，我写了2个服务共同调用一个服务
eureka-client、service-hi共同都是调用的miya,
client、hi调用miya的miya的接口，同时miya被调用的接口又调用client、hi的返回String的接口hib。
