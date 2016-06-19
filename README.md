# Google Static Map Url Builder
Utility for creating Google static maps url with a few simple options.

##Synopsis
Sometimes, we need to present a grid screen with some google maps as thumbnails, but, for android apps, you need to include google play services, and use google maps api for loading `MapFragment` instances, specifically using _lite mode_.

For a simpler approach, you can use the [Google Static Maps API](https://goo.gl/0hG1pu) for construct such image map urls using some parameters.

With this library, you can apply for the second note, yeah, you can build static maps image urls, using options like latitude, longitude, zoom, image width and height, and adding markers to the map.

It uses the _Fluent Builder pattern_, making this process as simple as possible.

[Demo](https://goo.gl/hI8T6S)

##Code Example
This repository contains the sample module, you can check it out.

For creating static maps, use the `StaticMapUrl` class

```java
StaticMapUrl.create()
  .centered(_latitude_, _longitude_)
  .size(_imageWidth_, _imageHeight_)
  .zoom(_zoom_)
  .mark(_marker_)
  .build();
```

The result is a string containing the url:

[Sample generated static map](http://maps.googleapis.com/maps/api/staticmap?&center=-34.615803,-58.50336&size=320x320&zoom=8&markers=color:blue|size:mid|-34.615803,-58.50336)

For creating markers and add it to the static maps, use the `StaticMapMarker` class

```java
StaticMapMarker.create(_color_, _latitude_, _longitude_).medium())
```

The color for the marker can be set as a 24-bit color (example: color=0xFFFFCC) or a predefined color using the folowwing set (black, brown, green, purple, yellow, blue, gray, orange, red, white).

The size of the marker is important, there are three methods, that must be used after _`create()`_ method: _`small()`, `medium()`, `tiny()`_

###License

```
Copyright 2016 marlonlom

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
