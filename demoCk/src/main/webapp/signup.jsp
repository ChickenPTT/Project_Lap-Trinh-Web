<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Văn Lang University - Đăng Ký</title>
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background: #f0f2f5;
            margin: 0;
        }

        .container {
            max-width: 400px;
            margin: 5% auto;
            padding: 20px;
            background: #ffffff;
            border-radius: 8px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #d32f2f;
        }

        label {
            display: block;
            margin-top: 10px;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        button {
            width: 100%;
            padding: 10px;
            font-size:16px;
            background: #d32f2f;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 15px;
        }

        button:hover {
            background: #b71c1c;
        }

        .link-button {
            width: 100%;
            padding: 10px;
            background: #1976d2;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }

        .link-button:hover {
            background: #1565c0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Dog Store - Đăng ký</h1>
        <form action="signup" method="post">
            <label for="username">Tên đăng nhập</label>
            <input type="text" name="username" required>

            <label for="password">Mật khẩu</label>
            <input type="password" name="password" required>

            <label for="email">Email</label>
            <input type="email" name="email" required>

            <button type="submit">Đăng Ký</button>
        </form>

        <a href="login.jsp" class="link-button">Đăng Nhập</a>
    </div>
</body>
</html>
