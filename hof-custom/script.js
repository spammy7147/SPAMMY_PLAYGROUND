const 전투 = {
				'' : 'Mine01'
			}

const 모험 = {
				'뒷산의 광산' : 'Mine01',
				'뒷산의 숲' : 'Herb01',
				'천년제 무투회' : 'festival01',
				'천년제 무투회(HARD)' : 'festival011',
				'마법신의 탑(상층(裏))' : 'mg06',
				'천체관' : 'mg04',
				'태양의 제단' : 'Pyra55',
				'마을 묘지' : 'Grave001'
			}


function pattern(formId, patternno){
	const form = document.getElementById(formId);
	form.querySelector('input[name="patternno"]').value = patternno;
	form.submit();
}


function party_pattern(class1, pattern1, class2, pattern2, class3, pattern3, class4, pattern4, class5, pattern5) {
	setTimeout(() => {pattern(class1, pattern1)}, 0)
	setTimeout(() => {pattern(class2, pattern2)}, 500)
	setTimeout(() => {pattern(class3, pattern3)}, 1000)
	setTimeout(() => {pattern(class4, pattern4)}, 1500)
	setTimeout(() => {pattern(class5, pattern5)}, 2000)
}

function battle(formId, action) { 
	const form = document.getElementById(formId);
	form.action = action
	form.submit();
}

function battle_chain(party) {
	let idx = 0;
	for(key in 모험) {
		let action = 'http://sic.zerosic.com/ZeroHOF/index.php?sp_common=' + 모험[key] 
		setTimeout(() => {battle(party, action)}, idx++ * 1000)
	}

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



function u_equip_5(a,b,c,d,e,f,g,h,i,j ) {
	setTimeout(equip,0,a,b,2);
	setTimeout(equip,1000,c,d,3);
	setTimeout(equip,2000,e,f,4);
	setTimeout(equip,3000,g,h,5);
	setTimeout(equip,4000,i,j,6);
}