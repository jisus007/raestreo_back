$(document).ready(function(){
	
	
	var date_ini=$('input[name="fIni"]'); //our date input has the name "date"
	var date_fin=$('input[name="fFin"]'); //our date input has the name "date"
	var date_reg=$('input[name="fechaR"]'); //our date input has the name "date"
	
    var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
    var options={
      format: 'dd/mm/yyyy',
      startDate: '-3d',
      container: container,
      todayHighlight: true,
      autoclose: true,
    };
    date_ini.datepicker(options);
    date_fin.datepicker(options);
    date_reg.datepicker(options);
});