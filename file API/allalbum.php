<?php 
     require "connect.php";
     $query = "SELECT * FROM album  ";
    $dataalbum = mysqli_query($con, $query);
class album {
    function __construct($IdAlbum ,$TenAlbum , $TenCaSiAlbum, $HinhAlbum) {
        $this->IdAlbum = $IdAlbum;
        $this->TenAlbum = $TenAlbum;
        $this->TenCaSiAlbum = $TenCaSiAlbum;
        $this->HinhAlbum = $HinhAlbum;

    }
}

$mangalbum = array();
    while ($row = mysqli_fetch_assoc($dataalbum)){
        array_push($mangalbum, new theloai($row['IdAlbum']
                                                ,$row['TenAlbum']
                                                ,$row['TenCaSiAlbum']
                                                ,$row['HinhAlbum']));
    }

    $response = array(
        "message" => "Success",
        "status" => 1,
        "data" => $mangalbum
    );

    echo json_encode($response);

?>