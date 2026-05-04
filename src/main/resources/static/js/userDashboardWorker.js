async function searchJobs() {
    

    let url = "/api/userDashboard/worker?";

    

    const response = await fetch(url);
    const workers = await response.json();

    let output = "";

    workers.forEach(da => {
        output += `
		<div class="jbox">
		               <div class="jbox11">
		               <div><p>${da.name} </p></div><div><p>${da.work}</p></div><div><p> Contact No.${da.phone}</p></div> <div><p>${da.city}</p></div> 
					   </div>
					   
					   <div class="jbox1">
					    <div><p>${da.description}</p></div>
					    </div>
					   <div class="jbox1">
					   <div><button><i class="fa-regular fa-thumbs-up"></i></button></div><div><p>${da.status}</p></div>
					   </div>
					   <div class="jbox1">
					   				   					   					              <div> <a href="/editWorker/${da.id}" class="edit-btn">Edit</a></div>
																						  <div><button onclick="deleteWorker(${da.id})">Delete</button></div>
					   				   					   </div>
		           </div>
        `;
    });

    document.getElementById("workers").innerHTML = output;
}

function deleteWorker(id) {

    let confirmDelete = confirm("Do you want to delete this listing?");

    if (confirmDelete) {
        fetch(`/deleteWorker/${id}`, {
            method: "DELETE"   
        })
        .then(response => {
            if (response.ok) {
                alert("Deleted successfully");
                location.reload(); // refresh list
            } else {
                alert("Error deleting");
            }
        })
        .catch(error => console.error(error));
    }
}

