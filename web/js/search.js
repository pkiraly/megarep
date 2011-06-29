$(document).ready(function(){
	
	var sel = document.getElementById('meter');
	handleMeter(sel.options[sel.selectedIndex].value);

	sel = document.getElementById('segmentation');
	if(sel != null) {
		handleSegmentation(sel.options[sel.selectedIndex].value);
	} else {
		alert("Could not find segmentation")
	}

	sel = document.getElementById('rhyme');
	if(sel != null) {
		handleRhyme(sel.options[sel.selectedIndex].value);
	} else {
		alert("Could not find rhyme")
	}
	
	sel = document.getElementById('language');
	if(sel != null) {
		handleLanguage(sel.options);
	} else {
		alert("Could not find language")
	}
	
	sel = document.getElementById('refrain');
	if(sel != null) {
		handleRefrain(sel.options);
	} else {
		alert("Could not find language")
	}

	sel = document.getElementById('query');
	if(sel != null) {
		var doShow = (sel.innerHTML == "") ? true : false;
		showForm(doShow);
	} else {
		alert("Could not find query");
	}
	
	$('#search-form-tab').click(function() {
		$('#main').show();
		$('#results').hide();
		$('#search-form-tab').css("background-color", "#eee")
		$('#results-tab').css("background-color", "#fff")
	});

	$('#results-tab').click(function() {
		$('#main').hide();
		$('#results').show();
		$('#search-form-tab').css("background-color", "#fff")
		$('#results-tab').css("background-color", "#eee")
	});
});

function showForm(doShow) {
	if(doShow) {
		$('#main').show();
		$('#search-form-tab').css("background-color", "#eee")
		$('#results-tab').css("background-color", "#fff")
	} else {
		$('#main').hide();
		$('#search-form-tab').css("background-color", "#fff")
		$('#results-tab').css("background-color", "#eee")
	}
}
function handleMeter(value) {
	if(value == '01') {
		$('#meter-01').show();
		$('#meter-07').hide();
	} else if(value == '07') {
		$('#meter-01').hide();
		$('#meter-07').show();
	} else {
		$('#meter-01').hide();
		$('#meter-07').hide();
	}
}

function handleSegmentation(value) {
	if(value == '01') {
		$('#segmentation_qualifier').show();
	} else {
		$('#segmentation_qualifier').hide();
	}
}

function handleRhyme(value) {
	if(value == '01') {
		$('#rhyme-01').show();
	} else {
		$('#rhyme-01').hide();
	}
}

function handleMelody(value) {
	if(value == '01') {
		$('#melody-01').show();
	} else {
		$('#melody-01').hide();
	}
}

function handleLanguage(options) {
	var j = 0;
	for(var i=0; i<options.length; i+=1) {
		if(options[i].selected) {
			j+=1;
		}
	}
	if(j > 1) {
		$('#language_qualifier').show();
	} else {
		$('#language_qualifier').hide();
	}
}

function handleRefrain(value) {
	if(value == '02') {
		$('#refrain_qualifier').show();
	} else {
		$('#refrain_qualifier').hide();
	}
}
