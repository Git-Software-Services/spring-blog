USE personal_blog_db;

insert into blogs(author, body, image, quote, title, user_id)values
('test', 'test', movie_proj.png, 'test', 'test', 1),




insert into projects(body, title, image, user_id)values
('This was one of my favorite projects to work on. We were approaching Christmas break (2018) and we had just learned about node and how to create node package manager projects.

The instructions were simply to build a single page movie application (SPA) that would allow users to add, edit, and delete movies, as well as rate them. We used a json-server to mock a database and our backend, so that we could just worry about the front end and AJAX requests.

Once my partner and I had the functionality in place, I took it a step further by connecting to The Movie DataBase API to display img, trailers, overviews and titles for all movies.

I used bootstrap to style the application, and made sure to use enough white space so that the layout remained simple and clean.', 'The Movie Project', 'movie_proj.png', 1),

('The Mentor-Lister Project is essentially a bare bones craigslist clone. We worked in small teams to allow ourselves to become more familiar with git pull requests and handling merge conflicts.
Features for this project include:

Users can view all the ads that have been posted
An ad has a title, a description, and a link to the user that posted it
Users can register for the site
Users can log in to the application
Logged in users can create ads with a title and description

We used Java to dynamically generate html pages with the help of JSPs (Java Server Pages) and the JSTL (JSP Standard Tag Library) and to interact with a MySQL database that we created using mySql.
We used Maven to manage all the dependencies for the project.
Passwords are properly handled using hash and salt methods and prepared statements are used to avoid SQL injections.', 'The Mentor-Lister Project', 'adlister_proj.png', 1),

(' This is a simple web application I built using HTML, CSS, jQuery, ajax, the OpenWeatherMap API, and the Google Maps API to display a three day forecast for any city search or any location clicked on the map.', 'The Weather Project', 'weather_proj.png', 1),

('The Mentor-Lister Project is essentially a bare bones craigslist clone. We worked in small teams to allow ourselves to become more familiar with git pull requests and handling merge conflicts.
Features for this project include:

Users can view all the ads that have been posted
An ad has a title, a description, and a link to the user that posted it
Users can register for the site
Users can log in to the application
Logged in users can create ads with a title and description

We used Java to dynamically generate html pages with the help of JSPs (Java Server Pages) and the JSTL (JSP Standard Tag Library) and to interact with a MySQL database that we created using mySql.
We used Maven to manage all the dependencies for the project.
Passwords are properly handled using hash and salt methods and prepared statements are used to avoid SQL injections.', 'The Mentor-Lister Project', 'adlister_proj.png', 1),

('Satya Yoga Trips is a small side project I took on for my wife,my favorite client. I found a template that she liked and tailored it to fit her brand. I connected email service, paypal to accept payments and connected the domain and local site to a hosting service and secured the SSL certificate. I provide ongoing services to assist in making changes to the website when needed. Future plans involve migrating the site over to a CMS I create, much like this one, to enable her to create and update her own content.', 'The SYT Project', 'satya_proj.png', 1),

('A client asked to have his site updated with a more modern look and feel. He''d also experience a drop-off in call volume since trying to make some modifications to the site himself. I migrated the current site''s content over to the template and implemented several SEO enhancing techniques and best practices.', 'Justin''s Locksmithing Project', 'justins_proj.png', 1 ),

insert into users(username, email, password)values
('dorian', 'dorian@email.com', 'password'),