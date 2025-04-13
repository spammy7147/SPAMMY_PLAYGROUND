
const e1 = "Equip_L_1"
const e2 = "Equip_L_2"

function pattern(formId, patternno){
	const form = document.getElementById(formId);
	form.querySelector('input[name="patternno"]').value = patternno;
	form.submit();
}

function equip(a,b,c){
	var form = a
	var input = document.createElement('input')
	input.type ='hidden'
	input.name = b
	form.target = '_blank'
	input.value ='Equip Load(1)';
	form.appendChild(input);
	form.submit() ;
	form.removeChild(input);
}

function pattern(pattern1, pattern2, pattern3, pattern4, pattern5) {
	setTimeout(pattern,0,a,b,2);
	setTimeout(pattern,1000,c,d,3);
	setTimeout(pattern,2000,e,f,4);
	setTimeout(pattern,3000,g,h,5);
	setTimeout(pattern,4000,i,j,6);
}

function u_equip_5(a,b,c,d,e,f,g,h,i,j ) {
	setTimeout(equip,0,a,b,2);
	setTimeout(equip,1000,c,d,3);
	setTimeout(equip,2000,e,f,4);
	setTimeout(equip,3000,g,h,5);
	setTimeout(equip,4000,i,j,6);
}