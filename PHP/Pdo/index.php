<?php
require 'vendor/autoload.php';
require('settings.php');

use Vitorota\Util\Util;

try {
    //Connect
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

    //Prepare Statement
    $sql = 'SELECT * FROM Usuario WHERE Email = :email OR Id = :id';
    $stm = $pdo->prepare($sql);

    $email = 'b.allen@csi.com'; //filter_input(INPUT_GET, 'email');
    $stm->bindValue(':email', $email);

    $id = 2; //filter_input(INPUT_GET, 'id');
    //by default, this method interpret the param as a string, in other cases, you need specify the parameter's type
    $stm->bindValue(':id', $id, PDO::PARAM_INT);

    //Query
    $stm->execute();
    
    while (($result = $stm->fetch(PDO::FETCH_ASSOC)) !== false) {
        echo $result['Email'].PHP_EOL;
        //Util::println($result['email']);
    }
} catch (PDOException $e) {
    echo $e->getMessage().PHP_EOL;
    //Util::println($e->getMessage());
}
