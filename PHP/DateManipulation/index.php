<?php
require '../PrintlnComponent/src/Util/Util.php';

use Vitorota\Util\Util as Util;

const DT_FORMAT = 'd-m-y H:i:s';

//The default time-zone
Util::println('Default time-zone: '.date_default_timezone_get());

//Today
$today = new DateTime();
Util::println('Today:');
printDate($today);

//Operation with Date
$date = new DateTime();
$interval = new DateInterval('P2D'); //Two days
$date->add($interval);
Util::println('Date Add:');
printDate($date);

//Define a period of dates
$dateStart = new DateTime();
$dateInterval = DateInterval::createFromDateString('-1 day');
$datePeriod = new DatePeriod(
    $dateStart,
    $dateInterval,
    3,
    DatePeriod::EXCLUDE_START_DATE
);
Util::println('Date Period:');
foreach ($datePeriod as $dt) {
    printDate($dt);
}


function printDate($date)
{
    Util::println($date->format(DT_FORMAT));
}
