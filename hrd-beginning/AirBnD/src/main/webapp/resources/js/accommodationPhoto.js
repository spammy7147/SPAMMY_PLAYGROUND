const imgFileBtn = document.querySelector('#imgFileBtn');
const imgFile = document.querySelector('#imgFile');

imgFileBtn.addEventListener('click',()=>{


    imgFile.click();
    }
);

function setThumbnail(event) {
    while(document.querySelector("div#image_container").hasChildNodes()){
        document.querySelector("img").remove()
    }
    for (var image of event.target.files) {
        var reader = new FileReader();

        reader.onload = function(event) {
            var img = document.createElement("img");
            img.setAttribute("src", event.target.result);
            img.setAttribute("class", "img-thumbnail wh-300")
            document.querySelector("div#image_container").appendChild(img);
        };
        console.log(image);
        reader.readAsDataURL(image);
    }
}

