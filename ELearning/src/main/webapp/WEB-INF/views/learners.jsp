<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title>Hello, world!</title>
  </head>
  <body>
        <div class="container mt-5" id="signin">
            <ul class="nav nav-tabs nav-pills" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                  <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">Sign in </button>
                </li>
                <li class="nav-item" role="presentation">
                  <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">Sign up</button>
                </li>
              </ul>
              <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                  <form class="needs-validation" novalidate action="loginProcess" method="post">
                    <div class="mb-3">
                      <label for="exampleInputEmail1" class="form-label">Email address</label>
                      <input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required>
                      <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                      <div class="valid-feedback">
                        Looks good!
                      </div>
                      <div class="invalid-feedback" id="wrong">
                        You entered wrong email formate or you haven't entered.
                      </div>
                    </div>
                    <div class="mb-3">
                      <label for="pass" class="form-label">Password</label>
                      <input type="password" class="form-control" name="email" id="pass" required>
                    </div>
                    <div class="mb-3 form-check">
                      <input type="checkbox" class="form-check-input" id="exampleCheck1" required>
                      <label class="form-check-label" for="exampleCheck1">Check me out</label>
                    </div>
                    <input class="btn btn-success" type="submit" name="submit">
                  </form>
                </div>
                <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                    <div id="registration">
                      <form class="needs-validation" novalidate action="add" method="post">
                        <div class="mb-3">
                            <label for="InputFirstName" class="form-label">First Name</label>
                            <input type="text" class="form-control" id="InputFirstName" name="firstName" aria-describedby="InputFirstNameHelper" pattern="^[A-Za-z]+$" required>
                            <div id="InputFirstNameHelper" class="form-text">Ex:- Chathuranga</div>
                            <div class="valid-feedback">
                              Looks good!
                            </div>
                            <div class="invalid-feedback">
                              Invalid First Name!
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="InputLastName" class="form-label">Last Name</label>
                            <input type="text" class="form-control" name="lastName" id="InputLastName" aria-describedby="InputLastNameHelper" pattern="^[A-Za-z]+$" required>
                            <div id="InputLastNameHelper" class="form-text">Ex:- Tennakoon</div>
                            <div class="valid-feedback">
                              Looks good!
                            </div>
                            <div class="invalid-feedback">
                              Invalid Last Name!
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="InputUserName" class="form-label">User Name</label>
                            <input type="text" class="form-control" name="userName" id="InputUserName" aria-describedby="InputUserNameeHelper" required>
                            <div id="InputUserNameHelper" class="form-text">Ex:- Bandara</div>
                            <div class="valid-feedback">
                              Looks good!
                            </div>
                        </div>
                        <div class="mb-3">
                          <label for="exampleInputEmail1" class="form-label">Email address</label>
                          <input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required>
                          <div id="emailHelp" class="form-text">Ex:qwertyuio@gmail.com</div>
                          <div class="invalid-feedback">
                            Invalid Email address!
                          </div>
                        </div>
                        <div class="mb-3">
                          <label for="exampleInputPassword1" class="form-label">Password</label>
                          <input type="password" class="form-control" name="pass" id="exampleInputPassword1" required>
                        </div>
                        <div class="mb-3">
                            <label for="InputPasswordRe" class="form-label">Re-Enter Password</label>
                            <input type="password" class="form-control" id="InputPasswordRe" name="password" required>
                          </div>
                        <div class="mb-3">
                          <label class="form-label" for="typeNumber">Number of Courses taken</label> 
                          <input type="number" id="typeNumber" name="numberOfCoursesTaken" class="form-control" required/>                        
                        </div>
                        <button type="submit" class="btn btn-success">Submit</button>
                      </form>
                    </div>
                </div>
              </div> 
        </div>         
    <!-- Optional JavaScript; choose one of the two! -->
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
    <script>
      // Example starter JavaScript for disabling form submissions if there are invalid fields
      (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
          .forEach(function (form) {
            form.addEventListener('submit', function (event) {
              if (!form.checkValidity()) {
                event.preventDefault()
                event.stopPropagation()
              }

              form.classList.add('was-validated')
            }, false)
          })
      })()
    </script>
  </body>
</html>
