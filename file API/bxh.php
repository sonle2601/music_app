<?php
    require "connect.php";

    $query = "SELECT DISTINCT * FROM BXH ORDER BY RAND(" . date("Ymd") . ") LIMIT 1";
    class BXH {
        function __construct($idbxh, $ten, $hinhanh, $icon) {
            $this->Id = $idbxh;
            $this->Ten = $ten;
            $this->Hinhanh = $hinhanh;
            $this->Icon = $icon;
        }
    }

    $data = mysqli_query($con, $query);

    $mangbxh = array();
    while ($row = mysqli_fetch_assoc($data)){
        array_push($mangbxh, new BXH($row['IdBXH']
                                                ,$row['TenBXH']
                                                ,$row['NoiDung']
                                                ,$row['Hinhnen']
                                                ,$row['HinhIcon']));
    }

    $response = array(
        "message" => "Success",
        "status" => 1,
        "data" => $mangbxh
    );

    echo json_encode($response);

?>