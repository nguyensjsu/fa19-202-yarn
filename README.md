# Yarn's Story

### Team Members:
* Steven Louie
* Mohit Patel
* Yueqiao Zhang
* Danqing Zhao
* Yu Zhao


### About Yarn's Story:
Once upon a time, there is a naughty dog named Yarn. He loves finding balls in his cozy home and hates dog bomb.

+ When Yarn hits a ball, player gets **10** scores and another ball is created randomly in the room.
+ When Yarn hits a bomb, player gets **-10** scores and Yarn’s speed get increased and another Bomb is created randomly in the room.
+ Magic States (```SPEEDUP```, ```SPEEDDOWN```, ```INVINCIBLE```) are randomly attached to ball and bomb, which cause temporary state change on Yarn **for 2 seconds**. 
+ There are walls/obstacle in the room. When Yarn hits a wall or the border of the room, game ends.

Start Page (**Add Screenshot here**):

![alt text](https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png "Logo Title Text 1")

Game Page:

![alt text](https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png "Logo Title Text 1")

Score Board:

![alt text](https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png "Logo Title Text 1")


### Design Overview:
![alt text](https://github.com/nguyensjsu/fa19-202-yarn/blob/master/doc/imgs/DesignDraft-v2.0.png)

### Key Design Features:

#### 1. Decorator Pattern
Decorator Pattern allows us to add reponsibilities to ```Ball``` and ```Bomb``` objects dynamically, a random ```MagicState``` effect is added to them. Although now our current demo is pretty simple, this pattern could help us gain more flexiblity when we try to extend/add more complex reponsibilites to ```Ball``` and ```Bomb```. And those responsibilities are also easy to remove. In our case, due to constraint of Greenfoot, we also use a Observer pattern to associated with Decorator pattern to handle touching event.
![alt text](https://github.com/nguyensjsu/fa19-202-yarn/blob/master/doc/imgs/DecoratorPattern.png)

#### 2. State Pattern

State Pattern is used to allow an ```Dog``` Object to alter its behavior when its magic state changes. The state transition is triggered by either touching a ```PowerUp``` (ball/bomb) with ```Magic State``` or timer (reset State). Instead of conditional or case statements, State Patter helps us to keep code structure clear and flexible for adding any more Magic State.

![alt text](https://github.com/nguyensjsu/fa19-202-yarn/blob/master/doc/imgs/StateDiagram.png)

![alt_text](https://github.com/nguyensjsu/fa19-202-yarn/blob/master/doc/imgs/Class-StatePattern.png)

#### 3. Observer Pattern
Observer Pattern let us avoid tight coupling between Item(```Ball```, ```Bomb```,```Wall``` and even ```PowerUp```) and all kinds of ```DisplayComponents```. We could vary subject and observers independently or add more observers anytime without modified current observers. And it also helps increasing our code reusibility.
![alt_text](https://github.com/nguyensjsu/fa19-202-yarn/blob/master/doc/imgs/ObserverPattern.png)

#### 4. Composite Pattern
An abstract class ```ScoreBoardComponent``` represents both primitive leaf classes (```Banner```, ```Title```, ```Background```, etc.) and their containers (```ScoreBoardComposite```). Clients can treat composite and leaf objects uniformly without writing a complex tag-and-case-statement style function. Thanks to composite pattern, now it is easy to add a new component to work automatically with existing client code.

![alt_text](https://github.com/nguyensjsu/fa19-202-yarn/blob/master/doc/imgs/ClassD-Composite.png)
