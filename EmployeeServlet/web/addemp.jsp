<%@include file="header.jsp" %>

<div class="container my-3">
    <div class="bg-warning text-center">
        <h1 class="jumborton">Add Employee</h1>
    </div>
    <!--    start form-->
    <form action="empServlet"  method="post">
        <input type="hidden" name="action" value="add">
        
        <div class="row">
            <div class="col-md-6">
                <label for="exampleInputEmail1" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Full Name">
            </div>

            <div class="col-md-6">
                <label for="exampleInputEmail1" class="form-label">Email</label>
                <input type="text" class="form-control" id="email" name="email" placeholder="example@gmail.com">
            </div>        
        </div>
        <!-- start 2nd row-->
        <div class="row mt-3">
            <div class="col-md-6">
                <label  class="form-label">Designation</label>
                <select class="form-select" name="designation" aria-label="Default select example">
                    <option selected>Select One</option>
                    <option value="Manager">Manager</option>
                    <option value="Programmer">Programmer</option>
                    <option value="Cashier">Cashier</option>
                    <option value="User">User</option>                    
                </select>
            </div>

        </div>

        <div class="row">
            <div class="col-md-6">
                <label for="exampleInputEmail1" class="form-label">Salary</label>
                <input type="text" class="form-control" id="contactNo" name="salary" placeholder="Salary">
            </div>

        </div>

        <div class="row mt-3 text-center">
            <div class="col-md-6">
                <button type="submit" class="btn btn-success text-center" >Save</button>

            </div>

            <div class="col-md-6">
                <button type="reset" class="btn btn-warning text-center" >Reset</button>

            </div>
        </div>
    </form>

    <!--end form    -->
</div>


<%@include file="footer.jsp" %>
