<?php 
     require "connect.php";
            
     $idquangcao = $_POST['idbanner'];
     $queryquangcao = "SELECT * FROM quangcao WHERE Id = '$idquangcao'";
    $dataquangcao = mysqli_query($con, $queryquangcao);
    $rowquangcao = mysqli_fetch_assoc($dataquangcao);
    $id = $rowquangcao['Idbaihat'];
    $query = "SELECT * FROM baihat WHERE Idbaihat = '$id'";

        $data = mysqli_query($con, $query);

class Baihat {
    function __construct($idbaihat ,$tenbaihat , $hinhbaihat, $casi, $linkbaihat, $luotthich) {
        $this->Idbaihat = $idbaihat;
        $this->Tenbaihat = $tenbaihat;
        $this->Hinhbaihat = $hinhbaihat;
        $this->Casi = $casi;
        $this->Linkbaihat = $linkbaihat;
        $this->Luotthich = $luotthich;

    }
}

$mangbaihat = array();
    while ($row = mysqli_fetch_assoc($data)){
        array_push($mangbaihat, new Baihat($row['IdBaiHat']
                                                ,$row['TenBaiHat']
                                                ,$row['HinhBaiHat']
                                                ,$row['CaSi']
                                                ,$row['LinkBaiHat']
                                                ,$row['LuotThich']));
    }

    $response = array(
        "message" => "Success",
        "status" => 1,
        "data" => $mangbaihat
    );

    echo json_encode($response);

?>