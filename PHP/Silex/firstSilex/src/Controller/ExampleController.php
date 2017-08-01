<?php
use Silex\Application;
use Symfony\Component\HttpFoundation\Request;

namespace Vitorota\Controller;

class ExampleController{

    //__FUNCTION__ get the name of the running function
    //(can't use a general function, because the name returned will be of the general function)

    public function get(){
        return 'function "'.__FUNCTION__.'" from exampleController';
    }

    public function post(){
        return 'function "'.__FUNCTION__.'" from exampleController';
    }

    public function xablau(){
        return 'function "'.__FUNCTION__.'" from exampleController';        
    }
}