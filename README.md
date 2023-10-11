# Computer Room Access Management

## Description

A computer room contains 20 computers numbered from 1 to 20.
The users who can access the room are as follows:

- Professors: they need to occupy the entire room.
- Thesis Students: they have their data saved on a specific computer $i$ and can only use that computer.
- Regular Students: they occupy a randomly selected computer.

Furthermore, in case there are multiple users who want to enter the room, the priority is as follows: Professors > Thesis Students > Regular Students.

## Implementation

The program is implemented in Java.
A PriorityBlockingQueue is used to manage the queue of users waiting to enter the room.
This queue is filled by a thread that generates random users and adds them to the queue.
Another thread is responsible for removing users from the queue and creating another thread to execute them.
In the created threads, it is determined which type of user it is and access to the room is granted along with the relevant action.
The computers in the room are implemented as an array of booleans, where true indicates that the computer is free, and false indicates that it is occupied.
The room is managed by a monitor that synchronizes access to the room to avoid resource conflicts.
The program terminates when a user of type UtenteTerm is recognized, which triggers the program to exit.
