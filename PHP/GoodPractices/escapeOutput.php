<?php
$output = '<script>alert("Backdoor installed");</script>';
echo htmlentities($output,ENT_QUOTES, 'UTF-8');

//some PHP template engines do this automatically. Search