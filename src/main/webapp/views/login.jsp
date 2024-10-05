<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <title>Login</title>
    <style>
        form {
            border: 3px solid #f1f1f1;
            width: 100%;
            max-width: 600px;
            margin: auto;
        }

        /* Full-width inputs */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        /* Set a style for all buttons */
        button {
            background-color: #04AA6D;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        /* Add a hover effect for buttons */
        button:hover {
            opacity: 0.8;
        }

        /* Extra style for the cancel button (red) */
        .cancelbtn {
            width: auto;
            padding: 10px 18px;
            background-color: #f44336;
        }

        /* Center the avatar image inside this container */
        .imgcontainer {
            text-align: center;
            margin: 24px 0 12px 0;
        }

        /* Avatar image */
        img.avatar {
            width: 40%;
            border-radius: 50%;
        }

        /* Add padding to containers */
        .container {
            padding: 16px;
        }

        /* The "Forgot password" text */
        span.psw {
            float: right;
            padding-top: 16px;
        }

        /* Change styles for span and cancel button on extra small screens */
        @media screen and (max-width: 300px) {
            span.psw {
                display: block;
                float: none;
            }
            .cancelbtn {
                width: 100%;
            }
        }
    </style>
</head>
<body>
<!-- BEGIN CONTENT -->
<div class="col-md-9 col-sm-9">
    <h1>Login</h1>
    <div class="content-form-page">
        <div class="row">
            <div class="col-md-7 col-sm-7">
                <form class="form-horizontal form-without-legend" role="form" method="post" action="/LTWebProject/login">

                    <div class="form-group">
                        <label for="uname" class="col-lg-4 control-label">Username <span class="require">*</span></label>
                        <div class="col-lg-8">
                            <input type="text" class="form-control" id="uname" name="uname">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="psw" class="col-lg-4 control-label">Password <span class="require">*</span></label>
                        <div class="col-lg-8">
                            <input type="text" class="form-control" id="psw" name="psw">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-8 col-md-offset-4 padding-left-0">
                            <a href="page-forgotton-password.html">Forget Password?</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-10 padding-right-30">
                            <hr>
                            <div class="login-socio">
                                <p class="text-muted">or login using:</p>
                                <ul class="social-icons">
                                    <li><a href="#" data-original-title="facebook" class="facebook" title="facebook"></a></li>
                                    <li><a href="#" data-original-title="Twitter" class="twitter" title="Twitter"></a></li>
                                    <li><a href="#" data-original-title="Google Plus" class="googleplus" title="Google Plus"></a></li>
                                    <li><a href="#" data-original-title="Linkedin" class="linkedin" title="LinkedIn"></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-4 col-sm-4 pull-right">
                <div class="form-info">
                    <h2><em>Important</em> Information</h2>
                    <p>Duis autem vel eum iriure at dolor vulputate velit esse vel molestie at dolore.</p>

                    <button type="button" class="btn btn-default">More details</button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- END CONTENT -->
</body>
</html>
