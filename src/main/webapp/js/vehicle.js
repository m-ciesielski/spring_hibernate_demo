
function addVehicle(ctx){
    // send ajax
    var vehicle = getFormData($("#add_vehicle_form"));
    $.ajax({
        url: ctx + '/api/vehicles/',
        type : "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        dataType : 'json',
        data : JSON.stringify(vehicle),
        success : function(result) {
            console.log(result);
            window.location.href = ctx + '/vehicles.jsp';
        },
        error: function(xhr, resp, text) {
            console.log(xhr, resp, text);
        }
    })

    return false;
};


function editVehicle(ctx){
    // send ajax
    var vehicle = getFormData($("#edit_vehicle_form"));
    $.ajax({
        url: ctx + '/api/vehicles/${vehicle.id}',
        type : "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        dataType : 'json',
        data : JSON.stringify(vehicle),
        success : function(result) {
            console.log(result);
            window.location.href = ctx + '/vehicles.jsp';
        },
        error: function(xhr, resp, text) {
            console.log(xhr, resp, text);
        }
     })
    return false;
};


function deleteVehicle(vehicleId, ctx){
    // send ajax
    $.ajax({
        url: ctx + '/api/vehicles/'+ vehicleId,
        type : "DELETE",
        success : function(result) {
            console.log(result);
            window.location.href = ctx + '/vehicles.jsp';
        },
        error: function(xhr, resp, text) {
            console.log(xhr, resp, text);
        }
    })

    return false;
};

function getVehicles(ctx){
    return $.ajax({
            url: ctx + '/api/vehicles/',
            type : "GET",
            success : function(result) {
                console.log(result);
            },
            error: function(xhr, resp, text) {
                console.log(xhr, resp, text);
            }
        });
}

function getVehicle(vehicleId, ctx){
    return $.ajax({
            url: ctx + '/api/vehicles/' + vehicleId,
            type : "GET",
            success : function(result) {
                console.log(result);
            },
            error: function(xhr, resp, text) {
                console.log(xhr, resp, text);
            }
        });
}

function generateVehiclesTable(ctx){
    getVehicles(ctx).done( function (result){
        var vehicles = result;

        var generatedTable = '';
        var row;
        for (var i = 0, length = vehicles.length; i < length; i++) {
            row = '<tr>';
            row += '<td>' + vehicles[i].id + '</td>';
            row += '<td>' + vehicles[i].brand + '</td>';
            row += '<td>' + vehicles[i].model + '</td>';
            row += '<td>' + vehicles[i].engine + '</td>';
            row += '<td>' + vehicles[i].vin + '</td>';
            row += '<td>' + vehicles[i].horsepower + '</td>';
            row += '<td>' + vehicles[i].mileage + '</td>';
            row += '<td><a class="btn btn-primary edit-vehicle-button" href="vehicles/edit/'+ vehicles[i].id+ '">Edytuj</a></td>';
            row += '<td><button class="btn btn-danger delete-vehicle-button" id="delete-button-'+ vehicles[i].id+ '">Usuń</button></td>';
            row += '</tr>';
            generatedTable += row;
        }
        $('#vehicles_table').append(generatedTable);

        $( ".delete-vehicle-button" ).button().on( "click", function() {
                var $this = $(this).closest('tr').children();
                var vehicleBrand = $this.eq(1).text();
                var vehicleModel = $this.eq(2).text();
                var vehicleVIN = $this.eq(4).text();
                vehicleId = $this.eq(0).text();
                console.log("deleting");
                bootbox.confirm("Usunąć pojazd "+vehicleBrand+" "+vehicleModel+"("+vehicleVIN+")?" , function(result){
                  if(result == true)
                    deleteVehicle(vehicleId, ctx);
                });

            });

    })
}


function fillVehicleEditForm(vehicleId, ctx){
    console.log(vehicleId);
    getVehicle(vehicleId, ctx).done( function (result){
        var vehicle = result;
        console.log(vehicle);
        document.getElementById('vehicleId').value = vehicle.id;
        document.getElementById('brand').value = vehicle.brand;
        document.getElementById('model').value = vehicle.model;
        document.getElementById('engine').value = vehicle.engine;
        document.getElementById('vin').value = vehicle.vin;
        document.getElementById('mileage').value = vehicle.mileage;
        document.getElementById('horsepower').value = vehicle.horsepower;
        document.getElementById('productionDate').value = vehicle.productionDate;
    })
}