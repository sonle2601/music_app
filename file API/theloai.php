<?php
require("connect.php");

class theloai {
    function __construct($IdTheLoai,$IdChuDe , $TenTheLoai, $HinhTheLoai) {
        $this->IdTheLoai = $IdTheLoai;
        $this->IdChuDe = $IdChuDe;
        $this->TenTheLoai = $TenTheLoai;
        $this->HinhTheLoai = $HinhTheLoai;

    }
}
$querytheloai = "SELECT DISTINCT * FROM theloai ORDER BY RAND(". date("Ymd"). ") LIMIT 4";
$datatheloai = mysqli_query($con, $querytheloai);

$mangtheloai = array();
    while ($row = mysqli_fetch_assoc($datatheloai)){
        array_push($mangtheloai, new theloai($row['IdTheLoai']
                                                ,$row['IdChuDe']
                                                ,$row['TenTheLoai']
                                                ,$row['HinhTheLoai']));
    }

    $response = array(
        "message" => "Success",
        "status" => 1,
        "data" => $mangtheloai
    );

    echo json_encode($response);

?>