sample
===
* 注释

	select #use("cols")# from area  where  #use("condition")#




cols
===
	name_school,name_course,price_course,name_teacher

updateSample
===
	
	name_school=#nameSchool#,name_course=#nameCourse#,price_course=#priceCourse#,name_teacher=#nameTeacher#

condition
===

	1 = 1  
	@if(!isEmpty(nameSchool)){
	 and name_school=#nameSchool#
	@}
	@if(!isEmpty(nameCourse)){
	 and name_course=#nameCourse#
	@}
	@if(!isEmpty(priceCourse)){
	 and price_course=#priceCourse#
	@}
	@if(!isEmpty(nameTeacher)){
	 and name_teacher=#nameTeacher#
	@}
	
	