CREATE DATABASE bdb;

USE bdb;

CREATE TABLE NOTES(  
   noteid   INT NOT NULL AUTO_INCREMENT,  
   title VARCHAR(50) NOT NULL,  
   content  MEDIUMTEXT NOT NULL,
   time TIMESTAMP,
  
   PRIMARY KEY (noteid)  
);

CREATE TABLE TAGS(
	noteid INT NOT NULL,
	tag VARCHAR(30) NOT NULL,
	FOREIGN KEY (noteid) REFERENCES NOTES(noteid)
);

CREATE TABLE COMMENTS(
	commentid INT NOT NULL AUTO_INCREMENT,
	user VARCHAR(20) NOT NULL,
	mail VARCHAR(50) NOT NULL,
	content TEXT NOT NULL,
	time TIMESTAMP,
	noteid INT NOT NULL,

	PRIMARY KEY(commentid),
	FOREIGN KEY(noteid) REFERENCES NOTES(noteid)
);


INSERT INTO `bdb`.`notes` (`noteid`, `title`, `content`, `time`) VALUES ('1', 'Lorem ipsum dolor sit ', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris id pharetra elit, sed auctor lacus. Duis pretium diam id enim fermentum gravida. Donec vitae vehicula metus. Curabitur ullamcorper nisi ut diam condimentum ultrices. Donec elementum ac massa sed porta. Etiam placerat tempus commodo. Donec at dui nec libero pharetra congue eget quis felis. Sed ornare pretium nunc at finibus.

Maecenas sit amet odio vitae ligula mattis fringilla nec porttitor dolor. Phasellus sed lobortis nunc. Praesent semper mattis sodales. Quisque non tellus ex. Fusce ac arcu nisi. Nulla facilisi. Sed pellentesque mi in metus eleifend iaculis. Duis mattis et ligula eu fermentum.

Mauris laoreet sem at arcu posuere eleifend. Suspendisse in nunc a ex euismod condimentum ac non mi. Mauris eros eros, faucibus luctus maximus at, tristique quis orci. Mauris nec sollicitudin justo, ut eleifend leo. In sollicitudin metus vehicula, aliquet ex quis, dignissim ipsum. Proin ac tortor ut felis aliquam interdum. Vivamus nec urna ac turpis facilisis tempus. Quisque faucibus, velit id mattis venenatis, enim nunc posuere ligula, ut vehicula purus est at erat. Morbi gravida enim non odio tincidunt, id tincidunt velit vehicula. Nam in arcu accumsan, auctor purus vel, sollicitudin eros. Integer ac tincidunt sapien.

Nullam ullamcorper aliquet massa, sollicitudin elementum magna rutrum id. Morbi magna neque, sodales sit amet volutpat nec, viverra sit amet lorem. Aliquam erat volutpat. Nulla egestas dui sit amet justo sodales feugiat. Aenean nunc ipsum, lacinia sed fringilla eu, maximus eu nulla. Cras id diam accumsan, tincidunt urna eleifend, hendrerit tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus tincidunt odio non tincidunt porttitor.

Aliquam massa quam, sollicitudin sed varius nec, vestibulum quis eros. Fusce et malesuada leo. Donec tristique luctus feugiat. Praesent et varius odio. In quis bibendum lectus, eu finibus lorem. Phasellus suscipit aliquam eleifend. Suspendisse blandit augue vel molestie fermentum. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Praesent convallis eget mi et sagittis. Pellentesque pulvinar scelerisque vehicula. Aenean maximus sem vel turpis rhoncus scelerisque.

Pellentesque tincidunt tincidunt risus, ut porttitor tellus tincidunt ut. Sed consequat, velit rutrum malesuada eleifend, sem enim imperdiet tellus, semper tristique sapien arcu in augue. Quisque velit ipsum, dapibus a ipsum nec, mattis hendrerit lacus. Donec ultricies eros a augue tempor, ac maximus mi ullamcorper. Integer tempor neque in aliquam feugiat. Donec porta euismod ex nec tempus. Ut volutpat egestas elit, nec auctor quam lacinia vitae. Suspendisse feugiat libero vel ex gravida varius. Nulla ac tellus lacus. Vivamus sagittis lacus ut nibh maximus consequat. Nullam quis efficitur arcu. Cras pulvinar justo sit amet volutpat rutrum.', '2015-07-08 00:00:00');



INSERT INTO `bdb`.`comments` (`commentid`, `user`, `mail`, `content`, `time`, `noteid`) VALUES ('1', 'lorem', 'avd@dkf.pl', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris id pharetra elit, sed auctor lacus. Duis pretium diam id enim fermentum gravida. Donec vitae vehicula metus. Curabitur ullamcorper nisi ut diam condimentum ultrices. Donec elementum ac massa sed porta. Etiam placerat tempus commodo. Donec at dui nec libero pharetra congue eget quis felis. Sed ornare pretium nunc at finibus.

Maecenas sit amet odio vitae ligula mattis fringilla nec porttitor dolor. Phasellus sed lobortis nunc. Praesent semper mattis sodales. Quisque non tellus ex. Fusce ac arcu nisi. Nulla facilisi. Sed pellentesque mi in metus eleifend iaculis. Duis mattis et ligula eu fermentum.
', '2015-07-25 00:00:00', '1');



INSERT INTO `bdb`.`tags` (`noteid`, `tag`) VALUES ('1', 'aa');
INSERT INTO `bdb`.`tags` (`noteid`, `tag`) VALUES ('1', 'ff');