DROP TABLE IF EXISTS Image;
DROP TABLE IF EXISTS Notes;
DROP TABLE IF EXISTS Students;

-- -- Creating the Students table
CREATE TABLE Students (
                          id BIGSERIAL PRIMARY KEY, -- Auto incrementing ID
                          username TEXT NOT NULL,
                          password TEXT NOT NULL,
                          email TEXT NOT NULL,
                          dateRegistered TIMESTAMP,
                          timeRegistered TIMESTAMP
);


-- Creating the Image table
CREATE TABLE Images (
                       id BIGSERIAL PRIMARY KEY, -- Auto incrementing ID
                       imageUrl TEXT NOT NULL,
                       studentName TEXT NOT NULL,
                       studentId BIGINT REFERENCES Students(id), -- foreign key reference to Students
                       title TEXT,
                       description TEXT,
                       dateSubmitted TIMESTAMP,
                       timeSubmitted TIMESTAMP
);

-- Inserting data into the Students table
INSERT INTO Students (username, password, email, dateRegistered, timeRegistered) VALUES
    ('Emma Thompson', 'emma123', 'emma.thompson@email.com', null, null),
    ('Liam Martinez', 'liam123', 'liam.martinez@email.com', null, null),
    ('Ava Patel', 'ava123', 'ava.patel@email.com', null, null),
    ('Noah Lee', 'noah123', 'noah.lee@email.com', null, null),
    ('Sophia Wang', 'sophia123', 'sophia.wang@email.com', null, null),
    ('Benjamin Clark', 'benjamin123', 'benjamin.clark@email.com', null, null),
    ('Mia Gonzalez', 'mia123', 'mia.gonzalez@email.com', null, null),
    ('Ethan Kim', 'ethan123', 'ethan.kim@email.com', null, null),
    ('Olivia Rodriguez', 'olivia123', 'olivia.rodriguez@email.com', null, null),
    ('Jacob Smith', 'jacob123', 'jacob.smith@email.com', null, null);



INSERT INTO Images (imageURL, studentId, title, description, dateSubmitted, timeSubmitted) VALUES
    ('https://hips.hearstapps.com/hmg-prod/images/frank-lloyd-wrights-fallingwater-house-back-detail-royalty-free-image-1582680814.jpg', 'Emma Thompson', 'Notre-Dame Cathedral', 'The Notre-Dame Cathedral, an epitome of Gothic architecture, was constructed between 1163 and 1345. Noteworthy are its flying buttresses, intricate rib vaults, and the harmonious unity of its floor plan. The recent restoration post-fire highlights the resilience of historical edifices.', null, null),
    ('https://blog.ecohotels.com/wp-content/uploads/2023/05/most-famous-buildings-in-the-world-13.png', 'Liam Martinez', 'The Louvre Museum', 'Originally a royal palace, the Louvre stands as a testament to various architectural styles from the Renaissance to modern times. The glass pyramid entrance, designed by I.M. Pei, is a striking example of blending contemporary and historical architecture.', null, null),
    ('https://static.demilked.com/wp-content/uploads/2021/06/60d42d25bf911-crazy-unique-buildings-coverimage-1.jpg', 'Ava Patel', 'Eiffel Tower', 'An architectural marvel of the Industrial Era, the Eiffel Tower is a wrought-iron lattice structure completed in 1889. Its construction for the World''s Fair was a feat in engineering, showcasing the aesthetic potential of exposed metal framework.', null, null),
    ('https://roguehabits.com/wp-content/uploads/resize-header-lofts-760x405.jpg', 'Noah Lee', 'Centre Pompidou', 'A revolutionary piece in high-tech architecture, the Centre Pompidou, designed by Renzo Piano and Richard Rogers, is renowned for its ''inside-out'' design with structural elements and mechanical systems visibly showcased on the exterior.', null, null),
    ('https://www.arch2o.com/wp-content/uploads/2017/10/Arch2O-10-famous-buildings-that-have-raised-controversy-with-their-unusual-design-2.jpg', 'Sophia Wang', 'Sainte-Chapelle', 'A gem of Rayonnant Gothic architecture, Sainte-Chapelle, completed in 1248, is celebrated for its extensive use of stained glass within a delicate stone framework, creating an ethereal, light-infused interior.', null, null),
    ('https://blog.ecohotels.com/wp-content/uploads/2023/05/most-famous-buildings-in-the-world-2.png', 'Benjamin Clark', 'Palais Garnier', 'The Palais Garnier, a 19th-century architectural masterpiece designed by Charles Garnier, epitomizes opulence and grandeur with its eclectic style, intricate detailing, and the use of diverse materials. Its majestic auditorium and grand staircase are particularly noteworthy.', null, null),
    ('https://i.pinimg.com/originals/5c/9b/3d/5c9b3d1e8a257de6890f992efdddfcbf.jpg', 'Mia Gonzalez', 'Hôtel des Invalides', 'Built in the late 17th century, Hôtel des Invalides is not only a historical complex housing museums and monuments relating to the military history of France, but also an architectural spectacle showcasing classical French Baroque style. The gilded dome is a landmark feature.', null, null),
    ('https://luxurycolumnist.com/wp-content/uploads/2022/02/Oscar-Niemeyer-International-Cultural-Centre-Asturias-Most-Famous-Architects.jpg', 'Ethan Kim', 'La Grande Arche de la Défense', 'A monumental 20th-century structure, La Grande Arche de la Défense embodies modernism and symmetry, aligning with the historical axis of Paris. Its open cube design represents a ‘window to the world’.', null, null),
    ('https://www.goconstruct.org/media/wk3i5ufk/la-sagrada-familia.jpg', 'Olivia Rodriguez', 'Musée d''Orsay', 'Converted from a Beaux-Arts railway station, the Musée d''Orsay is a fine example of adaptive reuse in architecture. The grand clock face and the glass-and-iron roof structure preserve the building''s historical essence while serving its new function as a museum.', null, null),
    ('https://assets3.thrillist.com/v1/image/2707738/1000x666/flatten;crop;webp=auto;jpeg_quality=60.jpg', 'Jacob Smith', 'Institut du Monde Arabe', 'A cultural testimony blending French design with Arabic architectural elements, the Institut du Monde Arabe, designed by Jean Nouvel and Architecture-Studio, features a south-facing façade with high-tech photo-sensitive apertures, mimicking traditional Arabic latticework, that regulate light and heat.', null, null);
