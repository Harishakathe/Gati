$( function() {
	'use strict';
	    $( "#Shipper_Code" ).autocomplete({
	        minLength: 3,
	        source: function( request, response ) {
	            $.ajax( {
	              method:"post",
	              url: "/getCustomerDetails/"+request.term,
	              success: function( data ) {
	                response( data );
	              }
	            } );
	          },
	        focus: function( event, ui ) {
	          $( "#Shipper_code" ).val( ui.item.label );
	          return false;
	        },
	        select: function( event, ui ) {
	        	console.log(ui.item);
	          //$( "#project" ).val( ui.item.label );
	          //$( "#project-id" ).val( ui.item.value );
	          //$( "#project-description" ).html( ui.item.desc );
	          //$( "#project-icon" ).attr( "src", "images/" + ui.item.icon );
	   
	          return false;
	        }
	    }).autocomplete( "instance" )._renderItem = function( ul, item ) {
	        return $( "<li>" )
	          .append( "<div>" + item.label + "<br>" + item.desc + "</div>" )
	          .appendTo( ul );
	      };
	      
	      $( "#Receiver_Code" ).autocomplete({
	        minLength: 3,
	        source: function( request, response ) {
	            $.ajax( {
	              method:"post",
	              url: "/getCustomerDetails/"+request.term,
	              success: function( data ) {
	                response( data );
	              }
	            } );
	          },       
	        focus: function( event, ui ) {
	          $( "#Receiver_Code" ).val( ui.item.label );
	          return false;
	        },
	        select: function( event, ui ) {
	          //$( "#project" ).val( ui.item.label );
	          //$( "#project-id" ).val( ui.item.value );	   
	          return false;
	        }
	      }).autocomplete( "instance" )._renderItem = function( ul, item ) {
	        return $( "<li>" )
	          .append( "<div>" + item.label + "<br>" + item.desc + "</div>" )
	          .appendTo( ul );
	      };
		      
	      $( "#Shipper_Pincode" ).autocomplete({
	        minLength: 3,
	        source: function( request, response ) {
	            $.ajax( {
	              method:"post",
	              url: "/getPinCodes/"+request.term,
	              success: function( data ) {
	                response( data );
	              }
	            } );
	          },
	        focus: function( event, ui ) {
	          $( "#Shipper_Pincode" ).val( ui.item.label );
	          return false;
	        },
	        select: function( event, ui ) {
	          $( "#project" ).val( ui.item.label );
	          return false;
	        }
	      }).autocomplete( "instance" )._renderItem = function( ul, item ) {
	        return $( "<li>" )
	          .append( "<div>" + item.label + "<br>" + item.desc + "</div>" )
	          .appendTo( ul );
	      };  
		      
	 });