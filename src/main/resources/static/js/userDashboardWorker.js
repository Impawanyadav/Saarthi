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
		           </div>
        `;
    });

    document.getElementById("workers").innerHTML = output;
}
