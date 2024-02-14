document.addEventListener('DOMContentLoaded', function() {
    var form = document.getElementById('preferencesForm');

    form.onsubmit = function(e) {
        e.preventDefault();

        var formData = new FormData(form);

        fetch('PreferencesServlet', {
            method: 'POST',
            body: formData
        })
        .then(function(response) {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();
        })
        .then(function(text) {
            console.log(text);
            window.location.href = '3rdsite.html';
        })
        .catch(function(error) {
            console.error(error);
        });
    };
});
