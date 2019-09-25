# springboot-MyabtisPlus-Swagger
springboot整合MybatisPlus和Swagger，并且使用代码生成器生成代码！

使用@Transitional切记不要再controller中使用，最好在Service层使用，否则可能会注入失败！

当发生找不到URL的时候，考虑@componentScan中加入basepackage的路径，或者是不是缺少@SpringbootApplication注解

#### 测试自定义SQL语句
     * 1.首先在Mapper中使用注解写好SQL语句，这时候的Mapper就相当于Dao层（也可以用Mapper.xml的注解形式完成SQL语句）
     * 2.然后在对应的service中写一样的方法
     * 3.在serviceImpl中，具体写这个方法，主要是调用Mapper的方法。
     * 4.Mapper一般不能自动注入，所以需要在Mapper上加上@Component，使其可以自动注入
