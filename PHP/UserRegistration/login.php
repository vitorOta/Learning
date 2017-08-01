<?php
session_start();
try {
    //Get email address from request body
    $email = filter_input(INPUT_POST, 'email');

    //Get password from request body
    $password = filter_input(INPUT_POST, 'password');

    //Pseudo-Code
    $passwordHash = getPassword($email);

    //Verify password with password hash
    if (password_verify($password, $passwordHash) ===false) {
        //just to learn, never inform that the problem is the password, just say 'Invalid Data'
        throw new Exception('Invalid password');
    }

    //Re-hash password if necessary
    $currentHashAlgorithm = PASSWORD_DEFAULT;
    $currentHashOptions = array('cost'=> 15);
    $passwordNeedsRehash = password_needs_rehash(
        $passwordHash,
        $currentHashAlgorithm,
        $currentHashOptions
    );
    if ($passwordNeedsRehash===true) {
        $passwordHash = password_hash(
            $password,
            $currentHashAlgorithm,
            $currentHashOptions
        );
        //Pseudo-Code (very ugly code)
        updatePassword($email,$passwordHash);

        $_SESSION['user_logged_in'] ='yes';
        $_SESSION['user_email'] =$email;

        //header
    }
} catch (Exception $e) {
    echo $e->getMessage();
}
