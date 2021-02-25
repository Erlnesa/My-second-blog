var header_bk_image_num = 1;

function change_header_image(){
    var header_bk_image = document.getElementById("header");
    if(header_bk_image_num == 1){
        header_bk_image_num = 2;
        header_bk_image.style.backgroundImage = "url('images/background/hx_2.jpg')";
    }else{
        header_bk_image_num = 1;
        header_bk_image.style.backgroundImage = "url('images/background/hx_1.jpg')";
    }
}

function go(){
	window.history.go(-1);
}

