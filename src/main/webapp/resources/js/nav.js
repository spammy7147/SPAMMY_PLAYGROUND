
const collapseEl = document.querySelector(".collapse")
const buttonEl = document.querySelector(".navbar-toggler")

buttonEl.addEventListener('click', () => {
    console.log('버튼클릭')
    if(collapseEl.classList.contains('show')){
        collapseEl.classList.remove('show')
        console.log('show 삭제')
    }else{
        collapseEl.classList.add('show')
        console.log('show 추가')
    }

})

buttonEl.addEventListener('blur', () => {
    console.log('focus해제됨')
    setTimeout(()=> {
        collapseEl.classList.remove("show")
    },500)

})


