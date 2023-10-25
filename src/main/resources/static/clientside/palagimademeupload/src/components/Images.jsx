import React from "react";

function Images({ images }) {
  return (
    <>
      {images.map((img, i) => (
        <div className="py-10" key={i}>
          <img
            className="inset-0 w-full h-full object-cover max-w-screen-sm"
            src={img.imagePath}
            alt={img.name}
          />
          <div className="flex flex-col text-left py-3">
            <p className="text-2xl">{img.studentName}</p>
            <p className="text-2xl">{img.title}</p>
            <p>{img.description}</p>
          </div>
        </div>
      ))}
    </>
  );
}

export default Images;
