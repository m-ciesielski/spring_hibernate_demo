
function addDriver(ctx){
    // send ajax
    var driver = getFormData($("#add_driver_form"));
    getAddress(driver.addressId, ctx).done(function(result) {

        // Build final Driver JSON after receiving Address response
        driver.address=result;
        delete driver["addressId"];
        console.log(JSON.stringify(driver));

        $.ajax({
            url: ctx + '/api/drivers/',
            type : "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType : 'json',
            data : JSON.stringify(driver),
            success : function(result) {
                console.log(result);
                window.location.href = ctx + '/drivers.jsp';
            },
            error: function(xhr, resp, text) {
                console.log(xhr, resp, text);
            }
        })
    }).fail(function() {
        // TODO: Handle error of getting Address response
        console.log("Failed to get Address with id:"+driver.addressId);
        return -1;
        });

    return false;
};


function editDriver(ctx){
    // send ajax
    var driver = getFormData($("#edit_driver_form"));
    getAddress(driver.addressId, ctx).done(function(result) {
        // Build final Driver JSON after receiving Address response
        driver.address=result;
        delete driver["addressId"];
        console.log(JSON.stringify(driver));
        $.ajax({
            url: ctx + '/api/drivers/${driver.id}',
            type : "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType : 'json',
            data : JSON.stringify(driver),
            success : function(result) {
                console.log(result);
                window.location.href = ctx + '/drivers.jsp';
            },
            error: function(xhr, resp, text) {
                console.log(xhr, resp, text);
            }
        })
    }).fail(function() {
            // TODO: Handle error of getting Address response
            console.log("Failed to get Address with id:"+driver.addressId);
            return -1;
        });

    return false;
};


function deleteDriver(driverId, ctx){
    // send ajax
    $.ajax({
        url: ctx + '/api/drivers/'+ driverId,
        type : "DELETE",
        success : function(result) {
            console.log(result);
            window.location.href = ctx + '/drivers.jsp';
        },
        error: function(xhr, resp, text) {
            console.log(xhr, resp, text);
        }
    })

    return false;
};

function getDrivers(ctx){
    return $.ajax({
            url: ctx + '/api/drivers/',
            type : "GET",
            success : function(result) {
                console.log(result);
            },
            error: function(xhr, resp, text) {
                console.log(xhr, resp, text);
            }
        });
}

function getDriver(driverId, ctx){
    return $.ajax({
            url: ctx + '/api/drivers/' + driverId,
            type : "GET",
            success : function(result) {
                console.log(result);
            },
            error: function(xhr, resp, text) {
                console.log(xhr, resp, text);
            }
        });
}

function generateDriversTable(ctx){
    getDrivers(ctx).done( function (result){
        var drivers = result;

        var generatedTable = '';
        var row;
        for (var i = 0, length = drivers.length; i < length; i++) {
            row = '<tr>';
            row += '<td>' + drivers[i].id + '</td>';
            row += '<td>' + drivers[i].firstName + '</td>';
            row += '<td>' + drivers[i].lastName + '</td>';
            row += '<td>' + drivers[i].pesel + '</td>';
            row += '<td>' + drivers[i].salary + '</td>';
            row += '<td>' + drivers[i].salaryBonus + '</td>';
            address = drivers[i].address.street + ' ' + drivers[i].address.houseNumber + ',' + drivers[i].address.code + ' ' + drivers[i].address.town;
            row += '<td>' + address + '</td>';
            row += '<td><a class="btn btn-default details-driver-button" href="drivers/'+ drivers[i].id+ '"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></button></td>';
            row += '<td><a class="btn btn-primary edit-driver-button" href="drivers/edit/'+ drivers[i].id+ '">Edytuj</a></td>';
            row += '<td><button class="btn btn-danger delete-driver-button" id="delete-button-'+ drivers[i].id+ '">Usuń</button></td>';
            row += '</tr>';
            generatedTable += row;
        }
        $('#drivers_table').append(generatedTable);

        $(".delete-driver-button").button().on(
                "click",
                function() {
                    var $this = $(this).closest('tr').children();
                    var driverFirstName = $this.eq(1).text();
                    var driverLastName = $this.eq(2).text();
                    var driverPesel = $this.eq(3).text();
                    driverId = $this.eq(0).text();
                    console.log("deleting");
                    bootbox.confirm("Usunąć kierowcę " + driverFirstName + " "
                            + driverLastName + "(" + driverPesel + ")?",
                            function(result) {
                                if (result == true)
                                    deleteDriver(driverId, ctx);
                            });
        });

    })
}


function fillDriverEditForm(driverId, ctx){
    console.log(driverId);
    getDriver(driverId, ctx).done( function (result){
        var driver = result;
        console.log(driver);
        document.getElementById('driverId').value=driver.id;
        document.getElementById('firstName').value=driver.firstName;
        document.getElementById('lastName').value=driver.lastName;
        document.getElementById('pesel').value=driver.pesel;
        document.getElementById('salary').value=driver.salary;
        document.getElementById('salaryBonus').value=driver.salaryBonus;
        console.log("id adresu: " + driver.address.id);
        var addressId = driver.address.id;
        generateAddressSelectList(addressId, ctx);
    })
}  
