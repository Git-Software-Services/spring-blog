USE personal_blog_db;

insert into blogs(author, body, image, quote, title)values
('test', 'test', movie_proj.png, 'test', 'test'),




insert into projects(port_body, port_image, port_title)values
('This was one of my favorite projects to work on. We were approaching Christmas break (2018) and we had just learned about node and how to create node package manager projects.

The instructions were simply to build a single page movie application (SPA) that would allow users to add, edit, and delete movies, as well as rate them. We used a json-server to mock a database and our backend, so that we could just worry about the front end and AJAX requests.

Once my partner and I had the functionality in place, I took it a step further by connecting to The Movie DataBase API to display images, trailers, overviews and titles for all movies.

I used bootstrap to style the application, and made sure to use enough white space so that the layout remained simple and clean.', 'The Movie Project', 'movie_proj.png'),

('The Mentor-Lister Project is essentially a bare bones craigslist clone. We worked in small teams to allow ourselves to become more familiar with git pull requests and handling merge conflicts.
Features for this project include:

Users can view all the ads that have been posted
An ad has a title, a description, and a link to the user that posted it
Users can register for the site
Users can log in to the application
Logged in users can create ads with a title and description

We used Java to dynamically generate html pages with the help of JSPs (Java Server Pages) and the JSTL (JSP Standard Tag Library) and to interact with a MySQL database that we created using mySql.
We used Maven to manage all the dependencies for the project.
Passwords are properly handled using hash and salt methods and prepared statements are used to avoid SQL injections.', 'The Mentor-Lister Project', 'adlister_proj.png'),

(' This is a simple web application I built using HTML, CSS, jQuery, ajax, the OpenWeatherMap API, and the Google Maps API to display a three day forecast for any city search or any location clicked on the map.', 'The Weather Project', 'weather_proj.png'),