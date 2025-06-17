<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap demo</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    </head>
    <body>

        <nav class="navbar navbar-dark bg-dark">
            <div class="container-fluid">
                <div class="col-md-3 text-center">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="addemp.jsp"><h4 class="text-success">Add Emp</h4></a>
                </li>
                </div>
                <div class="col-md-3 text-center">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.jsp"><h4 class="text-warning"> All Emp</h4></a>
                </li>
                </div>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </nav>
