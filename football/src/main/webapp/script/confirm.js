/*
 * SimpleModal Confirm Modal Dialog
 * http://simplemodal.com
 *
 * Copyright (c) 2013 Eric Martin - http://ericmmartin.com
 *
 * Licensed under the MIT license:
 *   http://www.opensource.org/licenses/mit-license.php
 */
function ajaxloading(){
	
	$('#loading').modal({
		position: ["20%",],
		overlayId: 'confirm-overlay',
		containerId: 'loading-container', 
		onShow: function (dialog) {
			var modal = this;	
		}
	});
			
}



function ajaxloadinClose(){
	$.modal.close();
}

function ajaxloading2(){
	
	$('#serviceLoading').modal({
		position: ["20%",],
		overlayId: 'confirm-overlay',
		containerId: 'loading-container', 
		onShow: function (dialog) {
			var modal = this;	
		}
	});
			
}

function ajaxloadinClose2(){
	$.modal.close();
}


function callLoading(msg){
	if(msg == 'on'){
		ajaxloading();
	}else{
		ajaxloadinClose();
	}
}


function confirm(message, callback) {
	
	$('#confirm').modal({
		closeHTML: "<a href='#' title='Close' class='modal-close'>x</a>",
		position: ["20%",],
		overlayId: 'confirm-overlay',
		containerId: 'confirm-container', 
		onShow: function (dialog) {
			var modal = this;

			$('.message', dialog.data[0]).append(message);

			// if the user clicks "yes"
			$('.yes', dialog.data[0]).click(function () {
				// call the callback
				if ($.isFunction(callback)) {
					callback.apply();
				}
				// close the dialog
				modal.close(); // or $.modal.close();
				ajaxloading();
			});
		}
	});
}

function alertConfirm(message){
	$('#alert').modal({
		closeHTML: "<a href='#' title='Close' class='modal-close'>x</a>",
		position: ["20%",],
		overlayId: 'confirm-overlay',
		containerId: 'confirm-container', 
		onShow: function (dialog) {
			var modal = this;

			$('.message', dialog.data[0]).append(message);

			// if the user clicks "yes"
			$('.yes', dialog.data[0]).click(function () {								
				// close the dialog
				modal.close(); // or $.modal.close();
				
			});
		}
	});
}

function alertConfirm2(message){
	message = message.replace( /\r/g, "<br>" );

	$('#alert2').modal({
		closeHTML: "<a href='#' title='Close' class='modal-close'>x</a>",
		position: ["20%",],
		overlayId: 'confirm-overlay',
		containerId: 'confirm-container', 
		onShow: function (dialog) {
			var modal = this;

			$('.message2', dialog.data[0]).append(message);

			// if the user clicks "yes"
			$('.yes', dialog.data[0]).click(function () {								
				// close the dialog
				modal.close(); // or $.modal.close();
				
			});
		}
	});
}

function redirectNewConfirm(message, location){
	$('#alert').modal({
		closeHTML: "<a href='#' title='Close' class='modal-close'>x</a>",
		position: ["20%",],
		overlayId: 'confirm-overlay',
		containerId: 'confirm-container', 
		onShow: function (dialog) {
			var modal = this;
			$('.message', dialog.data[0]).append(message);
			$("#confirm-container").css('height', '260px');
			$('#confirm-container .buttons_alone div').css('width', '100px');
			// if the user clicks "yes"
			$('.yes', dialog.data[0]).click(function () {								
				// close the dialog				
				modal.close(); // or $.modal.close();
				window.location.href=location;
			});
		}
	});
}
function redirectConfirm(message, location){
	$('#alert').modal({
		closeHTML: "<a href='#' title='Close' class='modal-close'>x</a>",
		position: ["20%",],
		overlayId: 'confirm-overlay',
		containerId: 'confirm-container', 
		onShow: function (dialog) {
			var modal = this;

			$('.message', dialog.data[0]).append(message);

			// if the user clicks "yes"
			$('.yes', dialog.data[0]).click(function () {								
				// close the dialog				
				modal.close(); // or $.modal.close();
				window.location.href=location;
				
				
			});
		}
	});
}

function redirect2Confirm(message, location){
	$('#alert').modal({
		
		position: ["20%",],
		overlayId: 'confirm-overlay',
		containerId: 'confirm-container', 
		onShow: function (dialog) {
			var modal = this;

			$('.message', dialog.data[0]).append(message);

			// if the user clicks "yes"
			$('.yes', dialog.data[0]).click(function () {								
				// close the dialog				
				modal.close(); // or $.modal.close();
				window.location.href=location;
				
				
			});
		}
	});
}

function joinconfirm(message, callback) {		
	$('#confirm').modal({
		closeHTML: "<a href='#' title='Close' class='modal-close'>x</a>",
		position: ["20%",],
		overlayId: 'confirm-overlay',
		containerId: 'joinconfirm-container', 
		onShow: function (dialog) {
			var modal = this;
			$('.message', dialog.data[0]).append(message);
			// if the user clicks "yes"
			$('.yes', dialog.data[0]).click(function () {
				modal.close(); 
				location.href=callback;
			});
		}
	});
}
