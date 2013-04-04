<?php
$arr = array('foo', 'bar');

file_put_contents('a.json', json_encode($arr));

$arr = array('foo1', 'bar');

file_put_contents('b.json', json_encode($arr));

