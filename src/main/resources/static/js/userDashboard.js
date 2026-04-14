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
		           </div>
        `;
    });

    document.getElementById("rooms").innerHTML = output;
}
