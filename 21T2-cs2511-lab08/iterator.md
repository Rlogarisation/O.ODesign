# Iterator Questions

a) Do you think making the Graph Iterable makes semantic sense? Discuss briefly, and think of both sides.

In semantic sense, it does not make sense, since graph has many weighted vertices and its edges can be either bi-directional or unidirectional, if there is special requirement related to the graph, then making graph iterable does not make sense.
However, in simply situation, when user do not care the underlying logic, then making graph iterable is easier to be used.

b) Is a Graph an iterator or an iterable in this case?

Graph is an iterable, since it is a representation of a series of elements that can be iterated over.

c) What would the .iterator method return in this case?

a list of iterator objects will be returned.
```java

public Iterator<E> iterator() {
    // your code here
}
```

d) What is the problem with this approach?
Since iterator function does not take any input, there is no flexibility of changing or modifying the way of iterator works.