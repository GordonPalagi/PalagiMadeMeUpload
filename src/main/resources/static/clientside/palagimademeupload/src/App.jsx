import "./App.css";
import axios from "axios";
import { useState, useEffect } from "react";
import './index.css'

function App() {
  const [images, setImages] = useState([]);
  // const [users, setUsers] = useState([]);

  const imageApi = "http://localhost:8080/api/v1/images";
  const userApi = "http://localhost:8080/api/v1/users";
  const username = "palagi";
  const password = "password";
  const basicAuth = "Basic " + btoa(username + ":" + password);


 const handleImageFetch = async () => {
  try {
    const response = await axios.get(imageApi, {
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
        Authorization: basicAuth,
      },
    });
    setImages(response.data);
  } catch (error) {
    console.error("Error fetching images:", error);
  }
};
// const handleUserFetch = async () => {
//   try {
//     const response = await axios.get(userApi);
//     setUsers(response.data);
//   } catch (error) {
//     console.error("Error fetching users:", error);
//   }
// };
  

useEffect(() => {
    handleImageFetch();
    handleUserFetch();
  },[])
  
  return (
    <>
      <h1>Upload Images</h1>
      {images.map((img, i) => (
          <div key={i}>
              <img src={img.imagePath} alt={img.name} />
              <p>{img.description}</p>
          </div>
      ))}

      <h1 className="text-xl font-bold text-red-500">Users</h1>
      {users.map((user, i) => (
          <div className="flex" key={i}>
              <p className="px-5">{user.name}:</p>
              <p className="flex-auto">{user.bio}</p>
          </div>
      ))} 
    </>
  );
}

export default App;
