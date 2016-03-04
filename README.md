####INFO
What is used? 
>Maven,Spring MVC, MySql, JDBC, basic Bootstrap options

What about configuration?
> Dependencies should be resolved by Maven. Sql file for creating database with first entry is located in src/main/resources/, info about connection can be found inside WEB-INF/spring/webcontext/DispatcherServlet-context.xml
> For server I used Tomcat 8.0. Since it is not hashed password and username for admin panel can be found in WEB-INF/spring/webcontext/security-context.xml

####ISSUES I'M AWARE OF
this could be solved by me with more time on hands.
* App was planned to be built with Jpa+Hibernate instead of JDBC. But as I am sweet child of .Net, I'm used to being led by hand when it comes to configuration. I messed that up horribly (God bless the the git and its version control!), and finally discarded since it wasted too much of my time.
* There is no pagination. There is a method for this within code, but its still buggy, so I decided not to implement it
* Password is not hashed
* UTests - Unfortunately, I displayed bad practice here, not writing test along with the code, but I was afraid that I won't be able to finish it on time.
* Lack of searching by date
* Comments are sometimes bugging, displaying that value of foreign key is not proper, despite model value setting properly.
* Tags are only accesible throught Detailed view. But they are clickable, and filter correctly

> some of the commits here on git are only for back-up purpose only

