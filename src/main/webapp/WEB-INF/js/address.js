function getAddress(id, ctx){
    return $.ajax({
        url: ctx + '/api/addresses/' + id,
        type : "GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success : function(result) {
            console.log(result);
        },
        error: function(xhr, resp, text) {
            console.log(xhr, resp, text);
        }
    })
}

function getAddresses(ctx){
    return $.ajax({
        url: ctx + '/api/addresses/',
        type : "GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success : function(result) {
            console.log(result);
        },
        error: function(xhr, resp, text) {
            console.log(xhr, resp, text);
        }
    })
}

function generateAddressSelectList(selectedId, ctx){
    getAddresses(ctx).done( function (result){
        var addresses = result;
        var generatedOptions;
        var option;

        console.log(selectedId);
        for (var i = 0, length = addresses.length; i < length; i++) {
            if (addresses[i].id == selectedId){
                var option = '<option value=' + addresses[i].id + '" selected >' + addresses[i].street + ' ' + addresses[i].houseNumber + ', ' + addresses[i].town + ' ' + addresses[i].code + '</option>';
            }
            else{
                var option = '<option value=' + addresses[i].id + '>' + addresses[i].street + ' ' + addresses[i].houseNumber + ', ' + addresses[i].town + ' ' + addresses[i].code + '</option>';
            }
            
            generatedOptions += option;
        }

        $('#addressId').append(generatedOptions);
    })
}