// Total Students
fetch("http://localhost:8080/student/count")
    .then(response => response.text())
    .then(count => {
        document.getElementById("studentCount").innerText = count;
    });

// Face Registered
fetch("http://localhost:8080/face/count")
    .then(response => response.text())
    .then(count => {
        document.getElementById("faceCount").innerText = count;
    });