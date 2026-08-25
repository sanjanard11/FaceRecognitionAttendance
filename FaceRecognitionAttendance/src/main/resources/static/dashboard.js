// Total Students
fetch("/student/count")
    .then(response => response.text())
    .then(count => {
        document.getElementById("studentCount").innerText = count;
    });

// Face Registered
fetch("/face/count")
    .then(response => response.text())
    .then(count => {
        document.getElementById("faceCount").innerText = count;
    });
