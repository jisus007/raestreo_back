$(document).ready(function() {
	$('#w-input-search').autocomplete({
		serviceUrl : '/getTags',
		paramName : "tagName",
		delimiter : ",",
		transformResult : function(response) {
			return {
				suggestions : $.map($.parseJSON(response), function(item) {
					return {
						value : item.tagName,
						data : item.id
					};
				})
			};
		}
	});

});