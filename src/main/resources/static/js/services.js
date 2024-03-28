
// HANDLING ADDING NEW SERVICES
let addServiceBtn = document.getElementById('addServiceBtn');

let name = document.getElementById('name');
let date = document.getElementById('date');
let cost = document.getElementById('cost');

addServiceBtn.addEventListener(`click`, function () {
    addService(name.value, cost.value, date.value)
});

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
        success: "redirect:/services",
        // Data type to be sent
        dataType: "json",
        contentType: "application/json"
    });
}

// HANDLING FETCHING ALL SERVICES
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
