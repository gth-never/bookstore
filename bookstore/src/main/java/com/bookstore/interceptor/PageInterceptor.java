package com.bookstore.interceptor;

import com.bookstore.util.Page;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

/**
 * Created by never on 17-3-22.
 */
@Intercepts({@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class})})
public class PageInterceptor implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        //invocation里面有拦截到的对象 方法 参数
        StatementHandler statementHandler=(StatementHandler) invocation.getTarget();
        //创建一个可以方便访问StatementHandler属性的对象
        MetaObject metaObject=MetaObject.forObject(statementHandler,SystemMetaObject.DEFAULT_OBJECT_FACTORY,SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,new DefaultReflectorFactory());
        MappedStatement mappedStatement=(MappedStatement) metaObject.getValue("delegate.mappedStatement");
        //拿到配置文件里面sql语句的id
        String id=mappedStatement.getId();
        if(id.matches(".+ByPage$"))
        {
            BoundSql boundSql=statementHandler.getBoundSql();
            String sql=boundSql.getSql();//截获原始的sql语句
            String countSql="select count(*) from ("+sql+") a";
            Connection connection=(Connection)invocation.getArgs()[0];
            PreparedStatement countStatement=(PreparedStatement)connection.prepareStatement(countSql);
            ParameterHandler parameterHandler=(ParameterHandler) metaObject.getValue("delegate.parameterHandler");
            parameterHandler.setParameters(countStatement);//通过这个方法 给传入的PreparedStatement设置参数
            ResultSet rs=countStatement.executeQuery();
            //BoundSql里面有sql语句和所需参数
            Map<String,Object> map=(Map<String,Object>)boundSql.getParameterObject();
            Page page=(Page) map.get("page");
            if(rs.next())
            {
                page.setTotalNumber(rs.getInt(1));
                page.count();
            }
            String pageSql=sql+" limit "+page.getStartIndex()+","+page.getPageNumber();
            metaObject.setValue("delegate.boundSql.sql",pageSql);//将添加了分页的sql语句设置回去
        }
        return invocation.proceed();//放行了
    }

    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    public void setProperties(Properties properties) {

    }
}
