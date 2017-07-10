<?php
namespace Vitorota\Util;

class Util
{
    public static function println($msg){
        echo $msg.(php_sapi_name()==='cli' ? PHP_EOL : "</br>");
    }
}
