<?php
// Sanitize input
$input="<p><script>alert('teste')</script></p>";
$inputSafe =htmlentities($input, ENT_QUOTES, 'UTF-8');
println($inputSafe);

// Sanitize email
$email = '(vitor@exampl//e.com)';
$emailSafe = filter_var($email, FILTER_SANITIZE_EMAIL);
println($emailSafe);

// Sanitize international chars
$string = "\nIñtërnâtiônàlizætiøn\t";
$stringSafe = filter_var($string, FILTER_SANITIZE_STRING, FILTER_FLAG_STRIP_LOW | FILTER_FLAG_ENCODE_HIGH);
println($string);
println($stringSafe);


function println($msg){
    echo $msg.(php_sapi_name()==='cli' ? PHP_EOL : "</br>");
}