<%@page session="false"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>PDF</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body{font-family: sans-serif;}
            p{font-weight: 400; line-height: 18px; margin: 0; padding: 0;}
            table {width:100%; border: 1px solid #ccc;}
            td{border: 1px solid #ccc;}
            th {font-weight: 600;}
            .container{width: 90%; min-height: 500px; position: relative; margin: 0 auto; }
            .box
            {width: 30%; min-height: 456px; margin: 0; padding: 0px; border: 1px solid #000; position:relative; display: inline-block; vertical-align: top;}
            .inner-box{width: 94%; min-height: 21px; top:0; display: inline-block; margin: 0; padding: 5px 10px; border-bottom: 1px solid #000; font-size: 14px; position: relative;}
            .inner-box-2{width: 44%; min-height: 21px; top:0; display: inline-block; margin: 0; padding: 5px 10px; border-bottom: 1px solid #000; font-size: 14px; position: relative;}
            .border-left{border-left: 1px solid #000;}
            .no-borders-btm {border-bottom:none !important;}
            .no-borders-rght {border-right:none !important;}
            .text-center {text-align: center;}
            .height-100{height:109px;}
            .font-big {font-size: 21px; font-weight: 800;}
            .black-bg {width:100%; height:auto; margin: 10px 0 0 0; padding: 5px; text-align: right; color: #fff; background: #000;font-weight: 800;}
        </style>
    </head>
    <body>
        <div class="container">
            <div class="box no-borders-rght">
                <div class="inner-box">
                    <p>You can track your shipment at www.gati.com. You can also reach us at TOLL FREE NO 1800-180-4284</p>
                </div>
                <div class="inner-box height-100">
                    <p><strong>Shipper Address <span style="float:right;">Code:${pickupDetails.shipper_code}</span></strong><br/>
                        ${pickupDetails.shipper_address1}, ${pickupDetails.shipper_address2}
                        ${pickupDetails.shipper_address3}, ${pickupDetails.shipper_address4}
                        ${pickupDetails.shipper_city}-${pickupDetails.shipper_pincode}, <br/>
                        PH:${pickupDetails.shipper_phone}, EMAIL: ${pickupDetails.shipper_email}<br/>
                        Policy No:<br/>
                        GSTIN No:
                    </p>
                </div>
                <div class="inner-box">
                    <p><strong>Pkg Nos: </strong> - </p>
                </div>
                <div class="inner-box">
                    <p><strong>Ref No: </strong></p>
                </div>
                <div class="inner-box">
                    <p><strong>Contains: </strong>Not Ava</p>
                </div>
                <div class="inner-box">
                    <p><strong>FOD Amount: </strong> ${pickupDetails.cod_dod_amount}</p>
                </div>
                <div class="inner-box-2">
                    <p><strong>Basis: </strong>${pickupDetails.booking_basis}</p>
                </div><!--
                --><div class="inner-box-2 border-left">
                    <p><strong>No. of pkgs: </strong>${pickupDetails.no_of_packages}</p>
                </div>
                <div class="inner-box-2">
                    <p><strong>COD: </strong>${pickupDetails.cod_flag}</p>
                </div><!--
                --><div class="inner-box-2 border-left">
                    <p><strong>COD in Fav: </strong>${pickupDetails.cod_dod_in_favor}</p>
                </div>
                <div class="inner-box-2">
                    <p><strong>ACT WT(Kgs): </strong>${pickupDetails.actual_weight}</p>
                </div><!--
                --><div class="inner-box-2 border-left">
                    <p><strong>WT(Kgs): </strong>${pickupDetails.actual_weight}</p>
                </div>
                <div class="inner-box-2 no-borders-btm">
                    <p><strong>Service: </strong>${pickupDetails.product}</p>
                </div><!--
                --><div class="inner-box-2 border-left no-borders-btm">
                    <p><strong>Cargo Value: </strong>${pickupDetails.volume} <br/>&nbsp;</p>
                </div>
            </div><!--
            --><div class="box no-borders-rght">
                <div class="inner-box text-center">
                    <img src="img/logo2.png" alt="logo"/>
                </div>
                <div class="inner-box height-100">
                    <p><strong>Receiver Address <span style="float:right;">Code: ${pickupDetails.receiver_code}</span></strong><br/>
                        ${pickupDetails.receiver_address1}, ${pickupDetails.receiver_address2}
                        ${pickupDetails.receiver_address3}, ${pickupDetails.receiver_address4}
                        ${pickupDetails.receiver_city}-${pickupDetails.receiver_pincode}, <br/>
                        PH:${pickupDetails.receiver_phone}, EMAIL: ${pickupDetails.receiver_email}<br/>
                        TIN:
                    </p>
                </div>
                <div class="inner-box text-center">
                    <img src="img/barcode.png" alt="barcode"/>
                </div>
                <div class="inner-box no-borders-btm text-center">
                    <p>Receiver's Signature, Stamp & Comments:</p>
                </div>
            </div><!--
            --><div class="box">
                <div class="inner-box">
                    <p><strong>Docket No: </strong> <span class="font-big">${pickupDetails.docket_no}</span><br/>
                    <small>Non Negotiable Docket</small></p>
                </div>
                <div class="inner-box">
                    <p><strong>Origin: </strong> <span class="font-big">${pickupDetails.booking_ou}</span></p>
                    <p><strong>Dly OU: </strong> <span class="font-big">${pickupDetails.delivery_ou}</span></p>
                    <p><strong>Dly. Stn/Ess: </strong> ${pickupDetails.ess_code}</p>
                </div>
                <div class="inner-box">
                    <p><strong>Booking Date: </strong> ${pickupDetails.pickup_date}</p>
                    <p><strong>Assured Dly Date: </strong> ${pickupDetails.pickup_date}</p>
                    <p><strong>Risk Coverage: </strong> ${pickupDetails.risk} Risk</p>
                </div>
                <div class="inner-box">
                    <p><strong>Shipper's Sign:</strong></p>
                    <br/><br/>
                </div>
                <div class="inner-box no-borders-btm">
                    <p><strong>Signature:</strong><br/><small>(For GAtiKWE)</small></p>
                    <table>
                        <thead>
                            <tr>
                                <th>&nbsp;</th>
                                <th>Date & Time</th>
                                <th>Undid cd</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1st Attempt</td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>2nd Attempt</td>
                                <td></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                    <p><strong>Service Tax Reg. No: </strong><br/>AADCG2096ASD001</p>
                    <p><strong>PAN No: </strong>AADCG2096A</p>
                    <div class="black-bg">POD Copy</div>
                </div>
            </div>
        </div>
    </body>
</html>
