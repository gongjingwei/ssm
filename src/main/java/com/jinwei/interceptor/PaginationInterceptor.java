package com.jinwei.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.io.Serializable;
import java.util.Properties;

/**
 * 创建人: 金伟
 * 描述: MyBatis分页插件
 * 创建时间: 2019/7/15 0015 - 下午 3:55
 **/

@Intercepts({
        @Signature(type = StatementHandler.class, method = "query", args = {java.sql.Statement.class})
})
public class PaginationInterceptor implements Interceptor, Serializable {


    //TODO 未实现分页

    public Object intercept(Invocation invocation) throws Throwable {

        System.out.println("intercept...intercept:" + invocation.getMethod());


        //动态的改变一下sql运行的参数：以前1号员工，实际从数据库查询3号员工
        Object target = invocation.getTarget();

        System.out.println("当前拦截到的对象：" + target);

        //拿到：StatementHandler==>ParameterHandler===>parameterObject
        //拿到target的元数据
        MetaObject metaObject = SystemMetaObject.forObject(target);
        Object value = metaObject.getValue("parameterHandler.parameterObject");

        System.out.println("sql语句用的参数是：" + value);
        //修改完sql语句要用的参数
        metaObject.setValue("parameterHandler.parameterObject", 3);

        //metaObject.getValue()可以取到拦截目标对象StatementHandler 里面的属性；在BaseStatementHandler里看StatementHandler所有可以取到属性
        Object mappedStatement = metaObject.getValue("parameterHandler.mappedStatement");

        System.out.println("mappedStatement：" + mappedStatement);
        //执行目标方法
        Object proceed = invocation.proceed();
        //返回执行后的返回值
        return proceed;

    }

    public Object plugin(Object target) {

        //我们可以借助Plugin的wrap方法来使用当前Interceptor包装我们目标对象
        System.out.println("ExamplePlugin...plugin:mybatis将要包装的对象" + target);

        Object wrap = Plugin.wrap(target, this);

        //返回为当前target创建的动态代理
        return wrap;

    }

    public void setProperties(Properties properties) {

        System.out.println("获得的属性:" + properties.toString());

    }


}

    