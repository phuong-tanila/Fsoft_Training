$(document).ready(function() {
	$("#addEmpLink").click(function() {
		$.get({
			url: "/JavaWeb_P_L002/add-emp",
			success: function(response) {
				$(".container").html(response);
			}
		});
	});
	$("#listEmpsLink").click(function() {
		$.get({
			url: "/JavaWeb_P_L002/list-employees",
			success: function(response) {
				$(".container").html(response);
			}
		});
	});
});