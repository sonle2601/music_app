<?php
    require "connect.php";
    $tu_khoa = $_POST['tukhoa'];
    if (!empty($tu_khoa)) {
        $query = "SELECT * FROM baihat WHERE lower(TenBaiHat) LIKE '%" . $tu_khoa . "%'";
    
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
    
    }else{
        echo "Loi";
    }

   

?>