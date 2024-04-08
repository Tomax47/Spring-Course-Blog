
// HANDLING ADDING NEW SERVICES
let addServiceBtn = document.getElementById('addServiceBtn');

let name = document.getElementById('name');
let date = document.getElementById('date');
let cost = document.getElementById('cost');

addServiceBtn.addEventListener(`click`, function () {
    addService(name.value, cost.value, date.value)
});

// Rendering the services in the INSERT service page!

let Refetch = () => {
    console.log("RE-FETCH FUNCTION HAS BEEN CALLED")
    $.ajax({
        type: "GET",
        url: "/allServices",
        success: function (response) {
            /** This must be a jQuery object so the <table> element gets fetched as a html element and processed properly
             therefore, we have to wrap it up in a jQuery constructor by fetching it through < $('#ElementIdHere') >.
             Otherwise, it will show the error -> table ain't have no method html,
             if we declare it the usual way as "let table = document.getElementById etc..." in the rendering function */
            let servicesTable = $('#servicesTable');
            RenderServicesTable(response, servicesTable)
        },
        dataType: "json",
        contentType: "application/json"
    })
};

function RenderServicesTable(responseServices, table) {

    console.log(`RENDERING FUNCTION HAS BEEN CALLED! Services length -> ${responseServices.length}`);
    let tableContent = '<tr>\n' +
        '                          <th>id</th>' +
        '                          <th>Name</th>' +
        '                          <th>Cost</th>' +
        '                          <th>Date</th>' +
        '                      </tr>';

    for (let i = 0; i < responseServices.length; i++) {
        tableContent += '<tr>';
        tableContent += '    <td>'+ responseServices[i]['id'] +'</td>';
        tableContent += '    <td>'+ responseServices[i]['name'] +'</td>';
        tableContent += '    <td>'+ responseServices[i]['cost'] +'</td>';
        tableContent += '    <td>'+ responseServices[i]['date'] +'</td>';
        tableContent += '</tr>';
    };

    console.log(tableContent);
    table.html(tableContent);
};

// Adding a new service
function addService(name, cost, date) {

    console.log('clicked');
    let data = {
        "name": name,
        "cost": cost,
        "date": date
    };

    $.ajax({
        type: "POST", // Request method
        url: "/services", // Targeted URL
        data: JSON.stringify(data),  // JSON-object to string json
        success: Refetch,
        // Data type to be sent
        dataType: "json",
        contentType: "application/json"
    });
}

// HANDLING FETCHING ALL SERVICES 'SEARCH QUERY'
let findAllBtn = document.getElementById('searchBtn');
let page = document.getElementById('page');
let size = document.getElementById('size');
let q = document.getElementById('q');

findAllBtn.addEventListener(`click`, function () {
    searchServices(page.value, size.value, q.value);
});

function searchServices(page, size, q) {

    let data = {
        "page": page,
        "size": size,
        "q": q
    };

    $.ajax({
        type: "POST",
        url: "//paper/service/search",
        data: JSON.stringify(data),
        success: function(data) {
            displayServices(data);
        },
        error: "redirect:/paper/service/search",
        dataType: "json",
        contentType: "application/json"
    });
}

function displayServices(services) {
    let serviceList = document.getElementById('serviceList');
    serviceList.empty();

    services.forEach(function(service) {
        let listItem = $('<li>').text(service.name);
        serviceList.append(listItem);
    });
};

