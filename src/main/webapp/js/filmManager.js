$(document).ready(function() {
	let target = $('#addFilmButton');
	let form = $('#addFilmForm');
	
	target.on("click", function() {
		if(form.hasClass("disabled")) {
			form.toggleClass("disabled");
			target.html("Cacher");
		} else {
			form.toggleClass("disabled");
			target.html("Ajouter un film");
		}
	});
});