/*!

 =========================================================
 * Material Bootstrap Wizard - v1.0.2
 =========================================================
 
 * Product Page: https://www.creative-tim.com/product/material-bootstrap-wizard
 * Copyright 2017 Creative Tim (http://www.creative-tim.com)
 * Licensed under MIT (https://github.com/creativetimofficial/material-bootstrap-wizard/blob/master/LICENSE.md)
 
 =========================================================
 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 */

// Material Bootstrap Wizard Functions

var searchVisible = 0;
var transparent = true;
var mobile_device = false;

$(document).ready(function(){

    $.material.init();

    /*  Activate the tooltips      */
    $('[rel="tooltip"]').tooltip();

    // Code for the Validator
    $.validator.addMethod("cemail", function(value, element) {
        return this.optional(element) || /^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\.[a-zA-Z.]{2,5}$/i.test(value);
    }, "Email Address is invalid: Please enter a valid email address.");
	 
	$.validator.addMethod("mobile", function(value, element) {
        return this.optional(element) || /^[0-9]{10}$/i.test(value);
    }, "It is not valid mobile number.input 10 digits number!");
	
    var $validator = $('.wizard-card form').validate({
		  rules: {
		    receiver_code: {
		    	required: true,
		    	digits: true,
				minlength: 5,
			},
			receiver_mobile: {
				required: true,
				mobile:true,
			},
			receiver_name:{
			    required: true,
			    minlength: 3
			},
			receiver_phone: {
			    required: true,
			    digits: true,
			},
			receiver_address1: {
			    required: true,
			    minlength: 3,
			},
			receiver_address2: {
			    required: true,
			    minlength: 3,
			},
			receiver_address3: {
			    required: true,
			    minlength: 3,
			},
			receiver_address4: {
				minlength: 3
			},
			receiver_city: {
			    required: true,
			    minlength: 3,
			},
			receiver_pincode: {
			    required: true,
			    digits: true,
			    minlength: 6,
			    maxlength: 6,
			},
			receiver_email: {
				required: true,
				cemail: true,
			},
			receiver_tin: {
				required: true,
				minlength: 3,
			},
			shipper_code: {
		    	required: true,
		    	digits: true,
				minlength: 5,
			},
			shipper_mobile: {
				required: true,
				mobile:true,
			},
			shipper_name: {
			    required: true,
			    minlength: 3
			},
			shipper_phone: {
			    required: true,
			    digits: true,
			},
			shipper_address1: {
			    required: true,
			    minlength: 3,
			},
			shipper_address2: {
			    required: true,
			    minlength: 3,
			},
			shipper_address3: {
			    required: true,
			    minlength: 3,
			},
			shipper_address4: {
				minlength: 3
			},
			shipper_city: {
			    required: true,
			    minlength: 3,
			},
			shipper_pincode: {
			    required: true,
			    digits: true,
			    minlength: 6,
			    maxlength: 6,
			},
			shipper_email: {
				required: true,
				cemail: true,
			},
			shipper_tin: {
				required: true,
				minlength: 3,
			},				
		    docket_type: {
				required: true
		    },
			docket_category:{
				required: true
		    },
			product: {
				required: true
		    },
			booking_basis: {
				required: true
		    },
			goods_code: {
				required: true
		    },
			booking_ou: {
				required: true
		    },
			delivery_ou: {
				required: true
		    },
			ess_code: {
				required: true
		    },
			no_of_packages:{
				required: true,
				range:[1,100],
			},
			shipment_value:{
				required: true,
				range:[1,9999999999]
			},
			risk: {
				required: true
		    },
			volume:{
				required: true,
				range:[1,999999]
			},
			UOM: {
				required: true
		    },
			actual_weight: {
				required: true
		    },
			cod_flag: {
				required: true
		    },
			cod_dod_in_favor: {
				required: true
		    },
			cod_dod_amount:{
				required:{
					depends:function(element){
						return $("#cod_flag").val()==='Y';
					}
				}
			}
        },

        errorPlacement: function(error, element) {
            $(element).parent('div').addClass('has-error');
         }
	});

    // Wizard Initialization
  	$('.wizard-card').bootstrapWizard({
        'tabClass': 'nav nav-pills',
        'nextSelector': '.btn-next',
        'previousSelector': '.btn-previous',

        onNext: function(tab, navigation, index) {
        	var $valid = $('.wizard-card form').valid();
        	if(!$valid) {
        		$validator.focusInvalid();
        		return false;
        	}
        },

        onInit : function(tab, navigation, index){
            //check number of tabs and fill the entire row
            var $total = navigation.find('li').length;
            var $wizard = navigation.closest('.wizard-card');

            $first_li = navigation.find('li:first-child a').html();
            $moving_div = $('<div class="moving-tab">' + $first_li + '</div>');
            $('.wizard-card .wizard-navigation').append($moving_div);

            refreshAnimation($wizard, index);

            $('.moving-tab').css('transition','transform 0s');
       },

        onTabClick : function(tab, navigation, index){
            var $valid = $('.wizard-card form').valid();

            if(!$valid){
                return false;
            } else{
                return true;
            }
        },

        onTabShow: function(tab, navigation, index) {
            var $total = navigation.find('li').length;
            var $current = index+1;

            var $wizard = navigation.closest('.wizard-card');

            // If it's the last tab then hide the last button and show the finish instead
            if($current >= $total) {
                $($wizard).find('.btn-next').hide();
                $($wizard).find('.btn-finish').show();
                
                $("#lbl_receiver_code").html( $("#receiver_code").val());
                $("#lbl_receiver_name").html( $("#receiver_name").val());
                $("#lbl_receiver_address1").html( $("#receiver_address1").val());
                $("#lbl_receiver_address2").html( $("#receiver_address2").val());
                $("#lbl_receiver_address3").html( $("#receiver_address3").val());
                $("#lbl_receiver_address4").html( $("#receiver_address4").val());
                $("#lbl_receiver_city").html( $("#receiver_city").val());
                $("#lbl_receiver_pincode").html( $("#receiver_pincode").val());
                $("#lbl_receiver_phone").html( $("#receiver_phone").val());
                $("#lbl_receiver_mobile").html( $("#receiver_mobile").val());
                $("#lbl_receiver_email").html( $("#receiver_email").val());
                $("#lbl_receiver_tin").html( $("#receiver_tin").val());
                $("#lbl_receiver_ou").html( $("#receiver_ou").val());
                $("#lbl_shipper_code").html( $("#shipper_code").val());     
                $("#lbl_shipper_name").html( $("#shipper_name").val());   		  	 	
                $("#lbl_shipper_address1").html( $("#shipper_address1").val());
                $("#lbl_shipper_address2").html( $("#shipper_address2").val());
                $("#lbl_shipper_address3").html( $("#shipper_address3").val());
                $("#lbl_shipper_address4").html( $("#shipper_address4").val());
                $("#lbl_shipper_city").html( $("#shipper_city").val());
                $("#lbl_shipper_pincode").html( $("#shipper_pincode").val());
                $("#lbl_shipper_phone").html( $("#shipper_phone").val());
                $("#lbl_shipper_mobile").html( $("#shipper_mobile").val());
                $("#lbl_shipper_email").html( $("#shipper_email").val());
                $("#lbl_shipper_tin").html( $("#shipper_tin").val());
                $("#lbl_shipper_ou").html( $("#shipper_ou").val());
                        
                $("#lbl_docket_type").html( $("#docket_type").val());
                $("#lbl_docket_category").html( $("#docket_category").val());
                $("#lbl_product").html( $("#product option:selected").text());
                $("#lbl_booking_basis").html( $("#booking_basis option:selected").text());
                $("#lbl_goods_code").html( $("#goods_code option:selected").text());
                $("#lbl_booking_pincode").html( $("#shipper_pincode").val());
                $("#lbl_delivery_pincode").html( $("#receiver_pincode").val());
                $("#lbl_no_of_packages").html( $("#no_of_packages").val());
                $("#lbl_package_number_from").html( $("#package_number_from").val());
                $("#lbl_package_number_to").html( $("#package_number_to").val());
                $("#lbl_package_type").html( $("#package_type").val());
                $("#lbl_shipment_value").html( $("#shipment_value").val());
                $("#lbl_risk").html( $("#risk option:selected").text());
                $("#lbl_volume").html( $("#volume").val());
                $("#lbl_uom").html( $("#uom option:selected").text());
                $("#lbl_actual_weight").html( $("#actual_weight").val());
                $("#lbl_cod_flag").html( $("#cod_flag option:selected").text());
                $("#lbl_cod_dod_in_favor").html( $("#cod_dod_in_favor option:selected").text());
                $("#lbl_cod_dod_amount").html( $("#cod_dod_amount").val());  
                
            } else {
                $($wizard).find('.btn-next').show();
                $($wizard).find('.btn-finish').hide();
            }

            button_text = navigation.find('li:nth-child(' + $current + ') a').html();

            setTimeout(function(){
                $('.moving-tab').text(button_text);
            }, 150);

            var checkbox = $('.footer-checkbox');

            if( !index == 0 ){
                $(checkbox).css({
                    'opacity':'0',
                    'visibility':'hidden',
                    'position':'absolute'
                });
            } else {
                $(checkbox).css({
                    'opacity':'1',
                    'visibility':'visible'
                });
            }

            refreshAnimation($wizard, index);
        }
        
  	}); 	

    // Prepare the preview for profile picture    
    $('.set-full-height').css('height', 'auto');



    $(".wizard-card input[name*='finish']").click(function(event){
    	console.log("onFinish");
    	event.preventDefault();
        var form = $("#PickupDetailsForm");
        var xml = ConvertFormToXML(form);
        var json = ConvertFormToJSON(form);
        
        console.log(JSON.stringify(json));
        console.log(xml);
        $.ajax({
        	method: form.attr('method'),
            url: form.attr('action'),
            data: xml,
            contentType: 'application/xml',
            headers: {
        	    Accept: "application/json"
        	  },
            success: function (data) {
            	console.log(data);
            	 if(data.status=='SUCCESS'){
            		 alert("Inserting Success:" +data.result);
            	 }
            	 else{
            		 if(data.message==='Inserting Error'){
            			 alert(data.message+" : "+data.result);
            		 }
            		 if(data.message==='Docket Generation Error'){
            			 alert(data.message+" : "+data.result);
            		 }
            		 if(data.message==='Validation XML Error'){
            			 alert(data.message+" : "+data.result);
            		 }
            		 else{
            			 console.log(data.result);
            			 var validator = $( "#PickupDetailsForm" ).validate({
            				 errorElement: "em",
            				 errorPlacement: function ( error, element ) {
									// Add the `help-block` class to the error element
									error.addClass( "help-block" );         	
									// Add `has-feedback` class to the parent div.form-group
									// in order to add icons to inputs
									element.parent().addClass( "has-feedback" );         	
									if ( element.prop( "type" ) === "checkbox" ) {
										error.insertAfter( element.parent( "label" ) );
									} else {
										error.insertAfter( element );
									}
									// Add the span element, if doesn't exists, and apply the icon classes to it.
									if ( !element.next( "span" )[ 0 ] ) {
										$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
									}
								},
            				 highlight: function ( element, errorClass, validClass ) {                                            					 
									$( element ).parent().addClass( "has-error" ).removeClass( "has-success" );
									$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
								}});
            			 validator.showErrors(data.result);                                            			
            		 }
            	 }
            },
            error:function(e){
            	alert(e);
            }
        });   
    });




});



 //Function to show image before upload

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#wizardPicturePreview').attr('src', e.target.result).fadeIn('slow');
        }
        reader.readAsDataURL(input.files[0]);
    }
}

function ConvertFormToJSON(form){
	
	var json = {};
	var ele = ''; var p_ele='';                                	
    var array = jQuery(form).serializeArray();
    
    jQuery.each(array, function() {
        
        var f_name = this.name;                                        		
		
        if(f_name.includes('.')){ 
        	
			var array_str = f_name.split('.');                                        			
			if(ele != array_str[0]){                                				
				ele = array_str[0];                                        				
				var ele_json_str = {};                                				
				if(p_ele != ele.substr(0,ele.length-3)){
					p_ele = ele.substr(0,ele.length-3);
				}                                				
				$.each($("input[name^='"+ele+"']"),function() {                                        					
					var e_name = this.name.substr(this.name.indexOf(".")+1);
					ele_json_str[e_name] = this.value || '';                                					
				});                                				
				json[p_ele] = (json[p_ele] || []).concat(ele_json_str);
			}                                			
		}
		else{
			json[this.name] = this.value || '';  
		}
    });                                    
    return json;
}

function ConvertFormToXML(form){
    var array = jQuery(form).serializeArray();
    try{
        var xml = $($.parseXML('<?xml version="1.0" encoding="utf-8" ?><PickupDetails />'));      //Main Root Name                          	
    	var ele = ''; var p_ele='';
    	
        jQuery.each(array, function() {
        	var f_name = this.name;                                        		
    		if(f_name.includes('.')){                                        			
    			
    			var array_str = f_name.split('.');                                        			
    			if(ele != array_str[0]){
    				
    				ele = array_str[0];
    				
    				if(p_ele != ele.substr(0,ele.length-3)){
    					p_ele = ele.substr(0,ele.length-3);
    					$('PickupDetails',xml).append($('<'+p_ele+' />', xml));
    				}
    				
    				$(p_ele,xml).append($('<PKG_INFO />', xml));
    				$.each($("input[name^='"+ele+"']"),function() {                                        					
    					var e_name = this.name.substr(this.name.indexOf(".")+1);
    					$('PKG_INFO',xml).last().append($('<'+e_name+' />', xml).text(this.value || ''));                                        					
    				});                                				
    			}
    			
    		}
    		else{
    			$('PickupDetails',xml).append($('<'+this.name+' />', xml).text(this.value || ''));                                   		    
    		}
        }); 
    }catch(e){
    	alert("Converting in xml error:"+e.message);
    }
    return ((new XMLSerializer()).serializeToString(xml.context));
}

$(window).resize(function(){
    $('.wizard-card').each(function(){
        $wizard = $(this);

        index = $wizard.bootstrapWizard('currentIndex');
        refreshAnimation($wizard, index);

        $('.moving-tab').css({
            'transition': 'transform 0s'
        });
    });
});

function refreshAnimation($wizard, index){
    $total = $wizard.find('.nav li').length;
    $li_width = 100/$total;

    total_steps = $wizard.find('.nav li').length;
    move_distance = $wizard.width() / total_steps;
    index_temp = index;
    vertical_level = 0;

    mobile_device = $(document).width() < 600 && $total > 3;

    if(mobile_device){
        move_distance = $wizard.width() / 2;
        index_temp = index % 2;
        $li_width = 50;
    }

    $wizard.find('.nav li').css('width',$li_width + '%');

    step_width = move_distance;
    move_distance = move_distance * index_temp;

    $current = index + 1;

    if($current == 1 || (mobile_device == true && (index % 2 == 0) )){
        move_distance -= 8;
    } else if($current == total_steps || (mobile_device == true && (index % 2 == 1))){
        move_distance += 8;
    }

    if(mobile_device){
        vertical_level = parseInt(index / 2);
        vertical_level = vertical_level * 38;
    }

    $wizard.find('.moving-tab').css('width', step_width);
    $('.moving-tab').css({
        'transform':'translate3d(' + move_distance + 'px, ' + vertical_level +  'px, 0)',
        'transition': 'all 0.5s cubic-bezier(0.29, 1.42, 0.79, 1)'

    });
}

materialDesign = {

    checkScrollForTransparentNavbar: debounce(function() {
                if($(document).scrollTop() > 260 ) {
                    if(transparent) {
                        transparent = false;
                        $('.navbar-color-on-scroll').removeClass('navbar-transparent');
                    }
                } else {
                    if( !transparent ) {
                        transparent = true;
                        $('.navbar-color-on-scroll').addClass('navbar-transparent');
                    }
                }
        }, 17)

}

function debounce(func, wait, immediate) {
	var timeout;
	return function() {
		var context = this, args = arguments;
		clearTimeout(timeout);
		timeout = setTimeout(function() {
			timeout = null;
			if (!immediate) func.apply(context, args);
		}, wait);
		if (immediate && !timeout) func.apply(context, args);
	};
};
