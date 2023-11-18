let addProductBtn = document.getElementById("addProductBtn");
let adminFormContClose = document.getElementById("adminFormContClose");
let adminProductFormCont = document.getElementById("adminProductFormCont");
let adminProductForm = document.getElementById("adminProductForm");


let productName = document.getElementById("name");
let productNature = document.getElementById("nature");
let productBreed = document.getElementById("breed");

let adminProductsCont = document.getElementById("adminProductsCont");
let postProductBtn = document.getElementById("postProductBtn");
let patchProductBtn = document.getElementById("patchProductBtn");
let goToHomePage = document.getElementById("goToHomePage");

let baseURL = "http://localhost:8080"; 

let adminProductsData = [];

let idToBeEdited = null;


patchProductBtn.addEventListener("click", (e) => {
  e.preventDefault();
  let editedProductDetails = {
    breed: productBreed.value,
  
    name: productName.value,
    nature: productNature.value
   
  };
  console.log(editedProductDetails, "edited", idToBeEdited);
  patchAndUpdateProduct(idToBeEdited, editedProductDetails);
});


let AllData = []

  fetch(`${baseURL}/allDogs`)
    .then((req) => req.json())
    .then((res) => {
      adminProductsData = [...res];
      console.log(adminProductsData)
      displayDogList(adminProductsData)
      AllData =  adminProductsData 
      if(adminProductsData.length == 0)
      {
        document.getElementById("deleteAll").style.display = "none"
      }
     
    })
    .catch((err) => {
     
      console.log(err);
    });


// Add Product Form start ------------------------------------------------
addProductBtn.addEventListener("click", () => {

  adminProductFormCont.style.display = "block";
  patchProductBtn.style.display = "none";
});

adminFormContClose.addEventListener("click", () => {
  adminProductFormCont.style.display = "none";
 
  productName.value = "";
  productBreed.value = "";
  productNature.value = "";

});

const DeleteAll = document.getElementById("deleteAll")

DeleteAll.addEventListener("click", () => {

  fetch(`${baseURL}/deleteAllDogs`, {
    method: "DELETE",
    headers: {
      "Content-type": "application/json",
    
    },
  })
   
    .then((res) => {
      console.log(res, "res");
      fetchData()
    })
    .catch((err) => console.log(err));

});

adminProductForm.addEventListener("submit", (e) => {
  e.preventDefault();
  console.log(productBreed)
  let productObj = {
 
   
    breed: productBreed.value,
    name: productName.value,
    nature: productNature.value
  };

  addProduct(productObj);
  window.location.reload();
});

function addProduct(data) {
  console.log(data);
  fetch(`${baseURL}/dogs`, {
    method: "POST",
    headers: {
      "Content-type": "application/json",
       
      
    },
    body: JSON.stringify(data),
  })
    .then((req) => req.json())
    .catch((err) => alert(JSON.stringify(err)));
    fetchData()
     
    
    
}


// Add Product Form start ------------------------------------------------

function patchAndUpdateProduct(idToBeEdited,editedProductDetails) {
  editedProductDetails.dog_uniqueid=parseInt(idToBeEdited)
  fetch(`${baseURL}/updatesDogDetails/${idToBeEdited}`, {
    method: "PATCH",
    headers: {
      "Content-type": "application/json",
  
    },
    body: JSON.stringify(editedProductDetails),
  })
    
    .then((res) => {
      console.log(res, "res");
      idToBeEdited = null;
      fetchData()
      window.location.reload()
    })
    .catch((err) => console.log(err));
}

function deleteProduct(dog_uniqueid) {
  console.log(`Deleting dog with dog_uniqueid: ${dog_uniqueid}`);
  fetch(`${baseURL}/deleteDogs/${dog_uniqueid}`, {
    method: "DELETE",
    headers: {
      "Content-type": "application/json",
     
    },
  })

  .then((res) => {
    console.log("Delete response:", res);
    fetchData(); 
    console.log(`Successfully deleted dog with dog_uniqueid: ${dog_uniqueid}`);
  })
  .catch((err) => {
    console.error("Error during delete request:", err.message);
    
  });
}



function fetchData ()
{



  fetch(`${baseURL}/allDogs`)
    .then((req) => req.json())
    .then((res) => {
      adminProductsData = [...res];
      console.log(adminProductsData)
      displayDogList(adminProductsData)
      AllData=  adminProductsData
    
    })
    .catch((err) => {
      console.log(err);
    });


}

const DogsContainer = document.getElementById("dogs_container")


function displayDogList(data){
  DogsContainer.innerHTML=""
  data.forEach((data) => {

  DogsContainer.innerHTML += dogList(data)
  })

}



function populateEditProduct(id) {
   console.log(id);

const data = AllData.find((item) => item.dog_uniqueid == id) 
  console.log(AllData)
  console.log(data)
  adminProductFormCont.style.display = "block";
  patchProductBtn.style.display = "block";
  postProductBtn.style.display = "none";

  idToBeEdited = data.dog_uniqueid;
  productBreed.value = data.breed;
  productName.value = data.name;
  productNature.value = data.nature;
  
 
}
function dogList(data) {
  return `
    <tr>
      <td>${data.name}</td>
      <td>${data.breed}</td>
      <td>${data.nature}</td>
      <td>
        <span onclick="populateEditProduct('${data.dog_uniqueid}')" class="edit_button">edit</span>
        <span onclick="deleteProduct('${data.dog_uniqueid}')" class="delete_button">Delete</span>
      </td>
    </tr>
  `;
}
