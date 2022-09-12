$(function(){

    const token = $('#csrf').val()
    const header = $('#csrf').attr("name")
    const url = $('#accommodationId').val()

    $('#addressSubmitBtn').click(function (){

        const address = {
            country: $('#country').val(),
            city : $('#city').val(),
            district : $('#district').val(),
            road : $('#road').val(),
            room : $('#room').val()
        }
        console.log(header)
        console.log(token)
        console.log(address)
        console.log(url)
        $.ajax({
            type: "POST",
            url: "/hosting/accommodation/updateAddress/"+url,
            headers: {
                "Content-Type": "application/json"
            },
            data: JSON.stringify(address),
            dataType : "text",
            beforeSend : function(csrf) {
                csrf.setRequestHeader(header,token)
            },
            success: function() {
                alert("주소 변경 완료")
            },
            error : function () {
                alert("주소 변경 실패")
            }
        })
    })

    $('#houseSubmitBtn').click(function (){
        const houseInfo = {
            name : $('#name').val(),
            type : $('#type').val(),
            maxNumberOfGuest : $('#maxNumberOfGuest').val(),
            numberOfBedroom : $('#numberOfBedroom').val(),
            numberOfBed : $('#numberOfBed').val(),
            numberOfBathroom : $('#numberOfBathroom').val(),
            contactNumber : $('#contactNumber').val(),
            price : $('#price').val(),
            description :$('#description').val()
        }
        console.log(houseInfo)
        $.ajax({
            type: "POST",
            url: "/hosting/accommodation/updateHouse/"+url,
            beforeSend : function(xhr) {
                xhr.setRequestHeader(header,token)
            },
            headers: {
                "Content-Type": "application/json"
            },
            data: JSON.stringify(houseInfo),
            dataType : "text",
            success: function() {
                alert("호스팅 정보 변경 완료")
            },
            error : function () {
                alert("호스팅 정보 변경 실패")
            }
        })
    })

})

