import "./App.css";
import axios from "axios";
import { useState, useEffect } from "react";

function App() {
  const [images, setImages] = useState([]);
  const [users, setUsers] = useState([]);

  const api = "http://localhost:8080/api/v1/images";
  const username = "palagi";
  const password = "password";
  const basicAuth = "Basic " + btoa(username + ":" + password);

  useEffect(() => {
    axios
      .get(api, {
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
          Authorization: basicAuth,
        },
      })
      .then((response) => {
        setImages(response.data);
      })
      .catch((error) => {
        console.error("Error fetching images:", error);
      });
  }, []);


  useEffect(() => {
    axios.get("http://localhost:8080/api/v1/users")
    .then((response) => {
      setUsers(response.data);
    }
  )},[])


  // function byteArrayToDataUrl(byteArray) {
  //   console.log("Received bytes:", byteArray);
  //   console.log("Length of received bytes:", byteArray.length);

  //   const base64 = btoa(
  //     new Uint8Array(byteArray).reduce((data, byte) => data + String.fromCharCode(byte), "")
  //   );

  //   console.log(base64)
  //   return `data:image/jpeg;base64,${base64}`;
  // }

//   function byteArrayToDataUrl(byteArray) {
//     const base64 = btoa(
//         byteArray.map(byte => String.fromCharCode(byte)).join('')
//     );
//     return `data:image/jpeg;base64,${base64}`;
// }

function byteArrayToDataUrl(byteArray) {
    // console.log("Received bytes:", byteArray);
    // console.log("Length of received bytes:", byteArray.length);
  const base64 = btoa(
      Array.from(byteArray).map(byte => String.fromCharCode(byte)).join('')
  );
    // console.log("String: " + base64)
    return `data:image/jpeg;base64,${base64}`;
}



  return (
    <>
      {/* <h1>Upload Images</h1> */}
      {/* {images.map((img, i) => (
          <div key={i}>
              <img src={byteArrayToDataUrl(img.imageBytes)} alt={img.name} />
              <p>{img.description}</p>
          </div>
      ))} */}
      <h1>Users</h1>
      {users.map((user, i) => (
          <div key={i}>
              <p>{user.name}</p>
              <p>{user.bio}</p>
          </div>
      ))} 
    </>
  );
}

export default App;
