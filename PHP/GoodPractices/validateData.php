<?php
// Validate email
$input = 'vitor@email.com';
$isEmail = filter_var($input, FILTER_VALIDATE_EMAIL);

if ($isEmail!==false) {
    echo "Success";
}else{
    echo "Fail";
}