const confirmBySMSCheckbox = document.getElementById('confirmBySMS');
const phoneNumberInput = document.getElementById('phoneNumberInput');

confirmBySMSCheckbox.addEventListener('change', function() {
    if (this.checked) {
        phoneNumberInput.style.display = 'block';
    } else {
        phoneNumberInput.style.display = 'none';
    }
});