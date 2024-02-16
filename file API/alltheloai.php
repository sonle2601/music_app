<?php
    require "connect.php";

    $query = "SELECT * FROM theloai ";
    class Theloai {
        function __construct($IdTheLoai,$IdChuDe , $TenTheLoai, $HinhTheLoai) {
            $this->IdTheLoai = $IdTheLoai;
            $this->IdChuDe = $IdChuDe;
            $this->TenTheLoai = $TenTheLoai;
            $this->HinhTheLoai = $HinhTheLoai;
    
        }
    }

    $data = mysqli_query($con, $query);

    $mangchude = array();
    while ($row = mysqli_fetch_assoc($data)){
        array_push($mangchude, new Theloai($row['IdTheLoai']
                                                ,$row['IdChuDe']
                                                ,$row['TenTheLoai']
                                                ,$row['HinhTheLoai']));
    }

    $response = array(
        "message" => "Success",
        "status" => 1,
        "data" => $mangchude
    );

    echo json_encode($response);

?>