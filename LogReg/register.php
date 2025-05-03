<?php
header('Content-Type: application/json');
error_reporting(E_ALL);
ini_set('display_errors', 1);

require_once 'database_connection.php';

$username = $_POST['username'] ?? '';
$password = $_POST['password'] ?? '';
$firstName = $_POST['firstName'] ?? '';
$lastName = $_POST['lastName'] ?? '';
$email = $_POST['email'] ?? '';
$type = $_POST['type'] ?? '';

$check = $conn->prepare("SELECT * FROM users WHERE username = ?");
$check->bind_param("s", $username);
$check->execute();
$result = $check->get_result();

if ($result->num_rows > 0) {
    echo json_encode(["status" => "error", "message" => "Username already taken"]);
} else {
    $stmt1 = $conn->prepare("INSERT INTO users (username, password) VALUES (?, ?)");
    $stmt1->bind_param("ss", $username, $password);

    if ($stmt1->execute()) {
        $stmt2 = $conn->prepare("INSERT INTO user_credentials (firstName, lastName, typeRegister, umak_email) VALUES (?, ?, ?, ?)");
        $stmt2->bind_param("ssss", $firstName, $lastName, $type, $email);

        if ($stmt2->execute()) {
            echo json_encode(["status" => "success"]);
        } else {
            echo json_encode(["status" => "error", "message" => "Failed to insert user credentials"]);
        }

        $stmt2->close();
    } else {
        echo json_encode(["status" => "error", "message" => "Failed to create user"]);
    }

    $stmt1->close();
}

$check->close();
$conn->close();
?>