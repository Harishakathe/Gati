<%@page session="false"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
      <title>Gati Print</title>
      <meta content="text/html; charset=iso-8859-1" http-equiv="Content-Type">
      <style>
      	 body {
         margin: 0px
         }
         .tdess {
         font-size: 10px; font-family: Arial, Helvetica, sans-serif; color: #000000
         }
         .td1 {
         font-size: 10px; border-top: #000000 1px solid; font-family: Arial, Helvetica, sans-serif; border-right: #000000 1px solid; border-bottom: #000000 1px solid; font-weight: bold; color: #000000; border-left: #000000 1px solid
         }
         .tdnew1 {
         font-size: 8px; font-family: Arial, Helvetica, sans-serif; font-weight: bold; color: #000000
         }
         .td_span {
         font-size: 5px; font-family: Arial, Helvetica, sans-serif
         }
         .td32 {
         border-top: #000000 1px solid; font-family: Arial, Helvetica, sans-serif; border-right: #000000 1px solid; border-bottom: #000000 1px solid; color: #000000; border-left: #000000 1px solid
         }
         .head {
         font-size: 11px; font-family: Arial, Helvetica, sans-serif; font-weight: bold; color: #000000
         }
         .td2 {
         font-size: 15px; font-family: Arial, Helvetica, sans-serif; font-weight: bold; color: #000000
         }
         .td3 {
         font-size: 8px; border-top: #000000 1px solid; font-family: Arial, Helvetica, sans-serif; border-right: #000000 1px solid; border-bottom: #000000 1px solid; font-weight: bold; color: #000000; border-left: #000000 1px solid
         }
         .td4 {
         font-size: 12px; font-family: Arial, Helvetica, sans-serif; font-weight: bold; color: #ffffff; background-color: #000000
         }
         .codeSnippet {
         border-top: #000000 1px dashed; border-right: #000000 1px dashed; border-bottom: #000000 1px dashed; border-left: #000000 1px dashed
         }
         P.breakhere {
         PAGE-BREAK-AFTER: always
         }
      </style>
      <style type="text/css" media="screen,print">
         @font-face {
         font-family: MyCustomFont;
         src: url(/Gati/resources/fonts/IDAutomationHC39MBarcode.eot);
         }
         @font-face {
         font-family: MyCustomFont;
         src: url(/Gati/resources/fonts/IDAutomationHC39MBarcode.ttf);
         }
         .barcode {
         font-size: medium; font-family: MyCustomFont, Verdana, Arial, sans-serif; color: black
         }
      </style>
      <script>function click(e){if(document.all){if(event.button == 2){alert('sorry');return false;}}if (document.layers){if(e.which == 3){alert(message);return false;}}}if (document.layers){document.captureEvents(Event.MOUSEDOWN);}document.onmousedown=click;</script>
      <meta name="GENERATOR" content="MSHTML 11.00.9600.18698">
   </head>
   <body onload="printstatus()" leftmargin="0" topmargin="0">
      <script language="JavaScript">
         function printstatus() {
         	alert("Spooling is over, You can print the dockets now");
         }	
      </script>
      <table class="td1" height="315" cellspacing="0" cellpadding="0" width="668" align="center">
         <tbody>
            <tr>
               <td height="315" valign="top" width="255">
                  <table height="100%" cellspacing="0" cellpadding="0" width="254">
                     <tbody>
                        <tr>
                           <td class="td1" height="34" valign="top" colspan="2" align="left">&nbsp;You 
                              can track Your shipments at<br>&nbsp;www.gatikwe.com.You can also 
                              reach us<br>&nbsp;at TOLL FREE NO 1800-180-4284
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="94" valign="top" colspan="2">
                           <span class="head">&nbsp;Shipper Address &emsp;&emsp;Code:</span>${pickupDetails.shipper_code}
	                          <br/>&nbsp;${pickupDetails.shipper_address1}, ${pickupDetails.shipper_address2}
		                      <br/>&nbsp;${pickupDetails.shipper_address3}, ${pickupDetails.shipper_address4}
		                      <br/>&nbsp;${pickupDetails.shipper_city}-${pickupDetails.shipper_pincode},
		                      <br/>&nbsp;PH:${pickupDetails.shipper_phone}, EMAIL: ${pickupDetails.shipper_email}
		                      <br/>
                              <br>&nbsp;Policy No: 
                              <br>&nbsp;GSTIN No: 
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="16" colspan="2">
                           	<span class="head">&nbsp;Pkg Nos : </span> 0 - 0
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="18" colspan="2">
                           	<span class="head">&nbsp;Ref No : </span> 0
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="18" colspan="2">
                           	<span class="head">&nbsp;Contains : </span> Not Available 
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="18" colspan="2">
                           	<span class="head">&nbsp;FOD Amount :</span> ${pickupDetails.cod_dod_amount}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="20">
                           	<span class="head">&nbsp;Basis : </span> ${pickupDetails.booking_basis}
                           </td>
                           <td class="td1" valign="top" width="130">
                           	<span class="head">&nbsp;No. of Pkgs : </span> ${pickupDetails.no_of_packages}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="23">
                           	<span class="head">&nbsp;COD : </span>${pickupDetails.cod_flag} 
                           </td>
                           <td class="td1">
                           	<span class="head">&nbsp;COD in Fav : </span> ${pickupDetails.cod_dod_in_favor}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="24">
                           	<span class="head">&nbsp;ACT Wt(Kgs): </span> ${pickupDetails.actual_weight} 
                           </td>
                           <td class="td1">
                           	<span class="head">&nbsp;Wt(Kgs): </span> ${pickupDetails.actual_weight}
                           	</td>
                        </tr>
                        <tr>
                           <td class="td1" height="22" width="122">
                           	<span class="head">&nbsp;Service : </span> ${pickupDetails.product} 
                           </td>
                           <td class="td1" width="130"><span class="head">&nbsp;Cargo Value : </span> ${pickupDetails.volume} 
                           </td>
                        </tr>
                     </tbody>
                  </table>
               </td>
               <td height="315" valign="top" width="208">
                  <table height="100%" cellspacing="0" cellpadding="0">
                     <tbody>
                        <tr>
                           <td class="td1" height="38" align="center">
                              <img src="/Gati/resources/img/gati_logo.png" width="205" height="34">
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="113" valign="top" width="210"><span class="head">&nbsp;Receiver Address 
                              &emsp;Code:</span> ${pickupDetails.receiver_code} 
                              <br>&nbsp;${pickupDetails.receiver_address1}, ${pickupDetails.receiver_address2}
                              <br>&nbsp;${pickupDetails.receiver_address3}, ${pickupDetails.receiver_address4}
                              <br>&nbsp;${pickupDetails.receiver_city}-${pickupDetails.receiver_pincode}, 
                              <br>&nbsp;PH: ${pickupDetails.receiver_phone},Email : ${pickupDetails.receiver_email}
                              <br>&nbsp;GSTIN No: 
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="163" valign="top" align="left">
                              <table height="160" cellspacing="0" cellpadding="0" width="212">
                                 <tbody>
                                    <tr>
                                       <td align="center"><span class="barcode">!${pickupDetails.docket_no}!</span></td>
                                    </tr>
                                 </tbody>
                              </table>
                           </td>
                        </tr>
                     </tbody>
                  </table>
               </td>
               <td height="315" valign="top" width="215">
                  <table height="100%" cellspacing="0" cellpadding="0" width="100%">
                     <tbody>
                        <tr>
                           <td class="td1" height="38">&nbsp;Docket No <span class="td2"> ${pickupDetails.docket_no} </span>
                           <br>(NON-NEGOTIABLE DOCKET)
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="54" valign="top">
	                           <span class="head">&nbsp;Bkg OU : </span><span class="td2"> ${pickupDetails.booking_ou} </span><br>
	                           <span class="head">&nbsp;Dly OU :</span><span class="td2"> ${pickupDetails.delivery_ou} -[ESS] </span><br>
	                           <span class="head">&nbsp;Dly/ESS Nm: </span><span class="tdess"> ${pickupDetails.ess_code} </span>
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="56" valign="top">
	                           <span class="head">&nbsp;Booking Date :</span> ${pickupDetails.pickup_date} <br>
	                           <span class="head">&nbsp;Assured Dly Date:</span> ${pickupDetails.pickup_date} <br>
	                           <span class="head">&nbsp;Risk Coverage :</span> ${pickupDetails.risk}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="31" valign="bottom" align="left"><span class="head"><br>&nbsp;Shipper's Sign</span>&nbsp;</td>
                        </tr>
                        <tr>
                           <td class="td1" height="130" valign="bottom" align="left">
                              <br>&nbsp;Signature&nbsp;&nbsp;<span class="head">&nbsp;<br>&nbsp;(For Gati KWE)</span>&nbsp; &nbsp; 
                              <hr>
                              <!--Service Tax Reg No.-->
                              <br>&nbsp;Gati GSTIN NO:33AADCG2096A1Z4
                              <br>&nbsp;PAN :AADCG2096A<br>
                              <!--PAN NO.AADCG2096A-->. 
                              <br><br>
                              <div class="td4" align="right">&nbsp;SHIPPER COPY&emsp;</div>
                           </td>
                        </tr>
                     </tbody>
                  </table>
               </td>
            </tr>
            <tr>
               <td class="td3" height="12" valign="top" colspan="3">Spl.Instruction:&nbsp;<br>Your obtaining this docket signifies 
                  your consent to the terms and conditions of the company for carrying the 
                  shipment as mentioned on 
                  www.gatikwe.com {HSRT_30811}
               </td>
            </tr>
         </tbody>
      </table>
      <hr class="codeSnippet">
      <table class="td1" height="322" cellspacing="0" cellpadding="0" width="668" align="center">
         <tbody>
            <tr>
               <td height="308" valign="top" width="255">
                  <table height="100%" cellspacing="0" cellpadding="0" width="254">
                     <tbody>
                        <tr>
                           <td class="td1" height="36" valign="top" colspan="2" align="left">&nbsp;You can track Your shipments at
                           <br>&nbsp;www.gatikwe.com.You can also reach us
                           <br>&nbsp;at TOLL FREE NO 1800-180-4284
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="97" valign="top" colspan="2">
                           <span class="head">&nbsp;Shipper Address &emsp;Code:</span>${pickupDetails.shipper_code}
                           <br/>&nbsp;${pickupDetails.shipper_address1}, ${pickupDetails.shipper_address2}
                           <br/>&nbsp;${pickupDetails.shipper_address3}, ${pickupDetails.shipper_address4}
                           <br/>&nbsp;${pickupDetails.shipper_city}-${pickupDetails.shipper_pincode},
                           <br/>&nbsp;PH:${pickupDetails.shipper_phone}, EMAIL: ${pickupDetails.shipper_email}<br/>
                           <br>&nbsp;Policy No: 
                           <br>&nbsp;GSTIN No: 
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="16" colspan="2">
                           	<span class="head">&nbsp;Pkg Nos : </span> 0 - 0
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="18" colspan="2">
                           	<span class="head">&nbsp;Ref No : </span> 0
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="18" colspan="2">
                           	<span class="head">&nbsp;Contains : </span> Not Available 
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="18" colspan="2">
                           	<span class="head">&nbsp;FOD Amount :</span> ${pickupDetails.cod_dod_amount}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="20">
                           	<span class="head">&nbsp;Basis : </span> ${pickupDetails.booking_basis}
                           </td>
                           <td class="td1" valign="top" width="130">
                           	<span class="head">&nbsp;No. of Pkgs : </span> ${pickupDetails.no_of_packages}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="23">
                           	<span class="head">&nbsp;COD : </span>${pickupDetails.cod_flag} 
                           </td>
                           <td class="td1">
                           	<span class="head">&nbsp;COD in Fav : </span> ${pickupDetails.cod_dod_in_favor}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="24">
                           	<span class="head">&nbsp;ACT Wt(Kgs): </span> ${pickupDetails.actual_weight} 
                           </td>
                           <td class="td1">
                           	<span class="head">&nbsp;Wt(Kgs): </span> ${pickupDetails.actual_weight}
                           	</td>
                        </tr>
                        <tr>
                           <td class="td1" height="22" width="122">
                           	<span class="head">&nbsp;Service : </span> ${pickupDetails.product} 
                           </td>
                           <td class="td1" width="130"><span class="head">&nbsp;Cargo Value : </span> ${pickupDetails.volume} 
                           </td>
                        </tr>
                     </tbody>
                  </table>
               </td>
               <td height="308" valign="top" width="208">
                  <table height="100%" cellspacing="0" cellpadding="0" width="100%" >
                     <tbody>
                        <tr>
                           <td class="td1" height="38" align="center">
                              <img src="/Gati/resources/img/gati_logo.png" width="205" height="34">
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="107" valign="top" width="210"><span class="head">&nbsp;Receiver&nbsp;Address 
                              &emsp;Code:</span> ${pickupDetails.receiver_code} 
                              <br>&nbsp;${pickupDetails.receiver_address1}, ${pickupDetails.receiver_address2}
                              <br>&nbsp;${pickupDetails.receiver_address3}, ${pickupDetails.receiver_address4}
                              <br>&nbsp;${pickupDetails.receiver_city}-${pickupDetails.receiver_pincode}, 
                              <br>&nbsp;PH: ${pickupDetails.receiver_phone},Email : ${pickupDetails.receiver_email}
                              <br>&nbsp;GSTIN No:
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="163" valign="top" align="left">
                              <table height="160" cellspacing="0" cellpadding="0" width="212">
                                 <tbody>
                                    <tr>
                                       <td align="center"><span class="barcode">!${pickupDetails.docket_no}!</span></td>
                                    </tr>
                                 </tbody>
                              </table>
                           </td>
                        </tr>
                     </tbody>
                  </table>
               </td>
               <td height="308" valign="top" width="215">
                  <table height="100%" cellspacing="0" cellpadding="0" width="100%">
                     <tbody>
                        <tr>
                           <td class="td1" height="38">&nbsp;Docket No <span class="td2"> ${pickupDetails.docket_no} </span> 
                           <br>&nbsp;(NON-NEGOTIABLE DOCKET)
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="54" valign="top">
	                           <span class="head">&nbsp;Bkg OU : </span><span class="td2"> ${pickupDetails.booking_ou} </span><br>
	                           <span class="head">&nbsp;Dly OU :</span><span class="td2"> ${pickupDetails.delivery_ou} -[ESS] </span><br>
	                           <span class="head">&nbsp;Dly/ESS Nm: </span><span class="tdess"> ${pickupDetails.ess_code} </span>
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="50" valign="top">
                               <span class="head">&nbsp;Booking Date :</span> ${pickupDetails.pickup_date} <br>
	                           <span class="head">&nbsp;Assured Dly Date:</span> ${pickupDetails.pickup_date} <br>
	                           <span class="head">&nbsp;Risk Coverage :</span> ${pickupDetails.risk}                           
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="31" valign="bottom" align="left"><span class="head"><br>&nbsp; Shipper's Sign</span>&nbsp;</td>
                        </tr>
                        <tr>
                           <td class="td1" height="130" valign="bottom" align="left">
                              <br>&nbsp;Signature&nbsp;&nbsp;<span class="head">&nbsp;<br>(For Gati KWE)</span>&nbsp; &nbsp; 
                              <hr>
                              <br>&nbsp;Gati GSTIN NO:33AADCG2096A1Z4 <!--Service Tax Reg No.-->
                              <br>&nbsp;PAN :AADCG2096A<!--PAN NO. AADCG2096A-->. 
                              <br><br><br>
                              <div class="td4" align="right">&nbsp;RECEIVER COPY&emsp;</div>
                           </td>
                        </tr>
                     </tbody>
                  </table>
               </td>
            </tr>
            <tr>
               <td class="td3" height="12" valign="top" colspan="3">Spl.Instruction:&nbsp;<br>Your obtaining this docket signifies 
                  your consent to the terms and conditions of the company for carrying the 
                  shipment as mentioned on 
                  www.gatikwe.com&nbsp;{HSRT_30811}
               </td>
            </tr>
         </tbody>
      </table>
      <hr class="codeSnippet">
      <table class="td1" height="332" cellspacing="0" cellpadding="0" width="669" align="center">
         <tbody>
            <tr>
               <td height="318" valign="top" width="255">
                  <table height="100%" cellspacing="0" cellpadding="0" width="253">
                     <tbody>
                        <tr>
                           <td class="td1" height="34" valign="top" colspan="2" align="left">&nbsp;You 
                              can track Your shipments at<br>&nbsp;www.gatikwe.com.You can also 
                              reach us<br>&nbsp;at TOLL FREE NO 1800-180-4284
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="95" valign="top" colspan="2">
                           <span class="head">&nbsp;Shipper Address &emsp;Code:</span>${pickupDetails.shipper_code}<br/>
	                           &nbsp;${pickupDetails.shipper_address1}, ${pickupDetails.shipper_address2}<br/>
	                           &nbsp;${pickupDetails.shipper_address3}, ${pickupDetails.shipper_address4}<br/>
	                           &nbsp;${pickupDetails.shipper_city}-${pickupDetails.shipper_pincode}, <br/>
	                           &nbsp;PH:${pickupDetails.shipper_phone}, EMAIL: ${pickupDetails.shipper_email}<br/>
                              <br>&nbsp;Policy No: 
                              <br>&nbsp;GSTIN No:  
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="16" colspan="2">
                           	<span class="head">&nbsp;Pkg Nos : </span> 0 - 0
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="18" colspan="2">
                           	<span class="head">&nbsp;Ref No : </span> 0
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="18" colspan="2">
                           	<span class="head">&nbsp;Contains : </span> Not Available 
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="18" colspan="2">
                           	<span class="head">&nbsp;FOD Amount :</span> ${pickupDetails.cod_dod_amount}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="20">
                           	<span class="head">&nbsp;Basis : </span> ${pickupDetails.booking_basis}
                           </td>
                           <td class="td1" valign="top" width="130">
                           	<span class="head">&nbsp;No. of Pkgs : </span> ${pickupDetails.no_of_packages}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="23">
                           	<span class="head">&nbsp;COD : </span>${pickupDetails.cod_flag} 
                           </td>
                           <td class="td1">
                           	<span class="head">&nbsp;COD in Fav : </span> ${pickupDetails.cod_dod_in_favor}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="24">
                           	<span class="head">&nbsp;ACT Wt(Kgs): </span> ${pickupDetails.actual_weight} 
                           </td>
                           <td class="td1">
                           	<span class="head">&nbsp;Wt(Kgs): </span> ${pickupDetails.actual_weight}
                           	</td>
                        </tr>
                        <tr>
                           <td class="td1" height="22" width="122">
                           	<span class="head">&nbsp;Service : </span> ${pickupDetails.product} 
                           </td>
                           <td class="td1" width="130"><span class="head">&nbsp;Cargo Value : </span> ${pickupDetails.volume} 
                           </td>
                        </tr>
                     </tbody>
                  </table>
               </td>
               <td height="318" valign="top" width="208">
                  <table height="100%" cellspacing="0" cellpadding="0">
                     <tbody>
                        <tr>
                           <td class="td1" height="38" align="center">
                              <img src="/Gati/resources/img/gati_logo.png" width="205" height="34">
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="110" valign="top" width="212"><span class="head">&nbsp;Receiver&nbsp;Address 
                              &emsp;Code:</span> ${pickupDetails.receiver_code} 
                              <br>&nbsp;${pickupDetails.receiver_address1}, ${pickupDetails.receiver_address2}
                              <br>&nbsp;${pickupDetails.receiver_address3}, ${pickupDetails.receiver_address4}
                              <br>&nbsp;${pickupDetails.receiver_city}-${pickupDetails.receiver_pincode}, 
                              <br>&nbsp;PH: ${pickupDetails.receiver_phone},Email : ${pickupDetails.receiver_email}
                              <br>&nbsp;GSTIN No:
                           </td>
                        </tr>
                        <tr>
                           <td class="td32" height="157" valign="bottom" align="center">
                              <span class="barcode">!${pickupDetails.docket_no}!</span> 
                              <hr size="1">
                              <span class="tdnew1">&nbsp;Receiver's&nbsp;Signature,Stamp&nbsp;&amp;Comments:</span><br><br><br><br><br><br><span class="tdnew1">I/We&nbsp;received&nbsp;the&nbsp;cargo/documents&nbsp;in&nbsp;good&nbsp;conditions</span>
                           </td>
                        </tr>
                        <tr class="tdnew1">
                           <td height="10">NAME&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DATE&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TIME</td>
                        </tr>
                     </tbody>
                  </table>
               </td>
               <td height="318" valign="top" width="215">
                  <table height="96%" cellspacing="0" cellpadding="0" width="100%">
                     <tbody>
                        <tr>
                           <td class="td1" height="38">&nbsp;Docket No <span class="td2"> ${pickupDetails.docket_no} </span>
                           <br>&nbsp;(NON-NEGOTIABLE DOCKET)
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="54" valign="top">
                              <span class="head">&nbsp;Origin : </span><span class="td2"> ${pickupDetails.booking_ou} </span><br>
	                           <span class="head">&nbsp;Dly OU :</span><span class="td2"> ${pickupDetails.delivery_ou} -[ESS] </span><br>
	                           <span class="head">&nbsp;Dly. Stn/ESS: </span><span class="tdess"> ${pickupDetails.ess_code} </span>
                           </td>                           
                        </tr>
                        <tr>
                           <td class="td1" height="50" valign="top">
                               <span class="head">&nbsp;Booking Date :</span> ${pickupDetails.pickup_date} <br>
	                           <span class="head">&nbsp;Assured Dly Date:</span> ${pickupDetails.pickup_date} <br>
	                           <span class="head">&nbsp;Risk Coverage :</span> ${pickupDetails.risk}
                           </td>
                        </tr>
                        <tr>
                           <td class="td1" height="30" valign="bottom" align="left"><span class="head"><br>&nbsp; Shipper's Sign</span>&nbsp;</td>
                        </tr>
                        <tr>
                           <td class="td1" height="141" align="left">
                              <br>&nbsp;Signature&nbsp;&nbsp;<span class="head">&nbsp;<br>(For Gati KWE)</span>&nbsp; 
                              <table class="tdnew1" cellspacing="0" cols="3" cellpadding="0" width="202" border="1">
                                 <tbody>
                                    <tr>
                                       <th class="head" width="70">&nbsp;</th>
                                       <th class="head" width="72">Date Time</th>
                                       <th class="head" width="48">Undld cd</th>
                                    </tr>
                                    <tr>
                                       <td class="head">1st Attempt</td>
                                       <td>&nbsp;</td>
                                       <td>&nbsp;</td>
                                    </tr>
                                    <tr>
                                       <td class="head">2nd Attempt</td>
                                       <td>&nbsp;</td>
                                       <td>&nbsp;</td>
                                    </tr>
                                 </tbody>
                              </table>
                              <br><!--Service Tax Reg No.-->
                              <br>&nbsp;Gati GSTIN NO:33AADCG2096A1Z4
                              <br>&nbsp;PAN :AADCG2096A
                              <br><!--PAN NO. AADCG2096A.-->
                              <br>
                              <div class="td4" align="right">POD COPY&emsp;</div>
                           </td>
                        </tr>
                     </tbody>
                  </table>
               </td>
            </tr>
            <tr>
               <td class="td3" height="12" valign="top" colspan="3">Your obtaining this docket 
                  signifies your consent to the terms and conditions of the company for 
                  carrying the shipment as mentioned on 
                  www.gatikwe.com&nbsp;{HSRT_30811}
               </td>
            </tr>
         </tbody>
      </table>   
</body>
</html>