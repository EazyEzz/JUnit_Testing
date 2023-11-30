# Team 3 Design Discussion

## Design 1
[EazyEzz Design 1](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Design-Individual/EazyEzz/design.pdf)

[![EazyEzz Design 1](https://github.com/EazyEzz/Test_Repo/raw/f525d1d672d0a6adfcecf29e76d741c2a43316f4/Designs_images/EazyEzz.png)](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Design-Individual/EazyEzz/design.pdf)

* Essmer Note:
    * Realized that a class cannot have both aggregation and composition relationships with another single class. Ex Level1 has both pointing to ReminderList.


* Mobin
     * Pros
        
    1. Esmmer, you really nailed most of the 
requirements, good job.
        
    2. I appreciated the way you separated Reminder Types from the actual reminders. Makes it easy to navigate.
        
    3. Love the ReminderDB approach.

    4. Having options like “Weekly” and “Kid’s Reminders” is pretty 
handy.Also the fact that its auto save and no need to hit save.

     * Cons:  
  1. It's a little Complicated because Some parts felt intertwined,might be tricky when coding.    
  2. I was a little confused about how ReminderDB and ReminderList play 
together.
  3.  How we see reminders by type could use some clarity.
  4. Just wondering how the user would interact or flow through all these 
features.

* Pros/Cons (Kenny):
    * Pros: Multiplicity and relationships between classes are well defined.
    * Cons: Realization of Requirement 9 and 10 are not clear.


* Moshe's Pros/Cons:
    * Pros: Good way of using specialization for different actualReminders, I also liked the idea of creating a seperate class and list for supportedTypes of reminders. Overall, I think this satisfies most the requirements, with the reminder (Actual and Supoorted), reminderList, and User classes. Keep in mind that our designs are kind've similar and can be intertwined if you're user class and my reminderApp class switch, as well as get rid of DB class. Only difference would be the way that we store reminders in the database. My idea was to store the reminders in a hashmap which mapped the supportedType to a list of the remidners with that supportedType.
    
    * Cons: Reminder DB should probably store more than one reminder list, as well as in the user class should be able to see more than one list of reminders.


* Elibby
    * Pros: 
	This is a very flushed out design. I think the highight of your design was the auto-save feature 
	which I think is super smart in app design and something we should definitely try to implement in
	our own app. 
    * Cons:
	The reminder list shouldn't be pre-defined to weekly, maybe we can allow users to pick the time 
	schedule of the list. 
- David Pros/Cons
  - pros: straight forward, specified levels which i didn't with my design
  - cons: requirement 11, has alert but day not mentioned

## Design 2

[driv568 Design 2](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Design-Individual/driv568/design.pdf)

[![driv568 Design 2](https://github.com/EazyEzz/Test_Repo/raw/f525d1d672d0a6adfcecf29e76d741c2a43316f4/Designs_images/driv568.png)](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Design-Individual/driv568/design.pdf)


* Mobin:
  * Pros:
  1. Your design is straightforward and easy to grasp. 
  2.  Clear-cut methods, especially in the reminderList. No 
need for guesswork.
  3. Love how everything interlinks; the multiplicities are on point.
  4. Solid approach with reminderList and Reminder classes.

<<<<<<< HEAD
   * Cons : Feels like reminderList is handling a broad range of 
functions. maybe 
=======
   * Cons:
   1. Feels like reminderList is handling a broad range of functions. maybe 
>>>>>>> 4bf4f137e0d3ba5e70d27320683b459431204db7
decentralzie its responsibilites for more clarity.
  2. Couldn't spot any time-tracking mechanism.
  3. I agree with Moshe; wondering if reminderDB is essential for a class UML.
  4. Perhaps introducing a few more classes might evenly distribute 
responsibilities?


* Essmer Pros/Cons:
    * Pros:
        * Simple
        * Operations
    * Cons: 
        * limited class representations and relationships.

* Kenny Pros/Cons:
  * Pros: 
    * Simple. All requirements realized
  * Cons: 
    * Missing Users class

* Moshe's Pros/Cons:
    * Pros: Share the same reminder Type list as me. Also has necessary reminderList, Reminder, and reminderType classes. Lastly, clear methods in reminderList class however i think they can b defined in different classes.
    * Cons: Reminder should probably be the one dealing with location, and alerts not the reminder List. Also, reminder DB isn't necessary in my opinion for CLASS uml diagram. Also, maybe you should add another class to manage the reminderList class. The reminderList class should manage lists of reminders, while there should be another class that mabages the reminderList class like the reminderList class manages the reminder class.

* Elibby
    * Pros: 
	The implementation of your design is very clear and easy to understand. The relationships and 
	multiplicies make it easy to understand what is used and where it is used in each part of the design.
    * Cons:
	The only issue I had with this design is that it doesn't have a way to keep track of time, which is
	used in a couple of your functions.

- David Pros/Cons (compared to everyone else)
  - pros: simple, all requirements can be met
  - cons: reminder list managing too many operations compared to everyone else

## Design 3

[ElibbysDesign Design 3](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Design-Individual/ElibbysDesign/design.pdf)

[![ElibbysDesign Design 3](https://github.com/EazyEzz/Test_Repo/raw/f525d1d672d0a6adfcecf29e76d741c2a43316f4/Designs_images/ElibbysDesign.png)](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Design-Individual/ElibbysDesign/design.pdf)

* Mobin 
  * Pros:
  1. Appreciate the structured approach in the Reminder Database class.
  2. Great job for incorporating utility classes, especially 
the "Location" touch.
  3. Noteworthy use of the '#' visibility symbol, showing 
attention to detail.

   * Cons:
  1. Noticed many classes have their attributes visible 
universally. Could that be a potential issue?
  2. Was expecting a more comprehensive organizational lists. Maybe a 
universal or generic one might help?
  3. Felt the design lacked the depth in relationships and 
cultiplicities. just like Moshe stated the missing 
'reminderList' class.

* Essmer Pros/Cons:
    * Pros:
        * saveReminder operation addition in the database.
        * use of the '#' visibility symbol.
        * use of utility classes.
    * Cons:
        * visibility of attributes, most classes have their attributes visible to all the other classes. Not sure if it matters.
        * Limited organizational lists, maybe add more or create a generic one.
        * limited relationships and multiplicities.

* Kenny Pros/Cons:
    * Pros: Database is nicely designed
    * Cons: Too specific. Hypothetical example of a Reminders app

* Moshe's Pros/Cons:
    * Pros: Good utility classes provided
    * Cons: lack of appropriate relationship represenation between classes. Where is the reminderList class? You can't manage the list within the reminders class. It should be it's own class. There also is no reminderType attribute or class provided, only a list of reminderTypes. 

- David Pros/Cons
  - pros: database is more detailed
  - cons: requirement 1 is not met

## Design 4

[mobinkakar Design 4](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Design-Individual/mobinkakar/design.pdf)

[![mobinkakar Design 4](https://github.com/EazyEzz/Test_Repo/raw/f525d1d672d0a6adfcecf29e76d741c2a43316f4/Designs_images/mobinkakar.png)](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Design-Individual/mobinkakar/design.pdf)

* Mobin
  * Pros:
The design is straightforward, which can ease development and 
understanding. Mines also had the Flexibility: The structure allows for potential 
future expansions or changes.Last but not least my Structured Framework wasnt 
overly complicated, the design captures most essential details, making it robust.
  * Cons:
 Could benefit from a more detailed representation in 
certain areas.I also realized that i  Need to refine the connections and 
relationships between classes to make interactions clearer.

* Essmer Pros/Cons:
    * Pros: 
        * simple
    * Cons:
        * limited class representations.
        * Dependency relationships (--->): these indicate a weak relationship and considers them optional.

* Kenny Pros/Cons:
    * Pros: Simple. Allows for flexibility.
    * Cons: Missing multiplicity and relationship between classes. Missing User class

* Moshe's Pros/Cons:
    * Pros: We share the same idea for reminderType class as well as similar ideas for reminderList manager, in my case i called it reminderApp instead of manager.
    * Cons: Search should return multiple reminders, and even similar reminderTypes potentially. Also, reminderAlert can be refined into reminder class. Also, I believe the DB is unecessary since it's a CLASS diagram.

* Elibby
    * Pros:
	I think your design is structured very well. The framework is simple, without lacking much detail, and
	it can be built upon without having to backtrack and redesign.
    * Cons:
	The only thing your design lacks is multiplicities and connecting relational words between some of 
	the classes.


- David Pros/Cons
  - pros: clean representation
  - cons: alert should be integrated into reminder and not separate

## Design 5

[MosheShDesign Design 5](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Design-Individual/MosheShDesign/design.pdf)

[![MosheShDesign Design 5](https://github.com/EazyEzz/Test_Repo/raw/f525d1d672d0a6adfcecf29e76d741c2a43316f4/Designs_images/MosheShDesign.png)](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Design-Individual/MosheShDesign/design.pdf)

* Mobin
  * Pros:
  1. The design smartly incorporates a blend of hash 
maps and a wide range of functions, covering most requirements comprehensively.
<<<<<<< HEAD

2: Using a map for reminder lists is not only efficient but also hints at a streamlined development process.
    
    * Cons 

1:The direct connection to the database is unclear, making the overall DB handling seem a bit disjointed.

2:Some relationships in the design, like the dual associations,are hard to understand. Additionally, the realization of 
=======
  2. Using a map for reminder lists is not only efficient but also hints at a streamlined development process.
    * Cons:
  1. The direct connection to the database is unclear, making the overall DB handling seem a bit disjointed.
  2. Some relationships in the design, like the dual associations,are hard to understand. Additionally, the realization of 
>>>>>>> 4bf4f137e0d3ba5e70d27320683b459431204db7
certain requirements, such as Requirement 4, could be clearer.

* Essmer Pros/Cons:
    * Pros:
        * simple.
        * reminderList mapping attribute
    * Cons:
        * limited class representation
        * relationships contain double directions, association and compositon. Unsure if this is allowed.

* Kenny Pros/Cons:
    * Pros: well defined functions, relationships. Minimalistic
    * Cons: Missing database. Realization of requirement 10 is unclear

* Moshe's Pros/Cons (opinion on my OWN design in relation to others. might add more on this later):
    * Pros: I believe there is strong overlap between mine, Essmer's, and YKWU1 design.

- David Pros/Cons
  - pros: simple
  - cons: requirement 4 not met
* Elibby
    * Pros:
	What I like most about your design was your use of a map to store the reminder lists. This implementation
	could probably cut down on coding time and increase app speeds.
    * Cons:
	There is not a lot of functionality for checked off/ already completed reminders.

## Design 6

[ykwu1Design Design 6](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Design-Individual/ykwu1Design/design.pdf)

[![ykwu1Design Design 6](https://github.com/EazyEzz/Test_Repo/raw/f525d1d672d0a6adfcecf29e76d741c2a43316f4/Designs_images/ykwu1Design.png)](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Design-Individual/ykwu1Design/design.pdf)

<<<<<<< HEAD
*Mobin
 (    Pros:

1: Love how the interface makes things clear and controlled.

2: The 'listName' touch is smart, and the reminder type setup is a neat way to sort things.

3: Everything's laid out well with easy-to-follow relationships.

     *Cons

1: Feels a bit limited with the classes and could use more attribute details.

2: Not sure we need a DB in a class diagram.

3: Seems like you are missing a reminder alert and some other sorting 
details. )
=======
* Mobin
  * Pros:
  1. Love how the interface makes things clear and controlled.
  2. The 'listName' touch is smart, and the reminder type setup is a neat way to sort things.
  3. Everything's laid out well with easy-to-follow relationships.
  * Cons:
  1. Feels a bit limited with the classes and could use more attribute details.
  2. Not sure we need a DB in a class diagram.
  3. Seems like you are missing a reminder alert and some other sorting 
details.
>>>>>>> 4bf4f137e0d3ba5e70d27320683b459431204db7

* Essmer Pros/Cons:
    * Pros:
        * interface class
    * Cons:
        * limited class representation
        * attributes usage

* Moshe's Pros/Cons:
    * Pros: I like how each reminderList has a listName, since this overlaps with my idea but instead of listName to identify lists, we can use the remidnerType to identify different reminderLists. Also, reminder type looks similar to mine besides i store the reminderListYype in my remindersApp class. Good overlap. 
    * Cons: Search should return multiple reminders, and even similar reminderTypes potentially. Also, reminderAlert can be refined into reminder class. Also, I believe the DB is unecessary since it's a CLASS diagram.

- David Pros/Cons
  - pros: has interface
  - cons: i don't see reminder alert
* Elibby
    * Pros:
	This design is really easy to understand with the use of its relationships. I also liked how the attributes 
	and operations are labeled based on class visibility.
    * Cons:
	The design does not account for reminder types or multiple reminder lists with respect to time.

## Team Design


* Mobin's vote
      I vote for Esmer's design and my own becasue it'll result in A design that 
covers everything we need without making things too complicated or hard to put into 
action.

* Essmer Vote:
    * I vote to combine Elibbys and mine.

* Kenny's vote: Design 4 (mobinkakar)
All requirements have been addressed in the simpliest of forms. Easy to understand and I think the simplicity allows for flexiblility. I like the idea of using a ReminderListManager class. However,mobinkakar is missing the relationship and multiplicity between each class, so if we choose Design 4, we need to make sure we include them.

* Moshe's vote: I vote dor Essmer's design with some changes and things to be added based on my own design and YKUW1 design. I think if we added the hashmap that links the reminderTypes to the reminderList it would be helpful to implement the two level hierarchy discussed in  the requirements.
  
* Elibby's vote: 
	I think a mixture of design 1 and design 4 should create an all- encompassing class diagram.

* David's Vote: Essmer's design, detailed and straightforward



#### Commonalities and Differences

* Commonalities
        
  1. Designs incorporate classes for managing reminders (ReminderList in 
yours and Reminders in Essmer's).
  2. The idea of having a structure or hierarchy for reminders is visible in both Mine 
ReminderType and his hierarchical representation.

* Differences

<<<<<<< HEAD
        * Differences between mine and Esmmer
1:Essmer's design puts a strong emphasis on user interactions and notifications, 
=======
  1. Essmer's design puts a strong emphasis on user interactions and notifications, 
>>>>>>> 4bf4f137e0d3ba5e70d27320683b459431204db7
which isn't a primary focus in mines.
  1. My design has a clear distinction between the database of reminders (ReminderDB) 
and the reminder management (ReminderList), whereas Essmer's design seems to merge 
these functionalities.

<<<<<<< HEAD
               * Justification
=======
* Justification
>>>>>>> 4bf4f137e0d3ba5e70d27320683b459431204db7
The justification behind these commanalities and differences is becasue Essmer's 
design emphasizes user interactions, suggesting a user-centric approach. While 
also considering The merging of reminder storage and management that could be seen 
as a way to simplify user interactions and reduce complexity.


[Team Design Draft](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Design-Team/TeamDesign.pdf)

[![Team Design Draft](https://github.com/EazyEzz/Test_Repo/raw/5c8011600a515bdd862aaa933bde4cfb5981e850/Designs_images/TeamDesign.png)](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Design-Team/TeamDesign.pdf)

[Team Design Updated](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Design-Team/TeamDesignDraftUpdate.pdf)
[![Team Design Updated](https://github.com/EazyEzz/Test_Repo/raw/576376654fb980c7ad4301bc9b35418e3df411bd/Designs_images/Screenshot%202023-10-25%20154612.png)](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Design-Team/TeamDesignDraftUpdate.pdf)

[FINAL TEAM DESIGN](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Design-Team/design.pdf)
[![FINAL TEAM DESIGN](https://github.com/EazyEzz/Test_Repo/raw/6bb639a353f416837cc3f04ea74edaeb63eedfa9/Designs_images/FinalTeamDesign.png)](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Design-Team/design.pdf)

 
## Summary

Reflecting on our journey discussing these designs, here’s what we’ve learned:

Design: Simplicity is key. A detailed design might look impressive initially, but 
when it comes to real-world implementation, things can get complicated. It's 
essential to strike a balance between thoroughness and feasibility. It’s not always 
about adding more; often, it's about optimizing and integrating what we already 
have.

Team Work: Each of us brought unique insights to our discussions. The value of 
active listening and constructive feedback became evident as we progressed. Open 
communication and the willingness to adjust based on team input were crucial for 
our collective growth.

Future-Proofing: Beyond just meeting the current requirements, it’s vital to think 
about how our design might need to evolve in the future. We aimed for a design that 
could adapt to potential changes, ensuring long-term relevance.

In sum, this process taught us a lot about the nuances of design, the importance of 
collaborative teamwork, and the need to think ahead. It was a growth experience, 
not just in terms of the project but also in understanding the dynamics of 
effective teamwork.
