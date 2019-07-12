function postData(url = '', data = {}) {
    return fetch(url, {
        method: 'POST',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
            'Content-Type': 'application/json',
        },
        redirect: 'follow',
        referrer: 'no-referrer',
        body: JSON.stringify(data),
    })
    .then(response => response.json());
}

function postd(task) {
    postData('http://localhost:8000/oldage', {"data": task})
  .then()
  .catch();
}

var button1 = document.getElementById('link1');
var button2 = document.getElementById('link2');
var button3 = document.getElementById('link3');

button1.onclick = function() {
    postd(0);
}

button2.onclick = function() {
    postd(1);
}

button3.onclick = function() {
    postd(2);
}