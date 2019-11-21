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

#### Decorator Pattern

#### State Pattern

State Pattern is used to allow an Dog(Yarn) Object to alter its behavior when its magic state changes.The state transition is triggered by either touching a PowerUp (ball/bomb) with Magic State or timer (reset State). 

State Diagram
![alt text](https://github.com/nguyensjsu/fa19-202-yarn/blob/master/doc/imgs/StateDiagram.png)
Class Diagram
![alt_text](https://github.com/nguyensjsu/fa19-202-yarn/blob/master/doc/imgs/Class-StatePattern.png)

#### Observer Pattern

#### Composite Pattern
