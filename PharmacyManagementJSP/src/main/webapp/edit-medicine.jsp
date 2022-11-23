<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ pageisELIgnored="false" %>
<%@page import="in.techdenovo.apps.model.Medicine"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <div class="container-fluid">
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
          <a class="navbar-brand" href="index.jsp">Pharmacy Management</a>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a
                  class="nav-link active"
                  aria-current="page"
                  href="add-medicine.jsp"
                  >Add Medicine</a
                >
              </li>
              <li class="nav-item">
                <a class="nav-link" href="search-medicine.jsp"
                  >Search Medicine</a
                >
              </li>

            </ul>
          </div>
        </div>
      </nav>
    </div>
    <div class="row">
      <div class="col-2"></div>
      <div class="col-12 col-md-8">
        <div class="container">
          <% Medicine medicine = (Medicine)request.getAttribute("medicine");
                 if(medicine!=null){%>
          <form
            action="${pageContext.request.contextPath}/editmedicine"
            method="post"
          >
            <div class="mb-6">
              <h2>Edit Medicine</h2>
              <br />
            </div>
            <div class="mb-3">
              <label for="uname" class="form-label">Medicine Code :</label>
            </div>
            <div class="mb-3">
              <input           

              class="form-control"
                type="text"
                id="uname"
                value="<%=medicine.getMedicineCode()%>"
                name="medicine-code"
                placeholder="Enter Medicine Code"
                readonly
              />
            </div>
            <div class="mb-3">
              <label for="uname" class="form-label">Medicine Name :</label>
            </div>
            <div class="mb-3">
              <input
                class="form-control"
                type="text"
                id="uname"
                name="medicine-name"
                value="<%=medicine.getMedicineName()%>"
                placeholder="Enter Medicine Name"
              />
            </div>
            <div class="mb-3">
              <label for="fname" class="form-label">Medicine Qauntity :</label>
            </div>
            <div class="mb-3">
              <input
                class="form-control"
                type="pass"
                id="pass"
                name="medicine-quantity"
              value="<%=medicine.getQuantity()%>"
                placeholder="Enter Quantity"
              />
            </div>
            <div class="mb-3">
              <label for="fname" class="form-label">Medicine Brand :</label>
            </div>
            <div class="mb-3">
              <input
                class="form-control"
                type="pass"
                id="pass"
                name="medicine-brand"
                value="<%=medicine.getBrand()%>"
                placeholder="Enter Brand"
              />
            </div>
            <div class="mb-3">
              <label for="fname" class="form-label">Medicine Price</label>
            </div>
            <div class="mb-1">
              <input
                class="form-control"
                type="pass"
                id="pass"
                name="medicine-price"
                value="<%=medicine.getPrice()%>"
                placeholder="Enter Price"
              />
              <br />
            </div>
                <% } %>
            <div class="d-grid gap-2">
              <button class="btn btn-primary" type="submit" >EDIT</button>
            </div>

          </form>
        </div>
      </div>
      <div class="col-2"></div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
