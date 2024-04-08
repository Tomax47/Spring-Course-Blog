
let alertMessage;
function ThrowAlert (message, exec) { // Preventing double error modal from popping up
    exec === true ? alert(message) :  alertMessage = message;
    alertMessage.length > 0 ? alertMessage = "Something went wrong! Could not upload the file" : alertMessage; // Default error msg "Unknown error"
};
function sendFile() {

    let formData = new FormData(); // Getting the raw data tp send to the backend

    let files = ($('#file'))[0]['files'];  // Getting the file from the input

    [].forEach.call(files, function (file, i, files) {  // Adding the collected file to the raw data to be sent

        if (file.type.match(/image\/*/)) { // Accepting only image type
            formData.append("file", file);
        } else {
            ThrowAlert("Invalid file format!", false);
            return;
        }

        if (file.size > 2 * 1024 * 1024) {
            ThrowAlert("File too large! You can't upload files larger than 2MB!", false);
            return;
        }
    });

    $.ajax({
        type: "POST",
        url: "/files",
        data: formData,
        processData: false,
        contentType: false
    })
        .done(function (response) { // Per successful request
            let fileUrl = 'http://localhost:8080/files/' + response;
            $('#photo').append('<img src = "' + fileUrl + '"/>');
        })
        .fail(function () { // Failure case "Popping up alert modal"
            //Something went wrong! Could not upload the file
            ThrowAlert(alertMessage, true);
        });
};