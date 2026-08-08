let capturedImage = null;


// Load students
window.onload = function(){

    loadStudents();

};



// Get students from backend

function loadStudents(){

    fetch("http://localhost:8080/student")

        .then(response => response.json())

        .then(students => {


            let select =
                document.getElementById("studentSelect");


            select.innerHTML =
                '<option value="">Select Student</option>';



            students.forEach(student => {


                let option =
                    document.createElement("option");


                option.value =
                    student.id;


                option.text =
                    student.name + " - " + student.usn;


                select.appendChild(option);


            });


        })

        .catch(error=>{

            console.log("Student Error :",error);

        });


}




// Open Camera

function openCamera(){


    navigator.mediaDevices
        .getUserMedia({
            video:true
        })


        .then(stream=>{


            let video =
                document.getElementById("video");


            video.srcObject = stream;


        })


        .catch(error=>{


            console.log(error);

            alert("Camera permission denied");


        });


}




// Capture Face

function captureFace(){


    let video =
        document.getElementById("video");


    let canvas =
        document.getElementById("canvas");


    let context =
        canvas.getContext("2d");



    context.drawImage(
        video,
        0,
        0,
        canvas.width,
        canvas.height
    );



    capturedImage =
        canvas.toDataURL("image/png");



    alert("Face captured successfully");


}






// Register Face

async function registerFace(){


    let studentId =
        document.getElementById("studentSelect").value;



    if(studentId === ""){

        alert("Please select student");

        return;

    }




    if(capturedImage === null){


        alert("Please capture face");

        return;

    }



    let formData =
        new FormData();



    formData.append(
        "studentId",
        studentId
    );



    let blob =
        await fetch(capturedImage)
            .then(res=>res.blob());



    formData.append(
        "image",
        blob,
        "face.png"
    );





    fetch(
        "http://localhost:8080/face/registerFace",
        {

            method:"POST",

            body:formData

        })



        .then(response=>response.text())


        .then(data=>{


            alert(data);


        })



        .catch(error=>{


            console.log(error);

            alert("Registration failed");


        });



}