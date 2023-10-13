import "./App.css";
import axios from "axios";
import { useState, useEffect } from "react";
import './index.css'
import Images from "./components/Images";

function App() {
  const [images, setImages] = useState([]);

  const imageApi = "http://localhost:8080/api/v1/images";
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

useEffect(() => {
    handleImageFetch();
  },[])
  
  return (
    <>
      <h1>Upload Images</h1>
      <Images images={images} />
    </>
  );
}

export default App;
