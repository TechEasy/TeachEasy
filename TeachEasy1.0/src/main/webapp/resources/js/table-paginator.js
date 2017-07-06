function getPagination(table, maxRows) {

	$('#pagination').html('').css('font-weight','bold'); // Vaciamos el bloque del paginador
	var totalPages = 0; // Iniciamos la variable del total de páginas a 0
	var trnum = 0; // Iniciamos el contador de filas
	var totalRows = $(table + ' tbody tr').length; // Calculamos el total de filas
	$ (table + ' tbody tr').each (function () {	// Recoremos cada tr que esté en el tbody
		trnum++; // Incrementamos contador
		if (trnum > maxRows) {
			$(this).hide();	// Si el contador es mayor que el máximo de filas a mostrar ocultamos la fila
		} else {
			$(this).show(); // En caso contrario lo mostramos
		}
	});
	if (totalRows > maxRows) { // Si el número de filas es mayor que el número de filas a mostrar
		totalPages = Math.ceil (totalRows / maxRows); // Calculamos el número de páginas
		for (var i = 1; i <= totalPages;) { // Agregamos cada botón de página
			$('#pagination').append ('<li data-page="' + i + '">\
							  <span>' + i++ + '<span class="sr-only">(current)</span></span>\
							</li>').show();
		}

		$ ('#pagination li:first-child').addClass('active'); // Ponemos como activo la primera página
		$ ('#pagination').prepend('<li id="pagina-anterior" class="icon" data-page="1"><span><</span></li>'); // Agregamos el botón de ir a la página anterior
		$ ('#pagination').prepend('<li class="icon" data-page="1"><span><<</span></li>'); // Agregamos el botón de ir a la primera página
		$ ('#pagination').append('<li id="pagina-posterior" class="icon" data-page="' + totalPages + '"><span>></span></li>'); // Agregamos el botón de ir a la página siguiente
		$ ('#pagination').append('<li class="icon" data-page="' + totalPages + '"><span>>></span></li>'); // Agregamos el botón de ir a la última página

		$ ('#pagination li').css('cursor', 'pointer'); // Ponemos cursor pointer para el paginador
	}


	$ ('#pagination li').on('click', function () {		// on click each page
		var pageNum = parseInt($(this).attr('data-page'));	// get it's number
		var trIndex = 0;							// reset tr counter
		$ ('#pagination li').removeClass('active');	// remove active class from all li

		$ ('#pagination [data-page="' + $(this).data('page') + '"]:not(.icon)').addClass('active');

		if (pageNum - 1 < 1) $('#pagina-anterior').data('page', 1);
		else $('#pagina-anterior').data('page', pageNum - 1);

		if (pageNum + 1 > totalPages) $('#pagina-posterior').data('page', totalPages);
		else $('#pagina-posterior').data('page', pageNum + 1);

		$(table + ' tr:gt(0)').each(function () {		// each tr in table not the header

			trIndex++;								// tr index counter
			// if tr index gt maxRows*pageNum or lt maxRows*pageNum-maxRows fade if out
			if (trIndex > (maxRows * pageNum) || trIndex <= ((maxRows * pageNum) - maxRows)) {
				$(this).hide();
			} else {
				$(this).show();
			} 				//else fade in
		}); 										// end of for each tr in table
	});										// end of on click pagination list
}