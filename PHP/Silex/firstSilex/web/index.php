<?php
require_once __DIR__.'/../vendor/autoload.php';

use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Vitorota\Exception\SpecificException;

$app = new Silex\Application();

//normal method
$app->get('/', function () {
 //is possible get the Application and Request passing both as parameters
    return 'Hello World';
});

//with parameter
$app->get('/number/{id}', function ($id) {
    return 'The number is '.$id;
});

//post
$app->post('/teste', function (Request $req) {
    $id = $req->get('id');
    return new Response('Fake insertion of '.$id, 201);
});

//altering/converting param before use
$app->get('/convert/{n}', function ($n) {
    return 'Number altered = '.$n;
})->convert('n', function ($n) {
    return 100+ $n;
});


//match only certain expressions (in this example, just strings starting with 't', using regex)
//is possible chain calls of assert() to match more than one parameter
$app->get('/assert/{n}', function ($n) {
    return 'This "'.$n.'" is valid !';
})->assert('n', 't.*');

//is possible put conditions to the method (i.e. attend just requests coming from some user-agent).
//I'm too lazy in this moment to do this, but the link is https://silex.symfony.com/doc/2.0/usage.html#requirements

//...

//defining a default value to a parameter
$app->get('/defaultValue/{msg}', function ($msg) {
    return 'The message is: '.$msg;
})->value('msg', 'default Message !');

//naming a route
$app->get('/namedRoute', function () {
    return 'This route have a name';
})->bind('named_route');

//using a Controller class
$app->get('/example', 'Vitorota\\Controller\\ExampleController::get');
//The route don't need match with the function name, but I think that this is a good practice
$app->get('/example/xablau', 'Vitorota\\Controller\\ExampleController::xablau');
$app->post('/example', 'Vitorota\\Controller\\ExampleController::post');


//Handling error's
    //specific Exception
$app->error(function (SpecificException $e, Request $request, $code) {
    return new Response('<div style="border:25px solid darkblue; background-color: darkred; color:white; padding:10px; font-size:5em;">SPECIFIC EXCETPION</div>');
});

//method to throw a Exception
$app->get('/throwException/{specific}', function ($specific) {

    if($specific==='true'){
        throw new SpecificException();
    }
    throw new Exception('look, a Exception !');

})->value('specific', false);

//general
$app->error(function (Exception $e, Request $request, $code) {
    return new Response('<div style="background-color: darkred; color:white; padding:10px; font-size:2em;">'.$e->getMessage().'</div>');
});

//run...
    $app->run();
