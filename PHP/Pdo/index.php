<?php
include('../settings.php');

try{
$pdo=new PDO(
        sprintf(
            'mysql:host=%s;dbname=%s;port=%s;charset=%s', 
            $settings['host'],
            $settings['name'],
            $settings['port'],
            $settings['charset']
        ),
        $settings['username'],
        $settings['password']
    );

}catch(PDOException $e){
    
}