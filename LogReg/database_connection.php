<?php
    $conn = new mysqli("localhost", "root", "gCEk4bteN)QgwfbA", "db_android_login");

    if ($conn->connect_error) {
        echo json_encode(["status" => "error", "message" => "Database connection failed"]);
        exit();
    }
?>