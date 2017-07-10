<?php
try {
    //Validate email
    $email - filter_input(INPUT_POST, 'email', FILTER_VALIDATE_EMAIL);
    if (!$email) {
        throw new Exception('Invalid email');
    }

    //Validate password
    $password = filter_input(INPUT_POST, 'password');
    if (!$password || mb_strlen($password) < 8) {
        throw new Exception('Invalid email');
    }

    //Create password hash
    $passwordHash = password_hash($password, PASSWORD_DEFAULT, ['cost'=>12]);

    if ($passwordHash===false) {
        throw new Exception('Password hash failed');
    }

    
    println('Info to be saved in the database:');
    println('Email: '.$email);
    println('Hashed Password: '.$passwordHash);
} catch (Exception $e) {
    //Report error
    println($e->getMessage());
}

function println($msg)
{
    echo $msg.(php_sapi_name()==='cli' ? PHP_EOL : "</br>");
}
