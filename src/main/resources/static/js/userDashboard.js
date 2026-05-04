async function searchRooms() {


	let url = "/api/userDashboard/rooms?";




	const response = await fetch(url);
	const rooms = await response.json();

	let output = "";

	rooms.forEach(da => {
		output += `
		<div class="jbox">
		               <div class="jbox11">
		               <div><p>${da.name} </p></div><div><p> Price.${da.price}</p></div><div><p> Contact No.${da.phone}</p></div> <div><p>${da.city}</p></div> <div><p>Pincode: ${da.pincode}</p></div>
					   </div>
					   <div class="jbox1">
		               <div><p>${da.roomType}</p></div>
					   </div>
					   
					   <div class="jbox1">
					   <div><p>${da.roomDetails}</p></div>
					   	</div>
					   
					   <div class="jbox1">
					    <div><p>${da.address}</p></div>
					    </div>
					   <div class="jbox1">
					   <div><button><i class="fa-regular fa-thumbs-up"></i></button></div><div><p>${da.status}</p></div>
					   </div>
					   <div class="jbox1">
					   					              <div> <a href="/editRoom/${da.id}" class="edit-btn">Edit</a></div>
													  <div><button onclick="deleteRoom(${da.id})">Delete</button></div>
					   </div>
					  
					   					           
		           </div>
				   
				   
        `;
	});

	document.getElementById("rooms").innerHTML = output;
}

let editId = null;

async function openEditForm(id) {
	editId = id;

	const response = await fetch(`/api/userDashboard/rooms/${id}`);
	const data = await response.json();

	document.getElementById("editName").value = data.name;
	document.getElementById("editPrice").value = data.price;
	document.getElementById("editPhone").value = data.phone;
	document.getElementById("editCity").value = data.city;
	document.getElementById("editPincode").value = data.pincode;
	document.getElementById("editDetails").value = data.roomDetails;
	document.getElementById("editAddress").value = data.address;

	document.getElementById("editSection").style.display = "block";
}

function deleteRoom(id) {

    let confirmDelete = confirm("Do you want to delete this listing?");

    if (confirmDelete) {
        fetch(`/deleteRoom/${id}`, {
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
