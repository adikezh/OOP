document.addEventListener('DOMContentLoaded', function() {
    var form = document.getElementById('preferencesForm');

    form.onsubmit = function(e) {
        e.preventDefault(); // Prevent the default form submission

        var formData = new FormData(form);

        fetch('PreferencesServlet', {
            method: 'POST',
            body: formData
        })
        .then(function(response) {
            return response.text();
        })
        .then(function(text) {
            console.log(text);
            // You might want to do some action after the data is successfully submitted, like redirecting
            // window.location.href = 'some-success-page.html';
        })
        .catch(function(error) {
            console.error(error);
        });
    };
});
