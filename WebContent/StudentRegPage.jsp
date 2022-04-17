<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>

<script>
	// Data Picker Initialization
	$('.datepicker').datepicker({
		inline : true
	});
</script>

<style>
.card-registration .select-input.form-control[readonly]:not([disabled])
	{
	font-size: 1rem;
	line-height: 2.15;
	padding-left: .75em;
	padding-right: .75em;
}

.card-registration .select-arrow {
	top: 13px;
}

.h-100 .bg-blue {
	background-color: blue;
}
</style>

</head>

<body>

	<section class="h-100" style="background-color: powderblue;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col">
					<div class="card card-registration my-4">
						<div class="row g-0">
							<div class="col-xl-6 d-none d-xl-block">
								<img
									src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img4.webp"
									alt="Sample photo" class="img-fluid"
									style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
							</div>
							<div class="col-xl-6">
								<div class="card-body p-md-5 text-black">
									<center>
										<h3 class="mb-5 text-uppercase">Student registration form</h3>
										<center>${errormsg1}</center>
									</center>

									<form action="Assignment_2" method="post">

										<div>
											<div class="mb-4">
												<div class="form-outline">
													<input type="number" id="form3Example1m"
														class="form-control form-control-lg" name="sid"
														placeholder="Student ID" required />
												</div>

											</div>
											<div class="mb-4">
												<div class="form-outline">
													<input type="text" id="form3Example1m"
														class="form-control form-control-lg" name="sfname"
														value="${fname }" placeholder="First name" required />
												</div>
												<font color="RED"> ${fnameError } </font>
											</div>
											<div class="mb-4">
												<div class="form-outline">
													<input type="text" id="form3Example1n"
														class="form-control form-control-lg" name="slname"
														value="${lname }" placeholder="Last Name" />
												</div>
												<font color="RED"> ${lnameError } </font>
											</div>
										</div>

										<div>

											<div class="mb-4">
												<div class="form-outline">
													<input type="text" id="form3Example1n1"
														class="form-control form-control-lg" name="smname"
														value="${mname }" placeholder="Father's name" required />

												</div>
												<font color="RED"> ${mnameError } </font>
											</div>
										</div>

										<div
											class="d-md-flex justify-content-start align-items-center mb-4 py-2">

											<h6 class="mb-0 me-4">Gender:</h6>

											<div class="form-check form-check-inline mb-0 me-4">
												<input class="form-check-input" type="radio" name="sgender"
													id="femaleGender" value="Femal" /> <label
													class="form-check-label" for="femaleGender">Female</label>
											</div>

											<div class="form-check form-check-inline mb-0 me-4">
												<input class="form-check-input" type="radio" name="sgender"
													id="maleGender" value="Male" /> <label
													class="form-check-label" for="maleGender">Male</label>
											</div>

											<div class="form-check form-check-inline mb-0">
												<input class="form-check-input" type="radio" name="sgender"
													id="otherGender" value="Other" /> <label
													class="form-check-label" for="otherGender">Other</label>
											</div>

										</div>
										<div
											class="d-md-flex justify-content-start align-items-center mb-4 py-2">
											<h6 class="mb-0 me-4">DOB:</h6>
											<br>

											<div>
												<input class="form-control" type="date" value="2001-01-01"
													name="sdob" placeholder="DOB" id="example-date-input"
													min="1997-01-01" max="2003-12-31">
											</div>
										</div>

										<div class="form-outline mb-4">
											<input type="text" id="form3Example9"
												class="form-control form-control-lg" name="sphone"
												value="${phone }" placeholder="Phone" required /> <font
												color="RED"> ${phoneError } </font>
										</div>


										<div class="form-outline mb-4">
											<input type="text" id="form3Example90"
												class="form-control form-control-lg" name="semail"
												value="${email }" placeholder="Email" /> <font color="RED">
												${emailError } </font>
										</div>
										
										<div class="form-outline mb-4">
											<input type="password" id="form3Example90"
												class="form-control form-control-lg" name="spassword"
												value="${email }" placeholder="Password" /> <font color="RED">
												${emailError } </font>
										</div>

										<br>
										<center>
											<input type="reset"
												class="btn btn-secondary btn-lg btn-block"
												style="width: 45%">&nbsp;&nbsp;&nbsp;&nbsp;
											<button type="submit"
												class="btn btn-primary btn-lg btn-block" style="width: 45%">Register</button>
										</center>
									</form>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>

</html>