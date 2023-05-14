var index=0;
var arr_anh=[
    "/styles/img/banner/banner6.png",
    "/styles/img/banner/banner4.jpg",
    "/styles/img/banner/banner5.jpg",
    "/styles/img/banner/banner1.jpg",
    "/styles/img/banner/banner3.jpg",
]
function prev(){
    index--;
    if(index <-0) index = arr_anh.length-1;
    document.getElementById("hinh").src=arr_anh[index];
    
}
function next(){
    index++;
    if(index==arr_anh.length) index = 0;
    document.getElementById("hinh").src=arr_anh[index];
}
setInterval("next()",5000);

const seebox = document.querySelector('.js-logout')
const logoutbutton = document.querySelector('.js-formlogout')

function logout(){
	logoutbutton.classList.add('logout-active')
}
const hide = () => {
	document.querySelector('.alert_main').classList.add('hide');
}
const hideout = () => {
	document.querySelector('.alert_main').classList.remove('hide');
}
const hide2 = () => {
	document.querySelector('.alert_main2').classList.add('hide');
}
const hideout2 = () => {
	document.querySelector('.alert_main2').classList.remove('hide');
}
const hide3 = () => {
	document.querySelector('.alert_main3').classList.add('hide');
}
const hideout3 = () => {
	document.querySelector('.alert_main3').classList.remove('hide');
}

