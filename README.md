# IndividualExercise

Why I used JAVA EE?

First of all, it allows for the separation of business code from framework implementation. This was necessary when writing the update an account feature.
It also requires zero to minimal configuration. Moreover, the build, transfer and deployment times are really short which made my life much easier.
Finally, we learnt this way of developing business applications so it seemed to be the obvious way of doing my project.

Map implementation

Basically, just wanted to have an implementation that is independent of the database but it could be useful to handle client specific business logic.
It was also easier to try out different kinds of logic with this implementation and then decide whether to keep it or not. 
I deleted the lines from the beans file that allows for this implementation.

Mock Testing

Not absolutely clear about the use of mocking or mock frameworks but it definitely allows for testing the expected interaction with the mock object.
It also simplified the development of tests for all the classes with external dependencies.

Maven

It was really quick to start and set up a new maven project and it was also quite simple to define the dependencies.

Postman

It made my life much easier using Postman so I could send get, put, post and delete requests to the database and see their effect.
This way I could try out the logic I wrote for the account management functions.

Wildfly

Standalone, Wildfly's single node application server is easy to use with Maven in order to deploy war applications.

Bootstrap

Makes if much easier to develop the frontend from scratch due to its simplicity and its large number of available resources.
Its biggest advantage is definitely speed development though.

XMLHttpRequest

Despite its name, XMLHttpRequest can be used to retrieve any type of data, not just XML.
Allows for updating the web page without reloading it. Request and receive data from the server after a page has loaded and sends data to the database in the background.

H2 Console

Didn't have to install and setup a real database so it was useful as a mock in-memory database during the development process.
