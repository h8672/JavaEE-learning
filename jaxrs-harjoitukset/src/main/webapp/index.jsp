<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JAX-RS laskin esimerkki</title>
	    <style>
	        ul{
	            list-style-type: none;
	            padding: 10px;
	            background-color: #AFE0EF;      
	        }
	        li{
	            margin: 5px;
	            margin-bottom: 15px;
	            padding: 15px;
	            background-color: #FFFFFF;      
	            color: #000000;
	        }
	    </style>
	    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
	    <script>
	    	$.ajaxSetup({
	    		contentType: "application/json; charset=utf-8",
	    		dataType: "json"
	    	});
	    
	    	$(document).ready(function(){
	    		$('#ajaxform').submit(function(e) {
	    			var $f = $('#ajaxform');
	    			var formAsJson = $('#ajaxform').serializeFormJSON();
    				validate();
	    			$.ajax({
	    				url: '/rest/calculator/calcform',
	    				type: 'POST',
	    				data: JSON.stringify(formAsJson),
	    				error: function(jqXHR, textStatus, errorThrown) {
	    					alert(errorThrown);
	    				}
	    			});
	    			e.preventDefault();
	    		});
	    	});	    
	    
	    	(function ($) {
	    		$.fn.serializeFormJSON = function () {
	    			var objectGraph = {};
	    			var arr = this.serializeArray();
	    			$.each(arr, function () {
	    				if (objectGraph[this.name]) {
	    					if (!objectGraph[this.name].push) {
	    						objectGraph[this.name] = [objectGraph[this.name]];
	    					}
	    					objectGraph[this.name].push(this.value || '');
	    				} else {
	    					objectGraph[this.name] = this.value || '';
	    				}
	    			});
	    			return objectGraph;
	    		};
	    	})(jQuery);
	    	
	    	$('#ajaxform').submit(function (e) {
	    		e.preventDefault();
	    		var data = $(this).serializeFormJSON();
	    		console.log(data);
	    	});
	    	
	    	function validate(){
	    		var left = document.getElementById('left');
	    		var right = document.getElementById('right');
	    		var valid = true;
	    		if($.isNumeric(left) && left.value < 0){
	    			alert("Vasemman puoleinen arvo pitää olla positiivinen");
	    			valid = false;
	    		}
	    		else if($.isNumeric(right) && right.value < 0){
	    			alert("Oikean puoleinen arvo pitää olla positiivinen");
	    			valid = false;
	    		}
	    		else valid = true;
	    		return valid;
	    	}
	    </script>

    </head>
    <body>
        <h1>Esimerkit JAX-RS-ohjelmoinnista</h1>

        <p>Tämä on esimerkki JAX-RS kutsujen teosta. Toisessa esimerkissa käytetään GET-kutsuja ja toisessa POST.
		<ul>
        	<li>Summa-operaatio: <a href="/rest/calculator/calc/add/">/rest/calculator/calc/add/{vasen}/{oikea}</a></li>
        	<li>Erotus-operaatio: <a href="/rest/calculator/calc/substract/">/rest/calculator/calc/subtract/{vasen}/{oikea}</a></li>
        	<li>Tulo-operaatio: <a href="/rest/calculator/calc/multiply/">/rest/calculator/calc/multiply/{vasen}/{oikea}</a></li>
        	<li>Jako-operaatio: <a href="/rest/calculator/calc/divide/">/rest/calculator/calc/divide/{vasen}/{oikea}</a></li>
		</ul>

        <div>Ohjelma vastaanottaa myös POST-kutsuja, joita voi tehdä seuraavalla lomakkeella:</div>
        <br>

		<form enctype="application/json" action="#" name="ajaxform" id="ajaxform" method="post">
		  <!-- Lähetetään parametrejä action="/rest/calculator/calcform"-->
		  <table>
		  	<tr><td>Vasen:</td><td>Operaatio:</td><td>Oikea:</td><td>&nbsp;</td></tr>
		  	<tr>
		  		<td><input type="text" name="left" id="left" /></td>
		  		<td><input type="text" name="operation" id="operation" /></td>
		  		<td><input type="text" name="right" id="right" /></td>
		  		<td><input type="submit" value="Lähetä" id="calcpost" /></td>
		  	</tr>		  	
		  </table> 
		</form>        
    </body>
</html>
