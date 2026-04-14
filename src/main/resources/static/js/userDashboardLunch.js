async function searchLunch(){
	
	
	let url="/api/userDashboard/lunch?";
	
	
	
	const response=await fetch(url);
	const lunch= await response.json();
	
	let output = "";

	   lunch.forEach(da => {
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

	   document.getElementById("lunch").innerHTML = output;
}