<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2024-10-11
  Time: 오후 3:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp"%>

<div class="row-content">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Search</h5>

            <form action="/todo/list" method="get">
                <input type="hidden" name="size" value="${pageRequestDTO.size}">

                <div class="mb-3">
                    <input type="checkbox" name="finished" ${pageRequestDTO.finished?"checked":""}>완료여부
                </div>

                <div class="mb-3">
                    <input type="checkbox" name="types" value="t" ${pageRequestDTO.checkType("t")?"checked":""}>제목
                    <input type="checkbox" name="types" value="w" ${pageRequestDTO.checkType("w")?"checked":""}>작성자
                    <input type="text"  name="keyword" class="form-control" value="${pageRequestDTO.keyword}">
                </div>
                <div class="input-group mb-3 dueDateDiv">
                    <input type="date" name="from" class="form-control" value="${pageRequestDTO.from}">
                    <input type="date" name="to" class="form-control" value="${pageRequestDTO.to}">
                </div>
                <div class="input-group mb-3">
                    <div class="float-end">
                        <button class="btn btn-primary" type="submit">Search</button>
                        <button class="btn btn-info clearBtn" type="reset">Clear</button>
<%--                        <input type="reset" value="Clear">--%>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>
<div class="row-content">
    <div class="card">
        <div class="card-header">
            Featured
        </div>
        <div class="card-body">
            <h5 class="card-title">Special title treatment</h5>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Tno</th>
                    <th scope="col">Title</th>
                    <th scope="col">Writer</th>
                    <th scope="col">DueDate</th>
                    <th scope="col">Finished</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${responseDTO.dtoList}" var="dto">
                    <tr>
                        <th scope="row">${dto.tno}</th>
                        <td><a href="/todo/read?tno=${dto.tno}&${pageRequestDTO.link}">${dto.title}</a></td>
                        <td>${dto.writer}</td>
                        <td>${dto.dueDate}</td>
                        <td>${dto.finished}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <nav aria-label="...">
                <ul class="pagination">
                    <c:if test="${responseDTO.prev}">
                        <li class="page-item">
                            <a class="page-link" data-num="${responseDTO.start-1}">Previous</a>
                        </li>
                    </c:if>

                    <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                        <li class="page-item ${responseDTO.page == num? "active":""}">
                            <a class="page-link" data-num="${num}">${num}</a>
                        </li>
                    </c:forEach>

                    <c:if test="${responseDTO.next}">
                        <li class="page-item">
                            <a class="page-link" data-num="${responseDTO.end+1}">Next</a>
                        </li>
                    </c:if>
                </ul>
            </nav>

            <script>

                document.querySelector(".pagination").addEventListener("click", function (e){
                    e.preventDefault()
                    e.stopPropagation()
                    const target=e.target
                    if(target.tagName !== 'A'){
                        return
                    }
                    const num=target.getAttribute("data-num") //페이지 num을 받았고,
                    const formObj=document.querySelector("form"); // form태그에서 formObj받고
                    formObj.innerHTML+=`<input type='hidden' name='page' value='\${num}'>`
                    // 이 폼에다가 페이지를 덧붙이는거지. 그리고 서브밋하면 검색어가 붙어서 나옴
                    formObj.submit()
                    //    self.location=`/todo/list?page=\${num}&\${pageRequestDTO.link}`
                    //crear 할때는 그냥 todo/list로 보내버리면 되겠네.
                    
                })
            </script>

        </div>
    </div>
</div>
<%@include file="../includes/footer.jsp"%>

