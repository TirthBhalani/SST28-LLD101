Flyweight markers

We have markerStyle which had properties that are commmon in most of the markers.

In markerStyle, we make the attributes final and then remove all the setters as these are meant to be immutable.

In the Mapmarker object, we were calling new markerStyle which is wrong. We want it to be shared.

We implement a MarkerStyleFactory, which caches the result, it has a get method that returns the markerStyle for a particular string.
If it doesnt exist in the cache, we create it and return it, else we return the cached one. So we are only storing unique markerstyles.

We pass the mapstyle obj in the mapmarker object directly instead of creating a new one in the constructor of mapmarker.
in the mapDataSource, we get the mapStyle from the factory and then pass it directly in the constructor.
