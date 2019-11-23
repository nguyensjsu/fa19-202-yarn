# Yarn's Story

### Team Members and Contributions:
* **Steven Louie**  : Task Group 1 (refer to Design Overview diagram below)
* **Mohit Patel**: Task Group 4
* **Yueqiao Zhang**: Task Group 2, graphic design and video making
* **Danqing Zhao**: Task Group 3
* **Yu Zhao**: Task Group 0, documentation, diagram preparation


### About Yarn's Story: https://youtu.be/aoWMlE4MoLE
Once upon a time, there is a naughty dog named Yarn. He loves finding balls in his cozy home and hates dog bomb.

+ When Yarn hits a ball, player gets **10** scores and another ball is created randomly in the room.
+ When Yarn hits a bomb, player gets **-10** scores and Yarn’s speed get increased and another Bomb is created randomly in the room.
+ Magic States (```SPEEDUP```, ```SPEEDDOWN```, ```INVINCIBLE```) are randomly attached to ball and bomb, which cause temporary state change on Yarn **for 2 seconds**. 
+ There are walls/obstacle in the room. When Yarn hits a wall or the border of the room, game ends.

**Start Page**
![alt text](https://github.com/nguyensjsu/fa19-202-yarn/blob/master/doc/imgs/EntryWorld.png)

**Game Page**:

Yarn gains a STAR State
![alt text](https://github.com/nguyensjsu/fa19-202-yarn/blob/master/doc/imgs/STAR.png)

Yarn gains SPEEDDOWN State
![alt text](https://github.com/nguyensjsu/fa19-202-yarn/blob/master/doc/imgs/DOWN.jpeg)

After 2s, State disappear
![alt text](https://github.com/nguyensjsu/fa19-202-yarn/blob/master/doc/imgs/OFF.png)

**Score Board**:

![alt text](https://github.com/nguyensjsu/fa19-202-yarn/blob/master/doc/imgs/Gameover.png)
![alt text](https://github.com/nguyensjsu/fa19-202-yarn/blob/master/doc/imgs/EndWorld.png)

### Design Overview:
![alt text](https://github.com/nguyensjsu/fa19-202-yarn/blob/master/doc/imgs/DesignDraft-v2.0.png)
All main component and basic interactions between components are shown above. Four design pattern are implemented (Decorator, State, Observer, Composite). The whole project is split into 5 task groups, each team member focusing on one task group.
* Task Group 0 (Yu):  MagicState and MagicState Manager
* Task Group 1 (Steven): Ball and Bomb (including decorator pattern and Touch Subject implementation)
* Task Group 2 (Yueqiao): Score Board (Composite Pattern) and Game entry/end World
* Task Group 3 (Danqing): Display Components (Status, Speed, Score) and Touch Observer 
* Task Group 4 (Mohit): Game World (Room) and Yarn, integration of all the components of the game

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

### Agile (Agile meeting video link: https://youtu.be/dK3pBHE5QsE)

![alt_text](https://github.com/nguyensjsu/fa19-202-yarn/blob/master/doc/imgs/BurndownSheet.png)
![alt_text](https://github.com/nguyensjsu/fa19-202-yarn/blob/master/doc/imgs/BurndownChart.png)

