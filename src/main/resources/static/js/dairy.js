async function searchDairy(){
	
	let city=document.getElementById("city").value;
	let pincode=document.getElementById("pincode").value;
	
	let url="/api/dairy/search?";
	
	if (city) url+=`city=${city}&`;
	if (pincode) url+=`pincode=${pincode}&`;
	
	const response=await fetch(url);
	const dairy= await response.json();
	
	let output = "";

	   dairy.forEach(da => {
	       output += `
	           <div class="jbox">
	               <div class="jbox11">
	               <div><p>${da.name} </p></div><div><p> Contact No.${da.phone}</p></div> <div><p>${da.city}</p></div> <div><p>Pincode: ${da.pincode}</p></div>
				   </div>
				   <div class="jbox1">
	               <div><p>${da.menuPrice}</p></div>
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

	   document.getElementById("dairy").innerHTML = output;
}