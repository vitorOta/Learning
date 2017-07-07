<?php
//1. Use Composer autoloader
 require 'vendor/autoload.php';
require '../component/src/Url/Scanner.php';

use League\Csv\Reader;

// use GuzzleHttp\Client;

//2. Instantiate Guzzle Httpl client
// $client = new Client();

//3. Open and iterate CSV
$array=["http://google.com", "https://vitorota.github.io", "https://asdfghjkl.com"];

$scan = new \OReilly\ModernPHP\Url\Scanner($array);

$invalids = $scan->getInvalidUrls();

foreach ($invalids as $key => $value) {
    echo $key." ->";
    foreach ($value as $k => $v) {
        echo $k.'->'.$v.PHP_EOL;
    }
}


// foreach ($csv as $csvRow) {
//     try {
//         //4. Send HTTP OPTIONS request
//         $httpResponse = $client->request('GET',$csvRow[0]);//         //5. Inspect HTTP response status code
//         if ($httpResponse->getStatusCode()>=400) {
//             throw new \Exception();
//         }
//     } catch (\Exception $e) {
//         //6. Send bad URLs to standard out
//         echo $csvRow[0].PHP_EOL;
//     }
// }

