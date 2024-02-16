<?php

require "connect.php";

$tendangnhap = $_POST['tendangnhap'];
$matkhau = $_POST['matkhau'];

if (!empty($tendangnhap) and !empty($matkhau)) {
    $query = "SELECT * FROM taikhoan WHERE tendangnhap = '$tendangnhap' AND matkhau = '$matkhau'";
    $data = mysqli_query($con, $query);

    if (mysqli_num_rows($data) > 0) {
        class Taikhoan {
            function __construct($id ,$tendangnhap , $matkhau, $ten) {
                $this->Id = $id;
                $this->Tendangnhap = $tendangnhap;
                $this->Matkhau = $matkhau;
                $this->Ten = $ten;
        
            }
        }
        
        $mangtaikhoan = array();
            while ($row = mysqli_fetch_assoc($data)){
                array_push($mangtaikhoan, new Taikhoan($row['id ']
                                                        ,$row['tendangnhap']
                                                        ,$row['matkhau']
                                                        ,$row['tennguoidung']));
            }
        
            $response = array(
                "message" => "Success",
                "status" => 1,
                "data" => $mangtaikhoan
            );
        
            
        
    } else {
        $response = array(
            "message" => "Error",
            "status" => 0,
            "data" => [],
        );
    }
} else {
    $response = array(
        "message" => "Error Valid",
        "status" => -1,
        "data" => [],
    );
}

echo json_encode($response);



?>
