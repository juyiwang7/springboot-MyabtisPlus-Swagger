# springboot-MyabtisPlus-Swagger
springboot整合MybatisPlus和Swagger，并且使用代码生成器生成代码！

使用@Transitional切记不要再controller中使用，最好在Service层使用，否则可能会注入失败！

当发生找不到URL的时候，考虑@componentScan中加入basepackage的路径，或者是不是缺少@SpringbootApplication注解
