<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../includes/header.jsp"%>

<div class="row-content">
  <div class="card">
    <div class="card-header">
      Toto Modify
    </div>
    <div class="card-body">
      <h5 class="card-title">Todo Modify Page</h5>
      <form>
      <div class="input-group mb-3">
        <label class="input-grout-text">Tno</label>
        <input class="form-control" type="text" name="tno" value="${dto.tno}" readonly>
      </div>
      <div class="input-group mb-3">
        <label class="input-grout-text">Title</label>
        <input class="form-control" type="text" name="title" value="${dto.title}">
      </div>
      <div class="input-group mb-3">
        <label class="input-grout-text">DueDate</label>
        <input class="form-control" type="date" name="dueDate" value="${dto.dueDate}">
      </div>
      <div class="input-group mb-3">
        <label class="input-grout-text">Writer</label>
        <input class="form-control" type="text" name="writer" value="${dto.writer}" readonly>
      </div>
      <div class="form-check">
        <label class="form-check-label">Finished</label>
        <input class="form-check-input" name="finished" type="checkbox" ${dto.finished?"checked":""}>
      </div>

      <div class="my-4">
        <div class="float-end">
          <button type="button" class="btn btn-primary">Modify</button>
          <button type="button" class="btn btn-danger">Delete</button>
          <button type="button" class="btn btn-secondary">List</button>
        </div>
      </div>
      </form>
    </div>
    <script>
      const formObj = document.querySelector("form") //변수할당

      document.querySelector(".btn-primary").addEventListener("click", function (e) {
        e.preventDefault();
        e.stopPropagation();
        formObj.action = "/todo/modify";
        formObj.method = "POST";
        formObj.submit();
      }, false);

      document.querySelector(".btn-danger").addEventListener("click", function (e) {
        e.preventDefault();
        e.stopPropagation();
        formObj.action = "/todo/remove";
        formObj.method = "POST";
        formObj.submit();
      }, false);

      document.querySelector(".btn-secondary").addEventListener("click", function (e) {
        e.preventDefault();
        e.stopPropagation();
        self.location = `/todo/list?${pageRequestDTO.link}`;
        //self.location = "/todo/list";
      }, false)
    </script>
  </div>
</div>

<%@ include file="../includes/footer.jsp"%>
