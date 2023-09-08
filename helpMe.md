# 1.SpringBoot视图层技术thymeleaf-URL表达式
######html中是这样的
****
    <a th:href="@{http://www.baidu.com}">Thymeleaf绝对路径-百度</a><br/>
    <a href="http://www.baidu.com">html绝对路径-百度</a>
    <hr/>
    <a th:href="@{/show}">相对路径</a>
    <hr/>
    <a th:href="@{~/images/java.jpg}">相对于服务器的根</a>
    <hr/>
    <a th:href="@{/page(id=1,name=zhangsan)}">相对路径-传参</a>
    <hr/>
    <a th:href="@{/article/details/{articleId}(articleId=1001)}">相对路径-restful</a>
****
######js中如何书写呢？
****
    XXXXXX
****

###### 2.SpringBoot视图层技术thymeleaf-URL表达式