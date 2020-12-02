<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/12/2
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <c:if test="${page.pageNo>1}">
        <a href="${page.url}&pageNo=1">首页</a>
        <a href="${page.url}&pageNo=${page.pageNo-1}">上一页</a>
    </c:if>

    <c:choose>
        <c:when test="${page.pageTotal<=5}">
            <c:forEach begin="1" end="${page.pageTotal}" var="i">
                <c:if test="${i==page.pageNo}">
                    【${i}】
                </c:if>
                <c:if test="${i!=page.pageNo}">
                    <a href="${page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>
        </c:when>

        <c:when test="${page.pageTotal>5}">
            <c:choose>
                <c:when test="${page.pageNo<=3}">
                    <c:forEach begin="1" end="5" var="i">
                        <c:if test="${i==page.pageNo}">
                            【${i}】
                        </c:if>
                        <c:if test="${i!=page.pageNo}">
                            <a href="${page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>

                <c:when test="${page.pageNo>=page.pageTotal-3}">
                    <c:forEach begin="${page.pageTotal-4}" end="${page.pageTotal}" var="i">
                        <c:if test="${i==page.pageNo}">
                            【${i}】
                        </c:if>
                        <c:if test="${i!=page.pageNo}">
                            <a href="${page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>

                <c:otherwise>
                    <c:forEach begin="${page.pageNo-2}" end="${page.pageNo+2}" var="i">
                        <c:if test="${i==page.pageNo}">
                            【${i}】
                        </c:if>
                        <c:if test="${i!=page.pageNo}">
                            <a href="${page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </c:when>

    </c:choose>


    <c:if test="${page.pageNo<page.pageTotal}">
        <a href="${page.url}&pageNo=${page.pageNo+1}">下一页</a>
        <a href="${page.url}&pageNo=${page.pageTotal}">末页</a>
    </c:if>
    共${page.pageTotal}页，${page.pageTotalCount}条记录
    到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
    <script type="text/javascript">
        $(function () {
            $("#searchPageBtn").click(function () {
                var pageNo = $("#pn_input").val();
                location.href="${basePath}${page.url}&pageNo="+pageNo;

            })
        })
    </script>
</div>