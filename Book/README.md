# 书城项目总结

## 一、项目展示

![](web\static\img\index.png)

![](web\static\img\购物车.png)

![](web\static\img\login.png)

![](web\static\img\regist.png)

## 二、项目目录展示

![](web\static\img\分层图.png)

对应的目录存放对应的资源，不同的目录下存放相同功能的类

## 三、项目细节

### 抽象的应用

#### Servlet中的抽象

将对于Servlet中对应方法的访问，用反射进行简化，这样就不用多个if-else进行判断，提高了系统的可扩展性。对应的Servlet只要在请求路径中加入action参数，后面跟上具体的方法名，就可以实现对该方法的调用。自己实现Servlet的时候，需要继承这个Servlet。

```java

public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
```

#### Dao中的抽象

所有的DAO都需要对数据库访问，在BaseDao中封装一系列的访问方法，这样对应的DAO访问的时候只要写好Sql语句，将语句和参数传入方法中就可以了。

```java
public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    public int update(String sql,Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return  -1;
    }
}
```

#### JSP中的抽象

对于jsp中多个页面出现的页脚，页眉，单独写一个jsp用静态包含的方法引入

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
</div>

//需要页脚的时候，通过下面的方式引入
<%@include file="/pages/common/footer.jsp"%>
```

#### 分页功能抽象

见web/pages/common/page_nav.jsp页面，这是对jsp的抽象

下面是对Page分页功能的抽象。

```
  public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();

        page.setPageSize(pageSize);

        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0){
            pageTotal+=1;
        }
        page.setPageTotal(pageTotal);

        if(pageNo<1){
            pageNo=1;
        }
        if (pageNo>pageTotal){
            pageNo = pageTotal;
        }
        page.setPageNo(pageNo);

        int begin = (page.getPageNo()-1)*pageSize;
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
        page.setItems(items);

        return page;
    }
```

### 项目中值得注意的点
1. 错误页面的应用，出现500,404错误跳转相应的错误页面

   ```xml
    <error-page>
           <error-code>500</error-code>
           <location>/pages/error/error.jsp</location>
       </error-page>
   
       <error-page>
           <error-code>404</error-code>
           <location>/pages/error/error404.jsp</location>
       </error-page>
   ```
2. Filter的应用，用来进行权限管理

   ```xml
     <filter>
           <filter-name>ManagerFilter</filter-name>
           <filter-class>com.syn.filter.ManagerFilter</filter-class>
       </filter>
       <filter-mapping>
           <filter-name>ManagerFilter</filter-name>
           <url-pattern>/pages/manager/*</url-pattern>
           <url-pattern>/manager/bookServlet</url-pattern>
       </filter-mapping>
   ```

3. Junit单元测试的应用

专门生成相应的测试包，用来进行测试，ctrl+shift+t生成测试接口

4. 表单重复提交

   ![](web\static\img\表单重复提交.png)

第二种，第三种可以用验证码来解决